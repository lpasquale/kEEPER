/**
 */
package model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Holds At Between</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link model.HoldsAtBetween#getInitialTime <em>Initial Time</em>}</li>
 *   <li>{@link model.HoldsAtBetween#getEndingTime <em>Ending Time</em>}</li>
 *   <li>{@link model.HoldsAtBetween#isIsHolding <em>Is Holding</em>}</li>
 *   <li>{@link model.HoldsAtBetween#getContextRelation <em>Context Relation</em>}</li>
 * </ul>
 *
 * @see model.ModelPackage#getHoldsAtBetween()
 * @model
 * @generated
 */
public interface HoldsAtBetween extends EObject {
	/**
	 * Returns the value of the '<em><b>Initial Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Time</em>' attribute.
	 * @see #setInitialTime(int)
	 * @see model.ModelPackage#getHoldsAtBetween_InitialTime()
	 * @model
	 * @generated
	 */
	int getInitialTime();

	/**
	 * Sets the value of the '{@link model.HoldsAtBetween#getInitialTime <em>Initial Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Time</em>' attribute.
	 * @see #getInitialTime()
	 * @generated
	 */
	void setInitialTime(int value);

	/**
	 * Returns the value of the '<em><b>Ending Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ending Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ending Time</em>' attribute.
	 * @see #setEndingTime(int)
	 * @see model.ModelPackage#getHoldsAtBetween_EndingTime()
	 * @model
	 * @generated
	 */
	int getEndingTime();

	/**
	 * Sets the value of the '{@link model.HoldsAtBetween#getEndingTime <em>Ending Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ending Time</em>' attribute.
	 * @see #getEndingTime()
	 * @generated
	 */
	void setEndingTime(int value);

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
	 * @see model.ModelPackage#getHoldsAtBetween_IsHolding()
	 * @model
	 * @generated
	 */
	boolean isIsHolding();

	/**
	 * Sets the value of the '{@link model.HoldsAtBetween#isIsHolding <em>Is Holding</em>}' attribute.
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
	 * @see model.ModelPackage#getHoldsAtBetween_ContextRelation()
	 * @model required="true"
	 * @generated
	 */
	ContextRelation getContextRelation();

	/**
	 * Sets the value of the '{@link model.HoldsAtBetween#getContextRelation <em>Context Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Relation</em>' reference.
	 * @see #getContextRelation()
	 * @generated
	 */
	void setContextRelation(ContextRelation value);

} // HoldsAtBetween
