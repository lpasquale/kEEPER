package behavDesc.model.diagram.part;

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

import model.BehaviouralDescription;
import model.Environment;
import model.Happens;
import model.HoldsAt;
import model.HoldsAtBetween;
import model.ModelPackage;
import model.Parameter;
import model.Type;

/**
 * @generated
 */
public class ModelDiagramUpdater {

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelNodeDescriptor> getSemanticChildren(View view) {
		switch (behavDesc.model.diagram.part.ModelVisualIDRegistry.getVisualID(view)) {
		case behavDesc.model.diagram.edit.parts.EnvironmentEditPart.VISUAL_ID:
			return getEnvironment_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelNodeDescriptor> getEnvironment_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Environment modelElement = (Environment) view.getElement();
		LinkedList<behavDesc.model.diagram.part.ModelNodeDescriptor> result = new LinkedList<behavDesc.model.diagram.part.ModelNodeDescriptor>();
		for (Iterator<?> it = modelElement.getBehavDescriptions().iterator(); it.hasNext();) {
			BehaviouralDescription childElement = (BehaviouralDescription) it.next();
			int visualID = behavDesc.model.diagram.part.ModelVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == behavDesc.model.diagram.edit.parts.BehaviouralDescriptionEditPart.VISUAL_ID) {
				result.add(new behavDesc.model.diagram.part.ModelNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getHappens().iterator(); it.hasNext();) {
			Happens childElement = (Happens) it.next();
			int visualID = behavDesc.model.diagram.part.ModelVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == behavDesc.model.diagram.edit.parts.HappensEditPart.VISUAL_ID) {
				result.add(new behavDesc.model.diagram.part.ModelNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getHoldsAts().iterator(); it.hasNext();) {
			HoldsAt childElement = (HoldsAt) it.next();
			int visualID = behavDesc.model.diagram.part.ModelVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == behavDesc.model.diagram.edit.parts.HoldsAtEditPart.VISUAL_ID) {
				result.add(new behavDesc.model.diagram.part.ModelNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getHoldsAtBetweens().iterator(); it.hasNext();) {
			HoldsAtBetween childElement = (HoldsAtBetween) it.next();
			int visualID = behavDesc.model.diagram.part.ModelVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == behavDesc.model.diagram.edit.parts.HoldsAtBetweenEditPart.VISUAL_ID) {
				result.add(new behavDesc.model.diagram.part.ModelNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter) it.next();
			int visualID = behavDesc.model.diagram.part.ModelVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == behavDesc.model.diagram.edit.parts.AgentParamEditPart.VISUAL_ID) {
				result.add(new behavDesc.model.diagram.part.ModelNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == behavDesc.model.diagram.edit.parts.ObserverParamEditPart.VISUAL_ID) {
				result.add(new behavDesc.model.diagram.part.ModelNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == behavDesc.model.diagram.edit.parts.GeneralParamEditPart.VISUAL_ID) {
				result.add(new behavDesc.model.diagram.part.ModelNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getTypes().iterator(); it.hasNext();) {
			Type childElement = (Type) it.next();
			int visualID = behavDesc.model.diagram.part.ModelVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == behavDesc.model.diagram.edit.parts.AgentEditPart.VISUAL_ID) {
				result.add(new behavDesc.model.diagram.part.ModelNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == behavDesc.model.diagram.edit.parts.ObserverEditPart.VISUAL_ID) {
				result.add(new behavDesc.model.diagram.part.ModelNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getContainedLinks(View view) {
		switch (behavDesc.model.diagram.part.ModelVisualIDRegistry.getVisualID(view)) {
		case behavDesc.model.diagram.edit.parts.EnvironmentEditPart.VISUAL_ID:
			return getEnvironment_1000ContainedLinks(view);
		case behavDesc.model.diagram.edit.parts.BehaviouralDescriptionEditPart.VISUAL_ID:
			return getBehaviouralDescription_2001ContainedLinks(view);
		case behavDesc.model.diagram.edit.parts.HappensEditPart.VISUAL_ID:
			return getHappens_2002ContainedLinks(view);
		case behavDesc.model.diagram.edit.parts.HoldsAtEditPart.VISUAL_ID:
			return getHoldsAt_2003ContainedLinks(view);
		case behavDesc.model.diagram.edit.parts.HoldsAtBetweenEditPart.VISUAL_ID:
			return getHoldsAtBetween_2004ContainedLinks(view);
		case behavDesc.model.diagram.edit.parts.AgentParamEditPart.VISUAL_ID:
			return getAgentParam_2005ContainedLinks(view);
		case behavDesc.model.diagram.edit.parts.ObserverParamEditPart.VISUAL_ID:
			return getObserverParam_2006ContainedLinks(view);
		case behavDesc.model.diagram.edit.parts.GeneralParamEditPart.VISUAL_ID:
			return getGeneralParam_2007ContainedLinks(view);
		case behavDesc.model.diagram.edit.parts.AgentEditPart.VISUAL_ID:
			return getAgent_2008ContainedLinks(view);
		case behavDesc.model.diagram.edit.parts.ObserverEditPart.VISUAL_ID:
			return getObserver_2010ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getIncomingLinks(View view) {
		switch (behavDesc.model.diagram.part.ModelVisualIDRegistry.getVisualID(view)) {
		case behavDesc.model.diagram.edit.parts.BehaviouralDescriptionEditPart.VISUAL_ID:
			return getBehaviouralDescription_2001IncomingLinks(view);
		case behavDesc.model.diagram.edit.parts.HappensEditPart.VISUAL_ID:
			return getHappens_2002IncomingLinks(view);
		case behavDesc.model.diagram.edit.parts.HoldsAtEditPart.VISUAL_ID:
			return getHoldsAt_2003IncomingLinks(view);
		case behavDesc.model.diagram.edit.parts.HoldsAtBetweenEditPart.VISUAL_ID:
			return getHoldsAtBetween_2004IncomingLinks(view);
		case behavDesc.model.diagram.edit.parts.AgentParamEditPart.VISUAL_ID:
			return getAgentParam_2005IncomingLinks(view);
		case behavDesc.model.diagram.edit.parts.ObserverParamEditPart.VISUAL_ID:
			return getObserverParam_2006IncomingLinks(view);
		case behavDesc.model.diagram.edit.parts.GeneralParamEditPart.VISUAL_ID:
			return getGeneralParam_2007IncomingLinks(view);
		case behavDesc.model.diagram.edit.parts.AgentEditPart.VISUAL_ID:
			return getAgent_2008IncomingLinks(view);
		case behavDesc.model.diagram.edit.parts.ObserverEditPart.VISUAL_ID:
			return getObserver_2010IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getOutgoingLinks(View view) {
		switch (behavDesc.model.diagram.part.ModelVisualIDRegistry.getVisualID(view)) {
		case behavDesc.model.diagram.edit.parts.BehaviouralDescriptionEditPart.VISUAL_ID:
			return getBehaviouralDescription_2001OutgoingLinks(view);
		case behavDesc.model.diagram.edit.parts.HappensEditPart.VISUAL_ID:
			return getHappens_2002OutgoingLinks(view);
		case behavDesc.model.diagram.edit.parts.HoldsAtEditPart.VISUAL_ID:
			return getHoldsAt_2003OutgoingLinks(view);
		case behavDesc.model.diagram.edit.parts.HoldsAtBetweenEditPart.VISUAL_ID:
			return getHoldsAtBetween_2004OutgoingLinks(view);
		case behavDesc.model.diagram.edit.parts.AgentParamEditPart.VISUAL_ID:
			return getAgentParam_2005OutgoingLinks(view);
		case behavDesc.model.diagram.edit.parts.ObserverParamEditPart.VISUAL_ID:
			return getObserverParam_2006OutgoingLinks(view);
		case behavDesc.model.diagram.edit.parts.GeneralParamEditPart.VISUAL_ID:
			return getGeneralParam_2007OutgoingLinks(view);
		case behavDesc.model.diagram.edit.parts.AgentEditPart.VISUAL_ID:
			return getAgent_2008OutgoingLinks(view);
		case behavDesc.model.diagram.edit.parts.ObserverEditPart.VISUAL_ID:
			return getObserver_2010OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getEnvironment_1000ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getBehaviouralDescription_2001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getHappens_2002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getHoldsAt_2003ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getHoldsAtBetween_2004ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getAgentParam_2005ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getObserverParam_2006ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getGeneralParam_2007ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getAgent_2008ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getObserver_2010ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getBehaviouralDescription_2001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getHappens_2002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getHoldsAt_2003IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getHoldsAtBetween_2004IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getAgentParam_2005IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getObserverParam_2006IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getGeneralParam_2007IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getAgent_2008IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getObserver_2010IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getBehaviouralDescription_2001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getHappens_2002OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getHoldsAt_2003OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getHoldsAtBetween_2004OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getAgentParam_2005OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getObserverParam_2006OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getGeneralParam_2007OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getAgent_2008OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<behavDesc.model.diagram.part.ModelLinkDescriptor> getObserver_2010OutgoingLinks(View view) {
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

		public List<behavDesc.model.diagram.part.ModelNodeDescriptor> getSemanticChildren(View view) {
			return ModelDiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<behavDesc.model.diagram.part.ModelLinkDescriptor> getContainedLinks(View view) {
			return ModelDiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<behavDesc.model.diagram.part.ModelLinkDescriptor> getIncomingLinks(View view) {
			return ModelDiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<behavDesc.model.diagram.part.ModelLinkDescriptor> getOutgoingLinks(View view) {
			return ModelDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
