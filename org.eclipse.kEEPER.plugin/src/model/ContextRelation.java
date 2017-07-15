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
 *   <li>{@link model.ContextRelation#isValue <em>Value</em>}</li>
 *   <li>{@link model.ContextRelation#getTypes <em>Types</em>}</li>
 *   <li>{@link model.ContextRelation#getTypeNames <em>Type Names</em>}</li>
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
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(boolean)
	 * @see model.ModelPackage#getContextRelation_Value()
	 * @model
	 * @generated
	 */
	boolean isValue();

	/**
	 * Sets the value of the '{@link model.ContextRelation#isValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #isValue()
	 * @generated
	 */
	void setValue(boolean value);

	/**
	 * Returns the value of the '<em><b>Types</b></em>' reference list.
	 * The list contents are of type {@link model.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' reference list.
	 * @see model.ModelPackage#getContextRelation_Types()
	 * @model
	 * @generated
	 */
	EList<Type> getTypes();

	/**
	 * Returns the value of the '<em><b>Type Names</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Names</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Names</em>' attribute.
	 * @see #setTypeNames(String)
	 * @see model.ModelPackage#getContextRelation_TypeNames()
	 * @model derived="true"
	 * @generated
	 */
	String getTypeNames();

	/**
	 * Sets the value of the '{@link model.ContextRelation#getTypeNames <em>Type Names</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Names</em>' attribute.
	 * @see #getTypeNames()
	 * @generated
	 */
	void setTypeNames();

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
