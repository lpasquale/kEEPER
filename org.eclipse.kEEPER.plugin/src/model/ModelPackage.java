/**
 */
package model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://github.com/mlatona/minorityReportPlugin";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.minorityReportPlugin";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link model.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.TypeImpl
	 * @see model.impl.ModelPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link model.impl.InstanceImpl <em>Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.InstanceImpl
	 * @see model.impl.ModelPackageImpl#getInstance()
	 * @generated
	 */
	int INSTANCE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link model.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.ParameterImpl
	 * @see model.impl.ModelPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 2;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NUMBER = 0;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__INSTANCE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = 3;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link model.impl.ContextRelationImpl <em>Context Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.ContextRelationImpl
	 * @see model.impl.ModelPackageImpl#getContextRelation()
	 * @generated
	 */
	int CONTEXT_RELATION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_RELATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_RELATION__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_RELATION__PARAMETERS = 2;

	/**
	 * The feature id for the '<em><b>Initial Complex Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_RELATION__INITIAL_COMPLEX_EVENT = 3;

	/**
	 * The feature id for the '<em><b>Ending Complex Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_RELATION__ENDING_COMPLEX_EVENT = 4;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_RELATION__TIME = 5;

	/**
	 * The number of structural features of the '<em>Context Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_RELATION_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Context Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_RELATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link model.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.EventImpl
	 * @see model.impl.ModelPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__PARAMETERS = 1;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link model.impl.PrimitiveEventImpl <em>Primitive Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.PrimitiveEventImpl
	 * @see model.impl.ModelPackageImpl#getPrimitiveEvent()
	 * @generated
	 */
	int PRIMITIVE_EVENT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_EVENT__NAME = EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_EVENT__PARAMETERS = EVENT__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Agent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_EVENT__AGENT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Observer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_EVENT__OBSERVER = EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Primitive Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Primitive Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_EVENT_OPERATION_COUNT = EVENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link model.impl.ComplexEventImpl <em>Complex Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.ComplexEventImpl
	 * @see model.impl.ModelPackageImpl#getComplexEvent()
	 * @generated
	 */
	int COMPLEX_EVENT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT__NAME = EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT__PARAMETERS = EVENT__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT__TIME = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Behavioural Descriptions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT__BEHAVIOURAL_DESCRIPTIONS = EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Agent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT__AGENT = EVENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Complex Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Complex Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT_OPERATION_COUNT = EVENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link model.impl.BehaviouralDescriptionImpl <em>Behavioural Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.BehaviouralDescriptionImpl
	 * @see model.impl.ModelPackageImpl#getBehaviouralDescription()
	 * @generated
	 */
	int BEHAVIOURAL_DESCRIPTION = 7;

	/**
	 * The feature id for the '<em><b>Holds Ats</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOURAL_DESCRIPTION__HOLDS_ATS = 0;

	/**
	 * The feature id for the '<em><b>Happens</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOURAL_DESCRIPTION__HAPPENS = 1;

	/**
	 * The feature id for the '<em><b>Holds At Betweens</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOURAL_DESCRIPTION__HOLDS_AT_BETWEENS = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOURAL_DESCRIPTION__NAME = 3;

	/**
	 * The feature id for the '<em><b>Time Instants</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOURAL_DESCRIPTION__TIME_INSTANTS = 4;

	/**
	 * The number of structural features of the '<em>Behavioural Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOURAL_DESCRIPTION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Behavioural Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOURAL_DESCRIPTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link model.impl.HoldsAtImpl <em>Holds At</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.HoldsAtImpl
	 * @see model.impl.ModelPackageImpl#getHoldsAt()
	 * @generated
	 */
	int HOLDS_AT = 8;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOLDS_AT__TIME = 0;

	/**
	 * The feature id for the '<em><b>Is Holding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOLDS_AT__IS_HOLDING = 1;

	/**
	 * The feature id for the '<em><b>Context Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOLDS_AT__CONTEXT_RELATION = 2;

	/**
	 * The number of structural features of the '<em>Holds At</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOLDS_AT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Holds At</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOLDS_AT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link model.impl.HappensImpl <em>Happens</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.HappensImpl
	 * @see model.impl.ModelPackageImpl#getHappens()
	 * @generated
	 */
	int HAPPENS = 9;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAPPENS__TIME = 0;

	/**
	 * The feature id for the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAPPENS__EVENT = 1;

	/**
	 * The number of structural features of the '<em>Happens</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAPPENS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Happens</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAPPENS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link model.impl.HoldsAtBetweenImpl <em>Holds At Between</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.HoldsAtBetweenImpl
	 * @see model.impl.ModelPackageImpl#getHoldsAtBetween()
	 * @generated
	 */
	int HOLDS_AT_BETWEEN = 10;

	/**
	 * The feature id for the '<em><b>Initial Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOLDS_AT_BETWEEN__INITIAL_TIME = 0;

	/**
	 * The feature id for the '<em><b>Ending Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOLDS_AT_BETWEEN__ENDING_TIME = 1;

	/**
	 * The feature id for the '<em><b>Is Holding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOLDS_AT_BETWEEN__IS_HOLDING = 2;

	/**
	 * The feature id for the '<em><b>Context Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOLDS_AT_BETWEEN__CONTEXT_RELATION = 3;

	/**
	 * The number of structural features of the '<em>Holds At Between</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOLDS_AT_BETWEEN_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Holds At Between</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOLDS_AT_BETWEEN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link model.impl.InitiallyImpl <em>Initially</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.InitiallyImpl
	 * @see model.impl.ModelPackageImpl#getInitially()
	 * @generated
	 */
	int INITIALLY = 11;

	/**
	 * The feature id for the '<em><b>Holds Ats</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALLY__HOLDS_ATS = 0;

	/**
	 * The feature id for the '<em><b>Holds At Betweens</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALLY__HOLDS_AT_BETWEENS = 1;

	/**
	 * The feature id for the '<em><b>Happens</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALLY__HAPPENS = 2;

	/**
	 * The feature id for the '<em><b>Context Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALLY__CONTEXT_RELATION = 3;

	/**
	 * The number of structural features of the '<em>Initially</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALLY_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Initially</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALLY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link model.impl.EnvironmentImpl <em>Environment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.EnvironmentImpl
	 * @see model.impl.ModelPackageImpl#getEnvironment()
	 * @generated
	 */
	int ENVIRONMENT = 12;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__TYPES = 0;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__INSTANCES = 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__PARAMETERS = 2;

	/**
	 * The feature id for the '<em><b>Context Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__CONTEXT_RELATIONS = 3;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__EVENTS = 4;

	/**
	 * The feature id for the '<em><b>Behav Descriptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__BEHAV_DESCRIPTIONS = 5;

	/**
	 * The feature id for the '<em><b>Holds Ats</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__HOLDS_ATS = 6;

	/**
	 * The feature id for the '<em><b>Happens</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__HAPPENS = 7;

	/**
	 * The feature id for the '<em><b>Holds At Betweens</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__HOLDS_AT_BETWEENS = 8;

	/**
	 * The feature id for the '<em><b>Initials</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__INITIALS = 9;

	/**
	 * The feature id for the '<em><b>Agents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__AGENTS = 10;

	/**
	 * The feature id for the '<em><b>Observers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__OBSERVERS = 11;

	/**
	 * The feature id for the '<em><b>Add Param</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__ADD_PARAM = 12;

	/**
	 * The feature id for the '<em><b>Primitive Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__PRIMITIVE_EVENTS = 13;

	/**
	 * The feature id for the '<em><b>Complex Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__COMPLEX_EVENTS = 14;

	/**
	 * The feature id for the '<em><b>Hypothesis</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__HYPOTHESIS = 15;

	/**
	 * The number of structural features of the '<em>Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_FEATURE_COUNT = 16;

	/**
	 * The number of operations of the '<em>Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link model.impl.ObserverImpl <em>Observer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.ObserverImpl
	 * @see model.impl.ModelPackageImpl#getObserver()
	 * @generated
	 */
	int OBSERVER = 13;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVER__NUMBER = PARAMETER__NUMBER;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVER__INSTANCE = PARAMETER__INSTANCE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVER__TYPE = PARAMETER__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVER__NAME = PARAMETER__NAME;

	/**
	 * The number of structural features of the '<em>Observer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Observer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVER_OPERATION_COUNT = PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link model.impl.AgentImpl <em>Agent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.AgentImpl
	 * @see model.impl.ModelPackageImpl#getAgent()
	 * @generated
	 */
	int AGENT = 14;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__NUMBER = PARAMETER__NUMBER;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__INSTANCE = PARAMETER__INSTANCE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__TYPE = PARAMETER__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__NAME = PARAMETER__NAME;

	/**
	 * The number of structural features of the '<em>Agent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Agent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_OPERATION_COUNT = PARAMETER_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link model.impl.HypothesisImpl <em>Hypothesis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.HypothesisImpl
	 * @see model.impl.ModelPackageImpl#getHypothesis()
	 * @generated
	 */
	int HYPOTHESIS = 15;

	/**
	 * The feature id for the '<em><b>Holds Ats</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPOTHESIS__HOLDS_ATS = 0;

	/**
	 * The feature id for the '<em><b>Happens</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPOTHESIS__HAPPENS = 1;

	/**
	 * The feature id for the '<em><b>Holds At Betweens</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPOTHESIS__HOLDS_AT_BETWEENS = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPOTHESIS__NAME = 3;

	/**
	 * The feature id for the '<em><b>Time Instants</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPOTHESIS__TIME_INSTANTS = 4;

	/**
	 * The number of structural features of the '<em>Hypothesis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPOTHESIS_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Hypothesis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPOTHESIS_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link model.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see model.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for the attribute '{@link model.Type#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see model.Type#getName()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_Name();

	/**
	 * Returns the meta object for class '{@link model.Instance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance</em>'.
	 * @see model.Instance
	 * @generated
	 */
	EClass getInstance();

	/**
	 * Returns the meta object for the attribute '{@link model.Instance#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see model.Instance#getName()
	 * @see #getInstance()
	 * @generated
	 */
	EAttribute getInstance_Name();

	/**
	 * Returns the meta object for the reference '{@link model.Instance#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see model.Instance#getType()
	 * @see #getInstance()
	 * @generated
	 */
	EReference getInstance_Type();

	/**
	 * Returns the meta object for class '{@link model.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see model.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link model.Parameter#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see model.Parameter#getNumber()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Number();

	/**
	 * Returns the meta object for the reference '{@link model.Parameter#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instance</em>'.
	 * @see model.Parameter#getInstance()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Instance();

	/**
	 * Returns the meta object for the reference '{@link model.Parameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see model.Parameter#getType()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Type();

	/**
	 * Returns the meta object for the attribute '{@link model.Parameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see model.Parameter#getName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Name();

	/**
	 * Returns the meta object for class '{@link model.ContextRelation <em>Context Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context Relation</em>'.
	 * @see model.ContextRelation
	 * @generated
	 */
	EClass getContextRelation();

	/**
	 * Returns the meta object for the attribute '{@link model.ContextRelation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see model.ContextRelation#getName()
	 * @see #getContextRelation()
	 * @generated
	 */
	EAttribute getContextRelation_Name();

	/**
	 * Returns the meta object for the attribute '{@link model.ContextRelation#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see model.ContextRelation#isValue()
	 * @see #getContextRelation()
	 * @generated
	 */
	EAttribute getContextRelation_Value();

	/**
	 * Returns the meta object for the reference list '{@link model.ContextRelation#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameters</em>'.
	 * @see model.ContextRelation#getParameters()
	 * @see #getContextRelation()
	 * @generated
	 */
	EReference getContextRelation_Parameters();

	/**
	 * Returns the meta object for the reference '{@link model.ContextRelation#getInitialComplexEvent <em>Initial Complex Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial Complex Event</em>'.
	 * @see model.ContextRelation#getInitialComplexEvent()
	 * @see #getContextRelation()
	 * @generated
	 */
	EReference getContextRelation_InitialComplexEvent();

	/**
	 * Returns the meta object for the reference '{@link model.ContextRelation#getEndingComplexEvent <em>Ending Complex Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ending Complex Event</em>'.
	 * @see model.ContextRelation#getEndingComplexEvent()
	 * @see #getContextRelation()
	 * @generated
	 */
	EReference getContextRelation_EndingComplexEvent();

	/**
	 * Returns the meta object for the attribute '{@link model.ContextRelation#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see model.ContextRelation#getTime()
	 * @see #getContextRelation()
	 * @generated
	 */
	EAttribute getContextRelation_Time();

	/**
	 * Returns the meta object for class '{@link model.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see model.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the attribute '{@link model.Event#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see model.Event#getName()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Name();

	/**
	 * Returns the meta object for the reference list '{@link model.Event#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameters</em>'.
	 * @see model.Event#getParameters()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Parameters();

	/**
	 * Returns the meta object for class '{@link model.PrimitiveEvent <em>Primitive Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Event</em>'.
	 * @see model.PrimitiveEvent
	 * @generated
	 */
	EClass getPrimitiveEvent();

	/**
	 * Returns the meta object for the reference '{@link model.PrimitiveEvent#getAgent <em>Agent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Agent</em>'.
	 * @see model.PrimitiveEvent#getAgent()
	 * @see #getPrimitiveEvent()
	 * @generated
	 */
	EReference getPrimitiveEvent_Agent();

	/**
	 * Returns the meta object for the reference '{@link model.PrimitiveEvent#getObserver <em>Observer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Observer</em>'.
	 * @see model.PrimitiveEvent#getObserver()
	 * @see #getPrimitiveEvent()
	 * @generated
	 */
	EReference getPrimitiveEvent_Observer();

	/**
	 * Returns the meta object for class '{@link model.ComplexEvent <em>Complex Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Event</em>'.
	 * @see model.ComplexEvent
	 * @generated
	 */
	EClass getComplexEvent();

	/**
	 * Returns the meta object for the attribute '{@link model.ComplexEvent#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see model.ComplexEvent#getTime()
	 * @see #getComplexEvent()
	 * @generated
	 */
	EAttribute getComplexEvent_Time();

	/**
	 * Returns the meta object for the reference list '{@link model.ComplexEvent#getBehaviouralDescriptions <em>Behavioural Descriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Behavioural Descriptions</em>'.
	 * @see model.ComplexEvent#getBehaviouralDescriptions()
	 * @see #getComplexEvent()
	 * @generated
	 */
	EReference getComplexEvent_BehaviouralDescriptions();

	/**
	 * Returns the meta object for the reference '{@link model.ComplexEvent#getAgent <em>Agent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Agent</em>'.
	 * @see model.ComplexEvent#getAgent()
	 * @see #getComplexEvent()
	 * @generated
	 */
	EReference getComplexEvent_Agent();

	/**
	 * Returns the meta object for class '{@link model.BehaviouralDescription <em>Behavioural Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavioural Description</em>'.
	 * @see model.BehaviouralDescription
	 * @generated
	 */
	EClass getBehaviouralDescription();

	/**
	 * Returns the meta object for the reference list '{@link model.BehaviouralDescription#getHoldsAts <em>Holds Ats</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Holds Ats</em>'.
	 * @see model.BehaviouralDescription#getHoldsAts()
	 * @see #getBehaviouralDescription()
	 * @generated
	 */
	EReference getBehaviouralDescription_HoldsAts();

	/**
	 * Returns the meta object for the reference list '{@link model.BehaviouralDescription#getHappens <em>Happens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Happens</em>'.
	 * @see model.BehaviouralDescription#getHappens()
	 * @see #getBehaviouralDescription()
	 * @generated
	 */
	EReference getBehaviouralDescription_Happens();

	/**
	 * Returns the meta object for the reference list '{@link model.BehaviouralDescription#getHoldsAtBetweens <em>Holds At Betweens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Holds At Betweens</em>'.
	 * @see model.BehaviouralDescription#getHoldsAtBetweens()
	 * @see #getBehaviouralDescription()
	 * @generated
	 */
	EReference getBehaviouralDescription_HoldsAtBetweens();

	/**
	 * Returns the meta object for the attribute '{@link model.BehaviouralDescription#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see model.BehaviouralDescription#getName()
	 * @see #getBehaviouralDescription()
	 * @generated
	 */
	EAttribute getBehaviouralDescription_Name();

	/**
	 * Returns the meta object for the attribute '{@link model.BehaviouralDescription#getTimeInstants <em>Time Instants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Instants</em>'.
	 * @see model.BehaviouralDescription#getTimeInstants()
	 * @see #getBehaviouralDescription()
	 * @generated
	 */
	EAttribute getBehaviouralDescription_TimeInstants();

	/**
	 * Returns the meta object for class '{@link model.HoldsAt <em>Holds At</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Holds At</em>'.
	 * @see model.HoldsAt
	 * @generated
	 */
	EClass getHoldsAt();

	/**
	 * Returns the meta object for the attribute '{@link model.HoldsAt#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see model.HoldsAt#getTime()
	 * @see #getHoldsAt()
	 * @generated
	 */
	EAttribute getHoldsAt_Time();

	/**
	 * Returns the meta object for the attribute '{@link model.HoldsAt#isIsHolding <em>Is Holding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Holding</em>'.
	 * @see model.HoldsAt#isIsHolding()
	 * @see #getHoldsAt()
	 * @generated
	 */
	EAttribute getHoldsAt_IsHolding();

	/**
	 * Returns the meta object for the reference '{@link model.HoldsAt#getContextRelation <em>Context Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context Relation</em>'.
	 * @see model.HoldsAt#getContextRelation()
	 * @see #getHoldsAt()
	 * @generated
	 */
	EReference getHoldsAt_ContextRelation();

	/**
	 * Returns the meta object for class '{@link model.Happens <em>Happens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Happens</em>'.
	 * @see model.Happens
	 * @generated
	 */
	EClass getHappens();

	/**
	 * Returns the meta object for the attribute '{@link model.Happens#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see model.Happens#getTime()
	 * @see #getHappens()
	 * @generated
	 */
	EAttribute getHappens_Time();

	/**
	 * Returns the meta object for the reference '{@link model.Happens#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event</em>'.
	 * @see model.Happens#getEvent()
	 * @see #getHappens()
	 * @generated
	 */
	EReference getHappens_Event();

	/**
	 * Returns the meta object for class '{@link model.HoldsAtBetween <em>Holds At Between</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Holds At Between</em>'.
	 * @see model.HoldsAtBetween
	 * @generated
	 */
	EClass getHoldsAtBetween();

	/**
	 * Returns the meta object for the attribute '{@link model.HoldsAtBetween#getInitialTime <em>Initial Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Time</em>'.
	 * @see model.HoldsAtBetween#getInitialTime()
	 * @see #getHoldsAtBetween()
	 * @generated
	 */
	EAttribute getHoldsAtBetween_InitialTime();

	/**
	 * Returns the meta object for the attribute '{@link model.HoldsAtBetween#getEndingTime <em>Ending Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ending Time</em>'.
	 * @see model.HoldsAtBetween#getEndingTime()
	 * @see #getHoldsAtBetween()
	 * @generated
	 */
	EAttribute getHoldsAtBetween_EndingTime();

	/**
	 * Returns the meta object for the attribute '{@link model.HoldsAtBetween#isIsHolding <em>Is Holding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Holding</em>'.
	 * @see model.HoldsAtBetween#isIsHolding()
	 * @see #getHoldsAtBetween()
	 * @generated
	 */
	EAttribute getHoldsAtBetween_IsHolding();

	/**
	 * Returns the meta object for the reference '{@link model.HoldsAtBetween#getContextRelation <em>Context Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context Relation</em>'.
	 * @see model.HoldsAtBetween#getContextRelation()
	 * @see #getHoldsAtBetween()
	 * @generated
	 */
	EReference getHoldsAtBetween_ContextRelation();

	/**
	 * Returns the meta object for class '{@link model.Initially <em>Initially</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Initially</em>'.
	 * @see model.Initially
	 * @generated
	 */
	EClass getInitially();

	/**
	 * Returns the meta object for the reference list '{@link model.Initially#getHoldsAts <em>Holds Ats</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Holds Ats</em>'.
	 * @see model.Initially#getHoldsAts()
	 * @see #getInitially()
	 * @generated
	 */
	EReference getInitially_HoldsAts();

	/**
	 * Returns the meta object for the reference list '{@link model.Initially#getHoldsAtBetweens <em>Holds At Betweens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Holds At Betweens</em>'.
	 * @see model.Initially#getHoldsAtBetweens()
	 * @see #getInitially()
	 * @generated
	 */
	EReference getInitially_HoldsAtBetweens();

	/**
	 * Returns the meta object for the reference list '{@link model.Initially#getHappens <em>Happens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Happens</em>'.
	 * @see model.Initially#getHappens()
	 * @see #getInitially()
	 * @generated
	 */
	EReference getInitially_Happens();

	/**
	 * Returns the meta object for the reference '{@link model.Initially#getContextRelation <em>Context Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context Relation</em>'.
	 * @see model.Initially#getContextRelation()
	 * @see #getInitially()
	 * @generated
	 */
	EReference getInitially_ContextRelation();

	/**
	 * Returns the meta object for class '{@link model.Environment <em>Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Environment</em>'.
	 * @see model.Environment
	 * @generated
	 */
	EClass getEnvironment();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Environment#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see model.Environment#getTypes()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_Types();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Environment#getInstances <em>Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instances</em>'.
	 * @see model.Environment#getInstances()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_Instances();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Environment#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see model.Environment#getParameters()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Environment#getContextRelations <em>Context Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Context Relations</em>'.
	 * @see model.Environment#getContextRelations()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_ContextRelations();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Environment#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Events</em>'.
	 * @see model.Environment#getEvents()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_Events();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Environment#getBehavDescriptions <em>Behav Descriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Behav Descriptions</em>'.
	 * @see model.Environment#getBehavDescriptions()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_BehavDescriptions();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Environment#getHoldsAts <em>Holds Ats</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Holds Ats</em>'.
	 * @see model.Environment#getHoldsAts()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_HoldsAts();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Environment#getHappens <em>Happens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Happens</em>'.
	 * @see model.Environment#getHappens()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_Happens();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Environment#getHoldsAtBetweens <em>Holds At Betweens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Holds At Betweens</em>'.
	 * @see model.Environment#getHoldsAtBetweens()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_HoldsAtBetweens();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Environment#getInitials <em>Initials</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Initials</em>'.
	 * @see model.Environment#getInitials()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_Initials();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Environment#getAgents <em>Agents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Agents</em>'.
	 * @see model.Environment#getAgents()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_Agents();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Environment#getObservers <em>Observers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Observers</em>'.
	 * @see model.Environment#getObservers()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_Observers();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Environment#getAddParam <em>Add Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Add Param</em>'.
	 * @see model.Environment#getAddParam()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_AddParam();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Environment#getPrimitiveEvents <em>Primitive Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Primitive Events</em>'.
	 * @see model.Environment#getPrimitiveEvents()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_PrimitiveEvents();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Environment#getComplexEvents <em>Complex Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Complex Events</em>'.
	 * @see model.Environment#getComplexEvents()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_ComplexEvents();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Environment#getHypothesis <em>Hypothesis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Hypothesis</em>'.
	 * @see model.Environment#getHypothesis()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_Hypothesis();

	/**
	 * Returns the meta object for class '{@link model.Observer <em>Observer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Observer</em>'.
	 * @see model.Observer
	 * @generated
	 */
	EClass getObserver();

	/**
	 * Returns the meta object for class '{@link model.Agent <em>Agent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Agent</em>'.
	 * @see model.Agent
	 * @generated
	 */
	EClass getAgent();

	/**
	 * Returns the meta object for class '{@link model.Hypothesis <em>Hypothesis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hypothesis</em>'.
	 * @see model.Hypothesis
	 * @generated
	 */
	EClass getHypothesis();

	/**
	 * Returns the meta object for the reference list '{@link model.Hypothesis#getHoldsAts <em>Holds Ats</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Holds Ats</em>'.
	 * @see model.Hypothesis#getHoldsAts()
	 * @see #getHypothesis()
	 * @generated
	 */
	EReference getHypothesis_HoldsAts();

	/**
	 * Returns the meta object for the reference list '{@link model.Hypothesis#getHappens <em>Happens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Happens</em>'.
	 * @see model.Hypothesis#getHappens()
	 * @see #getHypothesis()
	 * @generated
	 */
	EReference getHypothesis_Happens();

	/**
	 * Returns the meta object for the reference list '{@link model.Hypothesis#getHoldsAtBetweens <em>Holds At Betweens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Holds At Betweens</em>'.
	 * @see model.Hypothesis#getHoldsAtBetweens()
	 * @see #getHypothesis()
	 * @generated
	 */
	EReference getHypothesis_HoldsAtBetweens();

	/**
	 * Returns the meta object for the attribute '{@link model.Hypothesis#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see model.Hypothesis#getName()
	 * @see #getHypothesis()
	 * @generated
	 */
	EAttribute getHypothesis_Name();

	/**
	 * Returns the meta object for the attribute '{@link model.Hypothesis#getTimeInstants <em>Time Instants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Instants</em>'.
	 * @see model.Hypothesis#getTimeInstants()
	 * @see #getHypothesis()
	 * @generated
	 */
	EAttribute getHypothesis_TimeInstants();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link model.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.TypeImpl
		 * @see model.impl.ModelPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE__NAME = eINSTANCE.getType_Name();

		/**
		 * The meta object literal for the '{@link model.impl.InstanceImpl <em>Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.InstanceImpl
		 * @see model.impl.ModelPackageImpl#getInstance()
		 * @generated
		 */
		EClass INSTANCE = eINSTANCE.getInstance();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE__NAME = eINSTANCE.getInstance_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE__TYPE = eINSTANCE.getInstance_Type();

		/**
		 * The meta object literal for the '{@link model.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.ParameterImpl
		 * @see model.impl.ModelPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__NUMBER = eINSTANCE.getParameter_Number();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__INSTANCE = eINSTANCE.getParameter_Instance();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__TYPE = eINSTANCE.getParameter_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

		/**
		 * The meta object literal for the '{@link model.impl.ContextRelationImpl <em>Context Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.ContextRelationImpl
		 * @see model.impl.ModelPackageImpl#getContextRelation()
		 * @generated
		 */
		EClass CONTEXT_RELATION = eINSTANCE.getContextRelation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTEXT_RELATION__NAME = eINSTANCE.getContextRelation_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTEXT_RELATION__VALUE = eINSTANCE.getContextRelation_Value();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT_RELATION__PARAMETERS = eINSTANCE.getContextRelation_Parameters();

		/**
		 * The meta object literal for the '<em><b>Initial Complex Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT_RELATION__INITIAL_COMPLEX_EVENT = eINSTANCE.getContextRelation_InitialComplexEvent();

		/**
		 * The meta object literal for the '<em><b>Ending Complex Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT_RELATION__ENDING_COMPLEX_EVENT = eINSTANCE.getContextRelation_EndingComplexEvent();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTEXT_RELATION__TIME = eINSTANCE.getContextRelation_Time();

		/**
		 * The meta object literal for the '{@link model.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.EventImpl
		 * @see model.impl.ModelPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__NAME = eINSTANCE.getEvent_Name();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__PARAMETERS = eINSTANCE.getEvent_Parameters();

		/**
		 * The meta object literal for the '{@link model.impl.PrimitiveEventImpl <em>Primitive Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.PrimitiveEventImpl
		 * @see model.impl.ModelPackageImpl#getPrimitiveEvent()
		 * @generated
		 */
		EClass PRIMITIVE_EVENT = eINSTANCE.getPrimitiveEvent();

		/**
		 * The meta object literal for the '<em><b>Agent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_EVENT__AGENT = eINSTANCE.getPrimitiveEvent_Agent();

		/**
		 * The meta object literal for the '<em><b>Observer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_EVENT__OBSERVER = eINSTANCE.getPrimitiveEvent_Observer();

		/**
		 * The meta object literal for the '{@link model.impl.ComplexEventImpl <em>Complex Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.ComplexEventImpl
		 * @see model.impl.ModelPackageImpl#getComplexEvent()
		 * @generated
		 */
		EClass COMPLEX_EVENT = eINSTANCE.getComplexEvent();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPLEX_EVENT__TIME = eINSTANCE.getComplexEvent_Time();

		/**
		 * The meta object literal for the '<em><b>Behavioural Descriptions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_EVENT__BEHAVIOURAL_DESCRIPTIONS = eINSTANCE.getComplexEvent_BehaviouralDescriptions();

		/**
		 * The meta object literal for the '<em><b>Agent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_EVENT__AGENT = eINSTANCE.getComplexEvent_Agent();

		/**
		 * The meta object literal for the '{@link model.impl.BehaviouralDescriptionImpl <em>Behavioural Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.BehaviouralDescriptionImpl
		 * @see model.impl.ModelPackageImpl#getBehaviouralDescription()
		 * @generated
		 */
		EClass BEHAVIOURAL_DESCRIPTION = eINSTANCE.getBehaviouralDescription();

		/**
		 * The meta object literal for the '<em><b>Holds Ats</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOURAL_DESCRIPTION__HOLDS_ATS = eINSTANCE.getBehaviouralDescription_HoldsAts();

		/**
		 * The meta object literal for the '<em><b>Happens</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOURAL_DESCRIPTION__HAPPENS = eINSTANCE.getBehaviouralDescription_Happens();

		/**
		 * The meta object literal for the '<em><b>Holds At Betweens</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOURAL_DESCRIPTION__HOLDS_AT_BETWEENS = eINSTANCE.getBehaviouralDescription_HoldsAtBetweens();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOURAL_DESCRIPTION__NAME = eINSTANCE.getBehaviouralDescription_Name();

		/**
		 * The meta object literal for the '<em><b>Time Instants</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOURAL_DESCRIPTION__TIME_INSTANTS = eINSTANCE.getBehaviouralDescription_TimeInstants();

		/**
		 * The meta object literal for the '{@link model.impl.HoldsAtImpl <em>Holds At</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.HoldsAtImpl
		 * @see model.impl.ModelPackageImpl#getHoldsAt()
		 * @generated
		 */
		EClass HOLDS_AT = eINSTANCE.getHoldsAt();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOLDS_AT__TIME = eINSTANCE.getHoldsAt_Time();

		/**
		 * The meta object literal for the '<em><b>Is Holding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOLDS_AT__IS_HOLDING = eINSTANCE.getHoldsAt_IsHolding();

		/**
		 * The meta object literal for the '<em><b>Context Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HOLDS_AT__CONTEXT_RELATION = eINSTANCE.getHoldsAt_ContextRelation();

		/**
		 * The meta object literal for the '{@link model.impl.HappensImpl <em>Happens</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.HappensImpl
		 * @see model.impl.ModelPackageImpl#getHappens()
		 * @generated
		 */
		EClass HAPPENS = eINSTANCE.getHappens();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HAPPENS__TIME = eINSTANCE.getHappens_Time();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HAPPENS__EVENT = eINSTANCE.getHappens_Event();

		/**
		 * The meta object literal for the '{@link model.impl.HoldsAtBetweenImpl <em>Holds At Between</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.HoldsAtBetweenImpl
		 * @see model.impl.ModelPackageImpl#getHoldsAtBetween()
		 * @generated
		 */
		EClass HOLDS_AT_BETWEEN = eINSTANCE.getHoldsAtBetween();

		/**
		 * The meta object literal for the '<em><b>Initial Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOLDS_AT_BETWEEN__INITIAL_TIME = eINSTANCE.getHoldsAtBetween_InitialTime();

		/**
		 * The meta object literal for the '<em><b>Ending Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOLDS_AT_BETWEEN__ENDING_TIME = eINSTANCE.getHoldsAtBetween_EndingTime();

		/**
		 * The meta object literal for the '<em><b>Is Holding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOLDS_AT_BETWEEN__IS_HOLDING = eINSTANCE.getHoldsAtBetween_IsHolding();

		/**
		 * The meta object literal for the '<em><b>Context Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HOLDS_AT_BETWEEN__CONTEXT_RELATION = eINSTANCE.getHoldsAtBetween_ContextRelation();

		/**
		 * The meta object literal for the '{@link model.impl.InitiallyImpl <em>Initially</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.InitiallyImpl
		 * @see model.impl.ModelPackageImpl#getInitially()
		 * @generated
		 */
		EClass INITIALLY = eINSTANCE.getInitially();

		/**
		 * The meta object literal for the '<em><b>Holds Ats</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INITIALLY__HOLDS_ATS = eINSTANCE.getInitially_HoldsAts();

		/**
		 * The meta object literal for the '<em><b>Holds At Betweens</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INITIALLY__HOLDS_AT_BETWEENS = eINSTANCE.getInitially_HoldsAtBetweens();

		/**
		 * The meta object literal for the '<em><b>Happens</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INITIALLY__HAPPENS = eINSTANCE.getInitially_Happens();

		/**
		 * The meta object literal for the '<em><b>Context Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INITIALLY__CONTEXT_RELATION = eINSTANCE.getInitially_ContextRelation();

		/**
		 * The meta object literal for the '{@link model.impl.EnvironmentImpl <em>Environment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.EnvironmentImpl
		 * @see model.impl.ModelPackageImpl#getEnvironment()
		 * @generated
		 */
		EClass ENVIRONMENT = eINSTANCE.getEnvironment();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__TYPES = eINSTANCE.getEnvironment_Types();

		/**
		 * The meta object literal for the '<em><b>Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__INSTANCES = eINSTANCE.getEnvironment_Instances();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__PARAMETERS = eINSTANCE.getEnvironment_Parameters();

		/**
		 * The meta object literal for the '<em><b>Context Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__CONTEXT_RELATIONS = eINSTANCE.getEnvironment_ContextRelations();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__EVENTS = eINSTANCE.getEnvironment_Events();

		/**
		 * The meta object literal for the '<em><b>Behav Descriptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__BEHAV_DESCRIPTIONS = eINSTANCE.getEnvironment_BehavDescriptions();

		/**
		 * The meta object literal for the '<em><b>Holds Ats</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__HOLDS_ATS = eINSTANCE.getEnvironment_HoldsAts();

		/**
		 * The meta object literal for the '<em><b>Happens</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__HAPPENS = eINSTANCE.getEnvironment_Happens();

		/**
		 * The meta object literal for the '<em><b>Holds At Betweens</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__HOLDS_AT_BETWEENS = eINSTANCE.getEnvironment_HoldsAtBetweens();

		/**
		 * The meta object literal for the '<em><b>Initials</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__INITIALS = eINSTANCE.getEnvironment_Initials();

		/**
		 * The meta object literal for the '<em><b>Agents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__AGENTS = eINSTANCE.getEnvironment_Agents();

		/**
		 * The meta object literal for the '<em><b>Observers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__OBSERVERS = eINSTANCE.getEnvironment_Observers();

		/**
		 * The meta object literal for the '<em><b>Add Param</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__ADD_PARAM = eINSTANCE.getEnvironment_AddParam();

		/**
		 * The meta object literal for the '<em><b>Primitive Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__PRIMITIVE_EVENTS = eINSTANCE.getEnvironment_PrimitiveEvents();

		/**
		 * The meta object literal for the '<em><b>Complex Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__COMPLEX_EVENTS = eINSTANCE.getEnvironment_ComplexEvents();

		/**
		 * The meta object literal for the '<em><b>Hypothesis</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__HYPOTHESIS = eINSTANCE.getEnvironment_Hypothesis();

		/**
		 * The meta object literal for the '{@link model.impl.ObserverImpl <em>Observer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.ObserverImpl
		 * @see model.impl.ModelPackageImpl#getObserver()
		 * @generated
		 */
		EClass OBSERVER = eINSTANCE.getObserver();

		/**
		 * The meta object literal for the '{@link model.impl.AgentImpl <em>Agent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.AgentImpl
		 * @see model.impl.ModelPackageImpl#getAgent()
		 * @generated
		 */
		EClass AGENT = eINSTANCE.getAgent();

		/**
		 * The meta object literal for the '{@link model.impl.HypothesisImpl <em>Hypothesis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.HypothesisImpl
		 * @see model.impl.ModelPackageImpl#getHypothesis()
		 * @generated
		 */
		EClass HYPOTHESIS = eINSTANCE.getHypothesis();

		/**
		 * The meta object literal for the '<em><b>Holds Ats</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HYPOTHESIS__HOLDS_ATS = eINSTANCE.getHypothesis_HoldsAts();

		/**
		 * The meta object literal for the '<em><b>Happens</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HYPOTHESIS__HAPPENS = eINSTANCE.getHypothesis_Happens();

		/**
		 * The meta object literal for the '<em><b>Holds At Betweens</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HYPOTHESIS__HOLDS_AT_BETWEENS = eINSTANCE.getHypothesis_HoldsAtBetweens();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HYPOTHESIS__NAME = eINSTANCE.getHypothesis_Name();

		/**
		 * The meta object literal for the '<em><b>Time Instants</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HYPOTHESIS__TIME_INSTANTS = eINSTANCE.getHypothesis_TimeInstants();

	}

} //ModelPackage
