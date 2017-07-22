/**
 */
package model.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.BehaviouralDescription;
import model.Happens;
import model.HoldsAt;
import model.HoldsAtBetween;
import model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavioural Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link model.impl.BehaviouralDescriptionImpl#getHoldsAts <em>Holds Ats</em>}</li>
 *   <li>{@link model.impl.BehaviouralDescriptionImpl#getHappens <em>Happens</em>}</li>
 *   <li>{@link model.impl.BehaviouralDescriptionImpl#getHoldsAtBetweens <em>Holds At Betweens</em>}</li>
 *   <li>{@link model.impl.BehaviouralDescriptionImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.impl.BehaviouralDescriptionImpl#getTimeInstants <em>Time Instants</em>}</li>
 *   <li>{@link model.impl.BehaviouralDescriptionImpl#getSecondTimeInstant <em>Second Time Instant</em>}</li>
 *   <li>{@link model.impl.BehaviouralDescriptionImpl#getFirstTimeInstant <em>First Time Instant</em>}</li>
 *   <li>{@link model.impl.BehaviouralDescriptionImpl#isAny <em>Any</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BehaviouralDescriptionImpl extends MinimalEObjectImpl.Container implements BehaviouralDescription {
	/**
	 * The cached value of the '{@link #getHoldsAts() <em>Holds Ats</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHoldsAts()
	 * @generated
	 * @ordered
	 */
	protected EList<HoldsAt> holdsAts;

	/**
	 * The cached value of the '{@link #getHappens() <em>Happens</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHappens()
	 * @generated
	 * @ordered
	 */
	protected EList<Happens> happens;

	/**
	 * The cached value of the '{@link #getHoldsAtBetweens() <em>Holds At Betweens</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHoldsAtBetweens()
	 * @generated
	 * @ordered
	 */
	protected EList<HoldsAtBetween> holdsAtBetweens;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeInstants() <em>Time Instants</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeInstants()
	 * @generated
	 * @ordered
	 */
	protected static final int TIME_INSTANTS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTimeInstants() <em>Time Instants</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeInstants()
	 * @generated
	 * @ordered
	 */
	protected int timeInstants = TIME_INSTANTS_EDEFAULT;

	
    /**
	 * The default value of the '{@link #getSecondTimeInstant() <em>Second Time Instant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondTimeInstant()
	 * @generated
	 * @ordered
	 */
	protected static final int SECOND_TIME_INSTANT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSecondTimeInstant() <em>Second Time Instant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondTimeInstant()
	 * @generated
	 * @ordered
	 */
	protected int secondTimeInstant = SECOND_TIME_INSTANT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFirstTimeInstant() <em>First Time Instant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstTimeInstant()
	 * @generated
	 * @ordered
	 */
	protected static final int FIRST_TIME_INSTANT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFirstTimeInstant() <em>First Time Instant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstTimeInstant()
	 * @generated
	 * @ordered
	 */
	protected int firstTimeInstant = FIRST_TIME_INSTANT_EDEFAULT;

	/**
	 * The default value of the '{@link #isAny() <em>Any</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAny()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ANY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAny() <em>Any</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAny()
	 * @generated
	 * @ordered
	 */
	protected boolean any = ANY_EDEFAULT;

				protected Map<String, Integer> m = new HashMap<String, Integer>();

	//private ModelDiagramEditor editor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviouralDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.BEHAVIOURAL_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HoldsAt> getHoldsAts() {
		if (holdsAts == null) {
			holdsAts = new EObjectResolvingEList<HoldsAt>(HoldsAt.class, this, ModelPackage.BEHAVIOURAL_DESCRIPTION__HOLDS_ATS);
		}
		return holdsAts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Happens> getHappens() {
		if (happens == null) {
			happens = new EObjectResolvingEList<Happens>(Happens.class, this, ModelPackage.BEHAVIOURAL_DESCRIPTION__HAPPENS);
		}
		return happens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HoldsAtBetween> getHoldsAtBetweens() {
		if (holdsAtBetweens == null) {
			holdsAtBetweens = new EObjectResolvingEList<HoldsAtBetween>(HoldsAtBetween.class, this, ModelPackage.BEHAVIOURAL_DESCRIPTION__HOLDS_AT_BETWEENS);
		}
		return holdsAtBetweens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BEHAVIOURAL_DESCRIPTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTimeInstants() {
		return timeInstants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeInstants(int newTimeInstants) {
		int oldTimeInstants = timeInstants;
		timeInstants = newTimeInstants;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BEHAVIOURAL_DESCRIPTION__TIME_INSTANTS, oldTimeInstants, timeInstants));
	}

	
/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSecondTimeInstant() {
		return secondTimeInstant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondTimeInstant(int newSecondTimeInstant) {
		int oldSecondTimeInstant = secondTimeInstant;
		secondTimeInstant = newSecondTimeInstant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BEHAVIOURAL_DESCRIPTION__SECOND_TIME_INSTANT, oldSecondTimeInstant, secondTimeInstant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFirstTimeInstant() {
		return firstTimeInstant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstTimeInstant(int newFirstTimeInstant) {
		int oldFirstTimeInstant = firstTimeInstant;
		firstTimeInstant = newFirstTimeInstant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BEHAVIOURAL_DESCRIPTION__FIRST_TIME_INSTANT, oldFirstTimeInstant, firstTimeInstant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAny() {
		return any;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAny(boolean newAny) {
		boolean oldAny = any;
		any = newAny;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BEHAVIOURAL_DESCRIPTION__ANY, oldAny, any));
	}

	/*	public ModelDiagramEditor getEditor(){
		return editor;
	}

	public void setEditor(ModelDiagramEditor editor){
		this.editor = editor;
	}
	*/
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__HOLDS_ATS:
				return getHoldsAts();
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__HAPPENS:
				return getHappens();
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__HOLDS_AT_BETWEENS:
				return getHoldsAtBetweens();
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__NAME:
				return getName();
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__TIME_INSTANTS:
				return getTimeInstants();
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__SECOND_TIME_INSTANT:
				return getSecondTimeInstant();
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__FIRST_TIME_INSTANT:
				return getFirstTimeInstant();
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__ANY:
				return isAny();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__HOLDS_ATS:
				getHoldsAts().clear();
				getHoldsAts().addAll((Collection<? extends HoldsAt>)newValue);
				return;
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__HAPPENS:
				getHappens().clear();
				getHappens().addAll((Collection<? extends Happens>)newValue);
				return;
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__HOLDS_AT_BETWEENS:
				getHoldsAtBetweens().clear();
				getHoldsAtBetweens().addAll((Collection<? extends HoldsAtBetween>)newValue);
				return;
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__TIME_INSTANTS:
				setTimeInstants((Integer)newValue);
				return;
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__SECOND_TIME_INSTANT:
				setSecondTimeInstant((Integer)newValue);
				return;
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__FIRST_TIME_INSTANT:
				setFirstTimeInstant((Integer)newValue);
				return;
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__ANY:
				setAny((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__HOLDS_ATS:
				getHoldsAts().clear();
				return;
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__HAPPENS:
				getHappens().clear();
				return;
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__HOLDS_AT_BETWEENS:
				getHoldsAtBetweens().clear();
				return;
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__TIME_INSTANTS:
				setTimeInstants(TIME_INSTANTS_EDEFAULT);
				return;
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__SECOND_TIME_INSTANT:
				setSecondTimeInstant(SECOND_TIME_INSTANT_EDEFAULT);
				return;
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__FIRST_TIME_INSTANT:
				setFirstTimeInstant(FIRST_TIME_INSTANT_EDEFAULT);
				return;
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__ANY:
				setAny(ANY_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__HOLDS_ATS:
				return holdsAts != null && !holdsAts.isEmpty();
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__HAPPENS:
				return happens != null && !happens.isEmpty();
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__HOLDS_AT_BETWEENS:
				return holdsAtBetweens != null && !holdsAtBetweens.isEmpty();
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__TIME_INSTANTS:
				return timeInstants != TIME_INSTANTS_EDEFAULT;
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__SECOND_TIME_INSTANT:
				return secondTimeInstant != SECOND_TIME_INSTANT_EDEFAULT;
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__FIRST_TIME_INSTANT:
				return firstTimeInstant != FIRST_TIME_INSTANT_EDEFAULT;
			case ModelPackage.BEHAVIOURAL_DESCRIPTION__ANY:
				return any != ANY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", timeInstants: ");
		result.append(timeInstants);
		result.append(", secondTimeInstant: ");
		result.append(secondTimeInstant);
		result.append(", firstTimeInstant: ");
		result.append(firstTimeInstant);
		result.append(", any: ");
		result.append(any);
		result.append(')');
		return result.toString();
	}

} //BehaviouralDescriptionImpl
