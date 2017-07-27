/**
 */
package model.impl;

import java.util.Collection;
import model.ContextRelation;
import model.Initially;
import model.Instance;
import model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Initially</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link model.impl.InitiallyImpl#getContextRelation <em>Context Relation</em>}</li>
 *   <li>{@link model.impl.InitiallyImpl#getInstances <em>Instances</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InitiallyImpl extends MinimalEObjectImpl.Container implements Initially {
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
	 * The cached value of the '{@link #getInstances() <em>Instances</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<Instance> instances;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitiallyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.INITIALLY;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.INITIALLY__CONTEXT_RELATION, oldContextRelation, contextRelation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.INITIALLY__CONTEXT_RELATION, oldContextRelation, contextRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Instance> getInstances() {
		if (instances == null) {
			instances = new EObjectResolvingEList<Instance>(Instance.class, this, ModelPackage.INITIALLY__INSTANCES);
		}
		return instances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.INITIALLY__CONTEXT_RELATION:
				if (resolve) return getContextRelation();
				return basicGetContextRelation();
			case ModelPackage.INITIALLY__INSTANCES:
				return getInstances();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.INITIALLY__CONTEXT_RELATION:
				setContextRelation((ContextRelation)newValue);
				return;
			case ModelPackage.INITIALLY__INSTANCES:
				getInstances().clear();
				getInstances().addAll((Collection<? extends Instance>)newValue);
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
			case ModelPackage.INITIALLY__CONTEXT_RELATION:
				setContextRelation((ContextRelation)null);
				return;
			case ModelPackage.INITIALLY__INSTANCES:
				getInstances().clear();
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
			case ModelPackage.INITIALLY__CONTEXT_RELATION:
				return contextRelation != null;
			case ModelPackage.INITIALLY__INSTANCES:
				return instances != null && !instances.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InitiallyImpl
