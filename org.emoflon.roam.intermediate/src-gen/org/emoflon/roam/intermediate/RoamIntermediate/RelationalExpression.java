/**
 */
package org.emoflon.roam.intermediate.RoamIntermediate;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relational Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emoflon.roam.intermediate.RoamIntermediate.RelationalExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.emoflon.roam.intermediate.RoamIntermediate.RelationalExpression#getLhs <em>Lhs</em>}</li>
 *   <li>{@link org.emoflon.roam.intermediate.RoamIntermediate.RelationalExpression#getRhs <em>Rhs</em>}</li>
 * </ul>
 *
 * @see org.emoflon.roam.intermediate.RoamIntermediate.RoamIntermediatePackage#getRelationalExpression()
 * @model
 * @generated
 */
public interface RelationalExpression extends BoolValueExpression {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.emoflon.roam.intermediate.RoamIntermediate.RelationalOperator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.RelationalOperator
	 * @see #setOperator(RelationalOperator)
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.RoamIntermediatePackage#getRelationalExpression_Operator()
	 * @model
	 * @generated
	 */
	RelationalOperator getOperator();

	/**
	 * Sets the value of the '{@link org.emoflon.roam.intermediate.RoamIntermediate.RelationalExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.RelationalOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(RelationalOperator value);

	/**
	 * Returns the value of the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lhs</em>' containment reference.
	 * @see #setLhs(ArithmeticExpression)
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.RoamIntermediatePackage#getRelationalExpression_Lhs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ArithmeticExpression getLhs();

	/**
	 * Sets the value of the '{@link org.emoflon.roam.intermediate.RoamIntermediate.RelationalExpression#getLhs <em>Lhs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lhs</em>' containment reference.
	 * @see #getLhs()
	 * @generated
	 */
	void setLhs(ArithmeticExpression value);

	/**
	 * Returns the value of the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rhs</em>' containment reference.
	 * @see #setRhs(ArithmeticExpression)
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.RoamIntermediatePackage#getRelationalExpression_Rhs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ArithmeticExpression getRhs();

	/**
	 * Sets the value of the '{@link org.emoflon.roam.intermediate.RoamIntermediate.RelationalExpression#getRhs <em>Rhs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rhs</em>' containment reference.
	 * @see #getRhs()
	 * @generated
	 */
	void setRhs(ArithmeticExpression value);

} // RelationalExpression
