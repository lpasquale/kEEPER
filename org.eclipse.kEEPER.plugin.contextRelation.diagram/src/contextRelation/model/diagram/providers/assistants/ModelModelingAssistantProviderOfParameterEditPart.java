package contextRelation.model.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class ModelModelingAssistantProviderOfParameterEditPart
		extends contextRelation.model.diagram.providers.ModelModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((contextRelation.model.diagram.edit.parts.ParameterEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(contextRelation.model.diagram.edit.parts.ParameterEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(contextRelation.model.diagram.providers.ModelElementTypes.ContextRelationParameters_4001);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((contextRelation.model.diagram.edit.parts.ParameterEditPart) targetEditPart,
				relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(contextRelation.model.diagram.edit.parts.ParameterEditPart target,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == contextRelation.model.diagram.providers.ModelElementTypes.ContextRelationParameters_4001) {
			types.add(contextRelation.model.diagram.providers.ModelElementTypes.ContextRelation_2001);
		}
		return types;
	}

}
