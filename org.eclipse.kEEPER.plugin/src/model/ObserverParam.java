/**
 */
package model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Observer Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link model.ObserverParam#getObserver <em>Observer</em>}</li>
 * </ul>
 *
 * @see model.ModelPackage#getObserverParam()
 * @model
 * @generated
 */
public interface ObserverParam extends Parameter {

	/**
	 * Returns the value of the '<em><b>Observer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Observer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Observer</em>' reference.
	 * @see #setObserver(Observer)
	 * @see model.ModelPackage#getObserverParam_Observer()
	 * @model
	 * @generated
	 */
	Observer getObserver();

	/**
	 * Sets the value of the '{@link model.ObserverParam#getObserver <em>Observer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Observer</em>' reference.
	 * @see #getObserver()
	 * @generated
	 */
	void setObserver(Observer value);
} // ObserverParam
