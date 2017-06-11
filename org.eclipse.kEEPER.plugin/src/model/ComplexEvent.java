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
 *   <li>{@link model.ComplexEvent#getTime <em>Time</em>}</li>
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
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(int)
	 * @see model.ModelPackage#getComplexEvent_Time()
	 * @model required="true"
	 * @generated
	 */
	int getTime();

	/**
	 * Sets the value of the '{@link model.ComplexEvent#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(int value);

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

	void setAgent(Agent target);

} // ComplexEvent
