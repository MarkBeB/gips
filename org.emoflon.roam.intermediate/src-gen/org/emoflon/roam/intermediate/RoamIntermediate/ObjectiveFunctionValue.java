/**
 */
package org.emoflon.roam.intermediate.RoamIntermediate;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Objective Function Value</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.emoflon.roam.intermediate.RoamIntermediate.ObjectiveFunctionValue#getObjective
 * <em>Objective</em>}</li>
 * </ul>
 *
 * @see org.emoflon.roam.intermediate.RoamIntermediate.RoamIntermediatePackage#getObjectiveFunctionValue()
 * @model
 * @generated
 */
public interface ObjectiveFunctionValue extends ValueExpression {
	/**
	 * Returns the value of the '<em><b>Objective</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Objective</em>' reference.
	 * @see #setObjective(Objective)
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.RoamIntermediatePackage#getObjectiveFunctionValue_Objective()
	 * @model required="true"
	 * @generated
	 */
	Objective getObjective();

	/**
	 * Sets the value of the
	 * '{@link org.emoflon.roam.intermediate.RoamIntermediate.ObjectiveFunctionValue#getObjective
	 * <em>Objective</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Objective</em>' reference.
	 * @see #getObjective()
	 * @generated
	 */
	void setObjective(Objective value);

} // ObjectiveFunctionValue
