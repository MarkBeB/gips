/**
 */
package org.emoflon.roam.intermediate.RoamIntermediate;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Stream
 * Select Operation</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.emoflon.roam.intermediate.RoamIntermediate.StreamSelectOperation#getType
 * <em>Type</em>}</li>
 * </ul>
 *
 * @see org.emoflon.roam.intermediate.RoamIntermediate.RoamIntermediatePackage#getStreamSelectOperation()
 * @model
 * @generated
 */
public interface StreamSelectOperation extends StreamOperation {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(EClass)
	 * @see org.emoflon.roam.intermediate.RoamIntermediate.RoamIntermediatePackage#getStreamSelectOperation_Type()
	 * @model containment="true"
	 * @generated
	 */
	EClass getType();

	/**
	 * Sets the value of the
	 * '{@link org.emoflon.roam.intermediate.RoamIntermediate.StreamSelectOperation#getType
	 * <em>Type</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EClass value);

} // StreamSelectOperation
