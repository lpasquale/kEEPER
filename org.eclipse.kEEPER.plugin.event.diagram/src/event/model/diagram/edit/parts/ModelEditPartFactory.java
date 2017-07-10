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

			case AgentReferenceEditPart.VISUAL_ID:
				return new AgentReferenceEditPart(view);

			case AgentReferenceTypeNameEditPart.VISUAL_ID:
				return new AgentReferenceTypeNameEditPart(view);

			case ObserverReferenceEditPart.VISUAL_ID:
				return new ObserverReferenceEditPart(view);

			case ObserverReferenceTypeNameEditPart.VISUAL_ID:
				return new ObserverReferenceTypeNameEditPart(view);

			case GeneralTypeReferenceEditPart.VISUAL_ID:
				return new GeneralTypeReferenceEditPart(view);

			case GeneralTypeReferenceTypeNameEditPart.VISUAL_ID:
				return new GeneralTypeReferenceTypeNameEditPart(view);

			case ComplexEventEditPart.VISUAL_ID:
				return new ComplexEventEditPart(view);

			case ComplexEventNameEditPart.VISUAL_ID:
				return new ComplexEventNameEditPart(view);

			case PrimitiveEventAgentEditPart.VISUAL_ID:
				return new PrimitiveEventAgentEditPart(view);

			case ComplexEventAgentEditPart.VISUAL_ID:
				return new ComplexEventAgentEditPart(view);

			case EventTypesEditPart.VISUAL_ID:
				return new EventTypesEditPart(view);

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
