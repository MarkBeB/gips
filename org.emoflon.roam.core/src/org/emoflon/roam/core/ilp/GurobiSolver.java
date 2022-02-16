package org.emoflon.roam.core.ilp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.emoflon.roam.core.RoamEngine;
import org.emoflon.roam.core.RoamMapping;
import org.emoflon.roam.core.RoamMappingConstraint;
import org.emoflon.roam.core.RoamMappingObjective;
import org.emoflon.roam.core.RoamObjective;
import org.emoflon.roam.core.RoamTypeConstraint;
import org.emoflon.roam.core.RoamTypeObjective;
import org.emoflon.roam.intermediate.RoamIntermediate.RelationalOperator;

import gurobi.GRB;
import gurobi.GRB.DoubleParam;
import gurobi.GRB.IntParam;
import gurobi.GRBEnv;
import gurobi.GRBException;
import gurobi.GRBLinExpr;
import gurobi.GRBModel;
import gurobi.GRBVar;

public class GurobiSolver extends ILPSolver {

	/**
	 * Gurobi environment (for configuration etc.).
	 */
	private final GRBEnv env;

	/**
	 * Gurobi model.
	 */
	private GRBModel model;

	/**
	 * Look-up data structure to speed-up the variable look-up.
	 */
	private final HashMap<String, GRBVar> grbVars = new HashMap<String, GRBVar>();

	/**
	 * Global objective expression that will be constructed while executing
	 * 'translateObjective(...)'.
	 */
	private GRBLinExpr obj;

	public GurobiSolver(final RoamEngine engine, final ILPSolverConfig config) throws Exception {
		super(engine);
		env = new GRBEnv("Gurobi_ILP.log");
		env.set(DoubleParam.TimeLimit, config.timeLimit());
		env.set(IntParam.Seed, config.randomSeed());
		env.set(IntParam.Presolve, config.enablePresolve() ? 1 : 0);
		if (!config.enableOutput()) {
			env.set(IntParam.OutputFlag, 0);
		}
		model = new GRBModel(env);
		model.set(DoubleParam.TimeLimit, config.timeLimit());
		model.set(IntParam.Seed, config.randomSeed());
	}

	@Override
	public void solve() {
		try {
			// Finish setup
			model.setObjective(obj);

			// Solving starts here
			model.update();
			// TODO: Set optimality tolerance here
			model.optimize();
			// TODO: Determine solver status (e.g., 'infeasible')
		} catch (final GRBException e) {
			// TODO
		}
	}

	@Override
	public void updateValuesFromSolution() {
		// TODO Auto-generated method stub

		// TODO: Free model after solution update?
	}

	@Override
	protected void translateMapping(RoamMapping mapping) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void translateConstraint(RoamMappingConstraint constraint) {
		addIlpConstraintsToGrb(constraint.getConstraints(), constraint.getName());
	}

	@Override
	protected void translateConstraint(RoamTypeConstraint constraint) {
		addIlpConstraintsToGrb(constraint.getConstraints(), constraint.getName());
	}

	@Override
	protected void translateObjective(RoamMappingObjective objective) {
		addToObj(objective);
	}

	@Override
	protected void translateObjective(RoamTypeObjective objective) {
		addToObj(objective);
	}

	//
	// Helper methods
	//

	/**
	 * Adds a given collection of ILP constraints and a given constraint name to the
	 * Gurobi model.
	 * 
	 * @param constraints Collection of integer ILP constraints to add.
	 * @param name        Name of the overall constraint to add.
	 */
	private void addIlpConstraintsToGrb(final Collection<ILPConstraint<Integer>> constraints, final String name) {
		// For each constraint, create a Gurobi constraint
		int counter = 0;

		// Have to use an iterator to be able to increment the counter
		final Iterator<ILPConstraint<Integer>> cnstrsIt = constraints.iterator();
		while (cnstrsIt.hasNext()) {
			final ILPConstraint<Integer> curr = cnstrsIt.next();
			final GRBLinExpr grbLinExpr = new GRBLinExpr();

			//
			// Operator
			//

			final char op = convertOperator(curr.operator().getValue());

			//
			// Terms
			//

			// Add each term to the GRB linear expression
			curr.terms().forEach(t -> {
				try {
					final GRBVar var = model.addVar(0.0, 1.0, 0.0, GRB.BINARY, t.variable().getName());
					grbLinExpr.addTerm(t.weight(), var);
					grbVars.put(t.variable().getName(), var);
				} catch (final GRBException e) {
					throw new UnsupportedOperationException(e);
				}
			});

			// Add current constructed constraint to the GRB model
			try {
				model.addConstr(grbLinExpr, op, curr.constantTerm(), name + "_" + counter++);
			} catch (final GRBException e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	/**
	 * Converts a given operator value (from RelationalOperator) to the
	 * corresponding GRB char value.
	 * 
	 * @param op Operator value to convert.
	 * @return Corresponding GRB char value.
	 */
	private char convertOperator(final int op) {
		switch (op) {
		case RelationalOperator.LESS_VALUE:
			// https://www.gurobi.com/documentation/9.5/refman/java_model_addconstr.html
			throw new UnsupportedOperationException("Gurobi does not support LESS in constraints.");
		// break;
		// TODO: Could be expressed with !(x >= a)
		case RelationalOperator.LESS_OR_EQUAL_VALUE:
			return GRB.LESS_EQUAL;
		case RelationalOperator.EQUAL_VALUE:
			return GRB.EQUAL;
		case RelationalOperator.GREATER_OR_EQUAL_VALUE:
			return GRB.GREATER_EQUAL;
		case RelationalOperator.GREATER_VALUE:
			throw new UnsupportedOperationException("Gurobi does not support GREATER in constraints.");
		// break;
		// TODO: Could be expressed with !(x <= a)
		case RelationalOperator.NOT_EQUAL_VALUE:
			throw new UnsupportedOperationException("Gurobi does not support NOT EQUAL in constraints.");
		// TODO: This introduces an OR constraint
		// https://math.stackexchange.com/questions/37075/how-can-not-equals-be-expressed-as-an-inequality-for-a-linear-programming-model/1517850
		// break;
		default:
			throw new UnsupportedOperationException("Not yet implemented.");
		}

		// We do not support strict less-than, strict greater-than, or not-equal
		// comparators. While these other comparators may seem appropriate for
		// mathematical programming, we exclude them to avoid potential confusion
		// related to numerical tolerances.
		//
		// https://www.gurobi.com/documentation/9.5/refman/constraints.html
	}

	/**
	 * Adds the terms with their weights from a given Roam objective to the global
	 * objective.
	 * 
	 * @param objective Roam objective to add to the global objective.
	 */
	private void addToObj(final RoamObjective<?, ?, Integer> objective) {
		initObjIfNull();

		final List<ILPTerm<Integer, Double>> terms = objective.getObjectiveFunction().terms();
		terms.forEach(t -> {
			obj.addTerm(t.weight(), getVar(t.variable().getName()));
		});
	}

	/**
	 * Returns the corresponding GRBVar for a given name.
	 * 
	 * @param name Name to search variable for.
	 * @return GBRVar for a given name.
	 */
	private GRBVar getVar(final String name) {
		if (grbVars.containsKey(name)) {
			return grbVars.get(name);
		}

		try {
			return model.getVarByName(name);
		} catch (final GRBException e) {
			return null;
		}
	}

	/**
	 * Initializes the global objective (GRBExpr) if it is null.
	 */
	private void initObjIfNull() {
		if (this.obj == null) {
			this.obj = new GRBLinExpr();
		}
	}

}
