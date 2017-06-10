package contextRelation.model.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class ModelModelingAssistantProviderOfContextRelationEditPart
		extends contextRelation.model.diagram.providers.ModelModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((contextRelation.model.diagram.edit.parts.ContextRelationEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(
			contextRelation.model.diagram.edit.parts.ContextRelationEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(contextRelation.model.diagram.providers.ModelElementTypes.ContextRelationParameters_4001);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget(
				(contextRelation.model.diagram.edit.parts.ContextRelationEditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			contextRelation.model.diagram.edit.parts.ContextRelationEditPart source,
			IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof contextRelation.model.diagram.edit.parts.ParameterEditPart) {
			types.add(contextRelation.model.diagram.providers.ModelElementTypes.ContextRelationParameters_4001);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((contextRelation.model.diagram.edit.parts.ContextRelationEditPart) sourceEditPart,
				relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(
			contextRelation.model.diagram.edit.parts.ContextRelationEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == contextRelation.model.diagram.providers.ModelElementTypes.ContextRelationParameters_4001) {
			types.add(contextRelation.model.diagram.providers.ModelElementTypes.Parameter_2002);
		}
		return types;
	}

}
