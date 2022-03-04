package org.emoflon.roam.core;

import java.util.List;

import org.emoflon.roam.core.ilp.ILPConstraint;
import org.emoflon.roam.core.ilp.ILPTerm;
import org.emoflon.roam.intermediate.RoamIntermediate.MappingConstraint;

public abstract class RoamMappingConstraint<CONTEXT extends RoamMapping>
		extends RoamConstraint<MappingConstraint, CONTEXT, Integer> {

	final protected RoamMapper<CONTEXT> mapper;

	@SuppressWarnings("unchecked")
	public RoamMappingConstraint(RoamEngine engine, MappingConstraint constraint) {
		super(engine, constraint);
		mapper = (RoamMapper<CONTEXT>) engine.getMapper(constraint.getMapping().getName());
	}

	@Override
	public void buildConstraints() {
		mapper.getMappings().values().parallelStream().forEach(context -> {
			ilpConstraints.put(context, buildConstraint(context));
		});
	}

	@Override
	public ILPConstraint<Integer> buildConstraint(final CONTEXT context) {
		double constTerm = buildConstantTerm(context);
		List<ILPTerm<Integer, Double>> terms = buildVariableTerms(context);
		return new ILPConstraint<>(constTerm, constraint.getExpression().getOperator(), terms);
	}

}
