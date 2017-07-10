package event.model.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

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
import event.model.diagram.providers.ModelElementTypes;
import model.AgentReference;
import model.ComplexEvent;
import model.Environment;
import model.Event;
import model.GeneralTypeReference;
import model.ModelPackage;
import model.ObserverReference;
import model.PrimitiveEvent;

/**
 * @generated
 */
public class ModelDiagramUpdater {

	/**
	* @generated
	*/
	public static List<ModelNodeDescriptor> getSemanticChildren(View view) {
		switch (ModelVisualIDRegistry.getVisualID(view)) {
		case EnvironmentEditPart.VISUAL_ID:
			return getEnvironment_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelNodeDescriptor> getEnvironment_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Environment modelElement = (Environment) view.getElement();
		LinkedList<ModelNodeDescriptor> result = new LinkedList<ModelNodeDescriptor>();
		for (Iterator<?> it = modelElement.getEvents().iterator(); it.hasNext();) {
			Event childElement = (Event) it.next();
			int visualID = ModelVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == PrimitiveEventEditPart.VISUAL_ID) {
				result.add(new ModelNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ComplexEventEditPart.VISUAL_ID) {
				result.add(new ModelNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getAgentReferences().iterator(); it.hasNext();) {
			AgentReference childElement = (AgentReference) it.next();
			int visualID = ModelVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == AgentReferenceEditPart.VISUAL_ID) {
				result.add(new ModelNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getObserverReferences().iterator(); it.hasNext();) {
			ObserverReference childElement = (ObserverReference) it.next();
			int visualID = ModelVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ObserverReferenceEditPart.VISUAL_ID) {
				result.add(new ModelNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getGeneralTypeReferences().iterator(); it.hasNext();) {
			GeneralTypeReference childElement = (GeneralTypeReference) it.next();
			int visualID = ModelVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == GeneralTypeReferenceEditPart.VISUAL_ID) {
				result.add(new ModelNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getContainedLinks(View view) {
		switch (ModelVisualIDRegistry.getVisualID(view)) {
		case EnvironmentEditPart.VISUAL_ID:
			return getEnvironment_1000ContainedLinks(view);
		case PrimitiveEventEditPart.VISUAL_ID:
			return getPrimitiveEvent_2011ContainedLinks(view);
		case AgentReferenceEditPart.VISUAL_ID:
			return getAgentReference_2016ContainedLinks(view);
		case ObserverReferenceEditPart.VISUAL_ID:
			return getObserverReference_2017ContainedLinks(view);
		case GeneralTypeReferenceEditPart.VISUAL_ID:
			return getGeneralTypeReference_2018ContainedLinks(view);
		case ComplexEventEditPart.VISUAL_ID:
			return getComplexEvent_2012ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getIncomingLinks(View view) {
		switch (ModelVisualIDRegistry.getVisualID(view)) {
		case PrimitiveEventEditPart.VISUAL_ID:
			return getPrimitiveEvent_2011IncomingLinks(view);
		case AgentReferenceEditPart.VISUAL_ID:
			return getAgentReference_2016IncomingLinks(view);
		case ObserverReferenceEditPart.VISUAL_ID:
			return getObserverReference_2017IncomingLinks(view);
		case GeneralTypeReferenceEditPart.VISUAL_ID:
			return getGeneralTypeReference_2018IncomingLinks(view);
		case ComplexEventEditPart.VISUAL_ID:
			return getComplexEvent_2012IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getOutgoingLinks(View view) {
		switch (ModelVisualIDRegistry.getVisualID(view)) {
		case PrimitiveEventEditPart.VISUAL_ID:
			return getPrimitiveEvent_2011OutgoingLinks(view);
		case AgentReferenceEditPart.VISUAL_ID:
			return getAgentReference_2016OutgoingLinks(view);
		case ObserverReferenceEditPart.VISUAL_ID:
			return getObserverReference_2017OutgoingLinks(view);
		case GeneralTypeReferenceEditPart.VISUAL_ID:
			return getGeneralTypeReference_2018OutgoingLinks(view);
		case ComplexEventEditPart.VISUAL_ID:
			return getComplexEvent_2012OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getEnvironment_1000ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getPrimitiveEvent_2011ContainedLinks(View view) {
		PrimitiveEvent modelElement = (PrimitiveEvent) view.getElement();
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_PrimitiveEvent_Agent_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Event_Types_4005(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PrimitiveEvent_Observer_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getAgentReference_2016ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getObserverReference_2017ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getGeneralTypeReference_2018ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getComplexEvent_2012ContainedLinks(View view) {
		ComplexEvent modelElement = (ComplexEvent) view.getElement();
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ComplexEvent_Agent_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Event_Types_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getPrimitiveEvent_2011IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getAgentReference_2016IncomingLinks(View view) {
		AgentReference modelElement = (AgentReference) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_PrimitiveEvent_Agent_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ComplexEvent_Agent_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getObserverReference_2017IncomingLinks(View view) {
		ObserverReference modelElement = (ObserverReference) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_PrimitiveEvent_Observer_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getGeneralTypeReference_2018IncomingLinks(View view) {
		GeneralTypeReference modelElement = (GeneralTypeReference) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Event_Types_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getComplexEvent_2012IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getPrimitiveEvent_2011OutgoingLinks(View view) {
		PrimitiveEvent modelElement = (PrimitiveEvent) view.getElement();
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_PrimitiveEvent_Agent_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Event_Types_4005(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PrimitiveEvent_Observer_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getAgentReference_2016OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getObserverReference_2017OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getGeneralTypeReference_2018OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getComplexEvent_2012OutgoingLinks(View view) {
		ComplexEvent modelElement = (ComplexEvent) view.getElement();
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ComplexEvent_Agent_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Event_Types_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ModelLinkDescriptor> getIncomingFeatureModelFacetLinks_PrimitiveEvent_Agent_4001(
			AgentReference target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == ModelPackage.eINSTANCE.getPrimitiveEvent_Agent()) {
				result.add(new ModelLinkDescriptor(setting.getEObject(), target,
						ModelElementTypes.PrimitiveEventAgent_4001, PrimitiveEventAgentEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ModelLinkDescriptor> getIncomingFeatureModelFacetLinks_ComplexEvent_Agent_4004(
			AgentReference target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == ModelPackage.eINSTANCE.getComplexEvent_Agent()) {
				result.add(new ModelLinkDescriptor(setting.getEObject(), target,
						ModelElementTypes.ComplexEventAgent_4004, ComplexEventAgentEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ModelLinkDescriptor> getIncomingFeatureModelFacetLinks_Event_Types_4005(
			GeneralTypeReference target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == ModelPackage.eINSTANCE.getEvent_Types()) {
				result.add(new ModelLinkDescriptor(setting.getEObject(), target, ModelElementTypes.EventTypes_4005,
						EventTypesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ModelLinkDescriptor> getIncomingFeatureModelFacetLinks_PrimitiveEvent_Observer_4002(
			ObserverReference target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == ModelPackage.eINSTANCE.getPrimitiveEvent_Observer()) {
				result.add(new ModelLinkDescriptor(setting.getEObject(), target,
						ModelElementTypes.PrimitiveEventObserver_4002, PrimitiveEventObserverEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<ModelLinkDescriptor> getOutgoingFeatureModelFacetLinks_PrimitiveEvent_Agent_4001(
			PrimitiveEvent source) {
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		AgentReference destination = source.getAgent();
		if (destination == null) {
			return result;
		}
		result.add(new ModelLinkDescriptor(source, destination, ModelElementTypes.PrimitiveEventAgent_4001,
				PrimitiveEventAgentEditPart.VISUAL_ID));
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<ModelLinkDescriptor> getOutgoingFeatureModelFacetLinks_ComplexEvent_Agent_4004(
			ComplexEvent source) {
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		AgentReference destination = source.getAgent();
		if (destination == null) {
			return result;
		}
		result.add(new ModelLinkDescriptor(source, destination, ModelElementTypes.ComplexEventAgent_4004,
				ComplexEventAgentEditPart.VISUAL_ID));
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<ModelLinkDescriptor> getOutgoingFeatureModelFacetLinks_Event_Types_4005(Event source) {
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		for (Iterator<?> destinations = source.getTypes().iterator(); destinations.hasNext();) {
			GeneralTypeReference destination = (GeneralTypeReference) destinations.next();
			result.add(new ModelLinkDescriptor(source, destination, ModelElementTypes.EventTypes_4005,
					EventTypesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<ModelLinkDescriptor> getOutgoingFeatureModelFacetLinks_PrimitiveEvent_Observer_4002(
			PrimitiveEvent source) {
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		ObserverReference destination = source.getObserver();
		if (destination == null) {
			return result;
		}
		result.add(new ModelLinkDescriptor(source, destination, ModelElementTypes.PrimitiveEventObserver_4002,
				PrimitiveEventObserverEditPart.VISUAL_ID));
		return result;
	}

	/**
	* @generated
	*/
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		* @generated
		*/
		@Override

		public List<ModelNodeDescriptor> getSemanticChildren(View view) {
			return ModelDiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<ModelLinkDescriptor> getContainedLinks(View view) {
			return ModelDiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<ModelLinkDescriptor> getIncomingLinks(View view) {
			return ModelDiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<ModelLinkDescriptor> getOutgoingLinks(View view) {
			return ModelDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
