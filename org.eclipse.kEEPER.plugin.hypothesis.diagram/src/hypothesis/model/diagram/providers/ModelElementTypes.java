package hypothesis.model.diagram.providers;

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

import hypothesis.model.diagram.edit.parts.AgentEditPart;
import hypothesis.model.diagram.edit.parts.AgentParamEditPart;
import hypothesis.model.diagram.edit.parts.EnvironmentEditPart;
import hypothesis.model.diagram.edit.parts.GeneralParamEditPart;
import hypothesis.model.diagram.edit.parts.GeneralTypeEditPart;
import hypothesis.model.diagram.edit.parts.HappensEditPart;
import hypothesis.model.diagram.edit.parts.HoldsAtBetweenEditPart;
import hypothesis.model.diagram.edit.parts.HoldsAtEditPart;
import hypothesis.model.diagram.edit.parts.HypothesisEditPart;
import hypothesis.model.diagram.edit.parts.ObserverEditPart;
import hypothesis.model.diagram.edit.parts.ObserverParamEditPart;
import hypothesis.model.diagram.part.ModelDiagramEditorPlugin;
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
			"org.eclipse.kEEPER.plugin.hypothesis.diagram.Environment_1000"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Hypothesis_2001 = getElementType(
			"org.eclipse.kEEPER.plugin.hypothesis.diagram.Hypothesis_2001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Happens_2002 = getElementType(
			"org.eclipse.kEEPER.plugin.hypothesis.diagram.Happens_2002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType HoldsAt_2003 = getElementType(
			"org.eclipse.kEEPER.plugin.hypothesis.diagram.HoldsAt_2003"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType HoldsAtBetween_2004 = getElementType(
			"org.eclipse.kEEPER.plugin.hypothesis.diagram.HoldsAtBetween_2004"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType AgentParam_2005 = getElementType(
			"org.eclipse.kEEPER.plugin.hypothesis.diagram.AgentParam_2005"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType GeneralParam_2006 = getElementType(
			"org.eclipse.kEEPER.plugin.hypothesis.diagram.GeneralParam_2006"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType ObserverParam_2007 = getElementType(
			"org.eclipse.kEEPER.plugin.hypothesis.diagram.ObserverParam_2007"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Agent_2008 = getElementType(
			"org.eclipse.kEEPER.plugin.hypothesis.diagram.Agent_2008"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Observer_2009 = getElementType(
			"org.eclipse.kEEPER.plugin.hypothesis.diagram.Observer_2009"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType GeneralType_2010 = getElementType(
			"org.eclipse.kEEPER.plugin.hypothesis.diagram.GeneralType_2010"); //$NON-NLS-1$

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

			elements.put(Hypothesis_2001, ModelPackage.eINSTANCE.getHypothesis());

			elements.put(Happens_2002, ModelPackage.eINSTANCE.getHappens());

			elements.put(HoldsAt_2003, ModelPackage.eINSTANCE.getHoldsAt());

			elements.put(HoldsAtBetween_2004, ModelPackage.eINSTANCE.getHoldsAtBetween());

			elements.put(AgentParam_2005, ModelPackage.eINSTANCE.getAgentParam());

			elements.put(GeneralParam_2006, ModelPackage.eINSTANCE.getGeneralParam());

			elements.put(ObserverParam_2007, ModelPackage.eINSTANCE.getObserverParam());

			elements.put(Agent_2008, ModelPackage.eINSTANCE.getAgent());

			elements.put(Observer_2009, ModelPackage.eINSTANCE.getObserver());

			elements.put(GeneralType_2010, ModelPackage.eINSTANCE.getGeneralType());
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
			KNOWN_ELEMENT_TYPES.add(Hypothesis_2001);
			KNOWN_ELEMENT_TYPES.add(Happens_2002);
			KNOWN_ELEMENT_TYPES.add(HoldsAt_2003);
			KNOWN_ELEMENT_TYPES.add(HoldsAtBetween_2004);
			KNOWN_ELEMENT_TYPES.add(AgentParam_2005);
			KNOWN_ELEMENT_TYPES.add(GeneralParam_2006);
			KNOWN_ELEMENT_TYPES.add(ObserverParam_2007);
			KNOWN_ELEMENT_TYPES.add(Agent_2008);
			KNOWN_ELEMENT_TYPES.add(Observer_2009);
			KNOWN_ELEMENT_TYPES.add(GeneralType_2010);
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
		case HypothesisEditPart.VISUAL_ID:
			return Hypothesis_2001;
		case HappensEditPart.VISUAL_ID:
			return Happens_2002;
		case HoldsAtEditPart.VISUAL_ID:
			return HoldsAt_2003;
		case HoldsAtBetweenEditPart.VISUAL_ID:
			return HoldsAtBetween_2004;
		case AgentParamEditPart.VISUAL_ID:
			return AgentParam_2005;
		case GeneralParamEditPart.VISUAL_ID:
			return GeneralParam_2006;
		case ObserverParamEditPart.VISUAL_ID:
			return ObserverParam_2007;
		case AgentEditPart.VISUAL_ID:
			return Agent_2008;
		case ObserverEditPart.VISUAL_ID:
			return Observer_2009;
		case GeneralTypeEditPart.VISUAL_ID:
			return GeneralType_2010;
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
			return hypothesis.model.diagram.providers.ModelElementTypes.isKnownElementType(elementType);
		}

		/**
		* @generated
		*/
		@Override

		public IElementType getElementTypeForVisualId(int visualID) {
			return hypothesis.model.diagram.providers.ModelElementTypes.getElementType(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return hypothesis.model.diagram.providers.ModelElementTypes.getElement(elementTypeAdapter);
		}
	};

}
