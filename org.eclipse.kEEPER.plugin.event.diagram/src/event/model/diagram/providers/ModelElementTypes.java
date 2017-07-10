package event.model.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import event.model.diagram.edit.parts.AgentReferenceEditPart;
import event.model.diagram.edit.parts.ComplexEventAgentEditPart;
import event.model.diagram.edit.parts.ComplexEventEditPart;
import event.model.diagram.edit.parts.EnvironmentEditPart;
import event.model.diagram.edit.parts.EventTypesEditPart;
import event.model.diagram.edit.parts.GeneralTypeReferenceEditPart;
import event.model.diagram.edit.parts.ObserverReferenceEditPart;
import event.model.diagram.edit.parts.PrimitiveEventAgentEditPart;
import event.model.diagram.edit.parts.PrimitiveEventEditPart;
import event.model.diagram.edit.parts.PrimitiveEventObserverEditPart;
import event.model.diagram.part.ModelDiagramEditorPlugin;
import model.ModelPackage;

/**
 * @generated
 */
public class ModelElementTypes {

	/**
	* @generated
	*/
	private ModelElementTypes() {
	}

	/**
	* @generated
	*/
	private static Map<IElementType, ENamedElement> elements;

	/**
	* @generated
	*/
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			ModelDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	* @generated
	*/
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	* @generated
	*/
	public static final IElementType Environment_1000 = getElementType(
			"org.eclipse.kEEPER.plugin.event.diagram.Environment_1000"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PrimitiveEvent_2011 = getElementType(
			"org.eclipse.kEEPER.plugin.event.diagram.PrimitiveEvent_2011"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType AgentReference_2016 = getElementType(
			"org.eclipse.kEEPER.plugin.event.diagram.AgentReference_2016"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType ObserverReference_2017 = getElementType(
			"org.eclipse.kEEPER.plugin.event.diagram.ObserverReference_2017"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType GeneralTypeReference_2018 = getElementType(
			"org.eclipse.kEEPER.plugin.event.diagram.GeneralTypeReference_2018"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType ComplexEvent_2012 = getElementType(
			"org.eclipse.kEEPER.plugin.event.diagram.ComplexEvent_2012"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PrimitiveEventAgent_4001 = getElementType(
			"org.eclipse.kEEPER.plugin.event.diagram.PrimitiveEventAgent_4001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType ComplexEventAgent_4004 = getElementType(
			"org.eclipse.kEEPER.plugin.event.diagram.ComplexEventAgent_4004"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType EventTypes_4005 = getElementType(
			"org.eclipse.kEEPER.plugin.event.diagram.EventTypes_4005"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PrimitiveEventObserver_4002 = getElementType(
			"org.eclipse.kEEPER.plugin.event.diagram.PrimitiveEventObserver_4002"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	* @generated
	*/
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	* @generated
	*/
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	* Returns 'type' of the ecore object associated with the hint.
	* 
	* @generated
	*/
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(Environment_1000, ModelPackage.eINSTANCE.getEnvironment());

			elements.put(PrimitiveEvent_2011, ModelPackage.eINSTANCE.getPrimitiveEvent());

			elements.put(AgentReference_2016, ModelPackage.eINSTANCE.getAgentReference());

			elements.put(ObserverReference_2017, ModelPackage.eINSTANCE.getObserverReference());

			elements.put(GeneralTypeReference_2018, ModelPackage.eINSTANCE.getGeneralTypeReference());

			elements.put(ComplexEvent_2012, ModelPackage.eINSTANCE.getComplexEvent());

			elements.put(PrimitiveEventAgent_4001, ModelPackage.eINSTANCE.getPrimitiveEvent_Agent());

			elements.put(ComplexEventAgent_4004, ModelPackage.eINSTANCE.getComplexEvent_Agent());

			elements.put(EventTypes_4005, ModelPackage.eINSTANCE.getEvent_Types());

			elements.put(PrimitiveEventObserver_4002, ModelPackage.eINSTANCE.getPrimitiveEvent_Observer());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	* @generated
	*/
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	* @generated
	*/
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Environment_1000);
			KNOWN_ELEMENT_TYPES.add(PrimitiveEvent_2011);
			KNOWN_ELEMENT_TYPES.add(AgentReference_2016);
			KNOWN_ELEMENT_TYPES.add(ObserverReference_2017);
			KNOWN_ELEMENT_TYPES.add(GeneralTypeReference_2018);
			KNOWN_ELEMENT_TYPES.add(ComplexEvent_2012);
			KNOWN_ELEMENT_TYPES.add(PrimitiveEventAgent_4001);
			KNOWN_ELEMENT_TYPES.add(ComplexEventAgent_4004);
			KNOWN_ELEMENT_TYPES.add(EventTypes_4005);
			KNOWN_ELEMENT_TYPES.add(PrimitiveEventObserver_4002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	* @generated
	*/
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case EnvironmentEditPart.VISUAL_ID:
			return Environment_1000;
		case PrimitiveEventEditPart.VISUAL_ID:
			return PrimitiveEvent_2011;
		case AgentReferenceEditPart.VISUAL_ID:
			return AgentReference_2016;
		case ObserverReferenceEditPart.VISUAL_ID:
			return ObserverReference_2017;
		case GeneralTypeReferenceEditPart.VISUAL_ID:
			return GeneralTypeReference_2018;
		case ComplexEventEditPart.VISUAL_ID:
			return ComplexEvent_2012;
		case PrimitiveEventAgentEditPart.VISUAL_ID:
			return PrimitiveEventAgent_4001;
		case ComplexEventAgentEditPart.VISUAL_ID:
			return ComplexEventAgent_4004;
		case EventTypesEditPart.VISUAL_ID:
			return EventTypes_4005;
		case PrimitiveEventObserverEditPart.VISUAL_ID:
			return PrimitiveEventObserver_4002;
		}
		return null;
	}

	/**
	* @generated
	*/
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(elementTypeImages) {

		/**
		* @generated
		*/
		@Override

		public boolean isKnownElementType(IElementType elementType) {
			return event.model.diagram.providers.ModelElementTypes.isKnownElementType(elementType);
		}

		/**
		* @generated
		*/
		@Override

		public IElementType getElementTypeForVisualId(int visualID) {
			return event.model.diagram.providers.ModelElementTypes.getElementType(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return event.model.diagram.providers.ModelElementTypes.getElement(elementTypeAdapter);
		}
	};

}
