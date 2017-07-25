package initial.model.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import initial.model.diagram.edit.commands.ContextRelationCreateCommand;
import initial.model.diagram.edit.commands.Instance2CreateCommand;
import initial.model.diagram.edit.commands.InstanceCreateCommand;
import initial.model.diagram.providers.ModelElementTypes;

/**
 * @generated
 */
public class InitiallyInstancesNameCompartmentItemSemanticEditPolicy extends ModelBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public InitiallyInstancesNameCompartmentItemSemanticEditPolicy() {
		super(ModelElementTypes.Initially_2001);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (ModelElementTypes.ContextRelation_3003 == req.getElementType()) {
			return getGEFWrapper(new ContextRelationCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
