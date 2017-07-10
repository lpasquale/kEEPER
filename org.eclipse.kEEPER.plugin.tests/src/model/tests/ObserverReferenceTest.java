/**
 */
package model.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import model.ModelFactory;
import model.ObserverReference;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Observer Reference</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ObserverReferenceTest extends TestCase {

	/**
	 * The fixture for this Observer Reference test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObserverReference fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ObserverReferenceTest.class);
	}

	/**
	 * Constructs a new Observer Reference test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObserverReferenceTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Observer Reference test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ObserverReference fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Observer Reference test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObserverReference getFixture() {
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
		setFixture(ModelFactory.eINSTANCE.createObserverReference());
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

} //ObserverReferenceTest
