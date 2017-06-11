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
 *   <li>{@link model.Initially#getHoldsAts <em>Holds Ats</em>}</li>
 *   <li>{@link model.Initially#getHoldsAtBetweens <em>Holds At Betweens</em>}</li>
 *   <li>{@link model.Initially#getHappens <em>Happens</em>}</li>
 *   <li>{@link model.Initially#getContextRelation <em>Context Relation</em>}</li>
 * </ul>
 *
 * @see model.ModelPackage#getInitially()
 * @model
 * @generated
 */
public interface Initially extends EObject {
	/**
	 * Returns the value of the '<em><b>Holds Ats</b></em>' reference list.
	 * The list contents are of type {@link model.HoldsAt}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Holds Ats</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Holds Ats</em>' reference list.
	 * @see model.ModelPackage#getInitially_HoldsAts()
	 * @model
	 * @generated
	 */
	EList<HoldsAt> getHoldsAts();

	/**
	 * Returns the value of the '<em><b>Holds At Betweens</b></em>' reference list.
	 * The list contents are of type {@link model.HoldsAtBetween}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Holds At Betweens</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Holds At Betweens</em>' reference list.
	 * @see model.ModelPackage#getInitially_HoldsAtBetweens()
	 * @model
	 * @generated
	 */
	EList<HoldsAtBetween> getHoldsAtBetweens();

	/**
	 * Returns the value of the '<em><b>Happens</b></em>' reference list.
	 * The list contents are of type {@link model.Happens}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Happens</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Happens</em>' reference list.
	 * @see model.ModelPackage#getInitially_Happens()
	 * @model
	 * @generated
	 */
	EList<Happens> getHappens();

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

} // Initially
