/**
 */
package model.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import model.HoldsAtBetween;
import model.ModelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Holds At Between</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class HoldsAtBetweenTest extends TestCase {

	/**
	 * The fixture for this Holds At Between test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HoldsAtBetween fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(HoldsAtBetweenTest.class);
	}

	/**
	 * Constructs a new Holds At Between test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HoldsAtBetweenTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Holds At Between test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(HoldsAtBetween fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Holds At Between test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HoldsAtBetween getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ModelFactory.eINSTANCE.createHoldsAtBetween());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //HoldsAtBetweenTest
