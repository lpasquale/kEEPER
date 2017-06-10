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

import event.model.diagram.edit.parts.AgentEditPart;
import event.model.diagram.edit.parts.ComplexEventAgentEditPart;
import event.model.diagram.edit.parts.ComplexEventEditPart;
import event.model.diagram.edit.parts.EnvironmentEditPart;
import event.model.diagram.edit.parts.EventParametersEditPart;
import event.model.diagram.edit.parts.ObserverEditPart;
import event.model.diagram.edit.parts.ParameterEditPart;
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
	public static final IElementType PrimitiveEvent_2005 = getElementType(
			"org.eclipse.kEEPER.plugin.event.diagram.PrimitiveEvent_2005"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Agent_2007 = getElementType("org.eclipse.kEEPER.plugin.event.diagram.Agent_2007"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Observer_2008 = getElementType(
			"org.eclipse.kEEPER.plugin.event.diagram.Observer_2008"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Parameter_2009 = getElementType(
			"org.eclipse.kEEPER.plugin.event.diagram.Parameter_2009"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType ComplexEvent_2010 = getElementType(
			"org.eclipse.kEEPER.plugin.event.diagram.ComplexEvent_2010"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType PrimitiveEventAgent_4001 = getElementType(
			"org.eclipse.kEEPER.plugin.event.diagram.PrimitiveEventAgent_4001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType EventParameters_4003 = getElementType(
			"org.eclipse.kEEPER.plugin.event.diagram.EventParameters_4003"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType ComplexEventAgent_4004 = getElementType(
			"org.eclipse.kEEPER.plugin.event.diagram.ComplexEventAgent_4004"); //$NON-NLS-1$

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

			elements.put(PrimitiveEvent_2005, ModelPackage.eINSTANCE.getPrimitiveEvent());

			elements.put(Agent_2007, ModelPackage.eINSTANCE.getAgent());

			elements.put(Observer_2008, ModelPackage.eINSTANCE.getObserver());

			elements.put(Parameter_2009, ModelPackage.eINSTANCE.getParameter());

			elements.put(ComplexEvent_2010, ModelPackage.eINSTANCE.getComplexEvent());

			elements.put(PrimitiveEventAgent_4001, ModelPackage.eINSTANCE.getPrimitiveEvent_Agent());

			elements.put(ComplexEventAgent_4004, ModelPackage.eINSTANCE.getComplexEvent_Agent());

			elements.put(EventParameters_4003, ModelPackage.eINSTANCE.getEvent_Parameters());

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
			KNOWN_ELEMENT_TYPES.add(PrimitiveEvent_2005);
			KNOWN_ELEMENT_TYPES.add(Agent_2007);
			KNOWN_ELEMENT_TYPES.add(Observer_2008);
			KNOWN_ELEMENT_TYPES.add(Parameter_2009);
			KNOWN_ELEMENT_TYPES.add(ComplexEvent_2010);
			KNOWN_ELEMENT_TYPES.add(PrimitiveEventAgent_4001);
			KNOWN_ELEMENT_TYPES.add(ComplexEventAgent_4004);
			KNOWN_ELEMENT_TYPES.add(EventParameters_4003);
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
			return PrimitiveEvent_2005;
		case AgentEditPart.VISUAL_ID:
			return Agent_2007;
		case ObserverEditPart.VISUAL_ID:
			return Observer_2008;
		case ParameterEditPart.VISUAL_ID:
			return Parameter_2009;
		case ComplexEventEditPart.VISUAL_ID:
			return ComplexEvent_2010;
		case PrimitiveEventAgentEditPart.VISUAL_ID:
			return PrimitiveEventAgent_4001;
		case ComplexEventAgentEditPart.VISUAL_ID:
			return ComplexEventAgent_4004;
		case EventParametersEditPart.VISUAL_ID:
			return EventParameters_4003;
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
