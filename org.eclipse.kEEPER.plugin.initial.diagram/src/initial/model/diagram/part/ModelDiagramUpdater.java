package initial.model.diagram.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

import initial.model.diagram.edit.parts.EnvironmentEditPart;
import initial.model.diagram.edit.parts.InitiallyEditPart;
import model.Environment;
import model.Initially;

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
		for (Iterator<?> it = modelElement.getInitials().iterator(); it.hasNext();) {
			Initially childElement = (Initially) it.next();
			int visualID = ModelVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == InitiallyEditPart.VISUAL_ID) {
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
		case InitiallyEditPart.VISUAL_ID:
			return getInitially_2001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getIncomingLinks(View view) {
		switch (ModelVisualIDRegistry.getVisualID(view)) {
		case InitiallyEditPart.VISUAL_ID:
			return getInitially_2001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ModelLinkDescriptor> getOutgoingLinks(View view) {
		switch (ModelVisualIDRegistry.getVisualID(view)) {
		case InitiallyEditPart.VISUAL_ID:
			return getInitially_2001OutgoingLinks(view);
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
	public static List<ModelLinkDescriptor> getInitially_2001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getInitially_2001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ModelLinkDescriptor> getInitially_2001OutgoingLinks(View view) {
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
