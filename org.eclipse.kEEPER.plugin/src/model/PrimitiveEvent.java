/**
 */
package model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link model.PrimitiveEvent#getAgent <em>Agent</em>}</li>
 *   <li>{@link model.PrimitiveEvent#getObserver <em>Observer</em>}</li>
 * </ul>
 *
 * @see model.ModelPackage#getPrimitiveEvent()
 * @model
 * @generated
 */
public interface PrimitiveEvent extends Event {
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
	 * @see model.ModelPackage#getPrimitiveEvent_Agent()
	 * @model
	 * @generated
	 */
	Agent getAgent();

	/**
	 * Sets the value of the '{@link model.PrimitiveEvent#getAgent <em>Agent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Agent</em>' reference.
	 * @see #getAgent()
	 * @generated
	 */
	void setAgent(Agent value);

	/**
	 * Returns the value of the '<em><b>Observer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Observer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Observer</em>' reference.
	 * @see #setObserver(Observer)
	 * @see model.ModelPackage#getPrimitiveEvent_Observer()
	 * @model
	 * @generated
	 */
	Observer getObserver();

	/**
	 * Sets the value of the '{@link model.PrimitiveEvent#getObserver <em>Observer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Observer</em>' reference.
	 * @see #getObserver()
	 * @generated
	 */
	void setObserver(Observer value);

} // PrimitiveEvent
