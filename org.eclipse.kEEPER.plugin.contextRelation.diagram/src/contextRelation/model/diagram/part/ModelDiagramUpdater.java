package contextRelation.model.diagram.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

import model.ContextRelation;
import model.Environment;

/**
 * @generated
 */
public class ModelDiagramUpdater {

	/**
	* @generated
	*/
	public static List<contextRelation.model.diagram.part.ModelNodeDescriptor> getSemanticChildren(View view) {
		switch (contextRelation.model.diagram.part.ModelVisualIDRegistry.getVisualID(view)) {
		case contextRelation.model.diagram.edit.parts.EnvironmentEditPart.VISUAL_ID:
			return getEnvironment_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<contextRelation.model.diagram.part.ModelNodeDescriptor> getEnvironment_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Environment modelElement = (Environment) view.getElement();
		LinkedList<contextRelation.model.diagram.part.ModelNodeDescriptor> result = new LinkedList<contextRelation.model.diagram.part.ModelNodeDescriptor>();
		for (Iterator<?> it = modelElement.getContextRelations().iterator(); it.hasNext();) {
			ContextRelation childElement = (ContextRelation) it.next();
			int visualID = contextRelation.model.diagram.part.ModelVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == contextRelation.model.diagram.edit.parts.ContextRelationEditPart.VISUAL_ID) {
				result.add(new contextRelation.model.diagram.part.ModelNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<contextRelation.model.diagram.part.ModelLinkDescriptor> getContainedLinks(View view) {
		switch (contextRelation.model.diagram.part.ModelVisualIDRegistry.getVisualID(view)) {
		case contextRelation.model.diagram.edit.parts.EnvironmentEditPart.VISUAL_ID:
			return getEnvironment_1000ContainedLinks(view);
		case contextRelation.model.diagram.edit.parts.ContextRelationEditPart.VISUAL_ID:
			return getContextRelation_2001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<contextRelation.model.diagram.part.ModelLinkDescriptor> getIncomingLinks(View view) {
		switch (contextRelation.model.diagram.part.ModelVisualIDRegistry.getVisualID(view)) {
		case contextRelation.model.diagram.edit.parts.ContextRelationEditPart.VISUAL_ID:
			return getContextRelation_2001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<contextRelation.model.diagram.part.ModelLinkDescriptor> getOutgoingLinks(View view) {
		switch (contextRelation.model.diagram.part.ModelVisualIDRegistry.getVisualID(view)) {
		case contextRelation.model.diagram.edit.parts.ContextRelationEditPart.VISUAL_ID:
			return getContextRelation_2001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<contextRelation.model.diagram.part.ModelLinkDescriptor> getEnvironment_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<contextRelation.model.diagram.part.ModelLinkDescriptor> getContextRelation_2001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<contextRelation.model.diagram.part.ModelLinkDescriptor> getContextRelation_2001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<contextRelation.model.diagram.part.ModelLinkDescriptor> getContextRelation_2001OutgoingLinks(
			View view) {
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

		public List<contextRelation.model.diagram.part.ModelNodeDescriptor> getSemanticChildren(View view) {
			return ModelDiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<contextRelation.model.diagram.part.ModelLinkDescriptor> getContainedLinks(View view) {
			return ModelDiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<contextRelation.model.diagram.part.ModelLinkDescriptor> getIncomingLinks(View view) {
			return ModelDiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<contextRelation.model.diagram.part.ModelLinkDescriptor> getOutgoingLinks(View view) {
			return ModelDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
