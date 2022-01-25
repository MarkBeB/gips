/**
 */
package org.emoflon.roam.intermediate.RoamIntermediate;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.emoflon.roam.intermediate.RoamIntermediate.RoamIntermediateFactory
 * @model kind="package"
 * @generated
 */
public interface RoamIntermediatePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "RoamIntermediate";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "platform:/resource/org.emoflon.roam.intermediate/model/RoamIntermediate.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "RoamIntermediate";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RoamIntermediatePackage eINSTANCE = org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediateModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediateModelImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getRoamIntermediateModel()
	 * @generated
	 */
	int ROAM_INTERMEDIATE_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROAM_INTERMEDIATE_MODEL__VARIABLES = 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROAM_INTERMEDIATE_MODEL__CONSTRAINTS = 1;

	/**
	 * The feature id for the '<em><b>Ibex Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROAM_INTERMEDIATE_MODEL__IBEX_MODEL = 2;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROAM_INTERMEDIATE_MODEL_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROAM_INTERMEDIATE_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.VariableSetImpl <em>Variable Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.VariableSetImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getVariableSet()
	 * @generated
	 */
	int VARIABLE_SET = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_SET__NAME = 0;

	/**
	 * The number of structural features of the '<em>Variable Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_SET_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Variable Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_SET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.MappingImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__NAME = VARIABLE_SET__NAME;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__RULE = VARIABLE_SET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = VARIABLE_SET_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_COUNT = VARIABLE_SET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.ConstraintImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Lhs Constant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__LHS_CONSTANT = 1;

	/**
	 * The feature id for the '<em><b>Rhs Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__RHS_EXPRESSION = 2;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__OPERATOR = 3;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.Context <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.Context
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getContext()
	 * @generated
	 */
	int CONTEXT = 6;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.TypeConstraintImpl <em>Type Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.TypeConstraintImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getTypeConstraint()
	 * @generated
	 */
	int TYPE_CONSTRAINT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT__NAME = CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lhs Constant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT__LHS_CONSTANT = CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rhs Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT__RHS_EXPRESSION = CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT__OPERATOR = CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Model Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT__MODEL_TYPE = CONTEXT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Type Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT_FEATURE_COUNT = CONTEXT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Type Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT_OPERATION_COUNT = CONTEXT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.MappingConstraintImpl <em>Mapping Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.MappingConstraintImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getMappingConstraint()
	 * @generated
	 */
	int MAPPING_CONSTRAINT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CONSTRAINT__NAME = CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lhs Constant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CONSTRAINT__LHS_CONSTANT = CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rhs Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CONSTRAINT__RHS_EXPRESSION = CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CONSTRAINT__OPERATOR = CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CONSTRAINT__MAPPING = CONTEXT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Mapping Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CONSTRAINT_FEATURE_COUNT = CONTEXT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Mapping Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CONSTRAINT_OPERATION_COUNT = CONTEXT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.Iterator <em>Iterator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.Iterator
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getIterator()
	 * @generated
	 */
	int ITERATOR = 7;

	/**
	 * The number of structural features of the '<em>Iterator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Iterator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.ArithmeticExpressionImpl <em>Arithmetic Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.ArithmeticExpressionImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getArithmeticExpression()
	 * @generated
	 */
	int ARITHMETIC_EXPRESSION = 8;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_EXPRESSION__RETURN_TYPE = 0;

	/**
	 * The number of structural features of the '<em>Arithmetic Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_EXPRESSION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Arithmetic Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.BinaryArithmeticExpressionImpl <em>Binary Arithmetic Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.BinaryArithmeticExpressionImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getBinaryArithmeticExpression()
	 * @generated
	 */
	int BINARY_ARITHMETIC_EXPRESSION = 9;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_ARITHMETIC_EXPRESSION__RETURN_TYPE = ARITHMETIC_EXPRESSION__RETURN_TYPE;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_ARITHMETIC_EXPRESSION__LHS = ARITHMETIC_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_ARITHMETIC_EXPRESSION__RHS = ARITHMETIC_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_ARITHMETIC_EXPRESSION__OPERATOR = ARITHMETIC_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Binary Arithmetic Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_ARITHMETIC_EXPRESSION_FEATURE_COUNT = ARITHMETIC_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Binary Arithmetic Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_ARITHMETIC_EXPRESSION_OPERATION_COUNT = ARITHMETIC_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.UnaryArithmeticExpressionImpl <em>Unary Arithmetic Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.UnaryArithmeticExpressionImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getUnaryArithmeticExpression()
	 * @generated
	 */
	int UNARY_ARITHMETIC_EXPRESSION = 10;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_ARITHMETIC_EXPRESSION__RETURN_TYPE = ARITHMETIC_EXPRESSION__RETURN_TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_ARITHMETIC_EXPRESSION__EXPRESSION = ARITHMETIC_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_ARITHMETIC_EXPRESSION__OPERATOR = ARITHMETIC_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unary Arithmetic Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_ARITHMETIC_EXPRESSION_FEATURE_COUNT = ARITHMETIC_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Unary Arithmetic Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_ARITHMETIC_EXPRESSION_OPERATION_COUNT = ARITHMETIC_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.SumExpressionImpl <em>Sum Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.SumExpressionImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getSumExpression()
	 * @generated
	 */
	int SUM_EXPRESSION = 11;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUM_EXPRESSION__RETURN_TYPE = ITERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUM_EXPRESSION__EXPRESSION = ITERATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUM_EXPRESSION__CONDITION = ITERATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Sum Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUM_EXPRESSION_FEATURE_COUNT = ITERATOR_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Sum Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUM_EXPRESSION_OPERATION_COUNT = ITERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.VariableSumExpressionImpl <em>Variable Sum Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.VariableSumExpressionImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getVariableSumExpression()
	 * @generated
	 */
	int VARIABLE_SUM_EXPRESSION = 12;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_SUM_EXPRESSION__RETURN_TYPE = SUM_EXPRESSION__RETURN_TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_SUM_EXPRESSION__EXPRESSION = SUM_EXPRESSION__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_SUM_EXPRESSION__CONDITION = SUM_EXPRESSION__CONDITION;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_SUM_EXPRESSION__VARIABLE = SUM_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Sum Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_SUM_EXPRESSION_FEATURE_COUNT = SUM_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Variable Sum Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_SUM_EXPRESSION_OPERATION_COUNT = SUM_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.TypeSumExpressionImpl <em>Type Sum Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.TypeSumExpressionImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getTypeSumExpression()
	 * @generated
	 */
	int TYPE_SUM_EXPRESSION = 13;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SUM_EXPRESSION__RETURN_TYPE = SUM_EXPRESSION__RETURN_TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SUM_EXPRESSION__EXPRESSION = SUM_EXPRESSION__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SUM_EXPRESSION__CONDITION = SUM_EXPRESSION__CONDITION;

	/**
	 * The feature id for the '<em><b>Obj Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SUM_EXPRESSION__OBJ_TYPE = SUM_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Sum Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SUM_EXPRESSION_FEATURE_COUNT = SUM_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Type Sum Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SUM_EXPRESSION_OPERATION_COUNT = SUM_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.ArithmeticValueImpl <em>Arithmetic Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.ArithmeticValueImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getArithmeticValue()
	 * @generated
	 */
	int ARITHMETIC_VALUE = 14;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_VALUE__RETURN_TYPE = ARITHMETIC_EXPRESSION__RETURN_TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_VALUE__VALUE = ARITHMETIC_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Arithmetic Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_VALUE_FEATURE_COUNT = ARITHMETIC_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Arithmetic Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_VALUE_OPERATION_COUNT = ARITHMETIC_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.ArithmeticLiteralImpl <em>Arithmetic Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.ArithmeticLiteralImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getArithmeticLiteral()
	 * @generated
	 */
	int ARITHMETIC_LITERAL = 15;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_LITERAL__RETURN_TYPE = ARITHMETIC_EXPRESSION__RETURN_TYPE;

	/**
	 * The number of structural features of the '<em>Arithmetic Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_LITERAL_FEATURE_COUNT = ARITHMETIC_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Arithmetic Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_LITERAL_OPERATION_COUNT = ARITHMETIC_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.IntegerLiteralImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getIntegerLiteral()
	 * @generated
	 */
	int INTEGER_LITERAL = 16;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL__RETURN_TYPE = ARITHMETIC_LITERAL__RETURN_TYPE;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL__LITERAL = ARITHMETIC_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_FEATURE_COUNT = ARITHMETIC_LITERAL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Integer Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_OPERATION_COUNT = ARITHMETIC_LITERAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.DoubleLiteralImpl <em>Double Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.DoubleLiteralImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getDoubleLiteral()
	 * @generated
	 */
	int DOUBLE_LITERAL = 17;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL__RETURN_TYPE = ARITHMETIC_LITERAL__RETURN_TYPE;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL__LITERAL = ARITHMETIC_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Double Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL_FEATURE_COUNT = ARITHMETIC_LITERAL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Double Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL_OPERATION_COUNT = ARITHMETIC_LITERAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.BoolExpressionImpl <em>Bool Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.BoolExpressionImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getBoolExpression()
	 * @generated
	 */
	int BOOL_EXPRESSION = 18;

	/**
	 * The number of structural features of the '<em>Bool Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Bool Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.BoolBinaryExpressionImpl <em>Bool Binary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.BoolBinaryExpressionImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getBoolBinaryExpression()
	 * @generated
	 */
	int BOOL_BINARY_EXPRESSION = 19;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_BINARY_EXPRESSION__LHS = BOOL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_BINARY_EXPRESSION__RHS = BOOL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_BINARY_EXPRESSION__OPERATOR = BOOL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Bool Binary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_BINARY_EXPRESSION_FEATURE_COUNT = BOOL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Bool Binary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_BINARY_EXPRESSION_OPERATION_COUNT = BOOL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.BoolUnaryExpressionImpl <em>Bool Unary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.BoolUnaryExpressionImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getBoolUnaryExpression()
	 * @generated
	 */
	int BOOL_UNARY_EXPRESSION = 20;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_UNARY_EXPRESSION__EXPRESSION = BOOL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_UNARY_EXPRESSION__OPERATOR = BOOL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bool Unary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_UNARY_EXPRESSION_FEATURE_COUNT = BOOL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Bool Unary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_UNARY_EXPRESSION_OPERATION_COUNT = BOOL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.BoolValueImpl <em>Bool Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.BoolValueImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getBoolValue()
	 * @generated
	 */
	int BOOL_VALUE = 21;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_VALUE__VALUE = BOOL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Bool Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_VALUE_FEATURE_COUNT = BOOL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Bool Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_VALUE_OPERATION_COUNT = BOOL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.BoolLiteralImpl <em>Bool Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.BoolLiteralImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getBoolLiteral()
	 * @generated
	 */
	int BOOL_LITERAL = 22;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_LITERAL__LITERAL = BOOL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Bool Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_LITERAL_FEATURE_COUNT = BOOL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Bool Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_LITERAL_OPERATION_COUNT = BOOL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.ValueExpressionImpl <em>Value Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.ValueExpressionImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getValueExpression()
	 * @generated
	 */
	int VALUE_EXPRESSION = 23;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_EXPRESSION__TYPE = 0;

	/**
	 * The number of structural features of the '<em>Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_EXPRESSION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.ContextTypeValueImpl <em>Context Type Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.ContextTypeValueImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getContextTypeValue()
	 * @generated
	 */
	int CONTEXT_TYPE_VALUE = 24;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_TYPE_VALUE__TYPE = VALUE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Type Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_TYPE_VALUE__TYPE_CONTEXT = VALUE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Context Type Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_TYPE_VALUE_FEATURE_COUNT = VALUE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Context Type Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_TYPE_VALUE_OPERATION_COUNT = VALUE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.ContextMappingNodeImpl <em>Context Mapping Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.ContextMappingNodeImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getContextMappingNode()
	 * @generated
	 */
	int CONTEXT_MAPPING_NODE = 25;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_MAPPING_NODE__TYPE = VALUE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Mapping Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_MAPPING_NODE__MAPPING_CONTEXT = VALUE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_MAPPING_NODE__NODE = VALUE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Context Mapping Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_MAPPING_NODE_FEATURE_COUNT = VALUE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Context Mapping Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_MAPPING_NODE_OPERATION_COUNT = VALUE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.IteratorValueImpl <em>Iterator Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.IteratorValueImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getIteratorValue()
	 * @generated
	 */
	int ITERATOR_VALUE = 26;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_VALUE__TYPE = VALUE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_VALUE__ITERATOR = VALUE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Iterator Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_VALUE_FEATURE_COUNT = VALUE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Iterator Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_VALUE_OPERATION_COUNT = VALUE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.FeatureExpressionImpl <em>Feature Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.FeatureExpressionImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getFeatureExpression()
	 * @generated
	 */
	int FEATURE_EXPRESSION = 27;

	/**
	 * The feature id for the '<em><b>Current</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_EXPRESSION__CURRENT = 0;

	/**
	 * The feature id for the '<em><b>Child</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_EXPRESSION__CHILD = 1;

	/**
	 * The number of structural features of the '<em>Feature Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_EXPRESSION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Feature Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.FeatureLiteralImpl <em>Feature Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.FeatureLiteralImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getFeatureLiteral()
	 * @generated
	 */
	int FEATURE_LITERAL = 28;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_LITERAL__FEATURE = 0;

	/**
	 * The number of structural features of the '<em>Feature Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_LITERAL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Feature Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_LITERAL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.ContextTypeFeatureValueImpl <em>Context Type Feature Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.ContextTypeFeatureValueImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getContextTypeFeatureValue()
	 * @generated
	 */
	int CONTEXT_TYPE_FEATURE_VALUE = 29;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_TYPE_FEATURE_VALUE__TYPE = CONTEXT_TYPE_VALUE__TYPE;

	/**
	 * The feature id for the '<em><b>Type Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_TYPE_FEATURE_VALUE__TYPE_CONTEXT = CONTEXT_TYPE_VALUE__TYPE_CONTEXT;

	/**
	 * The feature id for the '<em><b>Feature Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_TYPE_FEATURE_VALUE__FEATURE_EXPRESSION = CONTEXT_TYPE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Context Type Feature Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_TYPE_FEATURE_VALUE_FEATURE_COUNT = CONTEXT_TYPE_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Context Type Feature Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_TYPE_FEATURE_VALUE_OPERATION_COUNT = CONTEXT_TYPE_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.ContextMappingNodeFeatureValueImpl <em>Context Mapping Node Feature Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.ContextMappingNodeFeatureValueImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getContextMappingNodeFeatureValue()
	 * @generated
	 */
	int CONTEXT_MAPPING_NODE_FEATURE_VALUE = 30;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_MAPPING_NODE_FEATURE_VALUE__TYPE = CONTEXT_MAPPING_NODE__TYPE;

	/**
	 * The feature id for the '<em><b>Mapping Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_MAPPING_NODE_FEATURE_VALUE__MAPPING_CONTEXT = CONTEXT_MAPPING_NODE__MAPPING_CONTEXT;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_MAPPING_NODE_FEATURE_VALUE__NODE = CONTEXT_MAPPING_NODE__NODE;

	/**
	 * The feature id for the '<em><b>Feature Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_MAPPING_NODE_FEATURE_VALUE__FEATURE_EXPRESSION = CONTEXT_MAPPING_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Context Mapping Node Feature Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_MAPPING_NODE_FEATURE_VALUE_FEATURE_COUNT = CONTEXT_MAPPING_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Context Mapping Node Feature Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_MAPPING_NODE_FEATURE_VALUE_OPERATION_COUNT = CONTEXT_MAPPING_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.IteratorFeatureValueImpl <em>Iterator Feature Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.IteratorFeatureValueImpl
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getIteratorFeatureValue()
	 * @generated
	 */
	int ITERATOR_FEATURE_VALUE = 31;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_FEATURE_VALUE__TYPE = ITERATOR_VALUE__TYPE;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_FEATURE_VALUE__ITERATOR = ITERATOR_VALUE__ITERATOR;

	/**
	 * The feature id for the '<em><b>Feature Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_FEATURE_VALUE__FEATURE_EXPRESSION = ITERATOR_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Iterator Feature Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_FEATURE_VALUE_FEATURE_COUNT = ITERATOR_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Iterator Feature Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_FEATURE_VALUE_OPERATION_COUNT = ITERATOR_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.RelationalOperator <em>Relational Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.RelationalOperator
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getRelationalOperator()
	 * @generated
	 */
	int RELATIONAL_OPERATOR = 32;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.BinaryArithmeticOperator <em>Binary Arithmetic Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.BinaryArithmeticOperator
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getBinaryArithmeticOperator()
	 * @generated
	 */
	int BINARY_ARITHMETIC_OPERATOR = 33;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.UnaryArithmeticOperator <em>Unary Arithmetic Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.UnaryArithmeticOperator
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getUnaryArithmeticOperator()
	 * @generated
	 */
	int UNARY_ARITHMETIC_OPERATOR = 34;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.BinaryBoolOperator <em>Binary Bool Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.BinaryBoolOperator
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getBinaryBoolOperator()
	 * @generated
	 */
	int BINARY_BOOL_OPERATOR = 35;

	/**
	 * The meta object id for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.UnaryBoolOperator <em>Unary Bool Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.UnaryBoolOperator
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getUnaryBoolOperator()
	 * @generated
	 */
	int UNARY_BOOL_OPERATOR = 36;

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.RoamIntermediateModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.RoamIntermediateModel
	 * @generated
	 */
	EClass getRoamIntermediateModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emoflon.roam.intermediate.RoamIntermediate.RoamIntermediateModel#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.RoamIntermediateModel#getVariables()
	 * @see #getRoamIntermediateModel()
	 * @generated
	 */
	EReference getRoamIntermediateModel_Variables();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emoflon.roam.intermediate.RoamIntermediate.RoamIntermediateModel#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.RoamIntermediateModel#getConstraints()
	 * @see #getRoamIntermediateModel()
	 * @generated
	 */
	EReference getRoamIntermediateModel_Constraints();

	/**
	 * Returns the meta object for the containment reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.RoamIntermediateModel#getIbexModel <em>Ibex Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ibex Model</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.RoamIntermediateModel#getIbexModel()
	 * @see #getRoamIntermediateModel()
	 * @generated
	 */
	EReference getRoamIntermediateModel_IbexModel();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.VariableSet <em>Variable Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Set</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.VariableSet
	 * @generated
	 */
	EClass getVariableSet();

	/**
	 * Returns the meta object for the attribute '{@link org.emoflon.roam.intermediate.RoamIntermediate.VariableSet#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.VariableSet#getName()
	 * @see #getVariableSet()
	 * @generated
	 */
	EAttribute getVariableSet_Name();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for the reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.Mapping#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rule</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.Mapping#getRule()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Rule();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.emoflon.roam.intermediate.RoamIntermediate.Constraint#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.Constraint#getName()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.Constraint#getLhsConstant <em>Lhs Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lhs Constant</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.Constraint#getLhsConstant()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_LhsConstant();

	/**
	 * Returns the meta object for the containment reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.Constraint#getRhsExpression <em>Rhs Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rhs Expression</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.Constraint#getRhsExpression()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_RhsExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.emoflon.roam.intermediate.RoamIntermediate.Constraint#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.Constraint#getOperator()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Operator();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.TypeConstraint <em>Type Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Constraint</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.TypeConstraint
	 * @generated
	 */
	EClass getTypeConstraint();

	/**
	 * Returns the meta object for the reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.TypeConstraint#getModelType <em>Model Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Type</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.TypeConstraint#getModelType()
	 * @see #getTypeConstraint()
	 * @generated
	 */
	EReference getTypeConstraint_ModelType();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.MappingConstraint <em>Mapping Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Constraint</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.MappingConstraint
	 * @generated
	 */
	EClass getMappingConstraint();

	/**
	 * Returns the meta object for the reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.MappingConstraint#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mapping</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.MappingConstraint#getMapping()
	 * @see #getMappingConstraint()
	 * @generated
	 */
	EReference getMappingConstraint_Mapping();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.Context
	 * @generated
	 */
	EClass getContext();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.Iterator <em>Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterator</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.Iterator
	 * @generated
	 */
	EClass getIterator();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.ArithmeticExpression <em>Arithmetic Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arithmetic Expression</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.ArithmeticExpression
	 * @generated
	 */
	EClass getArithmeticExpression();

	/**
	 * Returns the meta object for the reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.ArithmeticExpression#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Return Type</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.ArithmeticExpression#getReturnType()
	 * @see #getArithmeticExpression()
	 * @generated
	 */
	EReference getArithmeticExpression_ReturnType();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.BinaryArithmeticExpression <em>Binary Arithmetic Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Arithmetic Expression</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.BinaryArithmeticExpression
	 * @generated
	 */
	EClass getBinaryArithmeticExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.BinaryArithmeticExpression#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lhs</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.BinaryArithmeticExpression#getLhs()
	 * @see #getBinaryArithmeticExpression()
	 * @generated
	 */
	EReference getBinaryArithmeticExpression_Lhs();

	/**
	 * Returns the meta object for the containment reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.BinaryArithmeticExpression#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rhs</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.BinaryArithmeticExpression#getRhs()
	 * @see #getBinaryArithmeticExpression()
	 * @generated
	 */
	EReference getBinaryArithmeticExpression_Rhs();

	/**
	 * Returns the meta object for the attribute '{@link org.emoflon.roam.intermediate.RoamIntermediate.BinaryArithmeticExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.BinaryArithmeticExpression#getOperator()
	 * @see #getBinaryArithmeticExpression()
	 * @generated
	 */
	EAttribute getBinaryArithmeticExpression_Operator();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.UnaryArithmeticExpression <em>Unary Arithmetic Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Arithmetic Expression</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.UnaryArithmeticExpression
	 * @generated
	 */
	EClass getUnaryArithmeticExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.UnaryArithmeticExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.UnaryArithmeticExpression#getExpression()
	 * @see #getUnaryArithmeticExpression()
	 * @generated
	 */
	EReference getUnaryArithmeticExpression_Expression();

	/**
	 * Returns the meta object for the attribute '{@link org.emoflon.roam.intermediate.RoamIntermediate.UnaryArithmeticExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.UnaryArithmeticExpression#getOperator()
	 * @see #getUnaryArithmeticExpression()
	 * @generated
	 */
	EAttribute getUnaryArithmeticExpression_Operator();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.SumExpression <em>Sum Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sum Expression</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.SumExpression
	 * @generated
	 */
	EClass getSumExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.SumExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.SumExpression#getExpression()
	 * @see #getSumExpression()
	 * @generated
	 */
	EReference getSumExpression_Expression();

	/**
	 * Returns the meta object for the containment reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.SumExpression#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.SumExpression#getCondition()
	 * @see #getSumExpression()
	 * @generated
	 */
	EReference getSumExpression_Condition();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.VariableSumExpression <em>Variable Sum Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Sum Expression</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.VariableSumExpression
	 * @generated
	 */
	EClass getVariableSumExpression();

	/**
	 * Returns the meta object for the reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.VariableSumExpression#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.VariableSumExpression#getVariable()
	 * @see #getVariableSumExpression()
	 * @generated
	 */
	EReference getVariableSumExpression_Variable();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.TypeSumExpression <em>Type Sum Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Sum Expression</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.TypeSumExpression
	 * @generated
	 */
	EClass getTypeSumExpression();

	/**
	 * Returns the meta object for the reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.TypeSumExpression#getObjType <em>Obj Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Obj Type</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.TypeSumExpression#getObjType()
	 * @see #getTypeSumExpression()
	 * @generated
	 */
	EReference getTypeSumExpression_ObjType();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.ArithmeticValue <em>Arithmetic Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arithmetic Value</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.ArithmeticValue
	 * @generated
	 */
	EClass getArithmeticValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.ArithmeticValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.ArithmeticValue#getValue()
	 * @see #getArithmeticValue()
	 * @generated
	 */
	EReference getArithmeticValue_Value();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.ArithmeticLiteral <em>Arithmetic Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arithmetic Literal</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.ArithmeticLiteral
	 * @generated
	 */
	EClass getArithmeticLiteral();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.IntegerLiteral <em>Integer Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.IntegerLiteral
	 * @generated
	 */
	EClass getIntegerLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.emoflon.roam.intermediate.RoamIntermediate.IntegerLiteral#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Literal</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.IntegerLiteral#getLiteral()
	 * @see #getIntegerLiteral()
	 * @generated
	 */
	EAttribute getIntegerLiteral_Literal();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.DoubleLiteral <em>Double Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Literal</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.DoubleLiteral
	 * @generated
	 */
	EClass getDoubleLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.emoflon.roam.intermediate.RoamIntermediate.DoubleLiteral#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Literal</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.DoubleLiteral#getLiteral()
	 * @see #getDoubleLiteral()
	 * @generated
	 */
	EAttribute getDoubleLiteral_Literal();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.BoolExpression <em>Bool Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bool Expression</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.BoolExpression
	 * @generated
	 */
	EClass getBoolExpression();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.BoolBinaryExpression <em>Bool Binary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bool Binary Expression</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.BoolBinaryExpression
	 * @generated
	 */
	EClass getBoolBinaryExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.BoolBinaryExpression#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lhs</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.BoolBinaryExpression#getLhs()
	 * @see #getBoolBinaryExpression()
	 * @generated
	 */
	EReference getBoolBinaryExpression_Lhs();

	/**
	 * Returns the meta object for the containment reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.BoolBinaryExpression#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rhs</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.BoolBinaryExpression#getRhs()
	 * @see #getBoolBinaryExpression()
	 * @generated
	 */
	EReference getBoolBinaryExpression_Rhs();

	/**
	 * Returns the meta object for the attribute '{@link org.emoflon.roam.intermediate.RoamIntermediate.BoolBinaryExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.BoolBinaryExpression#getOperator()
	 * @see #getBoolBinaryExpression()
	 * @generated
	 */
	EAttribute getBoolBinaryExpression_Operator();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.BoolUnaryExpression <em>Bool Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bool Unary Expression</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.BoolUnaryExpression
	 * @generated
	 */
	EClass getBoolUnaryExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.BoolUnaryExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.BoolUnaryExpression#getExpression()
	 * @see #getBoolUnaryExpression()
	 * @generated
	 */
	EReference getBoolUnaryExpression_Expression();

	/**
	 * Returns the meta object for the attribute '{@link org.emoflon.roam.intermediate.RoamIntermediate.BoolUnaryExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.BoolUnaryExpression#getOperator()
	 * @see #getBoolUnaryExpression()
	 * @generated
	 */
	EAttribute getBoolUnaryExpression_Operator();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.BoolValue <em>Bool Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bool Value</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.BoolValue
	 * @generated
	 */
	EClass getBoolValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.BoolValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.BoolValue#getValue()
	 * @see #getBoolValue()
	 * @generated
	 */
	EReference getBoolValue_Value();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.BoolLiteral <em>Bool Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bool Literal</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.BoolLiteral
	 * @generated
	 */
	EClass getBoolLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.emoflon.roam.intermediate.RoamIntermediate.BoolLiteral#isLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Literal</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.BoolLiteral#isLiteral()
	 * @see #getBoolLiteral()
	 * @generated
	 */
	EAttribute getBoolLiteral_Literal();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.ValueExpression <em>Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Expression</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.ValueExpression
	 * @generated
	 */
	EClass getValueExpression();

	/**
	 * Returns the meta object for the reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.ValueExpression#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.ValueExpression#getType()
	 * @see #getValueExpression()
	 * @generated
	 */
	EReference getValueExpression_Type();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.ContextTypeValue <em>Context Type Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context Type Value</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.ContextTypeValue
	 * @generated
	 */
	EClass getContextTypeValue();

	/**
	 * Returns the meta object for the reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.ContextTypeValue#getTypeContext <em>Type Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type Context</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.ContextTypeValue#getTypeContext()
	 * @see #getContextTypeValue()
	 * @generated
	 */
	EReference getContextTypeValue_TypeContext();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.ContextMappingNode <em>Context Mapping Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context Mapping Node</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.ContextMappingNode
	 * @generated
	 */
	EClass getContextMappingNode();

	/**
	 * Returns the meta object for the reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.ContextMappingNode#getMappingContext <em>Mapping Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mapping Context</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.ContextMappingNode#getMappingContext()
	 * @see #getContextMappingNode()
	 * @generated
	 */
	EReference getContextMappingNode_MappingContext();

	/**
	 * Returns the meta object for the reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.ContextMappingNode#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.ContextMappingNode#getNode()
	 * @see #getContextMappingNode()
	 * @generated
	 */
	EReference getContextMappingNode_Node();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.IteratorValue <em>Iterator Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterator Value</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.IteratorValue
	 * @generated
	 */
	EClass getIteratorValue();

	/**
	 * Returns the meta object for the reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.IteratorValue#getIterator <em>Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Iterator</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.IteratorValue#getIterator()
	 * @see #getIteratorValue()
	 * @generated
	 */
	EReference getIteratorValue_Iterator();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.FeatureExpression <em>Feature Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Expression</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.FeatureExpression
	 * @generated
	 */
	EClass getFeatureExpression();

	/**
	 * Returns the meta object for the reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.FeatureExpression#getCurrent <em>Current</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.FeatureExpression#getCurrent()
	 * @see #getFeatureExpression()
	 * @generated
	 */
	EReference getFeatureExpression_Current();

	/**
	 * Returns the meta object for the reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.FeatureExpression#getChild <em>Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Child</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.FeatureExpression#getChild()
	 * @see #getFeatureExpression()
	 * @generated
	 */
	EReference getFeatureExpression_Child();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.FeatureLiteral <em>Feature Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Literal</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.FeatureLiteral
	 * @generated
	 */
	EClass getFeatureLiteral();

	/**
	 * Returns the meta object for the reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.FeatureLiteral#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.FeatureLiteral#getFeature()
	 * @see #getFeatureLiteral()
	 * @generated
	 */
	EReference getFeatureLiteral_Feature();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.ContextTypeFeatureValue <em>Context Type Feature Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context Type Feature Value</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.ContextTypeFeatureValue
	 * @generated
	 */
	EClass getContextTypeFeatureValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.ContextTypeFeatureValue#getFeatureExpression <em>Feature Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Feature Expression</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.ContextTypeFeatureValue#getFeatureExpression()
	 * @see #getContextTypeFeatureValue()
	 * @generated
	 */
	EReference getContextTypeFeatureValue_FeatureExpression();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.ContextMappingNodeFeatureValue <em>Context Mapping Node Feature Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context Mapping Node Feature Value</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.ContextMappingNodeFeatureValue
	 * @generated
	 */
	EClass getContextMappingNodeFeatureValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.ContextMappingNodeFeatureValue#getFeatureExpression <em>Feature Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Feature Expression</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.ContextMappingNodeFeatureValue#getFeatureExpression()
	 * @see #getContextMappingNodeFeatureValue()
	 * @generated
	 */
	EReference getContextMappingNodeFeatureValue_FeatureExpression();

	/**
	 * Returns the meta object for class '{@link org.emoflon.roam.intermediate.RoamIntermediate.IteratorFeatureValue <em>Iterator Feature Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterator Feature Value</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.IteratorFeatureValue
	 * @generated
	 */
	EClass getIteratorFeatureValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.emoflon.roam.intermediate.RoamIntermediate.IteratorFeatureValue#getFeatureExpression <em>Feature Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Feature Expression</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.IteratorFeatureValue#getFeatureExpression()
	 * @see #getIteratorFeatureValue()
	 * @generated
	 */
	EReference getIteratorFeatureValue_FeatureExpression();

	/**
	 * Returns the meta object for enum '{@link org.emoflon.roam.intermediate.RoamIntermediate.RelationalOperator <em>Relational Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Relational Operator</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.RelationalOperator
	 * @generated
	 */
	EEnum getRelationalOperator();

	/**
	 * Returns the meta object for enum '{@link org.emoflon.roam.intermediate.RoamIntermediate.BinaryArithmeticOperator <em>Binary Arithmetic Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Binary Arithmetic Operator</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.BinaryArithmeticOperator
	 * @generated
	 */
	EEnum getBinaryArithmeticOperator();

	/**
	 * Returns the meta object for enum '{@link org.emoflon.roam.intermediate.RoamIntermediate.UnaryArithmeticOperator <em>Unary Arithmetic Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Unary Arithmetic Operator</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.UnaryArithmeticOperator
	 * @generated
	 */
	EEnum getUnaryArithmeticOperator();

	/**
	 * Returns the meta object for enum '{@link org.emoflon.roam.intermediate.RoamIntermediate.BinaryBoolOperator <em>Binary Bool Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Binary Bool Operator</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.BinaryBoolOperator
	 * @generated
	 */
	EEnum getBinaryBoolOperator();

	/**
	 * Returns the meta object for enum '{@link org.emoflon.roam.intermediate.RoamIntermediate.UnaryBoolOperator <em>Unary Bool Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Unary Bool Operator</em>'.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.UnaryBoolOperator
	 * @generated
	 */
	EEnum getUnaryBoolOperator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RoamIntermediateFactory getRoamIntermediateFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediateModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediateModelImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getRoamIntermediateModel()
		 * @generated
		 */
		EClass ROAM_INTERMEDIATE_MODEL = eINSTANCE.getRoamIntermediateModel();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROAM_INTERMEDIATE_MODEL__VARIABLES = eINSTANCE.getRoamIntermediateModel_Variables();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROAM_INTERMEDIATE_MODEL__CONSTRAINTS = eINSTANCE.getRoamIntermediateModel_Constraints();

		/**
		 * The meta object literal for the '<em><b>Ibex Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROAM_INTERMEDIATE_MODEL__IBEX_MODEL = eINSTANCE.getRoamIntermediateModel_IbexModel();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.VariableSetImpl <em>Variable Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.VariableSetImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getVariableSet()
		 * @generated
		 */
		EClass VARIABLE_SET = eINSTANCE.getVariableSet();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_SET__NAME = eINSTANCE.getVariableSet_Name();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.MappingImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__RULE = eINSTANCE.getMapping_Rule();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.ConstraintImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__NAME = eINSTANCE.getConstraint_Name();

		/**
		 * The meta object literal for the '<em><b>Lhs Constant</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__LHS_CONSTANT = eINSTANCE.getConstraint_LhsConstant();

		/**
		 * The meta object literal for the '<em><b>Rhs Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__RHS_EXPRESSION = eINSTANCE.getConstraint_RhsExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__OPERATOR = eINSTANCE.getConstraint_Operator();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.TypeConstraintImpl <em>Type Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.TypeConstraintImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getTypeConstraint()
		 * @generated
		 */
		EClass TYPE_CONSTRAINT = eINSTANCE.getTypeConstraint();

		/**
		 * The meta object literal for the '<em><b>Model Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_CONSTRAINT__MODEL_TYPE = eINSTANCE.getTypeConstraint_ModelType();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.MappingConstraintImpl <em>Mapping Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.MappingConstraintImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getMappingConstraint()
		 * @generated
		 */
		EClass MAPPING_CONSTRAINT = eINSTANCE.getMappingConstraint();

		/**
		 * The meta object literal for the '<em><b>Mapping</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CONSTRAINT__MAPPING = eINSTANCE.getMappingConstraint_Mapping();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.Context <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.Context
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getContext()
		 * @generated
		 */
		EClass CONTEXT = eINSTANCE.getContext();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.Iterator <em>Iterator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.Iterator
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getIterator()
		 * @generated
		 */
		EClass ITERATOR = eINSTANCE.getIterator();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.ArithmeticExpressionImpl <em>Arithmetic Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.ArithmeticExpressionImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getArithmeticExpression()
		 * @generated
		 */
		EClass ARITHMETIC_EXPRESSION = eINSTANCE.getArithmeticExpression();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARITHMETIC_EXPRESSION__RETURN_TYPE = eINSTANCE.getArithmeticExpression_ReturnType();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.BinaryArithmeticExpressionImpl <em>Binary Arithmetic Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.BinaryArithmeticExpressionImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getBinaryArithmeticExpression()
		 * @generated
		 */
		EClass BINARY_ARITHMETIC_EXPRESSION = eINSTANCE.getBinaryArithmeticExpression();

		/**
		 * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_ARITHMETIC_EXPRESSION__LHS = eINSTANCE.getBinaryArithmeticExpression_Lhs();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_ARITHMETIC_EXPRESSION__RHS = eINSTANCE.getBinaryArithmeticExpression_Rhs();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINARY_ARITHMETIC_EXPRESSION__OPERATOR = eINSTANCE.getBinaryArithmeticExpression_Operator();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.UnaryArithmeticExpressionImpl <em>Unary Arithmetic Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.UnaryArithmeticExpressionImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getUnaryArithmeticExpression()
		 * @generated
		 */
		EClass UNARY_ARITHMETIC_EXPRESSION = eINSTANCE.getUnaryArithmeticExpression();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_ARITHMETIC_EXPRESSION__EXPRESSION = eINSTANCE.getUnaryArithmeticExpression_Expression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNARY_ARITHMETIC_EXPRESSION__OPERATOR = eINSTANCE.getUnaryArithmeticExpression_Operator();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.SumExpressionImpl <em>Sum Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.SumExpressionImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getSumExpression()
		 * @generated
		 */
		EClass SUM_EXPRESSION = eINSTANCE.getSumExpression();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUM_EXPRESSION__EXPRESSION = eINSTANCE.getSumExpression_Expression();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUM_EXPRESSION__CONDITION = eINSTANCE.getSumExpression_Condition();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.VariableSumExpressionImpl <em>Variable Sum Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.VariableSumExpressionImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getVariableSumExpression()
		 * @generated
		 */
		EClass VARIABLE_SUM_EXPRESSION = eINSTANCE.getVariableSumExpression();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_SUM_EXPRESSION__VARIABLE = eINSTANCE.getVariableSumExpression_Variable();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.TypeSumExpressionImpl <em>Type Sum Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.TypeSumExpressionImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getTypeSumExpression()
		 * @generated
		 */
		EClass TYPE_SUM_EXPRESSION = eINSTANCE.getTypeSumExpression();

		/**
		 * The meta object literal for the '<em><b>Obj Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_SUM_EXPRESSION__OBJ_TYPE = eINSTANCE.getTypeSumExpression_ObjType();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.ArithmeticValueImpl <em>Arithmetic Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.ArithmeticValueImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getArithmeticValue()
		 * @generated
		 */
		EClass ARITHMETIC_VALUE = eINSTANCE.getArithmeticValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARITHMETIC_VALUE__VALUE = eINSTANCE.getArithmeticValue_Value();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.ArithmeticLiteralImpl <em>Arithmetic Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.ArithmeticLiteralImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getArithmeticLiteral()
		 * @generated
		 */
		EClass ARITHMETIC_LITERAL = eINSTANCE.getArithmeticLiteral();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.IntegerLiteralImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getIntegerLiteral()
		 * @generated
		 */
		EClass INTEGER_LITERAL = eINSTANCE.getIntegerLiteral();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_LITERAL__LITERAL = eINSTANCE.getIntegerLiteral_Literal();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.DoubleLiteralImpl <em>Double Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.DoubleLiteralImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getDoubleLiteral()
		 * @generated
		 */
		EClass DOUBLE_LITERAL = eINSTANCE.getDoubleLiteral();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_LITERAL__LITERAL = eINSTANCE.getDoubleLiteral_Literal();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.BoolExpressionImpl <em>Bool Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.BoolExpressionImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getBoolExpression()
		 * @generated
		 */
		EClass BOOL_EXPRESSION = eINSTANCE.getBoolExpression();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.BoolBinaryExpressionImpl <em>Bool Binary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.BoolBinaryExpressionImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getBoolBinaryExpression()
		 * @generated
		 */
		EClass BOOL_BINARY_EXPRESSION = eINSTANCE.getBoolBinaryExpression();

		/**
		 * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOL_BINARY_EXPRESSION__LHS = eINSTANCE.getBoolBinaryExpression_Lhs();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOL_BINARY_EXPRESSION__RHS = eINSTANCE.getBoolBinaryExpression_Rhs();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOL_BINARY_EXPRESSION__OPERATOR = eINSTANCE.getBoolBinaryExpression_Operator();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.BoolUnaryExpressionImpl <em>Bool Unary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.BoolUnaryExpressionImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getBoolUnaryExpression()
		 * @generated
		 */
		EClass BOOL_UNARY_EXPRESSION = eINSTANCE.getBoolUnaryExpression();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOL_UNARY_EXPRESSION__EXPRESSION = eINSTANCE.getBoolUnaryExpression_Expression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOL_UNARY_EXPRESSION__OPERATOR = eINSTANCE.getBoolUnaryExpression_Operator();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.BoolValueImpl <em>Bool Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.BoolValueImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getBoolValue()
		 * @generated
		 */
		EClass BOOL_VALUE = eINSTANCE.getBoolValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOL_VALUE__VALUE = eINSTANCE.getBoolValue_Value();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.BoolLiteralImpl <em>Bool Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.BoolLiteralImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getBoolLiteral()
		 * @generated
		 */
		EClass BOOL_LITERAL = eINSTANCE.getBoolLiteral();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOL_LITERAL__LITERAL = eINSTANCE.getBoolLiteral_Literal();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.ValueExpressionImpl <em>Value Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.ValueExpressionImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getValueExpression()
		 * @generated
		 */
		EClass VALUE_EXPRESSION = eINSTANCE.getValueExpression();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_EXPRESSION__TYPE = eINSTANCE.getValueExpression_Type();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.ContextTypeValueImpl <em>Context Type Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.ContextTypeValueImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getContextTypeValue()
		 * @generated
		 */
		EClass CONTEXT_TYPE_VALUE = eINSTANCE.getContextTypeValue();

		/**
		 * The meta object literal for the '<em><b>Type Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT_TYPE_VALUE__TYPE_CONTEXT = eINSTANCE.getContextTypeValue_TypeContext();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.ContextMappingNodeImpl <em>Context Mapping Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.ContextMappingNodeImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getContextMappingNode()
		 * @generated
		 */
		EClass CONTEXT_MAPPING_NODE = eINSTANCE.getContextMappingNode();

		/**
		 * The meta object literal for the '<em><b>Mapping Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT_MAPPING_NODE__MAPPING_CONTEXT = eINSTANCE.getContextMappingNode_MappingContext();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT_MAPPING_NODE__NODE = eINSTANCE.getContextMappingNode_Node();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.IteratorValueImpl <em>Iterator Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.IteratorValueImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getIteratorValue()
		 * @generated
		 */
		EClass ITERATOR_VALUE = eINSTANCE.getIteratorValue();

		/**
		 * The meta object literal for the '<em><b>Iterator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATOR_VALUE__ITERATOR = eINSTANCE.getIteratorValue_Iterator();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.FeatureExpressionImpl <em>Feature Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.FeatureExpressionImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getFeatureExpression()
		 * @generated
		 */
		EClass FEATURE_EXPRESSION = eINSTANCE.getFeatureExpression();

		/**
		 * The meta object literal for the '<em><b>Current</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_EXPRESSION__CURRENT = eINSTANCE.getFeatureExpression_Current();

		/**
		 * The meta object literal for the '<em><b>Child</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_EXPRESSION__CHILD = eINSTANCE.getFeatureExpression_Child();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.FeatureLiteralImpl <em>Feature Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.FeatureLiteralImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getFeatureLiteral()
		 * @generated
		 */
		EClass FEATURE_LITERAL = eINSTANCE.getFeatureLiteral();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_LITERAL__FEATURE = eINSTANCE.getFeatureLiteral_Feature();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.ContextTypeFeatureValueImpl <em>Context Type Feature Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.ContextTypeFeatureValueImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getContextTypeFeatureValue()
		 * @generated
		 */
		EClass CONTEXT_TYPE_FEATURE_VALUE = eINSTANCE.getContextTypeFeatureValue();

		/**
		 * The meta object literal for the '<em><b>Feature Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT_TYPE_FEATURE_VALUE__FEATURE_EXPRESSION = eINSTANCE
				.getContextTypeFeatureValue_FeatureExpression();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.ContextMappingNodeFeatureValueImpl <em>Context Mapping Node Feature Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.ContextMappingNodeFeatureValueImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getContextMappingNodeFeatureValue()
		 * @generated
		 */
		EClass CONTEXT_MAPPING_NODE_FEATURE_VALUE = eINSTANCE.getContextMappingNodeFeatureValue();

		/**
		 * The meta object literal for the '<em><b>Feature Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT_MAPPING_NODE_FEATURE_VALUE__FEATURE_EXPRESSION = eINSTANCE
				.getContextMappingNodeFeatureValue_FeatureExpression();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.IteratorFeatureValueImpl <em>Iterator Feature Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.IteratorFeatureValueImpl
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getIteratorFeatureValue()
		 * @generated
		 */
		EClass ITERATOR_FEATURE_VALUE = eINSTANCE.getIteratorFeatureValue();

		/**
		 * The meta object literal for the '<em><b>Feature Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATOR_FEATURE_VALUE__FEATURE_EXPRESSION = eINSTANCE.getIteratorFeatureValue_FeatureExpression();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.RelationalOperator <em>Relational Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.RelationalOperator
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getRelationalOperator()
		 * @generated
		 */
		EEnum RELATIONAL_OPERATOR = eINSTANCE.getRelationalOperator();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.BinaryArithmeticOperator <em>Binary Arithmetic Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.BinaryArithmeticOperator
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getBinaryArithmeticOperator()
		 * @generated
		 */
		EEnum BINARY_ARITHMETIC_OPERATOR = eINSTANCE.getBinaryArithmeticOperator();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.UnaryArithmeticOperator <em>Unary Arithmetic Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.UnaryArithmeticOperator
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getUnaryArithmeticOperator()
		 * @generated
		 */
		EEnum UNARY_ARITHMETIC_OPERATOR = eINSTANCE.getUnaryArithmeticOperator();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.BinaryBoolOperator <em>Binary Bool Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.BinaryBoolOperator
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getBinaryBoolOperator()
		 * @generated
		 */
		EEnum BINARY_BOOL_OPERATOR = eINSTANCE.getBinaryBoolOperator();

		/**
		 * The meta object literal for the '{@link org.emoflon.roam.intermediate.RoamIntermediate.UnaryBoolOperator <em>Unary Bool Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.UnaryBoolOperator
		 * @see org.emoflon.roam.intermediate.RoamIntermediate.impl.RoamIntermediatePackageImpl#getUnaryBoolOperator()
		 * @generated
		 */
		EEnum UNARY_BOOL_OPERATOR = eINSTANCE.getUnaryBoolOperator();

	}

} //RoamIntermediatePackage
