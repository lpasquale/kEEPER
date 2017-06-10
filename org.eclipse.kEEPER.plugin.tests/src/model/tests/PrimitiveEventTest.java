/**
 */
package model.tests;

import junit.textui.TestRunner;

import model.ModelFactory;
import model.PrimitiveEvent;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Primitive Event</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PrimitiveEventTest extends EventTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PrimitiveEventTest.class);
	}

	/**
	 * Constructs a new Primitive Event test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveEventTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Primitive Event test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected PrimitiveEvent getFixture() {
		return (PrimitiveEvent)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ModelFactory.eINSTANCE.createPrimitiveEvent());
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

} //PrimitiveEventTest
