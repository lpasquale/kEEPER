/**
 */
package model.tests;

import junit.textui.TestRunner;

import model.ModelFactory;
import model.ObserverParam;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Observer Param</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ObserverParamTest extends ParameterTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ObserverParamTest.class);
	}

	/**
	 * Constructs a new Observer Param test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObserverParamTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Observer Param test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ObserverParam getFixture() {
		return (ObserverParam)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ModelFactory.eINSTANCE.createObserverParam());
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

} //ObserverParamTest
