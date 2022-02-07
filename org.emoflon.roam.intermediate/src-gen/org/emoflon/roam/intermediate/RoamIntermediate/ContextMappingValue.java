/**
 */
package org.emoflon.roam.intermediate.RoamIntermediate;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context Mapping Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emoflon.roam.intermediate.RoamIntermediate.ContextMappingValue#getMappingContext <em>Mapping Context</em>}</li>
 * </ul>
 *
 * @see org.emoflon.roam.intermediate.RoamIntermediate.RoamIntermediatePackage#getContextMappingValue()
 * @model
 * @generated
 */
public interface ContextMappingValue extends ValueExpression {
	/**
	 * Returns the value of the '<em><b>Mapping Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Context</em>' reference.
	 * @see #setMappingContext(MappingConstraint)
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.RoamIntermediatePackage#getContextMappingValue_MappingContext()
	 * @model
	 * @generated
	 */
	MappingConstraint getMappingContext();

	/**
	 * Sets the value of the '{@link org.emoflon.roam.intermediate.RoamIntermediate.ContextMappingValue#getMappingContext <em>Mapping Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Context</em>' reference.
	 * @see #getMappingContext()
	 * @generated
	 */
	void setMappingContext(MappingConstraint value);

} // ContextMappingValue