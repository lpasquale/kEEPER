package event.model.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

import event.model.diagram.edit.parts.AgentEditPart;
import event.model.diagram.edit.parts.AgentNameEditPart;
import event.model.diagram.edit.parts.ComplexEventEditPart;
import event.model.diagram.edit.parts.ComplexEventNameEditPart;
import event.model.diagram.edit.parts.EnvironmentEditPart;
import event.model.diagram.edit.parts.ObserverEditPart;
import event.model.diagram.edit.parts.ObserverNameEditPart;
import event.model.diagram.edit.parts.ParameterEditPart;
import event.model.diagram.edit.parts.ParameterNameEditPart;
import event.model.diagram.edit.parts.PrimitiveEventEditPart;
import event.model.diagram.edit.parts.PrimitiveEventNameEditPart;
import model.Environment;
import model.ModelPackage;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class ModelVisualIDRegistry {

	/**
	* @generated
	*/
	private static final String DEBUG_KEY = "org.eclipse.kEEPER.plugin.event.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	* @generated
	*/
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (EnvironmentEditPart.MODEL_ID.equals(view.getType())) {
				return EnvironmentEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return event.model.diagram.part.ModelVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	* @generated
	*/
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	* @generated
	*/
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				ModelDiagramEditorPlugin.getInstance()
						.logError("Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	* @generated
	*/
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (ModelPackage.eINSTANCE.getEnvironment().isSuperTypeOf(domainElement.eClass())
				&& isDiagram((Environment) domainElement)) {
			return EnvironmentEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = event.model.diagram.part.ModelVisualIDRegistry.getModelID(containerView);
		if (!EnvironmentEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (EnvironmentEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = event.model.diagram.part.ModelVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = EnvironmentEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case EnvironmentEditPart.VISUAL_ID:
			if (ModelPackage.eINSTANCE.getPrimitiveEvent().isSuperTypeOf(domainElement.eClass())) {
				return PrimitiveEventEditPart.VISUAL_ID;
			}
			if (ModelPackage.eINSTANCE.getAgent().isSuperTypeOf(domainElement.eClass())) {
				return AgentEditPart.VISUAL_ID;
			}
			if (ModelPackage.eINSTANCE.getObserver().isSuperTypeOf(domainElement.eClass())) {
				return ObserverEditPart.VISUAL_ID;
			}
			if (ModelPackage.eINSTANCE.getParameter().isSuperTypeOf(domainElement.eClass())) {
				return ParameterEditPart.VISUAL_ID;
			}
			if (ModelPackage.eINSTANCE.getComplexEvent().isSuperTypeOf(domainElement.eClass())) {
				return ComplexEventEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = event.model.diagram.part.ModelVisualIDRegistry.getModelID(containerView);
		if (!EnvironmentEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (EnvironmentEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = event.model.diagram.part.ModelVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = EnvironmentEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case EnvironmentEditPart.VISUAL_ID:
			if (PrimitiveEventEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AgentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ObserverEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ParameterEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComplexEventEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PrimitiveEventEditPart.VISUAL_ID:
			if (PrimitiveEventNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AgentEditPart.VISUAL_ID:
			if (AgentNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ObserverEditPart.VISUAL_ID:
			if (ObserverNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ParameterEditPart.VISUAL_ID:
			if (ParameterNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComplexEventEditPart.VISUAL_ID:
			if (ComplexEventNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	* @generated
	*/
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		return -1;
	}

	/**
	* User can change implementation of this method to handle some specific
	* situations not covered by default logic.
	* 
	* @generated
	*/
	private static boolean isDiagram(Environment element) {
		return true;
	}

	/**
	* @generated
	*/
	public static boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	* @generated
	*/
	public static boolean isCompartmentVisualID(int visualID) {
		return false;
	}

	/**
	* @generated
	*/
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case EnvironmentEditPart.VISUAL_ID:
			return false;
		case PrimitiveEventEditPart.VISUAL_ID:
		case AgentEditPart.VISUAL_ID:
		case ObserverEditPart.VISUAL_ID:
		case ParameterEditPart.VISUAL_ID:
		case ComplexEventEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	* @generated
	*/
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		* @generated
		*/
		@Override

		public int getVisualID(View view) {
			return event.model.diagram.part.ModelVisualIDRegistry.getVisualID(view);
		}

		/**
		* @generated
		*/
		@Override

		public String getModelID(View view) {
			return event.model.diagram.part.ModelVisualIDRegistry.getModelID(view);
		}

		/**
		* @generated
		*/
		@Override

		public int getNodeVisualID(View containerView, EObject domainElement) {
			return event.model.diagram.part.ModelVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		}

		/**
		* @generated
		*/
		@Override

		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return event.model.diagram.part.ModelVisualIDRegistry.checkNodeVisualID(containerView, domainElement,
					candidate);
		}

		/**
		* @generated
		*/
		@Override

		public boolean isCompartmentVisualID(int visualID) {
			return event.model.diagram.part.ModelVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public boolean isSemanticLeafVisualID(int visualID) {
			return event.model.diagram.part.ModelVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}
	};

}
