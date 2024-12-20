package org.emoflon.gips.core;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emoflon.gips.core.ilp.ILPSolver;
import org.emoflon.gips.core.ilp.ILPSolverOutput;
import org.emoflon.gips.core.ilp.ILPSolverStatus;
import org.emoflon.gips.core.ilp.ILPVariable;
import org.emoflon.gips.core.validation.GipsConstraintValidationLog;
import org.emoflon.gips.debugger.api.Gips2IlpTracer;
import org.emoflon.gips.intermediate.GipsIntermediate.Variable;

public abstract class GipsEngine {

	final protected Map<String, GipsMapper<?>> mappers = new HashMap<>();
	final protected Map<Object, Map<String, ILPVariable<?>>> nonMappingVariables = Collections
			.synchronizedMap(new HashMap<>());
	protected TypeIndexer indexer;
	protected GipsConstraintValidationLog validationLog;
	final protected Map<String, GipsConstraint<?, ?, ?>> constraints = new HashMap<>();
	final protected Map<String, GipsObjective<?, ?, ?>> objectives = new HashMap<>();
	protected GipsGlobalObjective globalObjective;
	protected ILPSolver ilpSolver;
	protected Gips2IlpTracer tracer;

	public abstract void update();

	public abstract void saveResult() throws IOException;

	public abstract void saveResult(final String path) throws IOException;

	public void buildILPProblem(boolean doUpdate) {
		if (doUpdate) {
			update();
		}

		// Reset validation log
		validationLog = new GipsConstraintValidationLog();

		// Constraints are re-build a few lines below
		constraints.values().stream().forEach(GipsConstraint::clear);

		// Objectives will be build by the global objective call below
//		objectives.values().stream().forEach(objective -> objective.clear());
		// TODO: It seems to me that this is not necessary for objectives. All tests
		// (and also the dedicated tests for checking this!) are happy with it.

		nonMappingVariables.clear();
		mappers.values().stream().flatMap(mapper -> mapper.getMappings().values().stream())
				.filter(GipsMapping::hasAdditionalVariables).forEach(m -> {
					Map<String, ILPVariable<?>> variables = nonMappingVariables.get(m);
					if (variables == null) {
						variables = Collections.synchronizedMap(new HashMap<>());
						nonMappingVariables.put(m, variables);
					}
					variables.putAll(m.getAdditionalVariables());
				});

		constraints.values().stream().forEach(GipsConstraint::calcAdditionalVariables);
		constraints.values().stream().forEach(GipsConstraint::buildConstraints);
		if (globalObjective != null) {
			globalObjective.buildObjectiveFunction();
		}

		ilpSolver.buildILPProblem();

		buildTracingTree();
	}

	protected void buildTracingTree() {
		final var tracer = getTracer();

		// try to build a bridge between ILP model and ILP text file

		for (final var mapper : this.mappers.values()) {
			tracer.gips2intern(mapper.mapping, "mapping::" + mapper.getName());
			final var fragmentPath = EcoreUtil.getURI(mapper.mapping);
			System.out.println(fragmentPath + " maps to " + mapper.getMappings().size() + " values");
		}

		for (final var constraint : this.constraints.values()) {
			tracer.gips2intern(constraint.constraint, "constraint::" + constraint.getName());
			for (final var ilpConstraint : constraint.getConstraints()) {
				for (final var ilpTerm : ilpConstraint.lhsTerms()) {
					tracer.gips2intern(constraint.constraint.getExpression(),
							"constraint-var::" + ilpTerm.variable().getName());
				}
			}

			for (final var variables : constraint.getAdditionalVariables()) {
				tracer.gips2intern(constraint.constraint.getExpression(), "constraint-var::" + variables.getName());
			}
		}

		for (final var objective : this.objectives.values()) {
			tracer.gips2intern(objective.objective, "objective::" + objective.getName());
			for (var term : objective.terms) {
				tracer.gips2intern(objective.objective, "objective-var::" + term.variable().getName());
			}

			final var fragmentPath = EcoreUtil.getURI(objective.objective);
			System.out.println(fragmentPath + " maps to " + objective.terms.size() + " values");
		}

		final var constraintsInMapper = new HashSet<>(this.mappers.keySet());
		constraintsInMapper.retainAll(this.constraints.keySet());
		System.out.println("Constraints in mapper " + constraintsInMapper.size() + " of " + constraints.size() + " ["
				+ mappers.size() + "]");

		final var objectsInMapper = new HashSet<>(this.mappers.keySet());
		objectsInMapper.retainAll(this.objectives.keySet());
		System.out.println("Objectives in mapper " + objectsInMapper.size() + " of " + objectives.size() + " ["
				+ mappers.size() + "]");

		if (globalObjective != null) {
			tracer.gips2intern(globalObjective.objective, "globalObjective::");
		}

		tracer.finalizeTrace();
	}

	public ILPSolverOutput solveILPProblem() {
		if (validationLog.isNotValid()) {
			ILPSolverOutput output = new ILPSolverOutput(ILPSolverStatus.INFEASIBLE, Double.NaN, validationLog, 0);
			ilpSolver.reset();
			return output;
		}
		ILPSolverOutput output = ilpSolver.solve();
		if (output.status() != ILPSolverStatus.INFEASIBLE && output.solutionCount() > 0) {
			ilpSolver.updateValuesFromSolution();
		}

		ilpSolver.reset();
		return output;
	}

	public GipsMapper<?> getMapper(final String mappingName) {
		return mappers.get(mappingName);
	}

	public Map<String, GipsMapper<?>> getMappers() {
		return mappers;
	}

	public Map<String, GipsConstraint<?, ?, ?>> getConstraints() {
		return constraints;
	}

	public Map<String, GipsObjective<?, ?, ?>> getObjectives() {
		return objectives;
	}

	public TypeIndexer getIndexer() {
		return indexer;
	}

	public GipsConstraintValidationLog getValidationLog() {
		return validationLog;
	}

	public GipsGlobalObjective getGlobalObjective() {
		return globalObjective;
	}

	public void terminate() {
		ilpSolver.terminate();
		indexer.terminate();
		mappers.forEach((name, mapper) -> mapper.terminate());
	}

	protected abstract void initTypeIndexer();

	public synchronized ILPVariable<?> getNonMappingVariable(final Object context, final String variableTypeName) {
		Map<String, ILPVariable<?>> variables = nonMappingVariables.get(context);
		if (variables == null) {
			throw new RuntimeException(
					"Variable <" + variableTypeName + "> is not present in the non-mapping variable index.");
		}

		return variables.get(variableTypeName);

	}

	public synchronized void addNonMappingVariable(final Object context, final Variable variableType,
			ILPVariable<?> variable) {
		Map<String, ILPVariable<?>> variables = nonMappingVariables.get(context);
		if (variables == null) {
			variables = Collections.synchronizedMap(new HashMap<>());
			nonMappingVariables.put(context, variables);
		}
		variables.put(variableType.getName(), variable);

	}

	public synchronized void removeNonMappingVariable(final ILPVariable<?> ilpVar) {
		nonMappingVariables.remove(ilpVar.getName());
	}

	protected void addMapper(final GipsMapper<?> mapper) {
		mappers.put(mapper.getName(), mapper);
	}

	protected void addConstraint(final GipsConstraint<?, ?, ?> constraint) {
		constraints.put(constraint.getName(), constraint);
	}

	protected void addObjective(final GipsObjective<?, ?, ?> objective) {
		objectives.put(objective.getName(), objective);
	}

	protected void setGlobalObjective(final GipsGlobalObjective globalObjective) {
		this.globalObjective = globalObjective;
	}

	public void setILPSolver(final ILPSolver solver) {
		this.ilpSolver = solver;
	}

	public void setTracer(final Gips2IlpTracer tracer) {
		this.tracer = tracer;
	}

	public Gips2IlpTracer getTracer() {
		return this.tracer;
	}
}
