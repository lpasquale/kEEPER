package contextRelation.model.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class ModelModelingAssistantProviderOfEnvironmentEditPart
		extends contextRelation.model.diagram.providers.ModelModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(contextRelation.model.diagram.providers.ModelElementTypes.ContextRelation_2001);
		types.add(contextRelation.model.diagram.providers.ModelElementTypes.Parameter_2002);
		return types;
	}

}
