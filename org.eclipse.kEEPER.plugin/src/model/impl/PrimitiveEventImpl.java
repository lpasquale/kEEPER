/**
 */
package model.impl;

import model.AgentReference;
import model.ModelPackage;
import model.ObserverReference;
import model.PrimitiveEvent;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link model.impl.PrimitiveEventImpl#getAgent <em>Agent</em>}</li>
 *   <li>{@link model.impl.PrimitiveEventImpl#getObserver <em>Observer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PrimitiveEventImpl extends EventImpl implements PrimitiveEvent {
	/**
	 * The cached value of the '{@link #getAgent() <em>Agent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgent()
	 * @generated
	 * @ordered
	 */
	protected AgentReference agent;

	/**
	 * The cached value of the '{@link #getObserver() <em>Observer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObserver()
	 * @generated
	 * @ordered
	 */
	protected ObserverReference observer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PRIMITIVE_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AgentReference getAgent() {
		if (agent != null && agent.eIsProxy()) {
			InternalEObject oldAgent = (InternalEObject)agent;
			agent = (AgentReference)eResolveProxy(oldAgent);
			if (agent != oldAgent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.PRIMITIVE_EVENT__AGENT, oldAgent, agent));
			}
		}
		return agent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AgentReference basicGetAgent() {
		return agent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAgent(AgentReference newAgent) {
		AgentReference oldAgent = agent;
		agent = newAgent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMITIVE_EVENT__AGENT, oldAgent, agent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObserverReference getObserver() {
		if (observer != null && observer.eIsProxy()) {
			InternalEObject oldObserver = (InternalEObject)observer;
			observer = (ObserverReference)eResolveProxy(oldObserver);
			if (observer != oldObserver) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.PRIMITIVE_EVENT__OBSERVER, oldObserver, observer));
			}
		}
		return observer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObserverReference basicGetObserver() {
		return observer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObserver(ObserverReference newObserver) {
		ObserverReference oldObserver = observer;
		observer = newObserver;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMITIVE_EVENT__OBSERVER, oldObserver, observer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.PRIMITIVE_EVENT__AGENT:
				if (resolve) return getAgent();
				return basicGetAgent();
			case ModelPackage.PRIMITIVE_EVENT__OBSERVER:
				if (resolve) return getObserver();
				return basicGetObserver();
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
			case ModelPackage.PRIMITIVE_EVENT__AGENT:
				setAgent((AgentReference)newValue);
				return;
			case ModelPackage.PRIMITIVE_EVENT__OBSERVER:
				setObserver((ObserverReference)newValue);
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
			case ModelPackage.PRIMITIVE_EVENT__AGENT:
				setAgent((AgentReference)null);
				return;
			case ModelPackage.PRIMITIVE_EVENT__OBSERVER:
				setObserver((ObserverReference)null);
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
			case ModelPackage.PRIMITIVE_EVENT__AGENT:
				return agent != null;
			case ModelPackage.PRIMITIVE_EVENT__OBSERVER:
				return observer != null;
		}
		return super.eIsSet(featureID);
	}

} //PrimitiveEventImpl
