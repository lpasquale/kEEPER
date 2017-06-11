/**
 */
package model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hypothesis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link model.Hypothesis#getHoldsAts <em>Holds Ats</em>}</li>
 *   <li>{@link model.Hypothesis#getHappens <em>Happens</em>}</li>
 *   <li>{@link model.Hypothesis#getHoldsAtBetweens <em>Holds At Betweens</em>}</li>
 *   <li>{@link model.Hypothesis#getName <em>Name</em>}</li>
 *   <li>{@link model.Hypothesis#getTimeInstants <em>Time Instants</em>}</li>
 * </ul>
 *
 * @see model.ModelPackage#getHypothesis()
 * @model
 * @generated
 */
public interface Hypothesis extends EObject {
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
	 * @see model.ModelPackage#getHypothesis_HoldsAts()
	 * @model
	 * @generated
	 */
	EList<HoldsAt> getHoldsAts();

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
	 * @see model.ModelPackage#getHypothesis_Happens()
	 * @model
	 * @generated
	 */
	EList<Happens> getHappens();

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
	 * @see model.ModelPackage#getHypothesis_HoldsAtBetweens()
	 * @model
	 * @generated
	 */
	EList<HoldsAtBetween> getHoldsAtBetweens();

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
	 * @see model.ModelPackage#getHypothesis_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link model.Hypothesis#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Time Instants</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Instants</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Instants</em>' attribute.
	 * @see #setTimeInstants(int)
	 * @see model.ModelPackage#getHypothesis_TimeInstants()
	 * @model
	 * @generated
	 */
	int getTimeInstants();

	/**
	 * Sets the value of the '{@link model.Hypothesis#getTimeInstants <em>Time Instants</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Instants</em>' attribute.
	 * @see #getTimeInstants()
	 * @generated
	 */
	void setTimeInstants(int value);

} // Hypothesis
