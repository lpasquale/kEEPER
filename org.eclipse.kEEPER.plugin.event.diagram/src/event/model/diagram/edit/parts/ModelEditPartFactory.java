package event.model.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

import event.model.diagram.part.ModelVisualIDRegistry;

/**
 * @generated
 */
public class ModelEditPartFactory implements EditPartFactory {

	/**
	* @generated
	*/
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (ModelVisualIDRegistry.getVisualID(view)) {

			case EnvironmentEditPart.VISUAL_ID:
				return new EnvironmentEditPart(view);

			case PrimitiveEventEditPart.VISUAL_ID:
				return new PrimitiveEventEditPart(view);

			case PrimitiveEventNameEditPart.VISUAL_ID:
				return new PrimitiveEventNameEditPart(view);

			case AgentEditPart.VISUAL_ID:
				return new AgentEditPart(view);

			case AgentNameEditPart.VISUAL_ID:
				return new AgentNameEditPart(view);

			case ObserverEditPart.VISUAL_ID:
				return new ObserverEditPart(view);

			case ObserverNameEditPart.VISUAL_ID:
				return new ObserverNameEditPart(view);

			case ParameterEditPart.VISUAL_ID:
				return new ParameterEditPart(view);

			case ParameterNameEditPart.VISUAL_ID:
				return new ParameterNameEditPart(view);

			case ComplexEventEditPart.VISUAL_ID:
				return new ComplexEventEditPart(view);

			case ComplexEventNameEditPart.VISUAL_ID:
				return new ComplexEventNameEditPart(view);

			case PrimitiveEventAgentEditPart.VISUAL_ID:
				return new PrimitiveEventAgentEditPart(view);

			case ComplexEventAgentEditPart.VISUAL_ID:
				return new ComplexEventAgentEditPart(view);

			case EventParametersEditPart.VISUAL_ID:
				return new EventParametersEditPart(view);

			case PrimitiveEventObserverEditPart.VISUAL_ID:
				return new PrimitiveEventObserverEditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	* @generated
	*/
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	* @generated
	*/
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);
	}

}
