package event.model.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import event.model.diagram.edit.commands.AgentReferenceCreateCommand;
import event.model.diagram.edit.commands.ComplexEventCreateCommand;
import event.model.diagram.edit.commands.GeneralTypeReferenceCreateCommand;
import event.model.diagram.edit.commands.ObserverReferenceCreateCommand;
import event.model.diagram.edit.commands.PrimitiveEventCreateCommand;
import event.model.diagram.providers.ModelElementTypes;

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
		if (ModelElementTypes.PrimitiveEvent_2011 == req.getElementType()) {
			return getGEFWrapper(new PrimitiveEventCreateCommand(req));
		}
		if (ModelElementTypes.AgentReference_2016 == req.getElementType()) {
			return getGEFWrapper(new AgentReferenceCreateCommand(req));
		}
		if (ModelElementTypes.ObserverReference_2017 == req.getElementType()) {
			return getGEFWrapper(new ObserverReferenceCreateCommand(req));
		}
		if (ModelElementTypes.GeneralTypeReference_2018 == req.getElementType()) {
			return getGEFWrapper(new GeneralTypeReferenceCreateCommand(req));
		}
		if (ModelElementTypes.ComplexEvent_2012 == req.getElementType()) {
			return getGEFWrapper(new ComplexEventCreateCommand(req));
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
