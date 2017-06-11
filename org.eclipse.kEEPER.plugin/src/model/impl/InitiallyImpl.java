/**
 */
package model.impl;

import java.util.Collection;

import model.ContextRelation;
import model.Happens;
import model.HoldsAt;
import model.HoldsAtBetween;
import model.Initially;
import model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Initially</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link model.impl.InitiallyImpl#getHoldsAts <em>Holds Ats</em>}</li>
 *   <li>{@link model.impl.InitiallyImpl#getHoldsAtBetweens <em>Holds At Betweens</em>}</li>
 *   <li>{@link model.impl.InitiallyImpl#getHappens <em>Happens</em>}</li>
 *   <li>{@link model.impl.InitiallyImpl#getContextRelation <em>Context Relation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InitiallyImpl extends MinimalEObjectImpl.Container implements Initially {
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
	 * The cached value of the '{@link #getHoldsAtBetweens() <em>Holds At Betweens</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHoldsAtBetweens()
	 * @generated
	 * @ordered
	 */
	protected EList<HoldsAtBetween> holdsAtBetweens;

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
	 * The cached value of the '{@link #getContextRelation() <em>Context Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextRelation()
	 * @generated
	 * @ordered
	 */
	protected ContextRelation contextRelation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InitiallyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.INITIALLY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HoldsAt> getHoldsAts() {
		if (holdsAts == null) {
			holdsAts = new EObjectResolvingEList<HoldsAt>(HoldsAt.class, this, ModelPackage.INITIALLY__HOLDS_ATS);
		}
		return holdsAts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HoldsAtBetween> getHoldsAtBetweens() {
		if (holdsAtBetweens == null) {
			holdsAtBetweens = new EObjectResolvingEList<HoldsAtBetween>(HoldsAtBetween.class, this, ModelPackage.INITIALLY__HOLDS_AT_BETWEENS);
		}
		return holdsAtBetweens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Happens> getHappens() {
		if (happens == null) {
			happens = new EObjectResolvingEList<Happens>(Happens.class, this, ModelPackage.INITIALLY__HAPPENS);
		}
		return happens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextRelation getContextRelation() {
		if (contextRelation != null && contextRelation.eIsProxy()) {
			InternalEObject oldContextRelation = (InternalEObject)contextRelation;
			contextRelation = (ContextRelation)eResolveProxy(oldContextRelation);
			if (contextRelation != oldContextRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.INITIALLY__CONTEXT_RELATION, oldContextRelation, contextRelation));
			}
		}
		return contextRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextRelation basicGetContextRelation() {
		return contextRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextRelation(ContextRelation newContextRelation) {
		ContextRelation oldContextRelation = contextRelation;
		contextRelation = newContextRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.INITIALLY__CONTEXT_RELATION, oldContextRelation, contextRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.INITIALLY__HOLDS_ATS:
				return getHoldsAts();
			case ModelPackage.INITIALLY__HOLDS_AT_BETWEENS:
				return getHoldsAtBetweens();
			case ModelPackage.INITIALLY__HAPPENS:
				return getHappens();
			case ModelPackage.INITIALLY__CONTEXT_RELATION:
				if (resolve) return getContextRelation();
				return basicGetContextRelation();
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
			case ModelPackage.INITIALLY__HOLDS_ATS:
				getHoldsAts().clear();
				getHoldsAts().addAll((Collection<? extends HoldsAt>)newValue);
				return;
			case ModelPackage.INITIALLY__HOLDS_AT_BETWEENS:
				getHoldsAtBetweens().clear();
				getHoldsAtBetweens().addAll((Collection<? extends HoldsAtBetween>)newValue);
				return;
			case ModelPackage.INITIALLY__HAPPENS:
				getHappens().clear();
				getHappens().addAll((Collection<? extends Happens>)newValue);
				return;
			case ModelPackage.INITIALLY__CONTEXT_RELATION:
				setContextRelation((ContextRelation)newValue);
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
			case ModelPackage.INITIALLY__HOLDS_ATS:
				getHoldsAts().clear();
				return;
			case ModelPackage.INITIALLY__HOLDS_AT_BETWEENS:
				getHoldsAtBetweens().clear();
				return;
			case ModelPackage.INITIALLY__HAPPENS:
				getHappens().clear();
				return;
			case ModelPackage.INITIALLY__CONTEXT_RELATION:
				setContextRelation((ContextRelation)null);
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
			case ModelPackage.INITIALLY__HOLDS_ATS:
				return holdsAts != null && !holdsAts.isEmpty();
			case ModelPackage.INITIALLY__HOLDS_AT_BETWEENS:
				return holdsAtBetweens != null && !holdsAtBetweens.isEmpty();
			case ModelPackage.INITIALLY__HAPPENS:
				return happens != null && !happens.isEmpty();
			case ModelPackage.INITIALLY__CONTEXT_RELATION:
				return contextRelation != null;
		}
		return super.eIsSet(featureID);
	}

} //InitiallyImpl
