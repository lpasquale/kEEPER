/**
 */
package model.impl;

import model.GeneralParam;
import model.ModelPackage;

import model.Type;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>General Param</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link model.impl.GeneralParamImpl#getGeneralType <em>General Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GeneralParamImpl extends ParameterImpl implements GeneralParam {
	/**
	 * The cached value of the '{@link #getGeneralType() <em>General Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralType()
	 * @generated
	 * @ordered
	 */
	protected Type generalType;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralParamImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.GENERAL_PARAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getGeneralType() {
		if (generalType != null && generalType.eIsProxy()) {
			InternalEObject oldGeneralType = (InternalEObject)generalType;
			generalType = (Type)eResolveProxy(oldGeneralType);
			if (generalType != oldGeneralType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.GENERAL_PARAM__GENERAL_TYPE, oldGeneralType, generalType));
			}
		}
		return generalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetGeneralType() {
		return generalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneralType(Type newGeneralType) {
		Type oldGeneralType = generalType;
		generalType = newGeneralType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.GENERAL_PARAM__GENERAL_TYPE, oldGeneralType, generalType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.GENERAL_PARAM__GENERAL_TYPE:
				if (resolve) return getGeneralType();
				return basicGetGeneralType();
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
			case ModelPackage.GENERAL_PARAM__GENERAL_TYPE:
				setGeneralType((Type)newValue);
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
			case ModelPackage.GENERAL_PARAM__GENERAL_TYPE:
				setGeneralType((Type)null);
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
			case ModelPackage.GENERAL_PARAM__GENERAL_TYPE:
				return generalType != null;
		}
		return super.eIsSet(featureID);
	}

} //GeneralParamImpl
