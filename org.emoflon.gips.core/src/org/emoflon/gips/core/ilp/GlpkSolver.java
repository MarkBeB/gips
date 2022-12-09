package org.emoflon.gips.core.ilp;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.emoflon.gips.core.GipsEngine;
import org.emoflon.gips.core.GipsGlobalConstraint;
import org.emoflon.gips.core.GipsGlobalObjective;
import org.emoflon.gips.core.GipsMapper;
import org.emoflon.gips.core.GipsMapping;
import org.emoflon.gips.core.GipsMappingConstraint;
import org.emoflon.gips.core.GipsTypeConstraint;
import org.emoflon.gips.core.gt.GipsPatternConstraint;
import org.emoflon.gips.intermediate.GipsIntermediate.RelationalOperator;
import org.gnu.glpk.GLPK;
import org.gnu.glpk.GLPKConstants;
import org.gnu.glpk.SWIGTYPE_p_double;
import org.gnu.glpk.SWIGTYPE_p_int;
import org.gnu.glpk.glp_iocp;
import org.gnu.glpk.glp_prob;

public class GlpkSolver extends ILPSolver {

	/**
	 * Variable type (binary, integer, double).
	 */
	private enum VarType {
		BIN, INT, DBL
	}

	/**
	 * GLPK model.
	 */
	private glp_prob model;

	/**
	 * GLPK environment (for configuration etc.).
	 */
	private glp_iocp iocp;

	/**
	 * Map to collect all ILP constraints (name -> collection of constraints).
	 */
	private Map<String, Collection<ILPConstraint>> constraints;

	/**
	 * Map to collect all ILP variables (name -> {integer (=index), type, lower
	 * bound, upper bound}).
	 */
	private Map<String, varInformation> ilpVars;

	/**
	 * Record for the variable information: index, type, lower bound, upper bound
	 */
	private record varInformation(int index, VarType type, Number lb, Number up) {
	}

	/**
	 * Global objective.
	 */
	private GipsGlobalObjective objective;

	/**
	 * LP file output path.
	 */
	private String lpPath = null;
	
	/**
	 * ILP solver configuration.
	 */
	final private ILPSolverConfig config;

	public GlpkSolver(final GipsEngine engine, final ILPSolverConfig config) {
		super(engine);
		constraints = new HashMap<>();
		ilpVars = new HashMap<>();
		this.config = config;
		init();
	}
	
	private void init() {
		GLPK.glp_free_env();
		model = GLPK.glp_create_prob();

		// GLPK initialization
		iocp = new glp_iocp();
		GLPK.glp_init_iocp(iocp);
		iocp.setPresolve(config.enablePresolve() ? GLPK.GLP_ON : GLPK.GLP_OFF);
		if (config.timeLimitEnabled()) {
			iocp.setTm_lim((int) config.timeLimit() * 1000); // seconds to milliseconds
		}
		// TODO: Check specific tolerances later on
		if (config.enableTolerance()) {
			iocp.setTol_obj(config.tolerance());
			iocp.setTol_int(config.tolerance());
			iocp.setMip_gap(config.tolerance());
		}
		// Random seed not supported by the GLPK Java interface
		// TODO: Set output flag

		if (config.lpOutput()) {
			this.lpPath = config.lpPath();
		}

		GLPK.glp_set_prob_name(model, "GIPS problem");
	}

	@Override
	public void terminate() {
		model.delete();
		iocp.delete();
	}

	@Override
	public ILPSolverOutput solve() {
		setUpVars();
		setUpCnstrs();
		setUpObj();

		// Save LP file if configured
		if (this.lpPath != null) {
			GLPK.glp_write_lp(model, null, this.lpPath);
		}

		// Solving
		final int ret = GLPK.glp_intopt(model, iocp);
		final int modelStatus = GLPK.glp_get_status(model);
		final int mipModelStatus = GLPK.glp_mip_status(model);

		// GLPK is extremely detailed regarding of the output. Therefore, the three
		// variables above capture:
		// * Return value of the solving process
		// * status of the overall model
		// * MIP status of the model
		// These three status will be checked against various constants to determine the
		// "overall" output/status of the solving process.

		final boolean solved = ret == 0;
		final boolean timeout = ret == GLPK.GLP_ETMLIM;
		final boolean unbounded = modelStatus == GLPK.GLP_UNBND;
		final boolean optimal = modelStatus == GLPK.GLP_OPT;
		final boolean infeasible = modelStatus == GLPK.GLP_INFEAS;
		final boolean noFeasibleSol = modelStatus == GLPK.GLP_NOFEAS;
		final boolean invalid = ret == GLPK.GLP_EBADB;
		final boolean noPrimalFeasSol = ret == GLPK.GLP_ENOPFS;
		final boolean noDualFeasSol = ret == GLPK.GLP_ENODFS;
		final boolean mipIntOptimal = mipModelStatus == GLPK.GLP_OPT;

		// Determine status
		ILPSolverStatus status = null;
		int solCounter = -1;
		// TODO: Not quite sure about the following values of 'solCounter'
		if (solved && (optimal || mipIntOptimal)) {
			status = ILPSolverStatus.OPTIMAL;
			solCounter = 1;
		} else if (unbounded) {
			status = ILPSolverStatus.UNBOUNDED;
			solCounter = 0;
		} else if (timeout) {
			status = ILPSolverStatus.TIME_OUT;
			solCounter = solved ? 1 : 0;
		} else if (infeasible || noFeasibleSol || noPrimalFeasSol || noDualFeasSol || modelStatus == 1) {
			status = ILPSolverStatus.INFEASIBLE;
			solCounter = 0;
		} else if (invalid) {
			status = ILPSolverStatus.INF_OR_UNBD;
			solCounter = 0;
		} else {
			throw new RuntimeException("GLPK: Solver status could not be determined.");
		}
		return new ILPSolverOutput(status, GLPK.glp_mip_obj_val(model), engine.getValidationLog(), solCounter);
	}

	@Override
	public void updateValuesFromSolution() {
		// Iterate over all mappers
		for (final String key : engine.getMappers().keySet()) {
			final GipsMapper<?> mapper = engine.getMapper(key);
			// Iterate over all mappings of each mapper
			for (final String k : mapper.getMappings().keySet()) {
				// Get corresponding ILP variable name
				final GipsMapping mapping = mapper.getMapping(k);
				final String varName = mapping.getName();
				// Get value of the ILP variable and round it (to eliminate small deltas)
				double result = Math.round(GLPK.glp_mip_col_val(model, ilpVars.get(varName).index));
				// Save result value in specific mapping
				mapping.setValue((int) result);

				// Save all values of additional variables if any
				if (mapping.hasAdditionalVariables()) {
					for (Entry<String, ILPVariable<?>> var : mapping.getAdditionalVariables().entrySet()) {
						double mappingVarResult = GLPK.glp_mip_col_val(model,
								ilpVars.get(var.getValue().getName()).index);
						mapping.setAdditionalVariableValue(var.getKey(), mappingVarResult);
					}
				}
			}
		}
		
		// Clear all old data of CPLEX and re-initialize for a possible next run
		init();
	}

	@Override
	protected void translateMapping(final GipsMapping mapping) {
		createBinVar(mapping.getName(), mapping.getLowerBound(), mapping.getUpperBound());
		if (mapping.hasAdditionalVariables()) {
			createAdditionalVars(mapping.getAdditionalVariables().values());
		}
	}

	@Override
	protected void translateConstraint(final GipsMappingConstraint<?, ? extends EObject> constraint) {
		createAdditionalVars(constraint.getAdditionalVariables());
		final Set<ILPConstraint> collectedCnstr = new HashSet<>();
		collectedCnstr.addAll(constraint.getConstraints());
		collectedCnstr.addAll(constraint.getAdditionalConstraints());
		constraints.put(constraint.getName(), collectedCnstr);
	}

	@Override
	protected void translateConstraint(final GipsPatternConstraint<?, ?, ?> constraint) {
		createAdditionalVars(constraint.getAdditionalVariables());
		final Set<ILPConstraint> collectedCnstr = new HashSet<>();
		collectedCnstr.addAll(constraint.getConstraints());
		collectedCnstr.addAll(constraint.getAdditionalConstraints());
		constraints.put(constraint.getName(), collectedCnstr);
	}

	@Override
	protected void translateConstraint(final GipsTypeConstraint<?, ? extends EObject> constraint) {
		createAdditionalVars(constraint.getAdditionalVariables());
		final Set<ILPConstraint> collectedCnstr = new HashSet<>();
		collectedCnstr.addAll(constraint.getConstraints());
		collectedCnstr.addAll(constraint.getAdditionalConstraints());
		constraints.put(constraint.getName(), collectedCnstr);
	}

	@Override
	protected void translateConstraint(GipsGlobalConstraint<?> constraint) {
		createAdditionalVars(constraint.getAdditionalVariables());
		final Set<ILPConstraint> collectedCnstr = new HashSet<>();
		collectedCnstr.addAll(constraint.getConstraints());
		collectedCnstr.addAll(constraint.getAdditionalConstraints());
		constraints.put(constraint.getName(), collectedCnstr);
	}

	@Override
	protected void translateObjective(final GipsGlobalObjective objective) {
		this.objective = objective;
	}

	/**
	 * Sets all ILP variables for GLPK up.
	 */
	private void setUpVars() {
		// In case of 0 variables, simply return
		if (ilpVars.size() == 0) {
			return;
		}

		GLPK.glp_add_cols(model, ilpVars.size());
		for (final String k : ilpVars.keySet()) {
			final int varCounter = ilpVars.get(k).index;
			final double lb = ilpVars.get(k).lb.doubleValue();
			final double ub = ilpVars.get(k).up.doubleValue();
			GLPK.glp_set_col_name(model, varCounter, k);

			// Type
			if (ilpVars.get(k).type == VarType.BIN) {
				// BV = binary variable
				setUpGlpkVar(varCounter, GLPKConstants.GLP_BV, lb, ub);
			} else if (ilpVars.get(k).type == VarType.INT) {
				// IV = integer variable
				setUpGlpkVar(varCounter, GLPKConstants.GLP_IV, lb, ub);
			} else if (ilpVars.get(k).type == VarType.DBL) {
				// CV = continuous variable
				setUpGlpkVar(varCounter, GLPKConstants.GLP_CV, lb, ub);
			} else {
				throw new UnsupportedOperationException("ILP var type not known.");
			}
		}
	}

	/**
	 * Sets up a GLPK variable with given parameters
	 * 
	 * @param j    j-th column.
	 * @param type Type of the variable (double, integer, binary).
	 * @param lb   Lower bound.
	 * @param ub   Upper bound.
	 */
	private void setUpGlpkVar(final int j, final int type, final double lb, final double ub) {
		if (ub < lb) {
			throw new IllegalArgumentException("Lower bound must be lower or equal to the upper bound.");
		}

		if (j < 0) {
			throw new IllegalArgumentException("j-th column " + j + " is not >=0.");
		}

		GLPK.glp_set_col_kind(model, j, type);
		// If lb == ub -> type must be GLP_FX
		if (lb == ub) {
			GLPK.glp_set_col_bnds(model, j, GLPKConstants.GLP_FX, lb, ub);
		} else {
			GLPK.glp_set_col_bnds(model, j, GLPKConstants.GLP_DB, lb, ub);
		}
	}

	/**
	 * Sets all constraints for GLPK up. Variable setup must be done before.
	 */
	private void setUpCnstrs() {
		// Determine total number of constraints
		int numRows = 0;
		for (final Collection<ILPConstraint> col : constraints.values()) {
			numRows += col.size();
		}

		// In case of 0 constraints, simply return
		if (numRows == 0) {
			return;
		}

		GLPK.glp_add_rows(model, numRows);

		// Iterate over all constraint name
		int globalCnstrCounter = 1;
		for (final String name : constraints.keySet()) {
			final Iterator<ILPConstraint> cnstrIt = constraints.get(name).iterator();

			// Iterate over each "sub" constraint (if any)
			int localCnstrCounter = 0;
			while (cnstrIt.hasNext()) {
				final ILPConstraint cnstr = cnstrIt.next();
				if (cnstr == null) {
					continue;
				}

				// For GLPK, we have to cumulate all weights for identical variables
				final Map<ILPVariable<?>, Double> cumulatedWeights = new HashMap<>();

				for (int i = 0; i < cnstr.lhsTerms().size(); i++) {
					final ILPVariable<?> var = cnstr.lhsTerms().get(i).variable();
					if (cumulatedWeights.containsKey(var)) {
						final double newWeight = cumulatedWeights.remove(var) + cnstr.lhsTerms().get(i).weight();
						cumulatedWeights.put(var, newWeight);
					} else {
						cumulatedWeights.put(var, cnstr.lhsTerms().get(i).weight());
					}
				}

				final int size = cumulatedWeights.size();
				final SWIGTYPE_p_int vars = GLPK.new_intArray(size + 1);
				final SWIGTYPE_p_double coeffs = GLPK.new_doubleArray(size + 1);

				int varIt = 1;
				for (final ILPVariable<?> v : cumulatedWeights.keySet()) {
					GLPK.intArray_setitem(vars, varIt, ilpVars.get(v.getName()).index);
					GLPK.doubleArray_setitem(coeffs, varIt, cumulatedWeights.get(v));
					varIt++;
				}

				GLPK.glp_set_row_name(model, globalCnstrCounter, name + "_" + localCnstrCounter);
				GLPK.glp_set_mat_row(model, globalCnstrCounter, size, vars, coeffs);
				GLPK.glp_set_row_bnds(model, globalCnstrCounter, convertOperator(cnstr.operator()),
						cnstr.rhsConstantTerm(), cnstr.rhsConstantTerm());

				globalCnstrCounter++;
				localCnstrCounter++;
			}
		}
	}

	/**
	 * Sets the objective function for GLPK up. Variable setup must be done before.
	 */
	private void setUpObj() {
		if (objective == null) {
			return;
		}

		final ILPNestedLinearFunction nestFunc = objective.getObjectiveFunction();

		// Set goal
		int goal = 0;
		switch (nestFunc.goal()) {
		case MAX -> {
			goal = GLPKConstants.GLP_MAX;
		}
		case MIN -> {
			goal = GLPKConstants.GLP_MIN;
		}
		}
		GLPK.glp_set_obj_dir(model, goal);

		// Constants
		double constSum = 0;
		for (ILPConstant c : nestFunc.constants()) {
			constSum += c.weight();
		}

		// Terms
		for (final ILPWeightedLinearFunction lf : nestFunc.linearFunctions()) {
			lf.linearFunction().terms().forEach(t -> {
				// Get index of current variable
				final int varIndex = ilpVars.get(t.variable().getName()).index;

				// Get previous aggregated weight
				final double prevCoef = GLPK.glp_get_obj_coef(model, varIndex);

				// Update aggregated weight = prev + weight(var) * weight(term)
				GLPK.glp_set_obj_coef(model, varIndex, prevCoef + (t.weight() * lf.weight()));
			});

			for (final ILPConstant c : lf.linearFunction().constantTerms()) {
				constSum += (c.weight() * lf.weight());
			}
		}

		// Add global constant sum
		GLPK.glp_set_obj_coef(model, 0, constSum);
	}

	/**
	 * Converts a given operator value (from RelationalOperator) to the
	 * corresponding GLPK int value.
	 *
	 * @param op Operator value to convert.
	 * @return Converted operator value.
	 */
	private int convertOperator(final RelationalOperator op) {
		switch (op) {
		case LESS:
			throw new UnsupportedOperationException("GLPK does not support LESS in constraints.");
		// TODO: Could be expressed with !(x >= a)
		case LESS_OR_EQUAL:
			return GLPKConstants.GLP_UP;
		case EQUAL:
			return GLPKConstants.GLP_FX;
		case GREATER_OR_EQUAL:
			return GLPKConstants.GLP_LO;
		case GREATER:
			throw new UnsupportedOperationException("GLPK does not support GREATER in constraints.");
		// TODO: Could be expressed with !(x <= a)
		case NOT_EQUAL:
			throw new UnsupportedOperationException("GLPK does not support NOT EQUAL in constraints.");
		// TODO: This introduces an OR constraint
		// https://math.stackexchange.com/questions/37075/how-can-not-equals-be-expressed-as-an-inequality-for-a-linear-programming-model/1517850
		default:
			throw new UnsupportedOperationException("Not yet implemented.");
		}
	}

	/**
	 * Checks the type of each given variable and creates corresponding (additional)
	 * variables in the GLPK model.
	 * 
	 * @param variables Collection of variables to create additional GLPK variables
	 *                  for.
	 */
	protected void createAdditionalVars(final Collection<ILPVariable<?>> variables) {
		for (final ILPVariable<?> variable : variables) {
			if (variable instanceof ILPBinaryVariable binVar) {
				createBinVar(binVar.name, binVar.getLowerBound(), binVar.getUpperBound());
			} else if (variable instanceof ILPIntegerVariable intVar) {
				createIntVar(intVar.name, intVar.getLowerBound(), intVar.getUpperBound());
			} else if (variable instanceof ILPRealVariable realVar) {
				createDblVar(realVar.name, realVar.getLowerBound(), realVar.getUpperBound());
			} else {
				throw new IllegalArgumentException("Unsupported variable type: " + variable.getClass().getSimpleName());
			}
		}
	}

	/**
	 * Adds a binary variable with given name to the model.
	 * 
	 * @param name Variable name.
	 * @param lb   Lower bound number.
	 * @param ub   Upper bound number.
	 */
	private void createBinVar(final String name, final Number lb, final Number ub) {
		ilpVars.put(name, new varInformation(ilpVars.size() + 1, VarType.BIN, lb, ub));
	}

	/**
	 * Adds an integer variable with given name to the model.
	 * 
	 * @param name Variable name.
	 * @param lb   Lower bound number.
	 * @param ub   Upper bound number.
	 */
	private void createIntVar(final String name, final Number lb, final Number ub) {
		ilpVars.put(name, new varInformation(ilpVars.size() + 1, VarType.INT, lb, ub));
	}

	/**
	 * Adds a double variable with given name to the model.
	 * 
	 * @param name Variable name.
	 * @param lb   Lower bound number.
	 * @param ub   Upper bound number.
	 */
	private void createDblVar(final String name, final Number lb, final Number ub) {
		ilpVars.put(name, new varInformation(ilpVars.size() + 1, VarType.DBL, lb, ub));
	}

}
