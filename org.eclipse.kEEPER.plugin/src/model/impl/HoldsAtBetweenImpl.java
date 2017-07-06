/**
 */
package model.impl;

import model.ContextRelation;
import model.HoldsAtBetween;
import model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Holds At Between</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link model.impl.HoldsAtBetweenImpl#getInitialTime <em>Initial Time</em>}</li>
 *   <li>{@link model.impl.HoldsAtBetweenImpl#getEndingTime <em>Ending Time</em>}</li>
 *   <li>{@link model.impl.HoldsAtBetweenImpl#isIsHolding <em>Is Holding</em>}</li>
 *   <li>{@link model.impl.HoldsAtBetweenImpl#getContextRelation <em>Context Relation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HoldsAtBetweenImpl extends MinimalEObjectImpl.Container implements HoldsAtBetween {
	/**
	 * The default value of the '{@link #getInitialTime() <em>Initial Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialTime()
	 * @generated
	 * @ordered
	 */
	protected static final int INITIAL_TIME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getInitialTime() <em>Initial Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialTime()
	 * @generated
	 * @ordered
	 */
	protected int initialTime = INITIAL_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndingTime() <em>Ending Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndingTime()
	 * @generated
	 * @ordered
	 */
	protected static final int ENDING_TIME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEndingTime() <em>Ending Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndingTime()
	 * @generated
	 * @ordered
	 */
	protected int endingTime = ENDING_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsHolding() <em>Is Holding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsHolding()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_HOLDING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsHolding() <em>Is Holding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsHolding()
	 * @generated
	 * @ordered
	 */
	protected boolean isHolding = IS_HOLDING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContextRelation() <em>Context Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextRelation()
	 * @generated
	 * @ordered
	 */
	protected ContextRelation contextRelation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HoldsAtBetweenImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.HOLDS_AT_BETWEEN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getInitialTime() {
		return initialTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialTime(int newInitialTime) {
		int oldInitialTime = initialTime;
		initialTime = newInitialTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.HOLDS_AT_BETWEEN__INITIAL_TIME, oldInitialTime, initialTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEndingTime() {
		return endingTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndingTime(int newEndingTime) {
		int oldEndingTime = endingTime;
		endingTime = newEndingTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.HOLDS_AT_BETWEEN__ENDING_TIME, oldEndingTime, endingTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsHolding() {
		return isHolding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsHolding(boolean newIsHolding) {
		boolean oldIsHolding = isHolding;
		isHolding = newIsHolding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.HOLDS_AT_BETWEEN__IS_HOLDING, oldIsHolding, isHolding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextRelation getContextRelation() {
		if (contextRelation != null && contextRelation.eIsProxy()) {
			InternalEObject oldContextRelation = (InternalEObject)contextRelation;
			contextRelation = (ContextRelation)eResolveProxy(oldContextRelation);
			if (contextRelation != oldContextRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.HOLDS_AT_BETWEEN__CONTEXT_RELATION, oldContextRelation, contextRelation));
			}
		}
		return contextRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextRelation basicGetContextRelation() {
		return contextRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextRelation(ContextRelation newContextRelation) {
		ContextRelation oldContextRelation = contextRelation;
		contextRelation = newContextRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.HOLDS_AT_BETWEEN__CONTEXT_RELATION, oldContextRelation, contextRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.HOLDS_AT_BETWEEN__INITIAL_TIME:
				return getInitialTime();
			case ModelPackage.HOLDS_AT_BETWEEN__ENDING_TIME:
				return getEndingTime();
			case ModelPackage.HOLDS_AT_BETWEEN__IS_HOLDING:
				return isIsHolding();
			case ModelPackage.HOLDS_AT_BETWEEN__CONTEXT_RELATION:
				if (resolve) return getContextRelation();
				return basicGetContextRelation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.HOLDS_AT_BETWEEN__INITIAL_TIME:
				setInitialTime((Integer)newValue);
				return;
			case ModelPackage.HOLDS_AT_BETWEEN__ENDING_TIME:
				setEndingTime((Integer)newValue);
				return;
			case ModelPackage.HOLDS_AT_BETWEEN__IS_HOLDING:
				setIsHolding((Boolean)newValue);
				return;
			case ModelPackage.HOLDS_AT_BETWEEN__CONTEXT_RELATION:
				setContextRelation((ContextRelation)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.HOLDS_AT_BETWEEN__INITIAL_TIME:
				setInitialTime(INITIAL_TIME_EDEFAULT);
				return;
			case ModelPackage.HOLDS_AT_BETWEEN__ENDING_TIME:
				setEndingTime(ENDING_TIME_EDEFAULT);
				return;
			case ModelPackage.HOLDS_AT_BETWEEN__IS_HOLDING:
				setIsHolding(IS_HOLDING_EDEFAULT);
				return;
			case ModelPackage.HOLDS_AT_BETWEEN__CONTEXT_RELATION:
				setContextRelation((ContextRelation)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.HOLDS_AT_BETWEEN__INITIAL_TIME:
				return initialTime != INITIAL_TIME_EDEFAULT;
			case ModelPackage.HOLDS_AT_BETWEEN__ENDING_TIME:
				return endingTime != ENDING_TIME_EDEFAULT;
			case ModelPackage.HOLDS_AT_BETWEEN__IS_HOLDING:
				return isHolding != IS_HOLDING_EDEFAULT;
			case ModelPackage.HOLDS_AT_BETWEEN__CONTEXT_RELATION:
				return contextRelation != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (initialTime: ");
		result.append(initialTime);
		result.append(", endingTime: ");
		result.append(endingTime);
		result.append(", isHolding: ");
		result.append(isHolding);
		result.append(')');
		return result.toString();
	}

} //HoldsAtBetweenImpl
