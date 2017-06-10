/**
 */
package model.provider;


import java.util.Collection;
import java.util.List;

import model.Environment;
import model.ModelFactory;
import model.ModelPackage;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link model.Environment} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EnvironmentItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnvironmentItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ModelPackage.Literals.ENVIRONMENT__TYPES);
			childrenFeatures.add(ModelPackage.Literals.ENVIRONMENT__INSTANCES);
			childrenFeatures.add(ModelPackage.Literals.ENVIRONMENT__PARAMETERS);
			childrenFeatures.add(ModelPackage.Literals.ENVIRONMENT__CONTEXT_RELATIONS);
			childrenFeatures.add(ModelPackage.Literals.ENVIRONMENT__EVENTS);
			childrenFeatures.add(ModelPackage.Literals.ENVIRONMENT__BEHAV_DESCRIPTIONS);
			childrenFeatures.add(ModelPackage.Literals.ENVIRONMENT__HOLDS_ATS);
			childrenFeatures.add(ModelPackage.Literals.ENVIRONMENT__HAPPENS);
			childrenFeatures.add(ModelPackage.Literals.ENVIRONMENT__HOLDS_AT_BETWEENS);
			childrenFeatures.add(ModelPackage.Literals.ENVIRONMENT__INITIALS);
			childrenFeatures.add(ModelPackage.Literals.ENVIRONMENT__AGENTS);
			childrenFeatures.add(ModelPackage.Literals.ENVIRONMENT__OBSERVERS);
			childrenFeatures.add(ModelPackage.Literals.ENVIRONMENT__ADD_PARAM);
			childrenFeatures.add(ModelPackage.Literals.ENVIRONMENT__PRIMITIVE_EVENTS);
			childrenFeatures.add(ModelPackage.Literals.ENVIRONMENT__COMPLEX_EVENTS);
			childrenFeatures.add(ModelPackage.Literals.ENVIRONMENT__HYPOTHESIS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Environment.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Environment"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_Environment_type");
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Environment.class)) {
			case ModelPackage.ENVIRONMENT__TYPES:
			case ModelPackage.ENVIRONMENT__INSTANCES:
			case ModelPackage.ENVIRONMENT__PARAMETERS:
			case ModelPackage.ENVIRONMENT__CONTEXT_RELATIONS:
			case ModelPackage.ENVIRONMENT__EVENTS:
			case ModelPackage.ENVIRONMENT__BEHAV_DESCRIPTIONS:
			case ModelPackage.ENVIRONMENT__HOLDS_ATS:
			case ModelPackage.ENVIRONMENT__HAPPENS:
			case ModelPackage.ENVIRONMENT__HOLDS_AT_BETWEENS:
			case ModelPackage.ENVIRONMENT__INITIALS:
			case ModelPackage.ENVIRONMENT__AGENTS:
			case ModelPackage.ENVIRONMENT__OBSERVERS:
			case ModelPackage.ENVIRONMENT__ADD_PARAM:
			case ModelPackage.ENVIRONMENT__PRIMITIVE_EVENTS:
			case ModelPackage.ENVIRONMENT__COMPLEX_EVENTS:
			case ModelPackage.ENVIRONMENT__HYPOTHESIS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__TYPES,
				 ModelFactory.eINSTANCE.createType()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__INSTANCES,
				 ModelFactory.eINSTANCE.createInstance()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__PARAMETERS,
				 ModelFactory.eINSTANCE.createParameter()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__PARAMETERS,
				 ModelFactory.eINSTANCE.createObserver()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__PARAMETERS,
				 ModelFactory.eINSTANCE.createAgent()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__CONTEXT_RELATIONS,
				 ModelFactory.eINSTANCE.createContextRelation()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__EVENTS,
				 ModelFactory.eINSTANCE.createPrimitiveEvent()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__EVENTS,
				 ModelFactory.eINSTANCE.createComplexEvent()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__BEHAV_DESCRIPTIONS,
				 ModelFactory.eINSTANCE.createBehaviouralDescription()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__HOLDS_ATS,
				 ModelFactory.eINSTANCE.createHoldsAt()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__HAPPENS,
				 ModelFactory.eINSTANCE.createHappens()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__HOLDS_AT_BETWEENS,
				 ModelFactory.eINSTANCE.createHoldsAtBetween()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__INITIALS,
				 ModelFactory.eINSTANCE.createInitially()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__AGENTS,
				 ModelFactory.eINSTANCE.createParameter()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__AGENTS,
				 ModelFactory.eINSTANCE.createObserver()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__AGENTS,
				 ModelFactory.eINSTANCE.createAgent()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__OBSERVERS,
				 ModelFactory.eINSTANCE.createParameter()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__OBSERVERS,
				 ModelFactory.eINSTANCE.createObserver()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__OBSERVERS,
				 ModelFactory.eINSTANCE.createAgent()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__ADD_PARAM,
				 ModelFactory.eINSTANCE.createParameter()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__ADD_PARAM,
				 ModelFactory.eINSTANCE.createObserver()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__ADD_PARAM,
				 ModelFactory.eINSTANCE.createAgent()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__PRIMITIVE_EVENTS,
				 ModelFactory.eINSTANCE.createPrimitiveEvent()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__COMPLEX_EVENTS,
				 ModelFactory.eINSTANCE.createComplexEvent()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.ENVIRONMENT__HYPOTHESIS,
				 ModelFactory.eINSTANCE.createHypothesis()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == ModelPackage.Literals.ENVIRONMENT__PARAMETERS ||
			childFeature == ModelPackage.Literals.ENVIRONMENT__AGENTS ||
			childFeature == ModelPackage.Literals.ENVIRONMENT__OBSERVERS ||
			childFeature == ModelPackage.Literals.ENVIRONMENT__ADD_PARAM ||
			childFeature == ModelPackage.Literals.ENVIRONMENT__EVENTS ||
			childFeature == ModelPackage.Literals.ENVIRONMENT__PRIMITIVE_EVENTS ||
			childFeature == ModelPackage.Literals.ENVIRONMENT__COMPLEX_EVENTS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ModelEditPlugin.INSTANCE;
	}

}
