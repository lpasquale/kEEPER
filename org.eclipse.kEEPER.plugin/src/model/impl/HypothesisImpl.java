/**
 */
package model.impl;

import java.util.Collection;

import model.Happens;
import model.HoldsAt;
import model.HoldsAtBetween;
import model.Hypothesis;
import model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hypothesis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link model.impl.HypothesisImpl#getHoldsAts <em>Holds Ats</em>}</li>
 *   <li>{@link model.impl.HypothesisImpl#getHappens <em>Happens</em>}</li>
 *   <li>{@link model.impl.HypothesisImpl#getHoldsAtBetweens <em>Holds At Betweens</em>}</li>
 *   <li>{@link model.impl.HypothesisImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.impl.HypothesisImpl#getTimeInstants <em>Time Instants</em>}</li>
 *   <li>{@link model.impl.HypothesisImpl#isAny <em>Any</em>}</li>
 *   <li>{@link model.impl.HypothesisImpl#getFirstTimeInstant <em>First Time Instant</em>}</li>
 *   <li>{@link model.impl.HypothesisImpl#getSecondTimeInstant <em>Second Time Instant</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HypothesisImpl extends MinimalEObjectImpl.Container implements Hypothesis {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HypothesisImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.HYPOTHESIS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HoldsAt> getHoldsAts() {
		if (holdsAts == null) {
			holdsAts = new EObjectResolvingEList<HoldsAt>(HoldsAt.class, this, ModelPackage.HYPOTHESIS__HOLDS_ATS);
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
			happens = new EObjectResolvingEList<Happens>(Happens.class, this, ModelPackage.HYPOTHESIS__HAPPENS);
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
			holdsAtBetweens = new EObjectResolvingEList<HoldsAtBetween>(HoldsAtBetween.class, this, ModelPackage.HYPOTHESIS__HOLDS_AT_BETWEENS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.HYPOTHESIS__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.HYPOTHESIS__TIME_INSTANTS, oldTimeInstants, timeInstants));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.HYPOTHESIS__ANY, oldAny, any));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.HYPOTHESIS__FIRST_TIME_INSTANT, oldFirstTimeInstant, firstTimeInstant));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.HYPOTHESIS__SECOND_TIME_INSTANT, oldSecondTimeInstant, secondTimeInstant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.HYPOTHESIS__HOLDS_ATS:
				return getHoldsAts();
			case ModelPackage.HYPOTHESIS__HAPPENS:
				return getHappens();
			case ModelPackage.HYPOTHESIS__HOLDS_AT_BETWEENS:
				return getHoldsAtBetweens();
			case ModelPackage.HYPOTHESIS__NAME:
				return getName();
			case ModelPackage.HYPOTHESIS__TIME_INSTANTS:
				return getTimeInstants();
			case ModelPackage.HYPOTHESIS__ANY:
				return isAny();
			case ModelPackage.HYPOTHESIS__FIRST_TIME_INSTANT:
				return getFirstTimeInstant();
			case ModelPackage.HYPOTHESIS__SECOND_TIME_INSTANT:
				return getSecondTimeInstant();
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
			case ModelPackage.HYPOTHESIS__HOLDS_ATS:
				getHoldsAts().clear();
				getHoldsAts().addAll((Collection<? extends HoldsAt>)newValue);
				return;
			case ModelPackage.HYPOTHESIS__HAPPENS:
				getHappens().clear();
				getHappens().addAll((Collection<? extends Happens>)newValue);
				return;
			case ModelPackage.HYPOTHESIS__HOLDS_AT_BETWEENS:
				getHoldsAtBetweens().clear();
				getHoldsAtBetweens().addAll((Collection<? extends HoldsAtBetween>)newValue);
				return;
			case ModelPackage.HYPOTHESIS__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.HYPOTHESIS__TIME_INSTANTS:
				setTimeInstants((Integer)newValue);
				return;
			case ModelPackage.HYPOTHESIS__ANY:
				setAny((Boolean)newValue);
				return;
			case ModelPackage.HYPOTHESIS__FIRST_TIME_INSTANT:
				setFirstTimeInstant((Integer)newValue);
				return;
			case ModelPackage.HYPOTHESIS__SECOND_TIME_INSTANT:
				setSecondTimeInstant((Integer)newValue);
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
			case ModelPackage.HYPOTHESIS__HOLDS_ATS:
				getHoldsAts().clear();
				return;
			case ModelPackage.HYPOTHESIS__HAPPENS:
				getHappens().clear();
				return;
			case ModelPackage.HYPOTHESIS__HOLDS_AT_BETWEENS:
				getHoldsAtBetweens().clear();
				return;
			case ModelPackage.HYPOTHESIS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.HYPOTHESIS__TIME_INSTANTS:
				setTimeInstants(TIME_INSTANTS_EDEFAULT);
				return;
			case ModelPackage.HYPOTHESIS__ANY:
				setAny(ANY_EDEFAULT);
				return;
			case ModelPackage.HYPOTHESIS__FIRST_TIME_INSTANT:
				setFirstTimeInstant(FIRST_TIME_INSTANT_EDEFAULT);
				return;
			case ModelPackage.HYPOTHESIS__SECOND_TIME_INSTANT:
				setSecondTimeInstant(SECOND_TIME_INSTANT_EDEFAULT);
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
			case ModelPackage.HYPOTHESIS__HOLDS_ATS:
				return holdsAts != null && !holdsAts.isEmpty();
			case ModelPackage.HYPOTHESIS__HAPPENS:
				return happens != null && !happens.isEmpty();
			case ModelPackage.HYPOTHESIS__HOLDS_AT_BETWEENS:
				return holdsAtBetweens != null && !holdsAtBetweens.isEmpty();
			case ModelPackage.HYPOTHESIS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.HYPOTHESIS__TIME_INSTANTS:
				return timeInstants != TIME_INSTANTS_EDEFAULT;
			case ModelPackage.HYPOTHESIS__ANY:
				return any != ANY_EDEFAULT;
			case ModelPackage.HYPOTHESIS__FIRST_TIME_INSTANT:
				return firstTimeInstant != FIRST_TIME_INSTANT_EDEFAULT;
			case ModelPackage.HYPOTHESIS__SECOND_TIME_INSTANT:
				return secondTimeInstant != SECOND_TIME_INSTANT_EDEFAULT;
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
		result.append(", any: ");
		result.append(any);
		result.append(", firstTimeInstant: ");
		result.append(firstTimeInstant);
		result.append(", secondTimeInstant: ");
		result.append(secondTimeInstant);
		result.append(')');
		return result.toString();
	}

} //HypothesisImpl
