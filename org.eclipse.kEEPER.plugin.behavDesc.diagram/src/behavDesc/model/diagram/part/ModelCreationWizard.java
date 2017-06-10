package behavDesc.model.diagram.part;

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
	protected behavDesc.model.diagram.part.ModelCreationWizardPage diagramModelFilePage;

	/**
	* @generated
	*/
	protected behavDesc.model.diagram.part.ModelCreationWizardPage domainModelFilePage;

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
		setWindowTitle(behavDesc.model.diagram.part.Messages.ModelCreationWizardTitle);
		setDefaultPageImageDescriptor(behavDesc.model.diagram.part.ModelDiagramEditorPlugin
				.getBundledImageDescriptor("icons/wizban/NewModelWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	/**
	* @generated
	*/
	public void addPages() {
		diagramModelFilePage = new behavDesc.model.diagram.part.ModelCreationWizardPage("DiagramModelFile", //$NON-NLS-1$
				getSelection(), "bdModel_diagram"); //$NON-NLS-1$
		diagramModelFilePage
				.setTitle(behavDesc.model.diagram.part.Messages.ModelCreationWizard_DiagramModelFilePageTitle);
		diagramModelFilePage.setDescription(
				behavDesc.model.diagram.part.Messages.ModelCreationWizard_DiagramModelFilePageDescription);
		addPage(diagramModelFilePage);

		domainModelFilePage = new behavDesc.model.diagram.part.ModelCreationWizardPage("DomainModelFile", //$NON-NLS-1$
				getSelection(), "bdModel") { //$NON-NLS-1$

			public void setVisible(boolean visible) {
				if (visible) {
					String fileName = diagramModelFilePage.getFileName();
					fileName = fileName.substring(0, fileName.length() - ".bdModel_diagram".length()); //$NON-NLS-1$
					setFileName(behavDesc.model.diagram.part.ModelDiagramEditorUtil
							.getUniqueFileName(getContainerFullPath(), fileName, "bdModel")); //$NON-NLS-1$
				}
				super.setVisible(visible);
			}
		};
		domainModelFilePage
				.setTitle(behavDesc.model.diagram.part.Messages.ModelCreationWizard_DomainModelFilePageTitle);
		domainModelFilePage.setDescription(
				behavDesc.model.diagram.part.Messages.ModelCreationWizard_DomainModelFilePageDescription);
		addPage(domainModelFilePage);
	}

	/**
	* @generated
	*/
	public boolean performFinish() {
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {

			protected void execute(IProgressMonitor monitor) throws CoreException, InterruptedException {
				diagram = behavDesc.model.diagram.part.ModelDiagramEditorUtil
						.createDiagram(diagramModelFilePage.getURI(), domainModelFilePage.getURI(), monitor);
				if (isOpenNewlyCreatedDiagramEditor() && diagram != null) {
					try {
						behavDesc.model.diagram.part.ModelDiagramEditorUtil.openDiagram(diagram);
					} catch (PartInitException e) {
						ErrorDialog.openError(getContainer().getShell(),
								behavDesc.model.diagram.part.Messages.ModelCreationWizardOpenEditorError, null,
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
						behavDesc.model.diagram.part.Messages.ModelCreationWizardCreationError, null,
						((CoreException) e.getTargetException()).getStatus());
			} else {
				behavDesc.model.diagram.part.ModelDiagramEditorPlugin.getInstance().logError("Error creating diagram", //$NON-NLS-1$
						e.getTargetException());
			}
			return false;
		}
		return diagram != null;
	}
}
