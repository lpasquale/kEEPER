package behavDesc.model.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

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
			switch (behavDesc.model.diagram.part.ModelVisualIDRegistry.getVisualID(view)) {

			case behavDesc.model.diagram.edit.parts.EnvironmentEditPart.VISUAL_ID:
				return new behavDesc.model.diagram.edit.parts.EnvironmentEditPart(view);

			case behavDesc.model.diagram.edit.parts.BehaviouralDescriptionEditPart.VISUAL_ID:
				return new behavDesc.model.diagram.edit.parts.BehaviouralDescriptionEditPart(view);

			case behavDesc.model.diagram.edit.parts.HappensEditPart.VISUAL_ID:
				return new behavDesc.model.diagram.edit.parts.HappensEditPart(view);

			case behavDesc.model.diagram.edit.parts.HoldsAtEditPart.VISUAL_ID:
				return new behavDesc.model.diagram.edit.parts.HoldsAtEditPart(view);

			case behavDesc.model.diagram.edit.parts.HoldsAtBetweenEditPart.VISUAL_ID:
				return new behavDesc.model.diagram.edit.parts.HoldsAtBetweenEditPart(view);
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
