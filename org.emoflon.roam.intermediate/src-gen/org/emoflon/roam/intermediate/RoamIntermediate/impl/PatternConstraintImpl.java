/**
 */
package org.emoflon.roam.intermediate.RoamIntermediate.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.emoflon.roam.intermediate.RoamIntermediate.Constraint;
import org.emoflon.roam.intermediate.RoamIntermediate.Pattern;
import org.emoflon.roam.intermediate.RoamIntermediate.PatternConstraint;
import org.emoflon.roam.intermediate.RoamIntermediate.RelationalExpression;
import org.emoflon.roam.intermediate.RoamIntermediate.RoamIntermediatePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Pattern
 * Constraint</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.PatternConstraintImpl#getName
 * <em>Name</em>}</li>
 * <li>{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.PatternConstraintImpl#isElementwise
 * <em>Elementwise</em>}</li>
 * <li>{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.PatternConstraintImpl#getExpression
 * <em>Expression</em>}</li>
 * <li>{@link org.emoflon.roam.intermediate.RoamIntermediate.impl.PatternConstraintImpl#getPattern
 * <em>Pattern</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PatternConstraintImpl extends MinimalEObjectImpl.Container implements PatternConstraint {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isElementwise() <em>Elementwise</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #isElementwise()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ELEMENTWISE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isElementwise() <em>Elementwise</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #isElementwise()
	 * @generated
	 * @ordered
	 */
	protected boolean elementwise = ELEMENTWISE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected RelationalExpression expression;

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected Pattern pattern;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected PatternConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RoamIntermediatePackage.Literals.PATTERN_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoamIntermediatePackage.PATTERN_CONSTRAINT__NAME,
					oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean isElementwise() {
		return elementwise;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setElementwise(boolean newElementwise) {
		boolean oldElementwise = elementwise;
		elementwise = newElementwise;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RoamIntermediatePackage.PATTERN_CONSTRAINT__ELEMENTWISE, oldElementwise, elementwise));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public RelationalExpression getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetExpression(RelationalExpression newExpression, NotificationChain msgs) {
		RelationalExpression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					RoamIntermediatePackage.PATTERN_CONSTRAINT__EXPRESSION, oldExpression, newExpression);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setExpression(RelationalExpression newExpression) {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject) expression).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - RoamIntermediatePackage.PATTERN_CONSTRAINT__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject) newExpression).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - RoamIntermediatePackage.PATTERN_CONSTRAINT__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RoamIntermediatePackage.PATTERN_CONSTRAINT__EXPRESSION, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Pattern getPattern() {
		if (pattern != null && pattern.eIsProxy()) {
			InternalEObject oldPattern = (InternalEObject) pattern;
			pattern = (Pattern) eResolveProxy(oldPattern);
			if (pattern != oldPattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							RoamIntermediatePackage.PATTERN_CONSTRAINT__PATTERN, oldPattern, pattern));
			}
		}
		return pattern;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Pattern basicGetPattern() {
		return pattern;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setPattern(Pattern newPattern) {
		Pattern oldPattern = pattern;
		pattern = newPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoamIntermediatePackage.PATTERN_CONSTRAINT__PATTERN,
					oldPattern, pattern));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RoamIntermediatePackage.PATTERN_CONSTRAINT__EXPRESSION:
			return basicSetExpression(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RoamIntermediatePackage.PATTERN_CONSTRAINT__NAME:
			return getName();
		case RoamIntermediatePackage.PATTERN_CONSTRAINT__ELEMENTWISE:
			return isElementwise();
		case RoamIntermediatePackage.PATTERN_CONSTRAINT__EXPRESSION:
			return getExpression();
		case RoamIntermediatePackage.PATTERN_CONSTRAINT__PATTERN:
			if (resolve)
				return getPattern();
			return basicGetPattern();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case RoamIntermediatePackage.PATTERN_CONSTRAINT__NAME:
			setName((String) newValue);
			return;
		case RoamIntermediatePackage.PATTERN_CONSTRAINT__ELEMENTWISE:
			setElementwise((Boolean) newValue);
			return;
		case RoamIntermediatePackage.PATTERN_CONSTRAINT__EXPRESSION:
			setExpression((RelationalExpression) newValue);
			return;
		case RoamIntermediatePackage.PATTERN_CONSTRAINT__PATTERN:
			setPattern((Pattern) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case RoamIntermediatePackage.PATTERN_CONSTRAINT__NAME:
			setName(NAME_EDEFAULT);
			return;
		case RoamIntermediatePackage.PATTERN_CONSTRAINT__ELEMENTWISE:
			setElementwise(ELEMENTWISE_EDEFAULT);
			return;
		case RoamIntermediatePackage.PATTERN_CONSTRAINT__EXPRESSION:
			setExpression((RelationalExpression) null);
			return;
		case RoamIntermediatePackage.PATTERN_CONSTRAINT__PATTERN:
			setPattern((Pattern) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case RoamIntermediatePackage.PATTERN_CONSTRAINT__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case RoamIntermediatePackage.PATTERN_CONSTRAINT__ELEMENTWISE:
			return elementwise != ELEMENTWISE_EDEFAULT;
		case RoamIntermediatePackage.PATTERN_CONSTRAINT__EXPRESSION:
			return expression != null;
		case RoamIntermediatePackage.PATTERN_CONSTRAINT__PATTERN:
			return pattern != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Constraint.class) {
			switch (derivedFeatureID) {
			case RoamIntermediatePackage.PATTERN_CONSTRAINT__NAME:
				return RoamIntermediatePackage.CONSTRAINT__NAME;
			case RoamIntermediatePackage.PATTERN_CONSTRAINT__ELEMENTWISE:
				return RoamIntermediatePackage.CONSTRAINT__ELEMENTWISE;
			case RoamIntermediatePackage.PATTERN_CONSTRAINT__EXPRESSION:
				return RoamIntermediatePackage.CONSTRAINT__EXPRESSION;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Constraint.class) {
			switch (baseFeatureID) {
			case RoamIntermediatePackage.CONSTRAINT__NAME:
				return RoamIntermediatePackage.PATTERN_CONSTRAINT__NAME;
			case RoamIntermediatePackage.CONSTRAINT__ELEMENTWISE:
				return RoamIntermediatePackage.PATTERN_CONSTRAINT__ELEMENTWISE;
			case RoamIntermediatePackage.CONSTRAINT__EXPRESSION:
				return RoamIntermediatePackage.PATTERN_CONSTRAINT__EXPRESSION;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", elementwise: ");
		result.append(elementwise);
		result.append(')');
		return result.toString();
	}

} // PatternConstraintImpl
