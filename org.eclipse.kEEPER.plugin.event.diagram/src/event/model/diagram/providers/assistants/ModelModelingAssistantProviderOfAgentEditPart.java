package event.model.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import event.model.diagram.edit.parts.AgentEditPart;
import event.model.diagram.providers.ModelElementTypes;
import event.model.diagram.providers.ModelModelingAssistantProvider;

/**
 * @generated
 */
public class ModelModelingAssistantProviderOfAgentEditPart extends ModelModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((AgentEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(AgentEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ModelElementTypes.PrimitiveEventAgent_4001);
		types.add(ModelElementTypes.ComplexEventAgent_4004);
		types.add(ModelElementTypes.EventParameters_4003);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((AgentEditPart) targetEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(AgentEditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == ModelElementTypes.PrimitiveEventAgent_4001) {
			types.add(ModelElementTypes.PrimitiveEvent_2005);
		} else if (relationshipType == ModelElementTypes.ComplexEventAgent_4004) {
			types.add(ModelElementTypes.ComplexEvent_2010);
		} else if (relationshipType == ModelElementTypes.EventParameters_4003) {
			types.add(ModelElementTypes.PrimitiveEvent_2005);
			types.add(ModelElementTypes.ComplexEvent_2010);
		}
		return types;
	}

}
