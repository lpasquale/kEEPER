package event.model.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import event.model.diagram.edit.parts.AgentReferenceEditPart;
import event.model.diagram.edit.parts.ComplexEventEditPart;
import event.model.diagram.edit.parts.GeneralTypeReferenceEditPart;
import event.model.diagram.providers.ModelElementTypes;
import event.model.diagram.providers.ModelModelingAssistantProvider;

/**
 * @generated
 */
public class ModelModelingAssistantProviderOfComplexEventEditPart extends ModelModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((ComplexEventEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(ComplexEventEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ModelElementTypes.ComplexEventAgent_4004);
		types.add(ModelElementTypes.EventTypes_4005);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((ComplexEventEditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(ComplexEventEditPart source,
			IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof AgentReferenceEditPart) {
			types.add(ModelElementTypes.ComplexEventAgent_4004);
		}
		if (targetEditPart instanceof GeneralTypeReferenceEditPart) {
			types.add(ModelElementTypes.EventTypes_4005);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((ComplexEventEditPart) sourceEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(ComplexEventEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == ModelElementTypes.ComplexEventAgent_4004) {
			types.add(ModelElementTypes.AgentReference_2016);
		} else if (relationshipType == ModelElementTypes.EventTypes_4005) {
			types.add(ModelElementTypes.GeneralTypeReference_2018);
		}
		return types;
	}

}
