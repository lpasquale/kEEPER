/**
 */
package model;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link model.ComplexEvent#getBehaviouralDescriptions <em>Behavioural Descriptions</em>}</li>
 *   <li>{@link model.ComplexEvent#getAgent <em>Agent</em>}</li>
 * </ul>
 *
 * @see model.ModelPackage#getComplexEvent()
 * @model
 * @generated
 */
public interface ComplexEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Behavioural Descriptions</b></em>' reference list.
	 * The list contents are of type {@link model.BehaviouralDescription}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavioural Descriptions</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavioural Descriptions</em>' reference list.
	 * @see model.ModelPackage#getComplexEvent_BehaviouralDescriptions()
	 * @model
	 * @generated
	 */
	EList<BehaviouralDescription> getBehaviouralDescriptions();

	/**
	 * Returns the value of the '<em><b>Agent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Agent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Agent</em>' reference.
	 * @see #setAgent(Agent)
	 * @see model.ModelPackage#getComplexEvent_Agent()
	 * @model
	 * @generated
	 */
	Agent getAgent();

	void setAgent(Agent target);

} // ComplexEvent
