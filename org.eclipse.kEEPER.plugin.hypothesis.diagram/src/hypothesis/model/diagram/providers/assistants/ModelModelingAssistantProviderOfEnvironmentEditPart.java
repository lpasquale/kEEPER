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
		List<IElementType> types = new ArrayList<IElementType>(9);
		types.add(ModelElementTypes.Hypothesis_2001);
		types.add(ModelElementTypes.Happens_2002);
		types.add(ModelElementTypes.HoldsAt_2003);
		types.add(ModelElementTypes.HoldsAtBetween_2004);
		types.add(ModelElementTypes.AgentParam_2005);
		types.add(ModelElementTypes.GeneralParam_2006);
		types.add(ModelElementTypes.ObserverParam_2007);
		types.add(ModelElementTypes.Agent_2008);
		types.add(ModelElementTypes.Observer_2009);
		return types;
	}

}
