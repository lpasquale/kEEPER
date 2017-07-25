package initial.model.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import initial.model.diagram.edit.commands.ContextRelationCreateCommand;
import initial.model.diagram.edit.commands.InstanceCreateCommand;
import initial.model.diagram.providers.ModelElementTypes;

/**
 * @generated
 */
public class InitiallyInstancesNameCompartment2ItemSemanticEditPolicy extends ModelBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public InitiallyInstancesNameCompartment2ItemSemanticEditPolicy() {
		super(ModelElementTypes.Initially_2001);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (ModelElementTypes.Instance_3002 == req.getElementType()) {
			return getGEFWrapper(new InstanceCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
