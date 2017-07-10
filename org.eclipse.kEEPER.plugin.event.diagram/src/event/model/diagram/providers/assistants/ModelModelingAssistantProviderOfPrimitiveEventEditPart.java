package event.model.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import event.model.diagram.edit.parts.AgentReferenceEditPart;
import event.model.diagram.edit.parts.GeneralTypeReferenceEditPart;
import event.model.diagram.edit.parts.ObserverReferenceEditPart;
import event.model.diagram.edit.parts.PrimitiveEventEditPart;
import event.model.diagram.providers.ModelElementTypes;
import event.model.diagram.providers.ModelModelingAssistantProvider;

/**
 * @generated
 */
public class ModelModelingAssistantProviderOfPrimitiveEventEditPart extends ModelModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((PrimitiveEventEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(PrimitiveEventEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ModelElementTypes.PrimitiveEventAgent_4001);
		types.add(ModelElementTypes.EventTypes_4005);
		types.add(ModelElementTypes.PrimitiveEventObserver_4002);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((PrimitiveEventEditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(PrimitiveEventEditPart source,
			IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof AgentReferenceEditPart) {
			types.add(ModelElementTypes.PrimitiveEventAgent_4001);
		}
		if (targetEditPart instanceof GeneralTypeReferenceEditPart) {
			types.add(ModelElementTypes.EventTypes_4005);
		}
		if (targetEditPart instanceof ObserverReferenceEditPart) {
			types.add(ModelElementTypes.PrimitiveEventObserver_4002);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((PrimitiveEventEditPart) sourceEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(PrimitiveEventEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == ModelElementTypes.PrimitiveEventAgent_4001) {
			types.add(ModelElementTypes.AgentReference_2016);
		} else if (relationshipType == ModelElementTypes.EventTypes_4005) {
			types.add(ModelElementTypes.GeneralTypeReference_2018);
		} else if (relationshipType == ModelElementTypes.PrimitiveEventObserver_4002) {
			types.add(ModelElementTypes.ObserverReference_2017);
		}
		return types;
	}

}
