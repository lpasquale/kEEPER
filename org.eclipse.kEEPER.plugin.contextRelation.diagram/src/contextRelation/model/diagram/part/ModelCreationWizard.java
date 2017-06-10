package contextRelation.model.diagram.part;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * @generated
 */
public class ModelCreationWizard extends Wizard implements INewWizard {

	/**
	* @generated
	*/
	private IWorkbench workbench;

	/**
	* @generated
	*/
	protected IStructuredSelection selection;

	/**
	* @generated
	*/
	protected contextRelation.model.diagram.part.ModelCreationWizardPage diagramModelFilePage;

	/**
	* @generated
	*/
	protected contextRelation.model.diagram.part.ModelCreationWizardPage domainModelFilePage;

	/**
	* @generated
	*/
	protected Resource diagram;

	/**
	* @generated
	*/
	private boolean openNewlyCreatedDiagramEditor = true;

	/**
	* @generated
	*/
	public IWorkbench getWorkbench() {
		return workbench;
	}

	/**
	* @generated
	*/
	public IStructuredSelection getSelection() {
		return selection;
	}

	/**
	* @generated
	*/
	public final Resource getDiagram() {
		return diagram;
	}

	/**
	* @generated
	*/
	public final boolean isOpenNewlyCreatedDiagramEditor() {
		return openNewlyCreatedDiagramEditor;
	}

	/**
	* @generated
	*/
	public void setOpenNewlyCreatedDiagramEditor(boolean openNewlyCreatedDiagramEditor) {
		this.openNewlyCreatedDiagramEditor = openNewlyCreatedDiagramEditor;
	}

	/**
	* @generated
	*/
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(contextRelation.model.diagram.part.Messages.ModelCreationWizardTitle);
		setDefaultPageImageDescriptor(contextRelation.model.diagram.part.ModelDiagramEditorPlugin
				.getBundledImageDescriptor("icons/wizban/NewModelWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	/**
	* @generated
	*/
	public void addPages() {
		diagramModelFilePage = new contextRelation.model.diagram.part.ModelCreationWizardPage("DiagramModelFile", //$NON-NLS-1$
				getSelection(), "contextRelationmodel_diagram"); //$NON-NLS-1$
		diagramModelFilePage
				.setTitle(contextRelation.model.diagram.part.Messages.ModelCreationWizard_DiagramModelFilePageTitle);
		diagramModelFilePage.setDescription(
				contextRelation.model.diagram.part.Messages.ModelCreationWizard_DiagramModelFilePageDescription);
		addPage(diagramModelFilePage);

		domainModelFilePage = new contextRelation.model.diagram.part.ModelCreationWizardPage("DomainModelFile", //$NON-NLS-1$
				getSelection(), "contextRelationmodel") { //$NON-NLS-1$

			public void setVisible(boolean visible) {
				if (visible) {
					String fileName = diagramModelFilePage.getFileName();
					fileName = fileName.substring(0, fileName.length() - ".contextRelationmodel_diagram".length()); //$NON-NLS-1$
					setFileName(contextRelation.model.diagram.part.ModelDiagramEditorUtil
							.getUniqueFileName(getContainerFullPath(), fileName, "contextRelationmodel")); //$NON-NLS-1$
				}
				super.setVisible(visible);
			}
		};
		domainModelFilePage
				.setTitle(contextRelation.model.diagram.part.Messages.ModelCreationWizard_DomainModelFilePageTitle);
		domainModelFilePage.setDescription(
				contextRelation.model.diagram.part.Messages.ModelCreationWizard_DomainModelFilePageDescription);
		addPage(domainModelFilePage);
	}

	/**
	* @generated
	*/
	public boolean performFinish() {
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {

			protected void execute(IProgressMonitor monitor) throws CoreException, InterruptedException {
				diagram = contextRelation.model.diagram.part.ModelDiagramEditorUtil
						.createDiagram(diagramModelFilePage.getURI(), domainModelFilePage.getURI(), monitor);
				if (isOpenNewlyCreatedDiagramEditor() && diagram != null) {
					try {
						contextRelation.model.diagram.part.ModelDiagramEditorUtil.openDiagram(diagram);
					} catch (PartInitException e) {
						ErrorDialog.openError(getContainer().getShell(),
								contextRelation.model.diagram.part.Messages.ModelCreationWizardOpenEditorError, null,
								e.getStatus());
					}
				}
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				ErrorDialog.openError(getContainer().getShell(),
						contextRelation.model.diagram.part.Messages.ModelCreationWizardCreationError, null,
						((CoreException) e.getTargetException()).getStatus());
			} else {
				contextRelation.model.diagram.part.ModelDiagramEditorPlugin.getInstance()
						.logError("Error creating diagram", e.getTargetException()); //$NON-NLS-1$
			}
			return false;
		}
		return diagram != null;
	}
}
