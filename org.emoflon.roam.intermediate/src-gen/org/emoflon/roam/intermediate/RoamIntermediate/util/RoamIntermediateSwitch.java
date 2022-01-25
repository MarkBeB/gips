/**
 */
package org.emoflon.roam.intermediate.RoamIntermediate.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.emoflon.roam.intermediate.RoamIntermediate.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.emoflon.roam.intermediate.RoamIntermediate.RoamIntermediatePackage
 * @generated
 */
public class RoamIntermediateSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RoamIntermediatePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoamIntermediateSwitch() {
		if (modelPackage == null) {
			modelPackage = RoamIntermediatePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case RoamIntermediatePackage.ROAM_INTERMEDIATE_MODEL: {
			RoamIntermediateModel roamIntermediateModel = (RoamIntermediateModel) theEObject;
			T result = caseRoamIntermediateModel(roamIntermediateModel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.VARIABLE_SET: {
			VariableSet variableSet = (VariableSet) theEObject;
			T result = caseVariableSet(variableSet);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.MAPPING: {
			Mapping mapping = (Mapping) theEObject;
			T result = caseMapping(mapping);
			if (result == null)
				result = caseVariableSet(mapping);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.CONSTRAINT: {
			Constraint constraint = (Constraint) theEObject;
			T result = caseConstraint(constraint);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.TYPE_CONSTRAINT: {
			TypeConstraint typeConstraint = (TypeConstraint) theEObject;
			T result = caseTypeConstraint(typeConstraint);
			if (result == null)
				result = caseContext(typeConstraint);
			if (result == null)
				result = caseConstraint(typeConstraint);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.MAPPING_CONSTRAINT: {
			MappingConstraint mappingConstraint = (MappingConstraint) theEObject;
			T result = caseMappingConstraint(mappingConstraint);
			if (result == null)
				result = caseContext(mappingConstraint);
			if (result == null)
				result = caseConstraint(mappingConstraint);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.CONTEXT: {
			Context context = (Context) theEObject;
			T result = caseContext(context);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.ITERATOR: {
			Iterator iterator = (Iterator) theEObject;
			T result = caseIterator(iterator);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.ARITHMETIC_EXPRESSION: {
			ArithmeticExpression arithmeticExpression = (ArithmeticExpression) theEObject;
			T result = caseArithmeticExpression(arithmeticExpression);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.BINARY_ARITHMETIC_EXPRESSION: {
			BinaryArithmeticExpression binaryArithmeticExpression = (BinaryArithmeticExpression) theEObject;
			T result = caseBinaryArithmeticExpression(binaryArithmeticExpression);
			if (result == null)
				result = caseArithmeticExpression(binaryArithmeticExpression);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.UNARY_ARITHMETIC_EXPRESSION: {
			UnaryArithmeticExpression unaryArithmeticExpression = (UnaryArithmeticExpression) theEObject;
			T result = caseUnaryArithmeticExpression(unaryArithmeticExpression);
			if (result == null)
				result = caseArithmeticExpression(unaryArithmeticExpression);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.SUM_EXPRESSION: {
			SumExpression sumExpression = (SumExpression) theEObject;
			T result = caseSumExpression(sumExpression);
			if (result == null)
				result = caseIterator(sumExpression);
			if (result == null)
				result = caseArithmeticExpression(sumExpression);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.VARIABLE_SUM_EXPRESSION: {
			VariableSumExpression variableSumExpression = (VariableSumExpression) theEObject;
			T result = caseVariableSumExpression(variableSumExpression);
			if (result == null)
				result = caseSumExpression(variableSumExpression);
			if (result == null)
				result = caseIterator(variableSumExpression);
			if (result == null)
				result = caseArithmeticExpression(variableSumExpression);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.TYPE_SUM_EXPRESSION: {
			TypeSumExpression typeSumExpression = (TypeSumExpression) theEObject;
			T result = caseTypeSumExpression(typeSumExpression);
			if (result == null)
				result = caseSumExpression(typeSumExpression);
			if (result == null)
				result = caseIterator(typeSumExpression);
			if (result == null)
				result = caseArithmeticExpression(typeSumExpression);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.ARITHMETIC_VALUE: {
			ArithmeticValue arithmeticValue = (ArithmeticValue) theEObject;
			T result = caseArithmeticValue(arithmeticValue);
			if (result == null)
				result = caseArithmeticExpression(arithmeticValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.ARITHMETIC_LITERAL: {
			ArithmeticLiteral arithmeticLiteral = (ArithmeticLiteral) theEObject;
			T result = caseArithmeticLiteral(arithmeticLiteral);
			if (result == null)
				result = caseArithmeticExpression(arithmeticLiteral);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.INTEGER_LITERAL: {
			IntegerLiteral integerLiteral = (IntegerLiteral) theEObject;
			T result = caseIntegerLiteral(integerLiteral);
			if (result == null)
				result = caseArithmeticLiteral(integerLiteral);
			if (result == null)
				result = caseArithmeticExpression(integerLiteral);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.DOUBLE_LITERAL: {
			DoubleLiteral doubleLiteral = (DoubleLiteral) theEObject;
			T result = caseDoubleLiteral(doubleLiteral);
			if (result == null)
				result = caseArithmeticLiteral(doubleLiteral);
			if (result == null)
				result = caseArithmeticExpression(doubleLiteral);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.BOOL_EXPRESSION: {
			BoolExpression boolExpression = (BoolExpression) theEObject;
			T result = caseBoolExpression(boolExpression);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.BOOL_BINARY_EXPRESSION: {
			BoolBinaryExpression boolBinaryExpression = (BoolBinaryExpression) theEObject;
			T result = caseBoolBinaryExpression(boolBinaryExpression);
			if (result == null)
				result = caseBoolExpression(boolBinaryExpression);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.BOOL_UNARY_EXPRESSION: {
			BoolUnaryExpression boolUnaryExpression = (BoolUnaryExpression) theEObject;
			T result = caseBoolUnaryExpression(boolUnaryExpression);
			if (result == null)
				result = caseBoolExpression(boolUnaryExpression);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.BOOL_VALUE: {
			BoolValue boolValue = (BoolValue) theEObject;
			T result = caseBoolValue(boolValue);
			if (result == null)
				result = caseBoolExpression(boolValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.BOOL_LITERAL: {
			BoolLiteral boolLiteral = (BoolLiteral) theEObject;
			T result = caseBoolLiteral(boolLiteral);
			if (result == null)
				result = caseBoolExpression(boolLiteral);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.VALUE_EXPRESSION: {
			ValueExpression valueExpression = (ValueExpression) theEObject;
			T result = caseValueExpression(valueExpression);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.CONTEXT_TYPE_VALUE: {
			ContextTypeValue contextTypeValue = (ContextTypeValue) theEObject;
			T result = caseContextTypeValue(contextTypeValue);
			if (result == null)
				result = caseValueExpression(contextTypeValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.CONTEXT_MAPPING_NODE: {
			ContextMappingNode contextMappingNode = (ContextMappingNode) theEObject;
			T result = caseContextMappingNode(contextMappingNode);
			if (result == null)
				result = caseValueExpression(contextMappingNode);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.ITERATOR_VALUE: {
			IteratorValue iteratorValue = (IteratorValue) theEObject;
			T result = caseIteratorValue(iteratorValue);
			if (result == null)
				result = caseValueExpression(iteratorValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.FEATURE_EXPRESSION: {
			FeatureExpression featureExpression = (FeatureExpression) theEObject;
			T result = caseFeatureExpression(featureExpression);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.FEATURE_LITERAL: {
			FeatureLiteral featureLiteral = (FeatureLiteral) theEObject;
			T result = caseFeatureLiteral(featureLiteral);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.CONTEXT_TYPE_FEATURE_VALUE: {
			ContextTypeFeatureValue contextTypeFeatureValue = (ContextTypeFeatureValue) theEObject;
			T result = caseContextTypeFeatureValue(contextTypeFeatureValue);
			if (result == null)
				result = caseContextTypeValue(contextTypeFeatureValue);
			if (result == null)
				result = caseValueExpression(contextTypeFeatureValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.CONTEXT_MAPPING_NODE_FEATURE_VALUE: {
			ContextMappingNodeFeatureValue contextMappingNodeFeatureValue = (ContextMappingNodeFeatureValue) theEObject;
			T result = caseContextMappingNodeFeatureValue(contextMappingNodeFeatureValue);
			if (result == null)
				result = caseContextMappingNode(contextMappingNodeFeatureValue);
			if (result == null)
				result = caseValueExpression(contextMappingNodeFeatureValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RoamIntermediatePackage.ITERATOR_FEATURE_VALUE: {
			IteratorFeatureValue iteratorFeatureValue = (IteratorFeatureValue) theEObject;
			T result = caseIteratorFeatureValue(iteratorFeatureValue);
			if (result == null)
				result = caseIteratorValue(iteratorFeatureValue);
			if (result == null)
				result = caseValueExpression(iteratorFeatureValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoamIntermediateModel(RoamIntermediateModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableSet(VariableSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapping(Mapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraint(Constraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeConstraint(TypeConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingConstraint(MappingConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContext(Context object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIterator(Iterator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Arithmetic Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Arithmetic Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArithmeticExpression(ArithmeticExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Arithmetic Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Arithmetic Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryArithmeticExpression(BinaryArithmeticExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Arithmetic Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Arithmetic Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryArithmeticExpression(UnaryArithmeticExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sum Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sum Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSumExpression(SumExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Sum Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Sum Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableSumExpression(VariableSumExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Sum Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Sum Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeSumExpression(TypeSumExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Arithmetic Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Arithmetic Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArithmeticValue(ArithmeticValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Arithmetic Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Arithmetic Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArithmeticLiteral(ArithmeticLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerLiteral(IntegerLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleLiteral(DoubleLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bool Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bool Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoolExpression(BoolExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bool Binary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bool Binary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoolBinaryExpression(BoolBinaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bool Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bool Unary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoolUnaryExpression(BoolUnaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bool Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bool Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoolValue(BoolValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bool Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bool Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoolLiteral(BoolLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueExpression(ValueExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context Type Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context Type Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContextTypeValue(ContextTypeValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context Mapping Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context Mapping Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContextMappingNode(ContextMappingNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterator Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterator Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIteratorValue(IteratorValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureExpression(FeatureExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureLiteral(FeatureLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context Type Feature Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context Type Feature Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContextTypeFeatureValue(ContextTypeFeatureValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context Mapping Node Feature Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context Mapping Node Feature Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContextMappingNodeFeatureValue(ContextMappingNodeFeatureValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterator Feature Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterator Feature Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIteratorFeatureValue(IteratorFeatureValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //RoamIntermediateSwitch
