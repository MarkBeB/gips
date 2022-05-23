package org.emoflon.gips.core.gt;

import java.util.List;

import org.emoflon.gips.core.GipsConstraint;
import org.emoflon.gips.core.GipsEngine;
import org.emoflon.gips.core.ilp.ILPConstraint;
import org.emoflon.gips.core.ilp.ILPTerm;
import org.emoflon.gips.core.validation.GipsValidationEventType;
import org.emoflon.gips.intermediate.GipsIntermediate.PatternConstraint;
import org.emoflon.gips.intermediate.GipsIntermediate.RelationalExpression;
import org.emoflon.gips.intermediate.GipsIntermediate.RelationalOperator;
import org.emoflon.ibex.gt.api.GraphTransformationMatch;
import org.emoflon.ibex.gt.api.GraphTransformationPattern;

public abstract class GipsPatternConstraint<ENGINE extends GipsEngine, M extends GraphTransformationMatch<M, P>, P extends GraphTransformationPattern<M, P>>
		extends GipsConstraint<ENGINE, PatternConstraint, M, Integer> {

	final protected GraphTransformationPattern<M, P> pattern;

	public GipsPatternConstraint(ENGINE engine, PatternConstraint constraint, final P pattern) {
		super(engine, constraint);
		this.pattern = pattern;
	}

	@Override
	public void buildConstraints() {
		pattern.findMatches(false).parallelStream().forEach(context -> {
			final ILPConstraint<Integer> candidate = buildConstraint(context);
			if (candidate != null) {
				ilpConstraints.put(context, buildConstraint(context));
			}
		});

		if (constraint.isDepending()) {
			pattern.findMatches(false).parallelStream().forEach(context -> {
				final List<ILPConstraint<?>> constraints = buildDependingConstraints(context);
				dependingIlpConstraints.put(context, constraints);
			});

		}
	}

	@Override
	public ILPConstraint<Integer> buildConstraint(final M context) {
		if (!isConstant && !(constraint.getExpression() instanceof RelationalExpression))
			throw new IllegalArgumentException("Boolean values can not be transformed to ilp relational constraints.");

		if (!isConstant) {
			RelationalOperator operator = ((RelationalExpression) constraint.getExpression()).getOperator();
			double constTerm = buildConstantRhs(context);
			List<ILPTerm<Integer, Double>> terms = buildVariableLhs(context);
			if (!terms.isEmpty())
				return new ILPConstraint<>(terms, operator, constTerm);

			// If the terms list is empty, no suitable mapping candidates are present in the
			// model. Therefore, zero variables are created, which in turn, can only result
			// in a sum of zero. Hence, we will continue to evaluate the constraint with a
			// zero value, since this might be intended behavior.
			boolean result = evaluateConstantConstraint(0.0d, constTerm, operator);
			if (!result) {
				StringBuilder sb = new StringBuilder();
				sb.append(constTerm);
				sb.append(" ");
				sb.append(operator);
				sb.append(" 0.0");
				sb.append(" -> ");
				sb.append(result ? "true" : "false");
				validationLog.addValidatorEvent(GipsValidationEventType.CONST_CONSTRAINT_VIOLATION, this.getClass(),
						sb.toString());
			}

			return null;
		} else {
			if (constraint.getExpression() instanceof RelationalExpression relExpr) {
				double lhs = buildConstantLhs(context);
				double rhs = buildConstantRhs(context);
				boolean result = evaluateConstantConstraint(lhs, rhs, relExpr.getOperator());
				if (!result) {
					StringBuilder sb = new StringBuilder();
					sb.append(lhs);
					sb.append(" ");
					sb.append(relExpr.getOperator());
					sb.append(" ");
					sb.append(rhs);
					sb.append(" -> ");
					sb.append(result ? "true" : "false");
					validationLog.addValidatorEvent(GipsValidationEventType.CONST_CONSTRAINT_VIOLATION, this.getClass(),
							sb.toString());
				}
			} else {
				boolean result = buildConstantExpression(context);
				if (!result) {
					StringBuilder sb = new StringBuilder();
					sb.append(" -> ");
					sb.append(result ? "true" : "false");
					validationLog.addValidatorEvent(GipsValidationEventType.CONST_CONSTRAINT_VIOLATION, this.getClass(),
							sb.toString());
				}
			}
			return null;
		}
	}

}
