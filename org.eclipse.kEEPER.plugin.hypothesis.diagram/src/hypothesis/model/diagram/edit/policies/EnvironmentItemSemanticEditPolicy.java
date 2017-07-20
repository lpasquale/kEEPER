package hypothesis.model.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import hypothesis.model.diagram.edit.commands.AgentCreateCommand;
import hypothesis.model.diagram.edit.commands.AgentParamCreateCommand;
import hypothesis.model.diagram.edit.commands.GeneralParamCreateCommand;
import hypothesis.model.diagram.edit.commands.GeneralTypeCreateCommand;
import hypothesis.model.diagram.edit.commands.HappensCreateCommand;
import hypothesis.model.diagram.edit.commands.HoldsAtBetweenCreateCommand;
import hypothesis.model.diagram.edit.commands.HoldsAtCreateCommand;
import hypothesis.model.diagram.edit.commands.HypothesisCreateCommand;
import hypothesis.model.diagram.edit.commands.ObserverCreateCommand;
import hypothesis.model.diagram.edit.commands.ObserverParamCreateCommand;
import hypothesis.model.diagram.providers.ModelElementTypes;

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
		if (ModelElementTypes.Hypothesis_2001 == req.getElementType()) {
			return getGEFWrapper(new HypothesisCreateCommand(req));
		}
		if (ModelElementTypes.Happens_2002 == req.getElementType()) {
			return getGEFWrapper(new HappensCreateCommand(req));
		}
		if (ModelElementTypes.HoldsAt_2003 == req.getElementType()) {
			return getGEFWrapper(new HoldsAtCreateCommand(req));
		}
		if (ModelElementTypes.HoldsAtBetween_2004 == req.getElementType()) {
			return getGEFWrapper(new HoldsAtBetweenCreateCommand(req));
		}
		if (ModelElementTypes.AgentParam_2005 == req.getElementType()) {
			return getGEFWrapper(new AgentParamCreateCommand(req));
		}
		if (ModelElementTypes.GeneralParam_2006 == req.getElementType()) {
			return getGEFWrapper(new GeneralParamCreateCommand(req));
		}
		if (ModelElementTypes.ObserverParam_2007 == req.getElementType()) {
			return getGEFWrapper(new ObserverParamCreateCommand(req));
		}
		if (ModelElementTypes.Agent_2008 == req.getElementType()) {
			return getGEFWrapper(new AgentCreateCommand(req));
		}
		if (ModelElementTypes.Observer_2009 == req.getElementType()) {
			return getGEFWrapper(new ObserverCreateCommand(req));
		}
		if (ModelElementTypes.GeneralType_2010 == req.getElementType()) {
			return getGEFWrapper(new GeneralTypeCreateCommand(req));
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
