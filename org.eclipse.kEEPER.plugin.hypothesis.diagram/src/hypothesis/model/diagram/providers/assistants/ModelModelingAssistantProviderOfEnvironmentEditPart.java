package hypothesis.model.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import hypothesis.model.diagram.providers.ModelElementTypes;
import hypothesis.model.diagram.providers.ModelModelingAssistantProvider;

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
		types.add(ModelElementTypes.Hypothesis_2001);
		types.add(ModelElementTypes.Happens_2002);
		types.add(ModelElementTypes.HoldsAt_2003);
		types.add(ModelElementTypes.HoldsAtBetween_2004);
		return types;
	}

}
