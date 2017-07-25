/**
 */
package model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Initially</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link model.Initially#getContextRelation <em>Context Relation</em>}</li>
 *   <li>{@link model.Initially#getInstances <em>Instances</em>}</li>
 * </ul>
 *
 * @see model.ModelPackage#getInitially()
 * @model
 * @generated
 */
public interface Initially extends EObject {
	/**
	 * Returns the value of the '<em><b>Context Relation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Relation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Relation</em>' containment reference.
	 * @see #setContextRelation(ContextRelation)
	 * @see model.ModelPackage#getInitially_ContextRelation()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ContextRelation getContextRelation();

	/**
	 * Sets the value of the '{@link model.Initially#getContextRelation <em>Context Relation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Relation</em>' containment reference.
	 * @see #getContextRelation()
	 * @generated
	 */
	void setContextRelation(ContextRelation value);

	/**
	 * Returns the value of the '<em><b>Instances</b></em>' containment reference list.
	 * The list contents are of type {@link model.Instance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instances</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instances</em>' containment reference list.
	 * @see model.ModelPackage#getInitially_Instances()
	 * @model containment="true"
	 * @generated
	 */
	EList<Instance> getInstances();

} // Initially
