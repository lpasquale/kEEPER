/**
 */
package model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>General Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link model.GeneralParam#getGeneralType <em>General Type</em>}</li>
 * </ul>
 *
 * @see model.ModelPackage#getGeneralParam()
 * @model
 * @generated
 */
public interface GeneralParam extends Parameter {

	/**
	 * Returns the value of the '<em><b>General Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>General Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>General Type</em>' reference.
	 * @see #setGeneralType(Type)
	 * @see model.ModelPackage#getGeneralParam_GeneralType()
	 * @model
	 * @generated
	 */
	Type getGeneralType();

	/**
	 * Sets the value of the '{@link model.GeneralParam#getGeneralType <em>General Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>General Type</em>' reference.
	 * @see #getGeneralType()
	 * @generated
	 */
	void setGeneralType(Type value);
} // GeneralParam
