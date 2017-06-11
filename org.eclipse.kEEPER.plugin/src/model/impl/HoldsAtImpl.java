/**
 */
package model.impl;

import model.ContextRelation;
import model.HoldsAt;
import model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Holds At</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link model.impl.HoldsAtImpl#getTime <em>Time</em>}</li>
 *   <li>{@link model.impl.HoldsAtImpl#isIsHolding <em>Is Holding</em>}</li>
 *   <li>{@link model.impl.HoldsAtImpl#getContextRelation <em>Context Relation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HoldsAtImpl extends MinimalEObjectImpl.Container implements HoldsAt {
	/**
	 * The default value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected static final int TIME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected int time = TIME_EDEFAULT;

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
	public HoldsAtImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.HOLDS_AT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTime() {
		return time;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTime(int newTime) {
		int oldTime = time;
		time = newTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.HOLDS_AT__TIME, oldTime, time));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.HOLDS_AT__IS_HOLDING, oldIsHolding, isHolding));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.HOLDS_AT__CONTEXT_RELATION, oldContextRelation, contextRelation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.HOLDS_AT__CONTEXT_RELATION, oldContextRelation, contextRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.HOLDS_AT__TIME:
				return getTime();
			case ModelPackage.HOLDS_AT__IS_HOLDING:
				return isIsHolding();
			case ModelPackage.HOLDS_AT__CONTEXT_RELATION:
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
			case ModelPackage.HOLDS_AT__TIME:
				setTime((Integer)newValue);
				return;
			case ModelPackage.HOLDS_AT__IS_HOLDING:
				setIsHolding((Boolean)newValue);
				return;
			case ModelPackage.HOLDS_AT__CONTEXT_RELATION:
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
			case ModelPackage.HOLDS_AT__TIME:
				setTime(TIME_EDEFAULT);
				return;
			case ModelPackage.HOLDS_AT__IS_HOLDING:
				setIsHolding(IS_HOLDING_EDEFAULT);
				return;
			case ModelPackage.HOLDS_AT__CONTEXT_RELATION:
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
			case ModelPackage.HOLDS_AT__TIME:
				return time != TIME_EDEFAULT;
			case ModelPackage.HOLDS_AT__IS_HOLDING:
				return isHolding != IS_HOLDING_EDEFAULT;
			case ModelPackage.HOLDS_AT__CONTEXT_RELATION:
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
		result.append(" (time: ");
		result.append(time);
		result.append(", isHolding: ");
		result.append(isHolding);
		result.append(')');
		return result.toString();
	}

} //HoldsAtImpl
