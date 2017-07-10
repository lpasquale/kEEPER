package typeinstance.model.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import typeinstance.model.diagram.providers.ModelElementTypes;
import typeinstance.model.diagram.providers.ModelModelingAssistantProvider;

/**
 * @generated
 */
public class ModelModelingAssistantProviderOfEnvironmentEditPart extends ModelModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(ModelElementTypes.Instance_2005);
		types.add(ModelElementTypes.GeneralType_2011);
		types.add(ModelElementTypes.Agent_2009);
		types.add(ModelElementTypes.Observer_2010);
		return types;
	}

}
