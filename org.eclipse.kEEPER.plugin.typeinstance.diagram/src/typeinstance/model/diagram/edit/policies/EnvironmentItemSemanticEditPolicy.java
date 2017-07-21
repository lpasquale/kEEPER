package typeinstance.model.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import typeinstance.model.diagram.edit.commands.AgentCreateCommand;
import typeinstance.model.diagram.edit.commands.InstanceCreateCommand;
import typeinstance.model.diagram.edit.commands.ObserverCreateCommand;
import typeinstance.model.diagram.edit.commands.TypeCreateCommand;
import typeinstance.model.diagram.providers.ModelElementTypes;

/**
 * @generated
 */
public class EnvironmentItemSemanticEditPolicy extends ModelBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public EnvironmentItemSemanticEditPolicy() {
		super(ModelElementTypes.Environment_1000);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (ModelElementTypes.Instance_2005 == req.getElementType()) {
			return getGEFWrapper(new InstanceCreateCommand(req));
		}
		if (ModelElementTypes.Agent_2009 == req.getElementType()) {
			return getGEFWrapper(new AgentCreateCommand(req));
		}
		if (ModelElementTypes.Observer_2010 == req.getElementType()) {
			return getGEFWrapper(new ObserverCreateCommand(req));
		}
		if (ModelElementTypes.Type_2012 == req.getElementType()) {
			return getGEFWrapper(new TypeCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	* @generated
	*/
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	* @generated
	*/
	private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

		/**
		* @generated
		*/
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
		}

	}

}
