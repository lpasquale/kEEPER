package typeinstance.model.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import typeinstance.model.diagram.edit.parts.AgentEditPart;
import typeinstance.model.diagram.edit.parts.GeneralTypeEditPart;
import typeinstance.model.diagram.edit.parts.InstanceEditPart;
import typeinstance.model.diagram.edit.parts.ObserverEditPart;
import typeinstance.model.diagram.providers.ModelElementTypes;
import typeinstance.model.diagram.providers.ModelModelingAssistantProvider;

/**
 * @generated
 */
public class ModelModelingAssistantProviderOfInstanceEditPart extends ModelModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((InstanceEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(InstanceEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(ModelElementTypes.InstanceType_4003);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((InstanceEditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(InstanceEditPart source,
			IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof GeneralTypeEditPart) {
			types.add(ModelElementTypes.InstanceType_4003);
		}
		if (targetEditPart instanceof AgentEditPart) {
			types.add(ModelElementTypes.InstanceType_4003);
		}
		if (targetEditPart instanceof ObserverEditPart) {
			types.add(ModelElementTypes.InstanceType_4003);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((InstanceEditPart) sourceEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(InstanceEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == ModelElementTypes.InstanceType_4003) {
			types.add(ModelElementTypes.GeneralType_2011);
			types.add(ModelElementTypes.Agent_2009);
			types.add(ModelElementTypes.Observer_2010);
		}
		return types;
	}

}
