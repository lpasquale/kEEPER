package contextRelation.model.diagram.edit.parts;

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
			switch (contextRelation.model.diagram.part.ModelVisualIDRegistry.getVisualID(view)) {

			case contextRelation.model.diagram.edit.parts.EnvironmentEditPart.VISUAL_ID:
				return new contextRelation.model.diagram.edit.parts.EnvironmentEditPart(view);

			case contextRelation.model.diagram.edit.parts.ContextRelationEditPart.VISUAL_ID:
				return new contextRelation.model.diagram.edit.parts.ContextRelationEditPart(view);

			case contextRelation.model.diagram.edit.parts.ContextRelationNameEditPart.VISUAL_ID:
				return new contextRelation.model.diagram.edit.parts.ContextRelationNameEditPart(view);

			case contextRelation.model.diagram.edit.parts.ParameterEditPart.VISUAL_ID:
				return new contextRelation.model.diagram.edit.parts.ParameterEditPart(view);

			case contextRelation.model.diagram.edit.parts.ParameterNameEditPart.VISUAL_ID:
				return new contextRelation.model.diagram.edit.parts.ParameterNameEditPart(view);

			case contextRelation.model.diagram.edit.parts.ContextRelationParametersEditPart.VISUAL_ID:
				return new contextRelation.model.diagram.edit.parts.ContextRelationParametersEditPart(view);

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
