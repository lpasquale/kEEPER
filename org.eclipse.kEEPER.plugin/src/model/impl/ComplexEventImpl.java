/**
 */
package model.impl;

import java.util.ArrayList;
import java.util.Collection;

import model.Agent;
import model.BehaviouralDescription;
import model.ComplexEvent;
import model.ModelPackage;
import model.Parameter;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link model.impl.ComplexEventImpl#getBehaviouralDescriptions <em>Behavioural Descriptions</em>}</li>
 *   <li>{@link model.impl.ComplexEventImpl#getAgent <em>Agent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComplexEventImpl extends EventImpl implements ComplexEvent {
	/**
	 * The cached value of the '{@link #getBehaviouralDescriptions() <em>Behavioural Descriptions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviouralDescriptions()
	 * @generated
	 * @ordered
	 */
	protected EList<BehaviouralDescription> behaviouralDescriptions;

	/**
	 * The cached value of the '{@link #getAgent() <em>Agent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgent()
	 * @generated
	 * @ordered
	 */
	protected Agent agent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.COMPLEX_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehaviouralDescription> getBehaviouralDescriptions() {
		if (behaviouralDescriptions == null) {
			behaviouralDescriptions = new EObjectResolvingEList<BehaviouralDescription>(BehaviouralDescription.class, this, ModelPackage.COMPLEX_EVENT__BEHAVIOURAL_DESCRIPTIONS);
		}
		return behaviouralDescriptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Agent getAgent() {
		if (agent != null && agent.eIsProxy()) {
			InternalEObject oldAgent = (InternalEObject)agent;
			agent = (Agent)eResolveProxy(oldAgent);
			if (agent != oldAgent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.COMPLEX_EVENT__AGENT, oldAgent, agent));
			}
		}
		return agent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Agent basicGetAgent() {
		return agent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAgent(Agent newAgent) {
		Agent oldAgent = agent;
		agent = newAgent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.COMPLEX_EVENT__AGENT, oldAgent, agent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.COMPLEX_EVENT__BEHAVIOURAL_DESCRIPTIONS:
				return getBehaviouralDescriptions();
			case ModelPackage.COMPLEX_EVENT__AGENT:
				if (resolve) return getAgent();
				return basicGetAgent();
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
			case ModelPackage.COMPLEX_EVENT__BEHAVIOURAL_DESCRIPTIONS:
				getBehaviouralDescriptions().clear();
				getBehaviouralDescriptions().addAll((Collection<? extends BehaviouralDescription>)newValue);
				return;
			case ModelPackage.COMPLEX_EVENT__AGENT:
				setAgent((Agent)newValue);
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
			case ModelPackage.COMPLEX_EVENT__BEHAVIOURAL_DESCRIPTIONS:
				getBehaviouralDescriptions().clear();
				return;
			case ModelPackage.COMPLEX_EVENT__AGENT:
				setAgent((Agent)null);
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
			case ModelPackage.COMPLEX_EVENT__BEHAVIOURAL_DESCRIPTIONS:
				return behaviouralDescriptions != null && !behaviouralDescriptions.isEmpty();
			case ModelPackage.COMPLEX_EVENT__AGENT:
				return agent != null;
		}
		return super.eIsSet(featureID);
	}

} //ComplexEventImpl
