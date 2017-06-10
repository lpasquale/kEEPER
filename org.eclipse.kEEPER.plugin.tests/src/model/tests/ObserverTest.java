/**
 */
package model.tests;

import junit.textui.TestRunner;

import model.ModelFactory;
import model.Observer;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Observer</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ObserverTest extends ParameterTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ObserverTest.class);
	}

	/**
	 * Constructs a new Observer test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObserverTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Observer test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Observer getFixture() {
		return (Observer)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ModelFactory.eINSTANCE.createObserver());
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

} //ObserverTest
