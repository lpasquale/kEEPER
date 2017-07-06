/**
 */
package model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Agent Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link model.AgentParam#getAgent <em>Agent</em>}</li>
 * </ul>
 *
 * @see model.ModelPackage#getAgentParam()
 * @model
 * @generated
 */
public interface AgentParam extends Parameter {

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
	 * @see model.ModelPackage#getAgentParam_Agent()
	 * @model
	 * @generated
	 */
	Agent getAgent();

	/**
	 * Sets the value of the '{@link model.AgentParam#getAgent <em>Agent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Agent</em>' reference.
	 * @see #getAgent()
	 * @generated
	 */
	void setAgent(Agent value);
} // AgentParam
