/*
 * generated by Xtext 2.25.0
 */
package org.emoflon.roam.roamslang.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.emoflon.roam.roamslang.roamSLang.EditorGTFile;
import org.emoflon.roam.roamslang.roamSLang.RoamArithmeticExpr;
import org.emoflon.roam.roamslang.roamSLang.RoamArithmeticLiteral;
import org.emoflon.roam.roamslang.roamSLang.RoamArithmeticUnaryOperator;
import org.emoflon.roam.roamslang.roamSLang.RoamAttributeExpr;
import org.emoflon.roam.roamslang.roamSLang.RoamBinaryBoolExpr;
import org.emoflon.roam.roamslang.roamSLang.RoamBool;
import org.emoflon.roam.roamslang.roamSLang.RoamBoolBinaryOperator;
import org.emoflon.roam.roamslang.roamSLang.RoamBoolExpr;
import org.emoflon.roam.roamslang.roamSLang.RoamBoolUnaryOperator;
import org.emoflon.roam.roamslang.roamSLang.RoamBooleanLiteral;
import org.emoflon.roam.roamslang.roamSLang.RoamBracketExpr;
import org.emoflon.roam.roamslang.roamSLang.RoamConstraint;
import org.emoflon.roam.roamslang.roamSLang.RoamContextExpr;
import org.emoflon.roam.roamslang.roamSLang.RoamContextOperation;
import org.emoflon.roam.roamslang.roamSLang.RoamContextOperationExpression;
import org.emoflon.roam.roamslang.roamSLang.RoamExpArithmeticExpr;
import org.emoflon.roam.roamslang.roamSLang.RoamExpOperator;
import org.emoflon.roam.roamslang.roamSLang.RoamExpressionOperand;
import org.emoflon.roam.roamslang.roamSLang.RoamFeatureExpr;
import org.emoflon.roam.roamslang.roamSLang.RoamFeatureLit;
import org.emoflon.roam.roamslang.roamSLang.RoamFeatureNavigation;
import org.emoflon.roam.roamslang.roamSLang.RoamLambdaAttributeExpression;
import org.emoflon.roam.roamslang.roamSLang.RoamLambdaExpression;
import org.emoflon.roam.roamslang.roamSLang.RoamMapping;
import org.emoflon.roam.roamslang.roamSLang.RoamMappingAttributeExpr;
import org.emoflon.roam.roamslang.roamSLang.RoamNodeAttributeExpr;
import org.emoflon.roam.roamslang.roamSLang.RoamObjective;
import org.emoflon.roam.roamslang.roamSLang.RoamObjectiveExpression;
import org.emoflon.roam.roamslang.roamSLang.RoamProductArithmeticExpr;
import org.emoflon.roam.roamslang.roamSLang.RoamProductOperator;
import org.emoflon.roam.roamslang.roamSLang.RoamRelExpr;
import org.emoflon.roam.roamslang.roamSLang.RoamRelOperator;
import org.emoflon.roam.roamslang.roamSLang.RoamSLangPackage;
import org.emoflon.roam.roamslang.roamSLang.RoamSelect;
import org.emoflon.roam.roamslang.roamSLang.RoamStreamArithmetic;
import org.emoflon.roam.roamslang.roamSLang.RoamStreamBoolExpr;
import org.emoflon.roam.roamslang.roamSLang.RoamStreamExpr;
import org.emoflon.roam.roamslang.roamSLang.RoamStreamNavigation;
import org.emoflon.roam.roamslang.roamSLang.RoamStreamNoArgOperator;
import org.emoflon.roam.roamslang.roamSLang.RoamStreamSet;
import org.emoflon.roam.roamslang.roamSLang.RoamStreamSetOperator;
import org.emoflon.roam.roamslang.roamSLang.RoamSumArithmeticExpr;
import org.emoflon.roam.roamslang.roamSLang.RoamSumOperator;
import org.emoflon.roam.roamslang.roamSLang.RoamTypeCast;
import org.emoflon.roam.roamslang.roamSLang.RoamUnaryArithmeticExpr;
import org.emoflon.roam.roamslang.roamSLang.RoamUnaryBoolExpr;

/**
 * This class contains custom validation rules.
 *
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class RoamSLangValidator extends AbstractRoamSLangValidator {

	/**
	 * The list of invalid mapping/objective names. Will be filled in the static
	 * block.
	 */
	public static final Set<String> INVALID_NAMES = new HashSet<String>();

	static {
		final String[] invalidNames = new String[] { "clone", "equals", "finalize", "getClass", "hashCode", "notify",
				"notifyAll", "toString", "wait", "abstract", "assert", "boolean", "break", "byte", "case", "catch",
				"char", "class", "const", "continue", "default", "do", "double", "EAttribute", "EBoolean", "EDataType",
				"EClass", "EClassifier", "EDouble", "EFloat", "EInt", "else", "enum", "EPackage", "EReference",
				"EString", "extends", "final", "finally", "float", "for", "goto", "if", "implements", "import",
				"instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected", "public",
				"return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws",
				"transient", "try", "void", "volatile", "while",

				// New values
				"mapping", "objective", "global objective", "global", "min", "max", "constraint" };
		INVALID_NAMES.addAll(Arrays.asList(invalidNames));
	}

	static final String CODE_PREFIX = "org.emoflon.roam.roamslang.";

	// General errors for named elements.
	public static final String NAME_BLOCKED = CODE_PREFIX + "name.blocked";
	public static final String NAME_EXPECT_CAMEL_CASE = CODE_PREFIX + "name.expectCamelCase";
	public static final String NAME_EXPECT_LOWER_CASE = CODE_PREFIX + "name.expectLowerCase";
	public static final String NAME_EXPECT_UNIQUE = CODE_PREFIX + "name.expectUnique";

	public static final String GLOBA_OBJJECTIVE_DOES_NOT_EXIST = CODE_PREFIX + "objective.global.doesNotExist";

	public static final String GLOBAL_OBJECTIVE_IS_NULL = "You need to specify a global objective.";

	public static final String MAPPING_NAME_MULTIPLE_DECLARATIONS_MESSAGE = "Mapping '%s' must not be declared '%s'.";
	public static final String MAPPING_NAME_FORBIDDEN_MESSAGE = "Mappings cannot be be named '%s'. Use a different name.";
	public static final String MAPPING_NAME_CONTAINS_UNDERSCORES_MESSAGE = "Mapping name '%s' contains underscores. Use camelCase instead.";
	public static final String MAPPING_NAME_STARTS_WITH_LOWER_CASE_MESSAGE = "Mapping '%s' should start with a lower case character.";

	public static final String OBJECTIVE_NAME_MULTIPLE_DECLARATIONS_MESSAGE = "Objective '%s' must not be declared '%s'";
	public static final String OBJECTIVE_NAME_FORBIDDEN_MESSAGE = "Objectives cannot be be named '%s'. Use a different name.";
	public static final String OBJECTIVE_NAME_CONTAINS_UNDERSCORES_MESSAGE = "Objective name '%s' contains underscores. Use camelCase instead.";
	public static final String OBJECTIVE_NAME_STARTS_WITH_LOWER_CASE_MESSAGE = "Objective '%s' should start with a lower case character.";

	// Other errors for types
	public static final String OBJECTIVE_VALUE_IS_ZERO_MESSAGE = "Objective '%s' can be removed because its value is 0.";

	public static final String CONSTRAINT_EVAL_NOT_BOOLEAN_MESSAGE = "Constraint does not evaluate to a boolean";
	public static final String CONSTRAINT_EVAL_LITERAL_MESSAGE = "Constraint is always '%s'.";

	public static final String OBJECTIVE_EVAL_NOT_NUMBER_MESSAGE = "Objective does not evaluate to an integer or double.";

	public static final String LITERAL_NOT_PARSABLE_MESSAGE = "Literal is not parsable.";

	public static final String LAMBDA_EXPR_EVAL_NOT_BOOLEAN_MESSAGE = "Lambda expression does not evaluate to boolean.";
	public static final String LAMBDA_EXPR_EVAL_LITERAL_MESSAGE = "Lambda expression is always '%s'.";

	public static final String CONSTRAINT_DEFINED_MULTIPLE_TIMES_MESSAGE = "Constraint defined multiple times.";

	// Exception error messages
	public static final String NOT_IMPLEMENTED_EXCEPTION_MESSAGE = "Not yet implemented";

	/**
	 * Checks if a global objective is specified in a given file. This must hold if
	 * there is any local objective defined.
	 * 
	 * @param file File to check existence of a global objective for.
	 */
	@Check
	public void checkGlobalObjectiveNotNull(final EditorGTFile file) {
		if (file.getObjectives() != null && !file.getObjectives().isEmpty() && file.getGlobalObjective() == null) {
			error(GLOBAL_OBJECTIVE_IS_NULL, //
					// TODO: I'm not quite sure about the second parameter:
					RoamSLangPackage.Literals.EDITOR_GT_FILE__GLOBAL_OBJECTIVE, //
					GLOBA_OBJJECTIVE_DOES_NOT_EXIST); //
		}
	}

	/**
	 * Runs checks for all Roam mappings.
	 * 
	 * @param mapping Input Roam mapping to check.
	 */
	@Check
	public void checkMapping(final RoamMapping mapping) {
		checkMappingNameValid(mapping);
		checkMappingNameUnique(mapping);
	}

	/**
	 * Checks for validity of a mapping name. The name must not be on the list of
	 * invalid names, the name should be in lowerCamelCase, and the name should
	 * start with a lower case character.
	 * 
	 * @param mapping Roam mapping to check.
	 */
	public void checkMappingNameValid(final RoamMapping mapping) {
		if (mapping.getName() == null) {
			return;
		}

		if (INVALID_NAMES.contains(mapping.getName())) {
			error( //
					String.format(MAPPING_NAME_FORBIDDEN_MESSAGE, mapping.getName()), //
					RoamSLangPackage.Literals.ROAM_MAPPING__NAME, //
					NAME_EXPECT_UNIQUE //
			);
		} else {
			// The mapping name should be lowerCamelCase.
			if (mapping.getName().contains("_")) {
				warning( //
						String.format(MAPPING_NAME_CONTAINS_UNDERSCORES_MESSAGE, mapping.getName()), //
						RoamSLangPackage.Literals.ROAM_MAPPING__NAME, //
						NAME_BLOCKED //
				);
			} else {
				// The mapping name should start with a lower case character.
				if (!Character.isLowerCase(mapping.getName().charAt(0))) {
					warning( //
							String.format(MAPPING_NAME_STARTS_WITH_LOWER_CASE_MESSAGE, mapping.getName()), //
							RoamSLangPackage.Literals.ROAM_MAPPING__NAME, NAME_EXPECT_LOWER_CASE //
					);
				}
			}
		}
	}

	/**
	 * Checks the uniqueness of the name of a given Roam mapping.
	 * 
	 * @param mapping Roam mapping to check uniqueness of the name for.
	 */
	public void checkMappingNameUnique(final RoamMapping mapping) {
		final EditorGTFile container = (EditorGTFile) mapping.eContainer();
		final int count = (int) container.getMappings().stream()
				.filter(m -> m.getName() != null && m.getName().equals(mapping.getName())).count();
		if (count != 1) {
			error( //
					String.format(MAPPING_NAME_MULTIPLE_DECLARATIONS_MESSAGE, mapping.getName(), getTimes(count)), //
					RoamSLangPackage.Literals.ROAM_MAPPING__NAME, //
					NAME_EXPECT_UNIQUE //
			);
		}
	}

	/**
	 * Runs all checks for a given constraints.
	 * 
	 * @param constraint Roam constraint to check.
	 */
	@Check
	public void checkConstraint(final RoamConstraint constraint) {
		if (LeafType.BOOLEAN != getEvalTypeFromBoolExpr(constraint.getExpr().getExpr())) {
			error( //
					CONSTRAINT_EVAL_NOT_BOOLEAN_MESSAGE, //
					RoamSLangPackage.Literals.ROAM_CONSTRAINT__EXPR //
			);
		}

		checkConstraintIsLiteral(constraint);
		checkConstraintUnique(constraint);
	}

	/**
	 * Checks if the constraint is a literal and, therefore, display a warning.
	 * 
	 * @param constraint Constraint to check.
	 */
	public void checkConstraintIsLiteral(final RoamConstraint constraint) {
		if (constraint.getExpr().getExpr() instanceof RoamBooleanLiteral) {
			final RoamBooleanLiteral lit = (RoamBooleanLiteral) constraint.getExpr().getExpr();
			final String warning = String.valueOf(lit.isLiteral());
			warning( //
					String.format(CONSTRAINT_EVAL_LITERAL_MESSAGE, warning), //
					RoamSLangPackage.Literals.ROAM_CONSTRAINT__EXPR //
			);
		}
	}

	public void checkConstraintUnique(final RoamConstraint constraint) {
		final EditorGTFile file = (EditorGTFile) constraint.eContainer();
		final HashSet<RoamConstraint> others = new HashSet<>();
		for (final RoamConstraint other : file.getConstraints()) {
			if (constraint.equals(other)) {
				// TODO: ^equals is defined as '==' in this case -.-
				others.add(other);
			}
		}

		if (others.size() > 1) {
			for (final RoamConstraint other : others) {
				warning( //
						CONSTRAINT_DEFINED_MULTIPLE_TIMES_MESSAGE, //
						other, //
						RoamSLangPackage.Literals.ROAM_CONSTRAINT__CONTEXT //
				);
			}
		}
	}

	/**
	 * Runs all checks for a given objective.
	 * 
	 * @param objective Roam objective to check.
	 */
	@Check
	public void checkObjective(final RoamObjective objective) {
		checkObjectiveNameValid(objective);
		checkObjectiveNameUnique(objective);
		checkObjectiveIsNotUseless(objective);

		final LeafType eval = getEvalTypeFromArithExpr(objective.getExpr());
		if (eval != LeafType.INTEGER && eval != LeafType.DOUBLE) {
			error( //
					OBJECTIVE_EVAL_NOT_NUMBER_MESSAGE, //
					RoamSLangPackage.Literals.ROAM_OBJECTIVE__EXPR //
			);
		}
	}

	/**
	 * Checks for validity of an objective name. The name must not be on the list of
	 * invalid names, the name should be in lowerCamelCase, and the name should
	 * start with a lower case character.
	 * 
	 * @param objective Roam objective to check.
	 */
	public void checkObjectiveNameValid(final RoamObjective objective) {
		if (objective.getName() == null) {
			return;
		}

		if (INVALID_NAMES.contains(objective.getName())) {
			error( //
					String.format(OBJECTIVE_NAME_FORBIDDEN_MESSAGE, objective.getName()), //
					RoamSLangPackage.Literals.ROAM_OBJECTIVE__NAME, //
					NAME_BLOCKED //
			);
		} else {
			// The objective name should be lowerCamelCase.
			if (objective.getName().contains("_")) {
				warning( //
						String.format(OBJECTIVE_NAME_CONTAINS_UNDERSCORES_MESSAGE, objective.getName()), //
						RoamSLangPackage.Literals.ROAM_OBJECTIVE__NAME, //
						NAME_BLOCKED //
				);
			} else {
				// The objective name should start with a lower case character.
				if (!Character.isLowerCase(objective.getName().charAt(0))) {
					warning( //
							String.format(OBJECTIVE_NAME_STARTS_WITH_LOWER_CASE_MESSAGE, objective.getName()), //
							RoamSLangPackage.Literals.ROAM_OBJECTIVE__NAME, //
							NAME_EXPECT_LOWER_CASE //
					);
				}
			}
		}
	}

	/**
	 * Checks the uniqueness of the name of a given Roam objective.
	 * 
	 * @param objective Roam objective to check uniqueness of the name for.
	 */
	public void checkObjectiveNameUnique(final RoamObjective objective) {
		final EditorGTFile container = (EditorGTFile) objective.eContainer();
		final int count = (int) container.getObjectives().stream()
				.filter(o -> o.getName() != null && o.getName().equals(objective.getName())).count();
		if (count != 1) {
			error( //
					String.format(OBJECTIVE_NAME_MULTIPLE_DECLARATIONS_MESSAGE, objective.getName(), getTimes(count)), //
					RoamSLangPackage.Literals.ROAM_OBJECTIVE__NAME, //
					NAME_EXPECT_UNIQUE //
			);
		}
	}

	/**
	 * Checks a given Roam objective for uselessness, i.e, if the objective is '0'.
	 * 
	 * @param objective Roam objective to check for uselessness.
	 */
	public void checkObjectiveIsNotUseless(final RoamObjective objective) {
		if (objective.getExpr() instanceof RoamArithmeticLiteral) {
			final RoamArithmeticLiteral lit = (RoamArithmeticLiteral) objective.getExpr();
			if (lit.getValue() != null && lit.getValue().equals("0")) {
				warning( //
						String.format(OBJECTIVE_VALUE_IS_ZERO_MESSAGE, objective.getName()), //
						RoamSLangPackage.Literals.ROAM_OBJECTIVE__EXPR //
				);
			}
		}
	}

	// TODO: Is this even necessary?
	@Check
	public void checkArithmeticLiteralParsable(final RoamArithmeticLiteral literal) {
		try {
			Double.valueOf(literal.getValue());
		} catch (final NumberFormatException ex) {
			error( //
					LITERAL_NOT_PARSABLE_MESSAGE, //
					RoamSLangPackage.Literals.ROAM_ARITHMETIC_LITERAL__VALUE //
			);
		}
	}

	public LeafType getEvalTypeFromBoolExpr(final RoamBoolExpr expr) {
		if (expr instanceof RoamBooleanLiteral) {
			return LeafType.BOOLEAN;
		} else if (expr instanceof RoamBinaryBoolExpr) {
			final RoamBinaryBoolExpr boolExpr = (RoamBinaryBoolExpr) expr;
			return getEvalLeftRightSideOp(boolExpr.getLeft(), boolExpr.getRight(), boolExpr.getOperator());
		} else if (expr instanceof RoamUnaryBoolExpr) {
			final RoamUnaryBoolExpr boolExpr = (RoamUnaryBoolExpr) expr;
			return getEvalLEftRightSideOp(boolExpr.getOperand(), boolExpr.getOperator());
		} else if (expr instanceof RoamRelExpr) {
			final RoamRelExpr relExpr = (RoamRelExpr) expr;
			final LeafType leftType = getEvalTypeDelegate(relExpr.getLeft());
			final LeafType rightType = getEvalTypeDelegate(relExpr.getRight());
			return combine(leftType, rightType, relExpr.getOperator());
		}

		return LeafType.ERROR;
	}

	public LeafType getEvalTypeFromArithExpr(final RoamArithmeticExpr expr) {
		if (expr instanceof RoamBracketExpr) {
			final RoamBracketExpr brack = (RoamBracketExpr) expr;
			return getEvalTypeFromArithExpr(brack.getOperand());
		} else if (expr instanceof RoamExpArithmeticExpr) {
			final RoamExpArithmeticExpr exp = (RoamExpArithmeticExpr) expr;
			final LeafType leftType = getEvalTypeDelegate(exp.getLeft());
			final LeafType rightType = getEvalTypeDelegate(exp.getRight());
			return combine(leftType, rightType, exp.getOperator());
		} else if (expr instanceof RoamProductArithmeticExpr) {
			final RoamProductArithmeticExpr prod = (RoamProductArithmeticExpr) expr;
			final LeafType leftType = getEvalTypeDelegate(prod.getLeft());
			final LeafType rightType = getEvalTypeDelegate(prod.getRight());
			return combine(leftType, rightType, prod.getOperator());
		} else if (expr instanceof RoamSumArithmeticExpr) {
			final RoamSumArithmeticExpr sum = (RoamSumArithmeticExpr) expr;
			final LeafType leftType = getEvalTypeDelegate(sum.getLeft());
			final LeafType rightType = getEvalTypeDelegate(sum.getRight());
			return combine(leftType, rightType, sum.getOperator());
		} else if (expr instanceof RoamUnaryArithmeticExpr) {
			final LeafType operand = getEvalTypeFromArithExpr(((RoamUnaryArithmeticExpr) expr).getOperand());
			return combine(operand, ((RoamUnaryArithmeticExpr) expr).getOperator());
		} else if (expr instanceof RoamExpressionOperand) {
			return getEvalTypeFromExprOp((RoamExpressionOperand) expr);
		}

		return LeafType.ERROR;
	}

	public LeafType getEvalTypeFromExprOp(final RoamExpressionOperand op) {
		if (op instanceof RoamArithmeticLiteral) {
			return getEvalTypeFromArithLit((RoamArithmeticLiteral) op);
		} else if (op instanceof RoamAttributeExpr) {
			return getEvalTypeFromAttrExpr((RoamAttributeExpr) op);
		} else if (op instanceof RoamObjectiveExpression) {
			return LeafType.OBJECTIVE;
		}

		return LeafType.ERROR;
	}

	public LeafType getEvalTypeFromAttrExpr(final RoamAttributeExpr expr) {
		if (expr instanceof RoamMappingAttributeExpr) {
			final RoamMappingAttributeExpr mapExpr = (RoamMappingAttributeExpr) expr;
			return getEvalTypeFromStreamExpr(mapExpr.getExpr());
		} else if (expr instanceof RoamContextExpr) {
			final RoamContextExpr conExpr = (RoamContextExpr) expr;
			return getEvalTypeFromContextExpr(conExpr);
		} else if (expr instanceof RoamLambdaAttributeExpression) {
			final RoamLambdaAttributeExpression lambExpr = (RoamLambdaAttributeExpression) expr;
			return getEvalTypeFromLambdaAttrExpr(lambExpr);
		}

		return LeafType.ERROR;
	}

	public LeafType getEvalTypeFromStreamExpr(final RoamStreamExpr expr) {
		if (expr instanceof RoamStreamNavigation) {
			final RoamStreamNavigation nav = (RoamStreamNavigation) expr;
			return getEvalTypeFromStreamNav(nav);
		} else if (expr instanceof RoamStreamSet) { // .filter(...)
			final RoamStreamSet set = (RoamStreamSet) expr;
			// set.getOperator(); // operator is always a filter -> output is a set
			validateLambdaExpr(set.getLambda());
			return LeafType.SET;
		} else if (expr instanceof RoamStreamArithmetic) { // .sum(...)
			final RoamStreamArithmetic arith = (RoamStreamArithmetic) expr;
			arith.getOperator(); // operator is always an integer/a double
			validateLambdaExpr(arith.getLambda());
			return LeafType.DOUBLE;
		} else if (expr instanceof RoamStreamBoolExpr) { // .exists(); .notExists(); .count()
			final RoamStreamBoolExpr boolExpr = (RoamStreamBoolExpr) expr;
			return getEvalTypeFromStreamNoArgOp(boolExpr.getOperator());
		} else if (expr instanceof RoamSelect) {
			final RoamSelect sel = (RoamSelect) expr;
			sel.getType(); // EClassifier
			// TODO
//			return leafType.ECLASS;
			throw new UnsupportedOperationException(NOT_IMPLEMENTED_EXCEPTION_MESSAGE);
		}

		return LeafType.ERROR;
	}

	public LeafType getEvalTypeFromStreamNav(final RoamStreamNavigation nav) {
		final RoamStreamExpr left = nav.getLeft();
		final RoamStreamExpr right = nav.getRight();

		final LeafType lhs = getEvalTypeFromStreamExpr(left);

		// Case: lhs is a stream set and rhs is a stream boolean expression (NOT
		// count()) = boolean
		if (left instanceof RoamStreamSet && right instanceof RoamStreamBoolExpr //
				&& ((RoamStreamBoolExpr) right).getOperator().getValue() != RoamStreamNoArgOperator.COUNT_VALUE) {
			return LeafType.BOOLEAN;
		}

		// Case: lhs is a stream set and rhs is a stream boolean expression (count()) =
		// integer
		if (left instanceof RoamStreamSet && lhs == LeafType.SET && right instanceof RoamStreamBoolExpr
				&& ((RoamStreamBoolExpr) right).getOperator().getValue() == RoamStreamNoArgOperator.COUNT_VALUE) {
			return LeafType.INTEGER;
		}

		// Case: else
		return getEvalTypeFromStreamExpr(right);
	}

	public LeafType getEvalTypeFromStreamNoArgOp(final RoamStreamNoArgOperator op) {
		final int val = op.getValue();
		if (val == RoamStreamNoArgOperator.COUNT_VALUE) {
			return LeafType.INTEGER;
		} else if (val == RoamStreamNoArgOperator.EXISTS_VALUE || val == RoamStreamNoArgOperator.NOTEXISTS_VALUE) {
			return LeafType.BOOLEAN;
		}

		return LeafType.ERROR;
	}

	public LeafType getEvalTypeFromStreamSet(final RoamStreamSet set) {
		validateLambdaExpr(set.getLambda());
		if (set.getOperator().getValue() == RoamStreamSetOperator.FILTER_VALUE) {
			return LeafType.SET;
		}

		throw new UnsupportedOperationException(NOT_IMPLEMENTED_EXCEPTION_MESSAGE);
	}

	public LeafType getEvalTypeFromLambdaAttrExpr(final RoamLambdaAttributeExpression expr) {
		validateLambdaExpr(expr.getVar());
		final EObject innerExpr = expr.getExpr();
		if (innerExpr instanceof RoamNodeAttributeExpr) {
			return getEvalTypeFromNodeAttrExpr((RoamNodeAttributeExpr) innerExpr);
		} else if (innerExpr instanceof RoamContextOperationExpression) {
			return getEvalTypeFromContextOpExpr((RoamContextOperationExpression) innerExpr);
		} else if (innerExpr instanceof RoamFeatureExpr) {
			return getEvalTypeFromFeatureExpr((RoamFeatureExpr) innerExpr);
		}

		throw new UnsupportedOperationException(NOT_IMPLEMENTED_EXCEPTION_MESSAGE);
	}

	public LeafType getEvalTypeFromContextExpr(final RoamContextExpr expr) {
//		final leafType exprType = getEvalTypeFromContextExpr(expr.getExpr());
//		expr.getExpr(); // <- (not) optional?
//		expr.getTypeCast(); // <- optional
//		expr.getStream(); // <- optional
		// ^All optional?

		if (expr.getExpr() != null) {
			final EObject innerExpr = expr.getExpr();
			if (innerExpr instanceof RoamNodeAttributeExpr) {
				return getEvalTypeFromNodeAttrExpr((RoamNodeAttributeExpr) innerExpr);
			} else if (innerExpr instanceof RoamContextOperationExpression) {
				return getEvalTypeFromContextOpExpr((RoamContextOperationExpression) innerExpr);
			} else if (innerExpr instanceof RoamFeatureExpr) {
				// TODO: ^this case should be dealt with as RoamNodeAttributeExpr right?
				return getEvalTypeFromFeatureExpr((RoamFeatureExpr) innerExpr);
			}
		}

		// TODO: typeCast + stream

		// TODO
		return null;
	}

	public LeafType getEvalTypeFromContextOpExpr(final RoamContextOperationExpression expr) {
		final int val = expr.getOperation().getValue();
		if (val == RoamContextOperation.MAPPED_VALUE) {
			return LeafType.BOOLEAN;
		} else if (val == RoamContextOperation.VALUE_VALUE) {
			return LeafType.INTEGER;
		}

		return LeafType.ERROR;
	}

	public LeafType getEvalTypeFromNodeAttrExpr(final RoamNodeAttributeExpr expr) {
		expr.getNode(); // <- not optional
		expr.getTypeCast(); // <- optional
		expr.getExpr(); // <- optional

		// TODO: Node + type cast
		return getEvalTypeFromFeatureExpr(expr.getExpr());
	}

	public LeafType getEvalTypeFromFeatureExpr(final RoamFeatureExpr expr) {
		if (expr instanceof RoamFeatureNavigation) {
			final RoamFeatureNavigation nav = (RoamFeatureNavigation) expr;
			getEvalTypeFromFeatureExpr(nav.getLeft());
			getEvalTypeFromFeatureExpr(nav.getRight());
			// TODO
		} else if (expr instanceof RoamFeatureLit) {
			final RoamFeatureLit lit = (RoamFeatureLit) expr;
			lit.getFeature(); // <- not optional
			lit.getTypeCast(); // <- optional
			lit.getFeature().getEType();// instanceof ELong;
			final EClassifier ecl = lit.getFeature().getEType();
			if (ecl.getName().equals("ELong") || ecl.getName().equals("EDouble")) {
				return LeafType.DOUBLE;
			} else if (ecl.getName().equals("EInt")) {
				return LeafType.INTEGER;
			} else if (ecl.getName().equals("EString")) {
				return LeafType.STRING;
			} else {
				// throw new UnsupportedOperationException("Not yet implemented");
				return LeafType.ECLASS;
			}
		}

		// TODO
		return null;
	}

	/**
	 * Returns the evaluation type from a given RoamTypeCast (EClass) or null if
	 * cast isn't set (because it is optional).
	 * 
	 * @param cast RoamTypeCast to check.
	 * @return leafType EClass or null if cast not set.
	 */
	public LeafType getEvalTypeFromTypeCast(final RoamTypeCast cast) {
		return (cast != null && cast.getType() != null) ? LeafType.ECLASS : null;
	}

	public LeafType getEvalTypeFromArithLit(final RoamArithmeticLiteral lit) {
//		if (lit instanceof RoamDoubleLiteral) {
//			
//		}
		// TODO: ^There is no 'RoamDoubleLiteral' or 'RoamIntegerLiteral'

		final String val = lit.getValue();
		try {
			Integer.valueOf(val);
			return LeafType.INTEGER;
		} catch (final NumberFormatException ex) {
			// No int
		}
		try {
			Double.valueOf(val);
			return LeafType.DOUBLE;
		} catch (final NumberFormatException ex) {
			return LeafType.ERROR;
		}
	}

	public LeafType getEvalTypeDelegate(final EObject e) {
		if (e == null) {
			return null;
		}

		if (e instanceof RoamBoolExpr) {
			return getEvalTypeFromBoolExpr((RoamBoolExpr) e);
		} else if (e instanceof RoamArithmeticExpr) {
			return getEvalTypeFromArithExpr((RoamArithmeticExpr) e);
		} else if (e instanceof RoamBool) {
			return getEvalTypeFromBoolExpr(((RoamBool) e).getExpr());
		} else if (e instanceof RoamStreamSet) {
			return getEvalTypeFromStreamSet((RoamStreamSet) e);
		} else if (e instanceof RoamStreamBoolExpr) {
			return getEvalTypeFromStreamExpr((RoamStreamBoolExpr) e);
		}

		return LeafType.ERROR;
	}

	public LeafType getEvalLeftRightSideOp(final RoamBoolExpr left, final RoamBoolExpr right,
			final RoamBoolBinaryOperator op) {
		if (right == null) {
			throw new UnsupportedOperationException(NOT_IMPLEMENTED_EXCEPTION_MESSAGE);
		} else {
			final LeafType leftType = getEvalTypeDelegate(left);
			final LeafType rightType = getEvalTypeDelegate(right);
			return combine(leftType, rightType, op);
		}
	}

	public LeafType getEvalLEftRightSideOp(final RoamBoolExpr operand, final RoamBoolUnaryOperator op) {
		final LeafType opType = getEvalTypeDelegate(operand);
		return combine(opType, op);
	}

	public LeafType combine(final LeafType left, final LeafType right, final RoamRelOperator op) {
		// Case: right side is null and operator did not change from default
		if (left != null && right == null && op == RoamRelOperator.GREATER) {
			return left;
		}

		// Case: Comparing numbers
		if ((left == LeafType.INTEGER || left == LeafType.DOUBLE)
				&& (right == LeafType.INTEGER || right == LeafType.DOUBLE)) {
			return LeafType.BOOLEAN;
		} else {
			return LeafType.ERROR;
		}
	}

	public LeafType combine(final LeafType left, final LeafType right, final RoamExpOperator op) {
		if ((left == LeafType.INTEGER || left == LeafType.DOUBLE)
				&& (right == LeafType.INTEGER || right == LeafType.DOUBLE)) {
			return LeafType.DOUBLE;
			// TODO: ^isn't there also an integer possible here?
		} else {
			return LeafType.ERROR;
		}
	}

	public LeafType combine(final LeafType left, final LeafType right, final RoamProductOperator op) {
		// return type must be integer or double
		return intOrDouble(left, right);
	}

	public LeafType combine(final LeafType left, final LeafType right, final RoamSumOperator op) {
		// return type must be integer or double
		return intOrDouble(left, right);
	}

	public LeafType combine(final LeafType operand, final RoamArithmeticUnaryOperator op) {
		// Case: Operand is not a number
		if (operand != LeafType.INTEGER && operand != LeafType.DOUBLE) {
			return LeafType.ERROR;
		}

		// Case: ABS and NEG do not change the type
		if (op == RoamArithmeticUnaryOperator.ABS || op == RoamArithmeticUnaryOperator.NEG) {
			return operand;
		} else if (op == RoamArithmeticUnaryOperator.SQRT || op == RoamArithmeticUnaryOperator.SIN
				|| op == RoamArithmeticUnaryOperator.COS) {
			// Case: SQRT, SIN, and COS change the type to double
			return LeafType.DOUBLE;
		} else {
			throw new UnsupportedOperationException(NOT_IMPLEMENTED_EXCEPTION_MESSAGE);
		}
	}

	public LeafType combine(final LeafType left, final LeafType right, final RoamBoolBinaryOperator op) {
		return (left == LeafType.BOOLEAN && right == LeafType.BOOLEAN) ? LeafType.BOOLEAN : LeafType.ERROR;
	}

	public LeafType combine(final LeafType left, final RoamBoolUnaryOperator op) {
		return left == LeafType.BOOLEAN ? LeafType.BOOLEAN : LeafType.ERROR;
	}

	public LeafType intOrDouble(final LeafType left, final LeafType right) {
		if (left == LeafType.INTEGER && right == LeafType.INTEGER) {
			return LeafType.INTEGER;
		} else if ((left == LeafType.INTEGER && right == LeafType.DOUBLE) //
				|| (left == LeafType.DOUBLE && right == LeafType.INTEGER) //
				|| (left == LeafType.DOUBLE && right == LeafType.DOUBLE)) {
			return LeafType.DOUBLE;
		}

		return LeafType.ERROR;
	}

	public void validateLambdaExpr(final RoamLambdaExpression expr) {
		// Check return type
		if (getEvalTypeFromBoolExpr(expr.getExpr()) != LeafType.BOOLEAN) {
			error( //
					LAMBDA_EXPR_EVAL_NOT_BOOLEAN_MESSAGE, //
					RoamSLangPackage.Literals.ROAM_LAMBDA_EXPRESSION__EXPR //
			);
		}

		// Check if literal is constant
		if (expr.getExpr() instanceof RoamBooleanLiteral) {
			final RoamBooleanLiteral lit = (RoamBooleanLiteral) expr.getExpr();
			final String warning = String.valueOf(lit.isLiteral());
			warning( //
					String.format(LAMBDA_EXPR_EVAL_LITERAL_MESSAGE, warning), //
					expr, //
					RoamSLangPackage.Literals.ROAM_LAMBDA_EXPRESSION__EXPR //
			);
		}
	}

	/**
	 * Enumeration for the type of the leaf.
	 */
	protected enum LeafType {
		BOOLEAN, // RoamBooleanLiteral
		INTEGER, //
		DOUBLE, //
		STRING, //
		SET, // Sets like output of a filter
		OBJECTIVE, // RoamObjective
		MAPPING, // RoamMapping
		ECLASS, // EClass for casts
		ERROR // If leaf type can not be evaluated, e.g.: '1 + true'
	}

}
