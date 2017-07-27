/**
 */
package model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link model.ContextRelation#getName <em>Name</em>}</li>
 *   <li>{@link model.ContextRelation#getInitialComplexEvent <em>Initial Complex Event</em>}</li>
 *   <li>{@link model.ContextRelation#getEndingComplexEvent <em>Ending Complex Event</em>}</li>
 *   <li>{@link model.ContextRelation#getTypes <em>Types</em>}</li>
 * </ul>
 *
 * @see model.ModelPackage#getContextRelation()
 * @model
 * @generated
 */
public interface ContextRelation extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see model.ModelPackage#getContextRelation_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link model.ContextRelation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link model.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @see model.ModelPackage#getContextRelation_Types()
	 * @model containment="true"
	 * @generated
	 */
	EList<Type> getTypes();

	/**
	 * Returns the value of the '<em><b>Initial Complex Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Complex Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Complex Event</em>' reference.
	 * @see #setInitialComplexEvent(ComplexEvent)
	 * @see model.ModelPackage#getContextRelation_InitialComplexEvent()
	 * @model
	 * @generated
	 */
	ComplexEvent getInitialComplexEvent();

	/**
	 * Sets the value of the '{@link model.ContextRelation#getInitialComplexEvent <em>Initial Complex Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Complex Event</em>' reference.
	 * @see #getInitialComplexEvent()
	 * @generated
	 */
	void setInitialComplexEvent(ComplexEvent value);

	/**
	 * Returns the value of the '<em><b>Ending Complex Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ending Complex Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ending Complex Event</em>' reference.
	 * @see #setEndingComplexEvent(ComplexEvent)
	 * @see model.ModelPackage#getContextRelation_EndingComplexEvent()
	 * @model
	 * @generated
	 */
	ComplexEvent getEndingComplexEvent();

	/**
	 * Sets the value of the '{@link model.ContextRelation#getEndingComplexEvent <em>Ending Complex Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ending Complex Event</em>' reference.
	 * @see #getEndingComplexEvent()
	 * @generated
	 */
	void setEndingComplexEvent(ComplexEvent value);

} // ContextRelation
