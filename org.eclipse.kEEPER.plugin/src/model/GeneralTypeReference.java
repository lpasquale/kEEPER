/**
 */
package model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>General Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link model.GeneralTypeReference#getReference <em>Reference</em>}</li>
 * </ul>
 *
 * @see model.ModelPackage#getGeneralTypeReference()
 * @model
 * @generated
 */
public interface GeneralTypeReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' reference.
	 * @see #setReference(Type)
	 * @see model.ModelPackage#getGeneralTypeReference_Reference()
	 * @model
	 * @generated
	 */
	Type getReference();

	/**
	 * Sets the value of the '{@link model.GeneralTypeReference#getReference <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' reference.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(Type value);

} // GeneralTypeReference
