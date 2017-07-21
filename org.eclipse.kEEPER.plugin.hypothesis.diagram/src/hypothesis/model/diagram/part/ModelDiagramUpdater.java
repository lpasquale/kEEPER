package hypothesis.model.diagram.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

import hypothesis.model.diagram.edit.parts.AgentEditPart;
import hypothesis.model.diagram.edit.parts.AgentParamEditPart;
import hypothesis.model.diagram.edit.parts.EnvironmentEditPart;
import hypothesis.model.diagram.edit.parts.GeneralParamEditPart;
import hypothesis.model.diagram.edit.parts.HappensEditPart;
import hypothesis.model.diagram.edit.parts.HoldsAtBetweenEditPart;
import hypothesis.model.diagram.edit.parts.HoldsAtEditPart;
import hypothesis.model.diagram.edit.parts.HypothesisEditPart;
import hypothesis.model.diagram.edit.parts.ObserverEditPart;
import hypothesis.model.diagram.edit.parts.ObserverParamEditPart;
import model.Environment;
import model.Happens;
import model.HoldsAt;
import model.HoldsAtBetween;
import model.Hypothesis;
import model.Parameter;
import model.Type;

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
		for (Iterator<?> it = modelElement.getHypothesis().iterator(); it.hasNext();) {
			Hypothesis childElement = (Hypothesis) it.next();
			int visualID = ModelVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == HypothesisEditPart.VISUAL_ID) {
				result.add(new ModelNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getHappens().iterator(); it.hasNext();) {
			Happens childElement = (Happens) it.next();
			int visualID = ModelVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == HappensEditPart.VISUAL_ID) {
				result.add(new ModelNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getHoldsAts().iterator(); it.hasNext();) {
			HoldsAt childElement = (HoldsAt) it.next();
			int visualID = ModelVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == HoldsAtEditPart.VISUAL_ID) {
				result.add(new ModelNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getHoldsAtBetweens().iterator(); it.hasNext();) {
			HoldsAtBetween childElement = (HoldsAtBetween) it.next();
			int visualID = ModelVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == HoldsAtBetweenEditPart.VISUAL_ID) {
				result.add(new ModelNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter) it.next();
			int visualID = ModelVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == AgentParamEditPart.VISUAL_ID) {
				result.add(new ModelNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == GeneralParamEditPart.VISUAL_ID) {
				result.add(new ModelNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ObserverParamEditPart.VISUAL_ID) {
				result.add(new ModelNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getTypes().iterator(); it.hasNext();) {
			Type childElement = (Type) it.next();
			int visualID = ModelVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == AgentEditPart.VISUAL_ID) {
				result.add(new ModelNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ObserverEditPart.VISUAL_ID) {
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
		case HypothesisEditPart.VISUAL_ID:
			return getHypothesis_2001ContainedLinks(view);
		case HappensEditPart.VISUAL_ID:
			return getHappens_2002ContainedLinks(view);
		case HoldsAtEditPart.VISUAL_ID:
			return getHoldsAt_2003ContainedLinks(view);
		case HoldsAtBetweenEditPart.VISUAL_ID:
			return getHoldsAtBetween_2004ContainedLinks(view);
		case AgentParamEditPart.VISUAL_ID:
			return getAgentParam_2005ContainedLinks(view);
		case GeneralParamEditPart.VISUAL_ID:
			return getGeneralParam_2006ContainedLinks(view);
		case ObserverParamEditPart.VISUAL_ID:
			return getObserverParam_2007ContainedLinks(view);
		case AgentEditPart.VISUAL_ID:
			return getAgent_2008ContainedLinks(view);
		case ObserverEditPart.VISUAL_ID:
			return getObserver_2009ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getIncomingLinks(View view) {
		switch (ModelVisualIDRegistry.getVisualID(view)) {
		case HypothesisEditPart.VISUAL_ID:
			return getHypothesis_2001IncomingLinks(view);
		case HappensEditPart.VISUAL_ID:
			return getHappens_2002IncomingLinks(view);
		case HoldsAtEditPart.VISUAL_ID:
			return getHoldsAt_2003IncomingLinks(view);
		case HoldsAtBetweenEditPart.VISUAL_ID:
			return getHoldsAtBetween_2004IncomingLinks(view);
		case AgentParamEditPart.VISUAL_ID:
			return getAgentParam_2005IncomingLinks(view);
		case GeneralParamEditPart.VISUAL_ID:
			return getGeneralParam_2006IncomingLinks(view);
		case ObserverParamEditPart.VISUAL_ID:
			return getObserverParam_2007IncomingLinks(view);
		case AgentEditPart.VISUAL_ID:
			return getAgent_2008IncomingLinks(view);
		case ObserverEditPart.VISUAL_ID:
			return getObserver_2009IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getOutgoingLinks(View view) {
		switch (ModelVisualIDRegistry.getVisualID(view)) {
		case HypothesisEditPart.VISUAL_ID:
			return getHypothesis_2001OutgoingLinks(view);
		case HappensEditPart.VISUAL_ID:
			return getHappens_2002OutgoingLinks(view);
		case HoldsAtEditPart.VISUAL_ID:
			return getHoldsAt_2003OutgoingLinks(view);
		case HoldsAtBetweenEditPart.VISUAL_ID:
			return getHoldsAtBetween_2004OutgoingLinks(view);
		case AgentParamEditPart.VISUAL_ID:
			return getAgentParam_2005OutgoingLinks(view);
		case GeneralParamEditPart.VISUAL_ID:
			return getGeneralParam_2006OutgoingLinks(view);
		case ObserverParamEditPart.VISUAL_ID:
			return getObserverParam_2007OutgoingLinks(view);
		case AgentEditPart.VISUAL_ID:
			return getAgent_2008OutgoingLinks(view);
		case ObserverEditPart.VISUAL_ID:
			return getObserver_2009OutgoingLinks(view);
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
	public static List<ModelLinkDescriptor> getHypothesis_2001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getHappens_2002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getHoldsAt_2003ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getHoldsAtBetween_2004ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getAgentParam_2005ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getGeneralParam_2006ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getObserverParam_2007ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getAgent_2008ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getObserver_2009ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getHypothesis_2001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getHappens_2002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getHoldsAt_2003IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getHoldsAtBetween_2004IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getAgentParam_2005IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getGeneralParam_2006IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getObserverParam_2007IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getAgent_2008IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getObserver_2009IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getHypothesis_2001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getHappens_2002OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getHoldsAt_2003OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getHoldsAtBetween_2004OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getAgentParam_2005OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getGeneralParam_2006OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getObserverParam_2007OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getAgent_2008OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getObserver_2009OutgoingLinks(View view) {
		return Collections.emptyList();
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
