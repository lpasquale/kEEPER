package event.model.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import event.model.diagram.providers.ModelElementTypes;
import event.model.diagram.providers.ModelModelingAssistantProvider;

/**
 * @generated
 */
public class ModelModelingAssistantProviderOfEnvironmentEditPart extends ModelModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(ModelElementTypes.PrimitiveEvent_2005);
		types.add(ModelElementTypes.Agent_2007);
		types.add(ModelElementTypes.Observer_2008);
		types.add(ModelElementTypes.Parameter_2009);
		types.add(ModelElementTypes.ComplexEvent_2010);
		return types;
	}

}
