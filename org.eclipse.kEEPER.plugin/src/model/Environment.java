/**
 */
package model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link model.Environment#getTypes <em>Types</em>}</li>
 *   <li>{@link model.Environment#getInstances <em>Instances</em>}</li>
 *   <li>{@link model.Environment#getParameters <em>Parameters</em>}</li>
 *   <li>{@link model.Environment#getContextRelations <em>Context Relations</em>}</li>
 *   <li>{@link model.Environment#getEvents <em>Events</em>}</li>
 *   <li>{@link model.Environment#getBehavDescriptions <em>Behav Descriptions</em>}</li>
 *   <li>{@link model.Environment#getHoldsAts <em>Holds Ats</em>}</li>
 *   <li>{@link model.Environment#getHappens <em>Happens</em>}</li>
 *   <li>{@link model.Environment#getHoldsAtBetweens <em>Holds At Betweens</em>}</li>
 *   <li>{@link model.Environment#getInitials <em>Initials</em>}</li>
 *   <li>{@link model.Environment#getGeneralParams <em>General Params</em>}</li>
 *   <li>{@link model.Environment#getPrimitiveEvents <em>Primitive Events</em>}</li>
 *   <li>{@link model.Environment#getComplexEvents <em>Complex Events</em>}</li>
 *   <li>{@link model.Environment#getHypothesis <em>Hypothesis</em>}</li>
 *   <li>{@link model.Environment#getAgentParams <em>Agent Params</em>}</li>
 *   <li>{@link model.Environment#getObserverParams <em>Observer Params</em>}</li>
 *   <li>{@link model.Environment#getAgentReferences <em>Agent References</em>}</li>
 *   <li>{@link model.Environment#getObserverReferences <em>Observer References</em>}</li>
 *   <li>{@link model.Environment#getGeneralTypeReferences <em>General Type References</em>}</li>
 * </ul>
 *
 * @see model.ModelPackage#getEnvironment()
 * @model
 * @generated
 */
public interface Environment extends EObject {
	/**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link model.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @see model.ModelPackage#getEnvironment_Types()
	 * @model containment="true"
	 * @generated
	 */
	EList<Type> getTypes();

	/**
	 * Returns the value of the '<em><b>Instances</b></em>' containment reference list.
	 * The list contents are of type {@link model.Instance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instances</em>' containment reference list.
	 * @see model.ModelPackage#getEnvironment_Instances()
	 * @model containment="true"
	 * @generated
	 */
	EList<Instance> getInstances();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link model.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see model.ModelPackage#getEnvironment_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Context Relations</b></em>' containment reference list.
	 * The list contents are of type {@link model.ContextRelation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Relations</em>' containment reference list.
	 * @see model.ModelPackage#getEnvironment_ContextRelations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ContextRelation> getContextRelations();

	/**
	 * Returns the value of the '<em><b>Events</b></em>' containment reference list.
	 * The list contents are of type {@link model.Event}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Events</em>' containment reference list.
	 * @see model.ModelPackage#getEnvironment_Events()
	 * @model containment="true"
	 * @generated
	 */
	EList<Event> getEvents();

	/**
	 * Returns the value of the '<em><b>Behav Descriptions</b></em>' containment reference list.
	 * The list contents are of type {@link model.BehaviouralDescription}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behav Descriptions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behav Descriptions</em>' containment reference list.
	 * @see model.ModelPackage#getEnvironment_BehavDescriptions()
	 * @model containment="true"
	 * @generated
	 */
	EList<BehaviouralDescription> getBehavDescriptions();

	/**
	 * Returns the value of the '<em><b>Holds Ats</b></em>' containment reference list.
	 * The list contents are of type {@link model.HoldsAt}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Holds Ats</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Holds Ats</em>' containment reference list.
	 * @see model.ModelPackage#getEnvironment_HoldsAts()
	 * @model containment="true"
	 * @generated
	 */
	EList<HoldsAt> getHoldsAts();

	/**
	 * Returns the value of the '<em><b>Happens</b></em>' containment reference list.
	 * The list contents are of type {@link model.Happens}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Happens</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Happens</em>' containment reference list.
	 * @see model.ModelPackage#getEnvironment_Happens()
	 * @model containment="true"
	 * @generated
	 */
	EList<Happens> getHappens();

	/**
	 * Returns the value of the '<em><b>Holds At Betweens</b></em>' containment reference list.
	 * The list contents are of type {@link model.HoldsAtBetween}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Holds At Betweens</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Holds At Betweens</em>' containment reference list.
	 * @see model.ModelPackage#getEnvironment_HoldsAtBetweens()
	 * @model containment="true"
	 * @generated
	 */
	EList<HoldsAtBetween> getHoldsAtBetweens();

	/**
	 * Returns the value of the '<em><b>Initials</b></em>' containment reference list.
	 * The list contents are of type {@link model.Initially}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initials</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initials</em>' containment reference list.
	 * @see model.ModelPackage#getEnvironment_Initials()
	 * @model containment="true"
	 * @generated
	 */
	EList<Initially> getInitials();
	
	/**
	 * Returns the value of the '<em><b>General Params</b></em>' containment reference list.
	 * The list contents are of type {@link model.GeneralParam}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>General Params</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>General Params</em>' containment reference list.
	 * @see model.ModelPackage#getEnvironment_GeneralParams()
	 * @model containment="true"
	 * @generated
	 */
	EList<GeneralParam> getGeneralParams();

	/**
	 * Returns the value of the '<em><b>Primitive Events</b></em>' containment reference list.
	 * The list contents are of type {@link model.PrimitiveEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitive Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive Events</em>' containment reference list.
	 * @see model.ModelPackage#getEnvironment_PrimitiveEvents()
	 * @model containment="true"
	 * @generated
	 */
	EList<PrimitiveEvent> getPrimitiveEvents();

	/**
	 * Returns the value of the '<em><b>Complex Events</b></em>' containment reference list.
	 * The list contents are of type {@link model.ComplexEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Complex Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complex Events</em>' containment reference list.
	 * @see model.ModelPackage#getEnvironment_ComplexEvents()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComplexEvent> getComplexEvents();

	/**
	 * Returns the value of the '<em><b>Hypothesis</b></em>' containment reference list.
	 * The list contents are of type {@link model.Hypothesis}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hypothesis</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hypothesis</em>' containment reference list.
	 * @see model.ModelPackage#getEnvironment_Hypothesis()
	 * @model containment="true"
	 * @generated
	 */
	EList<Hypothesis> getHypothesis();

	/**
	 * Returns the value of the '<em><b>Agent Params</b></em>' containment reference list.
	 * The list contents are of type {@link model.AgentParam}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Agent Params</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Agent Params</em>' containment reference list.
	 * @see model.ModelPackage#getEnvironment_AgentParams()
	 * @model containment="true"
	 * @generated
	 */
	EList<AgentParam> getAgentParams();

	/**
	 * Returns the value of the '<em><b>Observer Params</b></em>' containment reference list.
	 * The list contents are of type {@link model.ObserverParam}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Observer Params</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Observer Params</em>' containment reference list.
	 * @see model.ModelPackage#getEnvironment_ObserverParams()
	 * @model containment="true"
	 * @generated
	 */
	EList<ObserverParam> getObserverParams();

	/**
	 * Returns the value of the '<em><b>Agent References</b></em>' containment reference list.
	 * The list contents are of type {@link model.AgentReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Agent References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Agent References</em>' containment reference list.
	 * @see model.ModelPackage#getEnvironment_AgentReferences()
	 * @model containment="true"
	 * @generated
	 */
	EList<AgentReference> getAgentReferences();

	/**
	 * Returns the value of the '<em><b>Observer References</b></em>' containment reference list.
	 * The list contents are of type {@link model.ObserverReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Observer References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Observer References</em>' containment reference list.
	 * @see model.ModelPackage#getEnvironment_ObserverReferences()
	 * @model containment="true"
	 * @generated
	 */
	EList<ObserverReference> getObserverReferences();

	/**
	 * Returns the value of the '<em><b>General Type References</b></em>' containment reference list.
	 * The list contents are of type {@link model.GeneralTypeReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>General Type References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>General Type References</em>' containment reference list.
	 * @see model.ModelPackage#getEnvironment_GeneralTypeReferences()
	 * @model containment="true"
	 * @generated
	 */
	EList<GeneralTypeReference> getGeneralTypeReferences();

	void setTypes(EList<Type> types);
	
	void setInstances(EList<Instance> instances);
	
	void setContextRelations(EList<ContextRelation> contextRelations);
	
	void setEvents(EList<Event> events);
	
	void setBehavDescriptions(EList<BehaviouralDescription> behavDescriptions);
	
	void setInitials(EList<Initially> initials);

	void setHypothesis(EList<Hypothesis> hypothesis);

} // Environment
