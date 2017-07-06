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
 *   <li>{@link model.impl.GeneralParamImpl#getGeneralParam <em>General Param</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GeneralParamImpl extends ParameterImpl implements GeneralParam {
	/**
	 * The cached value of the '{@link #getGeneralParam() <em>General Param</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralParam()
	 * @generated
	 * @ordered
	 */
	protected Type generalParam;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeneralParamImpl() {
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
	public Type getGeneralParam() {
		if (generalParam != null && generalParam.eIsProxy()) {
			InternalEObject oldGeneralParam = (InternalEObject)generalParam;
			generalParam = (Type)eResolveProxy(oldGeneralParam);
			if (generalParam != oldGeneralParam) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.GENERAL_PARAM__GENERAL_PARAM, oldGeneralParam, generalParam));
			}
		}
		return generalParam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetGeneralParam() {
		return generalParam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneralParam(Type newGeneralParam) {
		Type oldGeneralParam = generalParam;
		generalParam = newGeneralParam;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.GENERAL_PARAM__GENERAL_PARAM, oldGeneralParam, generalParam));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.GENERAL_PARAM__GENERAL_PARAM:
				if (resolve) return getGeneralParam();
				return basicGetGeneralParam();
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
			case ModelPackage.GENERAL_PARAM__GENERAL_PARAM:
				setGeneralParam((Type)newValue);
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
			case ModelPackage.GENERAL_PARAM__GENERAL_PARAM:
				setGeneralParam((Type)null);
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
			case ModelPackage.GENERAL_PARAM__GENERAL_PARAM:
				return generalParam != null;
		}
		return super.eIsSet(featureID);
	}

} //GeneralParamImpl
