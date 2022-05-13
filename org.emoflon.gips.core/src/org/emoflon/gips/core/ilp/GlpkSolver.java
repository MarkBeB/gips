package org.emoflon.gips.core.ilp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emoflon.gips.core.GipsEngine;
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

	private glp_prob model;
	private glp_iocp iocp;
	private Collection<ILPConstraint<Integer>> constraints;
	private Map<String, Integer> ilpVars;
	private GipsGlobalObjective objective;

	public GlpkSolver(final GipsEngine engine, final ILPSolverConfig config) {
		super(engine);
		constraints = new LinkedList<>();
		ilpVars = new HashMap<>();

		GLPK.glp_free_env();
		model = GLPK.glp_create_prob();
		GLPK.glp_set_prob_name(model, "model");

		// GLPK initialization
		iocp = new glp_iocp();
		GLPK.glp_init_iocp(iocp);
		if (config.enablePresolve()) {
			iocp.setPresolve(GLPK.GLP_ON);
		}
		iocp.setTm_lim((int) config.timeLimit() * 1000); // seconds to milliseconds
		// Random seed not supported by the GLPK Java interface
		// TODO: Set output flag

		GLPK.glp_set_prob_name(model, "GIPS problem");
	}

	@Override
	public ILPSolverOutput solve() {
//		setUpVars();
//		setUpCnstrs();

		// Variables
		GLPK.glp_add_cols(model, ilpVars.size());

		int varCounter = 1;
		for (final String k : ilpVars.keySet()) {
			GLPK.glp_set_col_name(model, varCounter, k);
			GLPK.glp_set_col_kind(model, varCounter, GLPKConstants.GLP_BV); // binary
			GLPK.glp_set_col_bnds(model, varCounter, GLPKConstants.GLP_DB, 0, 1);
			varCounter++;
		}

		// Constraints
		GLPK.glp_add_rows(model, constraints.size());

		final Iterator<ILPConstraint<Integer>> cnstrIt = constraints.iterator();
		int cnstrCounter = 1;
		while (cnstrIt.hasNext()) {
			final ILPConstraint<Integer> cnstr = cnstrIt.next();
			final int size = cnstr.lhsTerms().size();
			final SWIGTYPE_p_int vars = GLPK.new_intArray(size + 1);
			final SWIGTYPE_p_double coeffs = GLPK.new_doubleArray(size + 1);

			for (int termCounter = 0; termCounter < cnstr.lhsTerms().size(); termCounter++) {
				GLPK.intArray_setitem(vars, termCounter + 1,
						ilpVars.get(cnstr.lhsTerms().get(termCounter).variable().getName()));
				GLPK.doubleArray_setitem(coeffs, termCounter + 1, cnstr.lhsTerms().get(termCounter).weight());
			}

			GLPK.glp_set_row_name(model, cnstrCounter, String.valueOf(cnstrCounter));
			GLPK.glp_set_mat_row(model, cnstrCounter, size, vars, coeffs);
			GLPK.glp_set_row_bnds(model, cnstrCounter, convertOperator(cnstr.operator()), cnstr.rhsConstantTerm(),
					cnstr.rhsConstantTerm());

			cnstrCounter++;
		}

		// Objective
		final ILPNestedLinearFunction<?> nestFunc = objective.getObjectiveFunction();

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
		GLPK.glp_set_obj_coef(model, 0, 0);

		// Constants
		double constSum = 0;
		for (ILPConstant<Double> c : nestFunc.constants()) {
			constSum += c.weight();
		}

		// Terms
		for (final ILPWeightedLinearFunction<?> lf : nestFunc.linearFunctions()) {
			lf.linearFunction().terms().forEach(t -> {
				GLPK.glp_set_obj_coef(model, ilpVars.get(t.variable().getName()), t.weight());
			});

			for (final ILPConstant<Double> c : lf.linearFunction().constantTerms()) {
				constSum += c.weight();
			}
		}

		// Add global constant sum
		GLPK.glp_set_obj_coef(model, 0, constSum);

//		GLPK.glp_write_lp(model, null, "glpk.lp");

		// Solving
		final int ret = GLPK.glp_intopt(model, iocp);
		final boolean unbounded = GLPK.glp_get_status(model) == GLPK.GLP_UNBND;
		final boolean feasible = ret == 0;
		final boolean timeout = ret == GLPK.GLP_ETMLIM;

		// Determine status
		ILPSolverStatus status = null;
		if (feasible) {
			status = ILPSolverStatus.OPTIMAL;
		} else if (unbounded) {
			status = ILPSolverStatus.UNBOUNDED;
		} else if (timeout) {
			status = ILPSolverStatus.TIME_OUT;
		} else {
			throw new RuntimeException("GLPK: Something went wrong.");
		}
		return new ILPSolverOutput(status, GLPK.glp_mip_obj_val(model));
	}

	@Override
	public void updateValuesFromSolution() {
		// Iterate over all mappers
		for (final String key : engine.getMappers().keySet()) {
			final GipsMapper<?> mapper = engine.getMapper(key);
			// Iterate over all mappings of each mapper
			for (final String k : mapper.getMappings().keySet()) {
				// Get corresponding ILP variable name
				final String varName = mapper.getMapping(k).ilpVariable;
				// Get value of the ILP variable and round it (to eliminate small deltas)
				double result = Math.round(GLPK.glp_mip_col_val(model, ilpVars.get(varName)));
				// Save result value in specific mapping
				mapper.getMapping(k).setValue((int) result);
			}
		}
	}

	@Override
	protected void translateMapping(final GipsMapping mapping) {
		ilpVars.put(mapping.ilpVariable, ilpVars.size() + 1);
	}

	@Override
	protected void translateConstraint(final GipsMappingConstraint<? extends EObject> constraint) {
		constraints.addAll(constraint.getConstraints());
	}

	@Override
	protected void translateConstraint(final GipsPatternConstraint<?, ?> constraint) {
		constraints.addAll(constraint.getConstraints());
	}

	@Override
	protected void translateConstraint(final GipsTypeConstraint<? extends EObject> constraint) {
		constraints.addAll(constraint.getConstraints());
	}

	@Override
	protected void translateObjective(final GipsGlobalObjective objective) {
//		final ILPNestedLinearFunction<?> nestFunc = objective.getObjectiveFunction();
//
//		// Set goal
//		int goal = 0;
//		switch (nestFunc.goal()) {
//		case MAX -> {
//			goal = GLPKConstants.GLP_MAX;
//		}
//		case MIN -> {
//			goal = GLPKConstants.GLP_MIN;
//		}
//		}
//		GLPK.glp_set_obj_dir(model, goal);
//
//		// Constants
//		double constSum = 0;
//		for (ILPConstant<Double> c : nestFunc.constants()) {
//			constSum += c.weight();
//		}
//
//		// Terms
//		for (final ILPWeightedLinearFunction<?> lf : nestFunc.linearFunctions()) {
//			lf.linearFunction().terms().forEach(t -> {
//				GLPK.glp_set_obj_coef(model, ilpVars.get(t.variable().getName()), t.weight());
//			});
//
//			for (final ILPConstant<Double> c : lf.linearFunction().constantTerms()) {
//				constSum += c.weight();
//			}
//		}
//
//		// Add global constant sum
//		GLPK.glp_set_obj_coef(model, 0, constSum);

		this.objective = objective;
	}

//	private void setUpVars() {
//		// Set number of variables
//		GLPK.glp_add_cols(model, ilpVars.size());
//		for (final String var : ilpVars.keySet()) {
//			GLPK.glp_set_col_name(model, ilpVars.get(var), var);
//
//			// Currently, only binary variables are supported
//			GLPK.glp_set_col_kind(model, ilpVars.get(var), GLPKConstants.GLP_BV);
//			GLPK.glp_set_col_bnds(model, ilpVars.get(var), GLPKConstants.GLP_DB, 0, 1);
//		}
//	}
//
//	private void setUpCnstrs() {
//		int cnstrRowCounter = 1;
//		GLPK.glp_add_rows(model, constraints.size());
//		for (final ILPConstraint<Integer> cnstr : constraints) {
//			final SWIGTYPE_p_int ind = GLPK.new_intArray(cnstr.lhsTerms().size());
//			final SWIGTYPE_p_double val = GLPK.new_doubleArray(cnstr.lhsTerms().size());
//
//			GLPK.glp_set_row_name(model, cnstrRowCounter, "cnstr_" + cnstrRowCounter);
//			int termIndexCounter = 0;
//			for (final ILPTerm<Integer, Double> term : cnstr.lhsTerms()) {
//				final int var = ilpVars.get(term.variable().getName());
//
//				GLPK.intArray_setitem(ind, termIndexCounter + 1, var);
//				GLPK.doubleArray_setitem(val, termIndexCounter + 1, term.weight());
//				termIndexCounter++;
//			}
//
//			setOperator(cnstr.operator(), cnstr.rhsConstantTerm(), cnstrRowCounter);
//			GLPK.glp_set_mat_row(model, cnstrRowCounter, cnstr.lhsTerms().size(), ind, val);
//		}
//
//	}

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

}
