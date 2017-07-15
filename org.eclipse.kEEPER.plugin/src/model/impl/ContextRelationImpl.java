/**
 */
package model.impl;

import java.util.Collection;

import model.ComplexEvent;
import model.ContextRelation;
import model.ModelPackage;
import model.Type;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link model.impl.ContextRelationImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.impl.ContextRelationImpl#getInitialComplexEvent <em>Initial Complex Event</em>}</li>
 *   <li>{@link model.impl.ContextRelationImpl#getEndingComplexEvent <em>Ending Complex Event</em>}</li>
 *   <li>{@link model.impl.ContextRelationImpl#isValue <em>Value</em>}</li>
 *   <li>{@link model.impl.ContextRelationImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link model.impl.ContextRelationImpl#getTypeNames <em>Type Names</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContextRelationImpl extends MinimalEObjectImpl.Container implements ContextRelation {
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
	 * The cached value of the '{@link #getInitialComplexEvent() <em>Initial Complex Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialComplexEvent()
	 * @generated
	 * @ordered
	 */
	protected ComplexEvent initialComplexEvent;

	/**
	 * The cached value of the '{@link #getEndingComplexEvent() <em>Ending Complex Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndingComplexEvent()
	 * @generated
	 * @ordered
	 */
	protected ComplexEvent endingComplexEvent;

	/**
	 * The default value of the '{@link #isValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValue()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VALUE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValue()
	 * @generated
	 * @ordered
	 */
	protected boolean value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> types;

	/**
	 * The default value of the '{@link #getTypeNames() <em>Type Names</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeNames()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_NAMES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypeNames() <em>Type Names</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeNames()
	 * @generated
	 * @ordered
	 */
	protected String typeNames = TYPE_NAMES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContextRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.CONTEXT_RELATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTEXT_RELATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(boolean newValue) {
		boolean oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTEXT_RELATION__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getTypes() {
		if (types == null) {
			types = new EObjectResolvingEList<Type>(Type.class, this, ModelPackage.CONTEXT_RELATION__TYPES);
		}
		return types;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTypeNames() {
		
		return typeNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeNames() {
		String oldTypeNames = typeNames;
		if (!getTypes().isEmpty())
			typeNames = getTypes().get(0).getName();
		if (getTypes().isEmpty()){
			typeNames = null;
		}
		//String oldTypeNames = typeNames;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTEXT_RELATION__TYPE_NAMES, oldTypeNames, typeNames));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexEvent getInitialComplexEvent() {
		if (initialComplexEvent != null && initialComplexEvent.eIsProxy()) {
			InternalEObject oldInitialComplexEvent = (InternalEObject)initialComplexEvent;
			initialComplexEvent = (ComplexEvent)eResolveProxy(oldInitialComplexEvent);
			if (initialComplexEvent != oldInitialComplexEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.CONTEXT_RELATION__INITIAL_COMPLEX_EVENT, oldInitialComplexEvent, initialComplexEvent));
			}
		}
		return initialComplexEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexEvent basicGetInitialComplexEvent() {
		return initialComplexEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialComplexEvent(ComplexEvent newInitialComplexEvent) {
		ComplexEvent oldInitialComplexEvent = initialComplexEvent;
		initialComplexEvent = newInitialComplexEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTEXT_RELATION__INITIAL_COMPLEX_EVENT, oldInitialComplexEvent, initialComplexEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexEvent getEndingComplexEvent() {
		if (endingComplexEvent != null && endingComplexEvent.eIsProxy()) {
			InternalEObject oldEndingComplexEvent = (InternalEObject)endingComplexEvent;
			endingComplexEvent = (ComplexEvent)eResolveProxy(oldEndingComplexEvent);
			if (endingComplexEvent != oldEndingComplexEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.CONTEXT_RELATION__ENDING_COMPLEX_EVENT, oldEndingComplexEvent, endingComplexEvent));
			}
		}
		return endingComplexEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexEvent basicGetEndingComplexEvent() {
		return endingComplexEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndingComplexEvent(ComplexEvent newEndingComplexEvent) {
		ComplexEvent oldEndingComplexEvent = endingComplexEvent;
		endingComplexEvent = newEndingComplexEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTEXT_RELATION__ENDING_COMPLEX_EVENT, oldEndingComplexEvent, endingComplexEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.CONTEXT_RELATION__NAME:
				return getName();
			case ModelPackage.CONTEXT_RELATION__INITIAL_COMPLEX_EVENT:
				if (resolve) return getInitialComplexEvent();
				return basicGetInitialComplexEvent();
			case ModelPackage.CONTEXT_RELATION__ENDING_COMPLEX_EVENT:
				if (resolve) return getEndingComplexEvent();
				return basicGetEndingComplexEvent();
			case ModelPackage.CONTEXT_RELATION__VALUE:
				return isValue();
			case ModelPackage.CONTEXT_RELATION__TYPES:
				return getTypes();
			case ModelPackage.CONTEXT_RELATION__TYPE_NAMES:
				return getTypeNames();
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
			case ModelPackage.CONTEXT_RELATION__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.CONTEXT_RELATION__INITIAL_COMPLEX_EVENT:
				setInitialComplexEvent((ComplexEvent)newValue);
				return;
			case ModelPackage.CONTEXT_RELATION__ENDING_COMPLEX_EVENT:
				setEndingComplexEvent((ComplexEvent)newValue);
				return;
			case ModelPackage.CONTEXT_RELATION__VALUE:
				setValue((Boolean)newValue);
				return;
			case ModelPackage.CONTEXT_RELATION__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection<? extends Type>)newValue);
				setTypeNames();
				return;
			case ModelPackage.CONTEXT_RELATION__TYPE_NAMES:
				setTypeNames();
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
			case ModelPackage.CONTEXT_RELATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.CONTEXT_RELATION__INITIAL_COMPLEX_EVENT:
				setInitialComplexEvent((ComplexEvent)null);
				return;
			case ModelPackage.CONTEXT_RELATION__ENDING_COMPLEX_EVENT:
				setEndingComplexEvent((ComplexEvent)null);
				return;
			case ModelPackage.CONTEXT_RELATION__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case ModelPackage.CONTEXT_RELATION__TYPES:
				getTypes().clear();
				setTypeNames();
				return;
			case ModelPackage.CONTEXT_RELATION__TYPE_NAMES:
				setTypeNames();
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
			case ModelPackage.CONTEXT_RELATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.CONTEXT_RELATION__INITIAL_COMPLEX_EVENT:
				return initialComplexEvent != null;
			case ModelPackage.CONTEXT_RELATION__ENDING_COMPLEX_EVENT:
				return endingComplexEvent != null;
			case ModelPackage.CONTEXT_RELATION__VALUE:
				return value != VALUE_EDEFAULT;
			case ModelPackage.CONTEXT_RELATION__TYPES:
				return types != null && !types.isEmpty();
			case ModelPackage.CONTEXT_RELATION__TYPE_NAMES:
				return TYPE_NAMES_EDEFAULT == null ? typeNames != null : !TYPE_NAMES_EDEFAULT.equals(typeNames);
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
		result.append(", value: ");
		result.append(value);
		result.append(", typeNames: ");
		result.append(typeNames);
		result.append(')');
		return result.toString();
	}


} //ContextRelationImpl
