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
import event.model.diagram.providers.ModelElementTypes;
import model.Agent;
import model.BehaviouralDescription;
import model.ComplexEvent;
import model.Environment;
import model.Event;
import model.ModelPackage;
import model.Observer;
import model.Parameter;
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
		for (Iterator<?> it = modelElement.getPrimitiveEvents().iterator(); it.hasNext();) {
			PrimitiveEvent childElement = (PrimitiveEvent) it.next();
			int visualID = ModelVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == PrimitiveEventEditPart.VISUAL_ID) {
				result.add(new ModelNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter) it.next();
			int visualID = ModelVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == AgentEditPart.VISUAL_ID) {
				result.add(new ModelNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ObserverEditPart.VISUAL_ID) {
				result.add(new ModelNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new ModelNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getComplexEvents().iterator(); it.hasNext();) {
			ComplexEvent childElement = (ComplexEvent) it.next();
			int visualID = ModelVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ComplexEventEditPart.VISUAL_ID) {
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
			return getPrimitiveEvent_2005ContainedLinks(view);
		case AgentEditPart.VISUAL_ID:
			return getAgent_2007ContainedLinks(view);
		case ObserverEditPart.VISUAL_ID:
			return getObserver_2008ContainedLinks(view);
		case ParameterEditPart.VISUAL_ID:
			return getParameter_2009ContainedLinks(view);
		case ComplexEventEditPart.VISUAL_ID:
			return getComplexEvent_2010ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getIncomingLinks(View view) {
		switch (ModelVisualIDRegistry.getVisualID(view)) {
		case PrimitiveEventEditPart.VISUAL_ID:
			return getPrimitiveEvent_2005IncomingLinks(view);
		case AgentEditPart.VISUAL_ID:
			return getAgent_2007IncomingLinks(view);
		case ObserverEditPart.VISUAL_ID:
			return getObserver_2008IncomingLinks(view);
		case ParameterEditPart.VISUAL_ID:
			return getParameter_2009IncomingLinks(view);
		case ComplexEventEditPart.VISUAL_ID:
			return getComplexEvent_2010IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getOutgoingLinks(View view) {
		switch (ModelVisualIDRegistry.getVisualID(view)) {
		case PrimitiveEventEditPart.VISUAL_ID:
			return getPrimitiveEvent_2005OutgoingLinks(view);
		case AgentEditPart.VISUAL_ID:
			return getAgent_2007OutgoingLinks(view);
		case ObserverEditPart.VISUAL_ID:
			return getObserver_2008OutgoingLinks(view);
		case ParameterEditPart.VISUAL_ID:
			return getParameter_2009OutgoingLinks(view);
		case ComplexEventEditPart.VISUAL_ID:
			return getComplexEvent_2010OutgoingLinks(view);
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
	public static List<ModelLinkDescriptor> getPrimitiveEvent_2005ContainedLinks(View view) {
		PrimitiveEvent modelElement = (PrimitiveEvent) view.getElement();
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_PrimitiveEvent_Agent_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Event_Parameters_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PrimitiveEvent_Observer_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getAgent_2007ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getObserver_2008ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getParameter_2009ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getComplexEvent_2010ContainedLinks(View view) {
		ComplexEvent modelElement = (ComplexEvent) view.getElement();
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ComplexEvent_Agent_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Event_Parameters_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getPrimitiveEvent_2005IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getAgent_2007IncomingLinks(View view) {
		Agent modelElement = (Agent) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_PrimitiveEvent_Agent_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ComplexEvent_Agent_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Event_Parameters_4003(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getObserver_2008IncomingLinks(View view) {
		Observer modelElement = (Observer) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Event_Parameters_4003(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_PrimitiveEvent_Observer_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getParameter_2009IncomingLinks(View view) {
		Parameter modelElement = (Parameter) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Event_Parameters_4003(modelElement, crossReferences));
		return result;
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getComplexEvent_2010IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getPrimitiveEvent_2005OutgoingLinks(View view) {
		PrimitiveEvent modelElement = (PrimitiveEvent) view.getElement();
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_PrimitiveEvent_Agent_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Event_Parameters_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PrimitiveEvent_Observer_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getAgent_2007OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getObserver_2008OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getParameter_2009OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getComplexEvent_2010OutgoingLinks(View view) {
		ComplexEvent modelElement = (ComplexEvent) view.getElement();
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ComplexEvent_Agent_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Event_Parameters_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ModelLinkDescriptor> getIncomingFeatureModelFacetLinks_PrimitiveEvent_Agent_4001(
			Agent target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
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
	private static Collection<ModelLinkDescriptor> getIncomingFeatureModelFacetLinks_Event_Parameters_4003(
			Parameter target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == ModelPackage.eINSTANCE.getEvent_Parameters()) {
				result.add(new ModelLinkDescriptor(setting.getEObject(), target, ModelElementTypes.EventParameters_4003,
						EventParametersEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<ModelLinkDescriptor> getIncomingFeatureModelFacetLinks_ComplexEvent_Agent_4004(
			Agent target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
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
	private static Collection<ModelLinkDescriptor> getIncomingFeatureModelFacetLinks_PrimitiveEvent_Observer_4002(
			Observer target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
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
		Agent destination = source.getAgent();
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
	private static Collection<ModelLinkDescriptor> getOutgoingFeatureModelFacetLinks_Event_Parameters_4003(
			Event source) {
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		for (Iterator<?> destinations = source.getParameters().iterator(); destinations.hasNext();) {
			Parameter destination = (Parameter) destinations.next();
			result.add(new ModelLinkDescriptor(source, destination, ModelElementTypes.EventParameters_4003,
					EventParametersEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<ModelLinkDescriptor> getOutgoingFeatureModelFacetLinks_ComplexEvent_Agent_4004(
			ComplexEvent source) {
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		Agent destination = source.getAgent();
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
	private static Collection<ModelLinkDescriptor> getOutgoingFeatureModelFacetLinks_PrimitiveEvent_Observer_4002(
			PrimitiveEvent source) {
		LinkedList<ModelLinkDescriptor> result = new LinkedList<ModelLinkDescriptor>();
		Observer destination = source.getObserver();
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
