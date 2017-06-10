package contextRelation.model.diagram.part;

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

import model.ContextRelation;
import model.Environment;
import model.ModelPackage;
import model.Parameter;

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
		for (Iterator<?> it = modelElement.getParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter) it.next();
			int visualID = contextRelation.model.diagram.part.ModelVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == contextRelation.model.diagram.edit.parts.ParameterEditPart.VISUAL_ID) {
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
		case contextRelation.model.diagram.edit.parts.ParameterEditPart.VISUAL_ID:
			return getParameter_2002ContainedLinks(view);
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
		case contextRelation.model.diagram.edit.parts.ParameterEditPart.VISUAL_ID:
			return getParameter_2002IncomingLinks(view);
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
		case contextRelation.model.diagram.edit.parts.ParameterEditPart.VISUAL_ID:
			return getParameter_2002OutgoingLinks(view);
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
		ContextRelation modelElement = (ContextRelation) view.getElement();
		LinkedList<contextRelation.model.diagram.part.ModelLinkDescriptor> result = new LinkedList<contextRelation.model.diagram.part.ModelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ContextRelation_Parameters_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<contextRelation.model.diagram.part.ModelLinkDescriptor> getParameter_2002ContainedLinks(
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
	public static List<contextRelation.model.diagram.part.ModelLinkDescriptor> getParameter_2002IncomingLinks(
			View view) {
		Parameter modelElement = (Parameter) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<contextRelation.model.diagram.part.ModelLinkDescriptor> result = new LinkedList<contextRelation.model.diagram.part.ModelLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ContextRelation_Parameters_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<contextRelation.model.diagram.part.ModelLinkDescriptor> getContextRelation_2001OutgoingLinks(
			View view) {
		ContextRelation modelElement = (ContextRelation) view.getElement();
		LinkedList<contextRelation.model.diagram.part.ModelLinkDescriptor> result = new LinkedList<contextRelation.model.diagram.part.ModelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ContextRelation_Parameters_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<contextRelation.model.diagram.part.ModelLinkDescriptor> getParameter_2002OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	private static Collection<contextRelation.model.diagram.part.ModelLinkDescriptor> getIncomingFeatureModelFacetLinks_ContextRelation_Parameters_4001(
			Parameter target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<contextRelation.model.diagram.part.ModelLinkDescriptor> result = new LinkedList<contextRelation.model.diagram.part.ModelLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == ModelPackage.eINSTANCE.getContextRelation_Parameters()) {
				result.add(new contextRelation.model.diagram.part.ModelLinkDescriptor(setting.getEObject(), target,
						contextRelation.model.diagram.providers.ModelElementTypes.ContextRelationParameters_4001,
						contextRelation.model.diagram.edit.parts.ContextRelationParametersEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<contextRelation.model.diagram.part.ModelLinkDescriptor> getOutgoingFeatureModelFacetLinks_ContextRelation_Parameters_4001(
			ContextRelation source) {
		LinkedList<contextRelation.model.diagram.part.ModelLinkDescriptor> result = new LinkedList<contextRelation.model.diagram.part.ModelLinkDescriptor>();
		for (Iterator<?> destinations = source.getParameters().iterator(); destinations.hasNext();) {
			Parameter destination = (Parameter) destinations.next();
			result.add(new contextRelation.model.diagram.part.ModelLinkDescriptor(source, destination,
					contextRelation.model.diagram.providers.ModelElementTypes.ContextRelationParameters_4001,
					contextRelation.model.diagram.edit.parts.ContextRelationParametersEditPart.VISUAL_ID));
		}
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
