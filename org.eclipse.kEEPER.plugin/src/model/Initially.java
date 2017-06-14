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
	 * Returns the value of the '<em><b>Context Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Relation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Relation</em>' reference.
	 * @see #setContextRelation(ContextRelation)
	 * @see model.ModelPackage#getInitially_ContextRelation()
	 * @model required="true"
	 * @generated
	 */
	ContextRelation getContextRelation();

	/**
	 * Sets the value of the '{@link model.Initially#getContextRelation <em>Context Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Relation</em>' reference.
	 * @see #getContextRelation()
	 * @generated
	 */
	void setContextRelation(ContextRelation value);

	/**
	 * Returns the value of the '<em><b>Instances</b></em>' reference list.
	 * The list contents are of type {@link model.Instance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instances</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instances</em>' reference list.
	 * @see model.ModelPackage#getInitially_Instances()
	 * @model
	 * @generated
	 */
	EList<Instance> getInstances();

} // Initially
