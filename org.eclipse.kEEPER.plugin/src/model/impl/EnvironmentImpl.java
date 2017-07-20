/**
 */
package model.impl;

import java.util.Collection;
import model.AgentParam;
import model.AgentReference;
import model.BehaviouralDescription;
import model.ComplexEvent;
import model.ContextRelation;
import model.Environment;
import model.Event;
import model.GeneralParam;
import model.GeneralTypeReference;
import model.Happens;
import model.HoldsAt;
import model.HoldsAtBetween;
import model.Hypothesis;
import model.Initially;
import model.Instance;
import model.ModelPackage;
import model.ObserverParam;
import model.ObserverReference;
import model.Parameter;
import model.PrimitiveEvent;
import model.Type;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Environment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link model.impl.EnvironmentImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link model.impl.EnvironmentImpl#getInstances <em>Instances</em>}</li>
 *   <li>{@link model.impl.EnvironmentImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link model.impl.EnvironmentImpl#getContextRelations <em>Context Relations</em>}</li>
 *   <li>{@link model.impl.EnvironmentImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link model.impl.EnvironmentImpl#getBehavDescriptions <em>Behav Descriptions</em>}</li>
 *   <li>{@link model.impl.EnvironmentImpl#getHoldsAts <em>Holds Ats</em>}</li>
 *   <li>{@link model.impl.EnvironmentImpl#getHappens <em>Happens</em>}</li>
 *   <li>{@link model.impl.EnvironmentImpl#getHoldsAtBetweens <em>Holds At Betweens</em>}</li>
 *   <li>{@link model.impl.EnvironmentImpl#getInitials <em>Initials</em>}</li>
 *   <li>{@link model.impl.EnvironmentImpl#getGeneralParams <em>General Params</em>}</li>
 *   <li>{@link model.impl.EnvironmentImpl#getPrimitiveEvents <em>Primitive Events</em>}</li>
 *   <li>{@link model.impl.EnvironmentImpl#getComplexEvents <em>Complex Events</em>}</li>
 *   <li>{@link model.impl.EnvironmentImpl#getHypothesis <em>Hypothesis</em>}</li>
 *   <li>{@link model.impl.EnvironmentImpl#getAgentParams <em>Agent Params</em>}</li>
 *   <li>{@link model.impl.EnvironmentImpl#getObserverParams <em>Observer Params</em>}</li>
 *   <li>{@link model.impl.EnvironmentImpl#getAgentReferences <em>Agent References</em>}</li>
 *   <li>{@link model.impl.EnvironmentImpl#getObserverReferences <em>Observer References</em>}</li>
 *   <li>{@link model.impl.EnvironmentImpl#getGeneralTypeReferences <em>General Type References</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnvironmentImpl extends MinimalEObjectImpl.Container implements Environment {
	/**
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> types;

	/**
	 * The cached value of the '{@link #getInstances() <em>Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<Instance> instances;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

	/**
	 * The cached value of the '{@link #getContextRelations() <em>Context Relations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<ContextRelation> contextRelations;

	/**
	 * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> events;

	/**
	 * The cached value of the '{@link #getBehavDescriptions() <em>Behav Descriptions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehavDescriptions()
	 * @generated
	 * @ordered
	 */
	protected EList<BehaviouralDescription> behavDescriptions;

	/**
	 * The cached value of the '{@link #getHoldsAts() <em>Holds Ats</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHoldsAts()
	 * @generated
	 * @ordered
	 */
	protected EList<HoldsAt> holdsAts;

	/**
	 * The cached value of the '{@link #getHappens() <em>Happens</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHappens()
	 * @generated
	 * @ordered
	 */
	protected EList<Happens> happens;

	/**
	 * The cached value of the '{@link #getHoldsAtBetweens() <em>Holds At Betweens</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHoldsAtBetweens()
	 * @generated
	 * @ordered
	 */
	protected EList<HoldsAtBetween> holdsAtBetweens;

	/**
	 * The cached value of the '{@link #getInitials() <em>Initials</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitials()
	 * @generated
	 * @ordered
	 */
	protected EList<Initially> initials;

	/**
	 * The cached value of the '{@link #getGeneralParams() <em>General Params</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralParams()
	 * @generated
	 * @ordered
	 */
	protected EList<GeneralParam> generalParams;

	/**
	 * The cached value of the '{@link #getPrimitiveEvents() <em>Primitive Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitiveEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<PrimitiveEvent> primitiveEvents;

	/**
	 * The cached value of the '{@link #getComplexEvents() <em>Complex Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComplexEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<ComplexEvent> complexEvents;

	/**
	 * The cached value of the '{@link #getHypothesis() <em>Hypothesis</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHypothesis()
	 * @generated
	 * @ordered
	 */
	protected EList<Hypothesis> hypothesis;

	/**
	 * The cached value of the '{@link #getAgentParams() <em>Agent Params</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgentParams()
	 * @generated
	 * @ordered
	 */
	protected EList<AgentParam> agentParams;

	/**
	 * The cached value of the '{@link #getObserverParams() <em>Observer Params</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObserverParams()
	 * @generated
	 * @ordered
	 */
	protected EList<ObserverParam> observerParams;

	/**
	 * The cached value of the '{@link #getAgentReferences() <em>Agent References</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgentReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<AgentReference> agentReferences;

	/**
	 * The cached value of the '{@link #getObserverReferences() <em>Observer References</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObserverReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<ObserverReference> observerReferences;

	/**
	 * The cached value of the '{@link #getGeneralTypeReferences() <em>General Type References</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralTypeReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<GeneralTypeReference> generalTypeReferences;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnvironmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ENVIRONMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getTypes() {
		if (types == null) {
			types = new EObjectContainmentEList<Type>(Type.class, this, ModelPackage.ENVIRONMENT__TYPES);
		}
		return types;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Instance> getInstances() {
		if (instances == null) {
			instances = new EObjectContainmentEList<Instance>(Instance.class, this, ModelPackage.ENVIRONMENT__INSTANCES);
		}
		return instances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, ModelPackage.ENVIRONMENT__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ContextRelation> getContextRelations() {
		if (contextRelations == null) {
			contextRelations = new EObjectContainmentEList<ContextRelation>(ContextRelation.class, this, ModelPackage.ENVIRONMENT__CONTEXT_RELATIONS);
		}
		return contextRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Event> getEvents() {
		if (events == null) {
			events = new EObjectContainmentEList<Event>(Event.class, this, ModelPackage.ENVIRONMENT__EVENTS);
		}
		if (primitiveEvents == null) {
			primitiveEvents = new EObjectContainmentEList<PrimitiveEvent>(PrimitiveEvent.class, this, ModelPackage.ENVIRONMENT__PRIMITIVE_EVENTS);
		}
		if (complexEvents == null) {
			complexEvents = new EObjectContainmentEList<ComplexEvent>(ComplexEvent.class, this, ModelPackage.ENVIRONMENT__COMPLEX_EVENTS);
		}
		events.addAll(primitiveEvents);
		events.addAll(complexEvents);
		return events;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehaviouralDescription> getBehavDescriptions() {
		if (behavDescriptions == null) {
			behavDescriptions = new EObjectContainmentEList<BehaviouralDescription>(BehaviouralDescription.class, this, ModelPackage.ENVIRONMENT__BEHAV_DESCRIPTIONS);
		}
		return behavDescriptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HoldsAt> getHoldsAts() {
		if (holdsAts == null) {
			holdsAts = new EObjectContainmentEList<HoldsAt>(HoldsAt.class, this, ModelPackage.ENVIRONMENT__HOLDS_ATS);
		}
		return holdsAts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Happens> getHappens() {
		if (happens == null) {
			happens = new EObjectContainmentEList<Happens>(Happens.class, this, ModelPackage.ENVIRONMENT__HAPPENS);
		}
		return happens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HoldsAtBetween> getHoldsAtBetweens() {
		if (holdsAtBetweens == null) {
			holdsAtBetweens = new EObjectContainmentEList<HoldsAtBetween>(HoldsAtBetween.class, this, ModelPackage.ENVIRONMENT__HOLDS_AT_BETWEENS);
		}
		return holdsAtBetweens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Initially> getInitials() {
		if (initials == null) {
			initials = new EObjectContainmentEList<Initially>(Initially.class, this, ModelPackage.ENVIRONMENT__INITIALS);
		}
		return initials;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GeneralParam> getGeneralParams() {
		if (generalParams == null) {
			generalParams = new EObjectContainmentEList<GeneralParam>(GeneralParam.class, this, ModelPackage.ENVIRONMENT__GENERAL_PARAMS);
		}
		return generalParams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PrimitiveEvent> getPrimitiveEvents() {
		if (primitiveEvents == null) {
			primitiveEvents = new EObjectContainmentEList<PrimitiveEvent>(PrimitiveEvent.class, this, ModelPackage.ENVIRONMENT__PRIMITIVE_EVENTS);
		}
		return primitiveEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComplexEvent> getComplexEvents() {
		if (complexEvents == null) {
			complexEvents = new EObjectContainmentEList<ComplexEvent>(ComplexEvent.class, this, ModelPackage.ENVIRONMENT__COMPLEX_EVENTS);
		}
		return complexEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Hypothesis> getHypothesis() {
		if (hypothesis == null) {
			hypothesis = new EObjectContainmentEList<Hypothesis>(Hypothesis.class, this, ModelPackage.ENVIRONMENT__HYPOTHESIS);
		}
		return hypothesis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AgentParam> getAgentParams() {
		if (agentParams == null) {
			agentParams = new EObjectContainmentEList<AgentParam>(AgentParam.class, this, ModelPackage.ENVIRONMENT__AGENT_PARAMS);
		}
		return agentParams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ObserverParam> getObserverParams() {
		if (observerParams == null) {
			observerParams = new EObjectContainmentEList<ObserverParam>(ObserverParam.class, this, ModelPackage.ENVIRONMENT__OBSERVER_PARAMS);
		}
		return observerParams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AgentReference> getAgentReferences() {
		if (agentReferences == null) {
			agentReferences = new EObjectContainmentEList<AgentReference>(AgentReference.class, this, ModelPackage.ENVIRONMENT__AGENT_REFERENCES);
		}
		return agentReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ObserverReference> getObserverReferences() {
		if (observerReferences == null) {
			observerReferences = new EObjectContainmentEList<ObserverReference>(ObserverReference.class, this, ModelPackage.ENVIRONMENT__OBSERVER_REFERENCES);
		}
		return observerReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GeneralTypeReference> getGeneralTypeReferences() {
		if (generalTypeReferences == null) {
			generalTypeReferences = new EObjectContainmentEList<GeneralTypeReference>(GeneralTypeReference.class, this, ModelPackage.ENVIRONMENT__GENERAL_TYPE_REFERENCES);
		}
		return generalTypeReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.ENVIRONMENT__TYPES:
				return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
			case ModelPackage.ENVIRONMENT__INSTANCES:
				return ((InternalEList<?>)getInstances()).basicRemove(otherEnd, msgs);
			case ModelPackage.ENVIRONMENT__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case ModelPackage.ENVIRONMENT__CONTEXT_RELATIONS:
				return ((InternalEList<?>)getContextRelations()).basicRemove(otherEnd, msgs);
			case ModelPackage.ENVIRONMENT__EVENTS:
				return ((InternalEList<?>)getEvents()).basicRemove(otherEnd, msgs);
			case ModelPackage.ENVIRONMENT__BEHAV_DESCRIPTIONS:
				return ((InternalEList<?>)getBehavDescriptions()).basicRemove(otherEnd, msgs);
			case ModelPackage.ENVIRONMENT__HOLDS_ATS:
				return ((InternalEList<?>)getHoldsAts()).basicRemove(otherEnd, msgs);
			case ModelPackage.ENVIRONMENT__HAPPENS:
				return ((InternalEList<?>)getHappens()).basicRemove(otherEnd, msgs);
			case ModelPackage.ENVIRONMENT__HOLDS_AT_BETWEENS:
				return ((InternalEList<?>)getHoldsAtBetweens()).basicRemove(otherEnd, msgs);
			case ModelPackage.ENVIRONMENT__INITIALS:
				return ((InternalEList<?>)getInitials()).basicRemove(otherEnd, msgs);
			case ModelPackage.ENVIRONMENT__GENERAL_PARAMS:
				return ((InternalEList<?>)getGeneralParams()).basicRemove(otherEnd, msgs);
			case ModelPackage.ENVIRONMENT__PRIMITIVE_EVENTS:
				return ((InternalEList<?>)getPrimitiveEvents()).basicRemove(otherEnd, msgs);
			case ModelPackage.ENVIRONMENT__COMPLEX_EVENTS:
				return ((InternalEList<?>)getComplexEvents()).basicRemove(otherEnd, msgs);
			case ModelPackage.ENVIRONMENT__HYPOTHESIS:
				return ((InternalEList<?>)getHypothesis()).basicRemove(otherEnd, msgs);
			case ModelPackage.ENVIRONMENT__AGENT_PARAMS:
				return ((InternalEList<?>)getAgentParams()).basicRemove(otherEnd, msgs);
			case ModelPackage.ENVIRONMENT__OBSERVER_PARAMS:
				return ((InternalEList<?>)getObserverParams()).basicRemove(otherEnd, msgs);
			case ModelPackage.ENVIRONMENT__AGENT_REFERENCES:
				return ((InternalEList<?>)getAgentReferences()).basicRemove(otherEnd, msgs);
			case ModelPackage.ENVIRONMENT__OBSERVER_REFERENCES:
				return ((InternalEList<?>)getObserverReferences()).basicRemove(otherEnd, msgs);
			case ModelPackage.ENVIRONMENT__GENERAL_TYPE_REFERENCES:
				return ((InternalEList<?>)getGeneralTypeReferences()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.ENVIRONMENT__TYPES:
				return getTypes();
			case ModelPackage.ENVIRONMENT__INSTANCES:
				return getInstances();
			case ModelPackage.ENVIRONMENT__PARAMETERS:
				return getParameters();
			case ModelPackage.ENVIRONMENT__CONTEXT_RELATIONS:
				return getContextRelations();
			case ModelPackage.ENVIRONMENT__EVENTS:
				return getEvents();
			case ModelPackage.ENVIRONMENT__BEHAV_DESCRIPTIONS:
				return getBehavDescriptions();
			case ModelPackage.ENVIRONMENT__HOLDS_ATS:
				return getHoldsAts();
			case ModelPackage.ENVIRONMENT__HAPPENS:
				return getHappens();
			case ModelPackage.ENVIRONMENT__HOLDS_AT_BETWEENS:
				return getHoldsAtBetweens();
			case ModelPackage.ENVIRONMENT__INITIALS:
				return getInitials();
			case ModelPackage.ENVIRONMENT__GENERAL_PARAMS:
				return getGeneralParams();
			case ModelPackage.ENVIRONMENT__PRIMITIVE_EVENTS:
				return getPrimitiveEvents();
			case ModelPackage.ENVIRONMENT__COMPLEX_EVENTS:
				return getComplexEvents();
			case ModelPackage.ENVIRONMENT__HYPOTHESIS:
				return getHypothesis();
			case ModelPackage.ENVIRONMENT__AGENT_PARAMS:
				return getAgentParams();
			case ModelPackage.ENVIRONMENT__OBSERVER_PARAMS:
				return getObserverParams();
			case ModelPackage.ENVIRONMENT__AGENT_REFERENCES:
				return getAgentReferences();
			case ModelPackage.ENVIRONMENT__OBSERVER_REFERENCES:
				return getObserverReferences();
			case ModelPackage.ENVIRONMENT__GENERAL_TYPE_REFERENCES:
				return getGeneralTypeReferences();
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
			case ModelPackage.ENVIRONMENT__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection<? extends Type>)newValue);
				return;
			case ModelPackage.ENVIRONMENT__INSTANCES:
				getInstances().clear();
				getInstances().addAll((Collection<? extends Instance>)newValue);
				return;
			case ModelPackage.ENVIRONMENT__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case ModelPackage.ENVIRONMENT__CONTEXT_RELATIONS:
				getContextRelations().clear();
				getContextRelations().addAll((Collection<? extends ContextRelation>)newValue);
				return;
			case ModelPackage.ENVIRONMENT__EVENTS:
				getEvents().clear();
				getEvents().addAll((Collection<? extends Event>)newValue);
				return;
			case ModelPackage.ENVIRONMENT__BEHAV_DESCRIPTIONS:
				getBehavDescriptions().clear();
				getBehavDescriptions().addAll((Collection<? extends BehaviouralDescription>)newValue);
				return;
			case ModelPackage.ENVIRONMENT__HOLDS_ATS:
				getHoldsAts().clear();
				getHoldsAts().addAll((Collection<? extends HoldsAt>)newValue);
				return;
			case ModelPackage.ENVIRONMENT__HAPPENS:
				getHappens().clear();
				getHappens().addAll((Collection<? extends Happens>)newValue);
				return;
			case ModelPackage.ENVIRONMENT__HOLDS_AT_BETWEENS:
				getHoldsAtBetweens().clear();
				getHoldsAtBetweens().addAll((Collection<? extends HoldsAtBetween>)newValue);
				return;
			case ModelPackage.ENVIRONMENT__INITIALS:
				getInitials().clear();
				getInitials().addAll((Collection<? extends Initially>)newValue);
				return;
			case ModelPackage.ENVIRONMENT__GENERAL_PARAMS:
				getGeneralParams().clear();
				getGeneralParams().addAll((Collection<? extends GeneralParam>)newValue);
				return;
			case ModelPackage.ENVIRONMENT__PRIMITIVE_EVENTS:
				getPrimitiveEvents().clear();
				getPrimitiveEvents().addAll((Collection<? extends PrimitiveEvent>)newValue);
				return;
			case ModelPackage.ENVIRONMENT__COMPLEX_EVENTS:
				getComplexEvents().clear();
				getComplexEvents().addAll((Collection<? extends ComplexEvent>)newValue);
				return;
			case ModelPackage.ENVIRONMENT__HYPOTHESIS:
				getHypothesis().clear();
				getHypothesis().addAll((Collection<? extends Hypothesis>)newValue);
				return;
			case ModelPackage.ENVIRONMENT__AGENT_PARAMS:
				getAgentParams().clear();
				getAgentParams().addAll((Collection<? extends AgentParam>)newValue);
				return;
			case ModelPackage.ENVIRONMENT__OBSERVER_PARAMS:
				getObserverParams().clear();
				getObserverParams().addAll((Collection<? extends ObserverParam>)newValue);
				return;
			case ModelPackage.ENVIRONMENT__AGENT_REFERENCES:
				getAgentReferences().clear();
				getAgentReferences().addAll((Collection<? extends AgentReference>)newValue);
				return;
			case ModelPackage.ENVIRONMENT__OBSERVER_REFERENCES:
				getObserverReferences().clear();
				getObserverReferences().addAll((Collection<? extends ObserverReference>)newValue);
				return;
			case ModelPackage.ENVIRONMENT__GENERAL_TYPE_REFERENCES:
				getGeneralTypeReferences().clear();
				getGeneralTypeReferences().addAll((Collection<? extends GeneralTypeReference>)newValue);
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
			case ModelPackage.ENVIRONMENT__TYPES:
				getTypes().clear();
				return;
			case ModelPackage.ENVIRONMENT__INSTANCES:
				getInstances().clear();
				return;
			case ModelPackage.ENVIRONMENT__PARAMETERS:
				getParameters().clear();
				return;
			case ModelPackage.ENVIRONMENT__CONTEXT_RELATIONS:
				getContextRelations().clear();
				return;
			case ModelPackage.ENVIRONMENT__EVENTS:
				getEvents().clear();
				return;
			case ModelPackage.ENVIRONMENT__BEHAV_DESCRIPTIONS:
				getBehavDescriptions().clear();
				return;
			case ModelPackage.ENVIRONMENT__HOLDS_ATS:
				getHoldsAts().clear();
				return;
			case ModelPackage.ENVIRONMENT__HAPPENS:
				getHappens().clear();
				return;
			case ModelPackage.ENVIRONMENT__HOLDS_AT_BETWEENS:
				getHoldsAtBetweens().clear();
				return;
			case ModelPackage.ENVIRONMENT__INITIALS:
				getInitials().clear();
				return;
			case ModelPackage.ENVIRONMENT__GENERAL_PARAMS:
				getGeneralParams().clear();
				return;
			case ModelPackage.ENVIRONMENT__PRIMITIVE_EVENTS:
				getPrimitiveEvents().clear();
				return;
			case ModelPackage.ENVIRONMENT__COMPLEX_EVENTS:
				getComplexEvents().clear();
				return;
			case ModelPackage.ENVIRONMENT__HYPOTHESIS:
				getHypothesis().clear();
				return;
			case ModelPackage.ENVIRONMENT__AGENT_PARAMS:
				getAgentParams().clear();
				return;
			case ModelPackage.ENVIRONMENT__OBSERVER_PARAMS:
				getObserverParams().clear();
				return;
			case ModelPackage.ENVIRONMENT__AGENT_REFERENCES:
				getAgentReferences().clear();
				return;
			case ModelPackage.ENVIRONMENT__OBSERVER_REFERENCES:
				getObserverReferences().clear();
				return;
			case ModelPackage.ENVIRONMENT__GENERAL_TYPE_REFERENCES:
				getGeneralTypeReferences().clear();
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
			case ModelPackage.ENVIRONMENT__TYPES:
				return types != null && !types.isEmpty();
			case ModelPackage.ENVIRONMENT__INSTANCES:
				return instances != null && !instances.isEmpty();
			case ModelPackage.ENVIRONMENT__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case ModelPackage.ENVIRONMENT__CONTEXT_RELATIONS:
				return contextRelations != null && !contextRelations.isEmpty();
			case ModelPackage.ENVIRONMENT__EVENTS:
				return events != null && !events.isEmpty();
			case ModelPackage.ENVIRONMENT__BEHAV_DESCRIPTIONS:
				return behavDescriptions != null && !behavDescriptions.isEmpty();
			case ModelPackage.ENVIRONMENT__HOLDS_ATS:
				return holdsAts != null && !holdsAts.isEmpty();
			case ModelPackage.ENVIRONMENT__HAPPENS:
				return happens != null && !happens.isEmpty();
			case ModelPackage.ENVIRONMENT__HOLDS_AT_BETWEENS:
				return holdsAtBetweens != null && !holdsAtBetweens.isEmpty();
			case ModelPackage.ENVIRONMENT__INITIALS:
				return initials != null && !initials.isEmpty();
			case ModelPackage.ENVIRONMENT__GENERAL_PARAMS:
				return generalParams != null && !generalParams.isEmpty();
			case ModelPackage.ENVIRONMENT__PRIMITIVE_EVENTS:
				return primitiveEvents != null && !primitiveEvents.isEmpty();
			case ModelPackage.ENVIRONMENT__COMPLEX_EVENTS:
				return complexEvents != null && !complexEvents.isEmpty();
			case ModelPackage.ENVIRONMENT__HYPOTHESIS:
				return hypothesis != null && !hypothesis.isEmpty();
			case ModelPackage.ENVIRONMENT__AGENT_PARAMS:
				return agentParams != null && !agentParams.isEmpty();
			case ModelPackage.ENVIRONMENT__OBSERVER_PARAMS:
				return observerParams != null && !observerParams.isEmpty();
			case ModelPackage.ENVIRONMENT__AGENT_REFERENCES:
				return agentReferences != null && !agentReferences.isEmpty();
			case ModelPackage.ENVIRONMENT__OBSERVER_REFERENCES:
				return observerReferences != null && !observerReferences.isEmpty();
			case ModelPackage.ENVIRONMENT__GENERAL_TYPE_REFERENCES:
				return generalTypeReferences != null && !generalTypeReferences.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	
	public void setTypes(EList<Type> types) {
		this.types = types;
	}

	public void setInstances(EList<Instance> instances) {
		this.instances = instances;
	}

	public void setParameters(EList<Parameter> parameters) {
		this.parameters = parameters;
	}

	public void setContextRelations(EList<ContextRelation> contextRelations) {
		this.contextRelations = contextRelations;
	}

	public void setEvents(EList<Event> events) {
		this.events = events;
	}

	public void setBehavDescriptions(EList<BehaviouralDescription> behavDescriptions) {
		this.behavDescriptions = behavDescriptions;
	}

	public void setHoldsAts(EList<HoldsAt> holdsAts) {
		this.holdsAts = holdsAts;
	}

	public void setHappens(EList<Happens> happens) {
		this.happens = happens;
	}

	public void setHoldsAtBetweens(EList<HoldsAtBetween> holdsAtBetweens) {
		this.holdsAtBetweens = holdsAtBetweens;
	}

	public void setInitials(EList<Initially> initials) {
		this.initials = initials;
	}
	
	public void setHypothesis(EList<Hypothesis> hypothesis) {
		this.hypothesis = hypothesis;
	}
	

} //EnvironmentImpl
