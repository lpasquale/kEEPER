/**
 */
package model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Holds At</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link model.HoldsAt#getTime <em>Time</em>}</li>
 *   <li>{@link model.HoldsAt#isIsHolding <em>Is Holding</em>}</li>
 *   <li>{@link model.HoldsAt#getContextRelation <em>Context Relation</em>}</li>
 * </ul>
 *
 * @see model.ModelPackage#getHoldsAt()
 * @model
 * @generated
 */
public interface HoldsAt extends EObject {
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
	 * @see model.ModelPackage#getHoldsAt_Time()
	 * @model
	 * @generated
	 */
	int getTime();

	/**
	 * Sets the value of the '{@link model.HoldsAt#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(int value);

	/**
	 * Returns the value of the '<em><b>Is Holding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Holding</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Holding</em>' attribute.
	 * @see #setIsHolding(boolean)
	 * @see model.ModelPackage#getHoldsAt_IsHolding()
	 * @model
	 * @generated
	 */
	boolean isIsHolding();

	/**
	 * Sets the value of the '{@link model.HoldsAt#isIsHolding <em>Is Holding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Holding</em>' attribute.
	 * @see #isIsHolding()
	 * @generated
	 */
	void setIsHolding(boolean value);

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
	 * @see model.ModelPackage#getHoldsAt_ContextRelation()
	 * @model required="true"
	 * @generated
	 */
	ContextRelation getContextRelation();

	/**
	 * Sets the value of the '{@link model.HoldsAt#getContextRelation <em>Context Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Relation</em>' reference.
	 * @see #getContextRelation()
	 * @generated
	 */
	void setContextRelation(ContextRelation value);

} // HoldsAt
