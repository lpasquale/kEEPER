package event.model.diagram.edit.parts;

import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.draw2d.ui.render.factory.RenderedImageFactory;
import org.eclipse.gmf.runtime.draw2d.ui.render.figures.ScalableImageFigure;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import event.model.diagram.edit.policies.PrimitiveEventItemSemanticEditPolicy;
import event.model.diagram.part.ModelDiagramEditor;
import event.model.diagram.part.ModelDiagramEditorPlugin;
import event.model.diagram.part.ModelVisualIDRegistry;
import model.AgentReference;
import model.ModelPackage;
import model.ObserverReference;
import model.PrimitiveEvent;
import model.impl.AgentReferenceImpl;
import model.impl.ObserverReferenceImpl;

/**
 * @generated
 */
public class PrimitiveEventEditPart extends AbstractBorderedShapeEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 2011;

	/**
	* @generated
	*/
	protected IFigure contentPane;

	/**
	* @generated
	*/
	protected IFigure primaryShape;

	private ModelDiagramEditor editor;

	private View view;

	private PrimitiveEvent pe;

	/**
	* @generated NOT
	*/
	public PrimitiveEventEditPart(View view) {
		super(view);

		// Variables essentials to get the workbench of THIS Primitive Event
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
		IWorkbenchPage workbenchPage = workbenchWindow.getActivePage();
		IEditorReference[] editorPart = workbenchPage.getEditorReferences();

		// Initializing the editor
		for (int i = 0; i < editorPart.length; i++) {
			if (editorPart[i].getEditor(true) instanceof event.model.diagram.part.ModelDiagramEditor) {
				System.out.println("Title: " + editorPart[i].getEditor(true).getTitle());

				if (editorPart[i].getEditor(true).getTitle().equals(view.eResource().getURI().lastSegment())) {
					editor = (ModelDiagramEditor) editorPart[i].getEditor(true);
				}
				System.out.println("Editor: " + editor);

			}
		}
		this.view = view;

		this.pe = (PrimitiveEvent) view.getElement();

		System.out.println(pe.getAgent());
		System.out.println(pe.getObserver());
		
		if ((pe.getAgent() == null) ||(pe.getObserver() == null)){
			Thread thread = new Thread() {
				public void run() {
					try {
						System.out.println("Creating the agent...");
						Thread.sleep(2000);
						if (pe.getAgent() == null) {
						//	agentCreation();
						}
						if (pe.getObserver() == null) {
						//	observerCreation();
						} 
					} catch (InterruptedException v) {
						System.out.println(v);
					}catch(NullPointerException e){
						System.out.println(e);
					}
				}
			};

			thread.start();
		} 
		
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new PrimitiveEventItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	* @generated
	*/
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View) child.getModel();
				switch (ModelVisualIDRegistry.getVisualID(childView)) {
				case PrimitiveEventNameEditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy() {

						protected List createSelectionHandles() {
							MoveHandle mh = new MoveHandle((GraphicalEditPart) getHost());
							mh.setBorder(null);
							return Collections.singletonList(mh);
						}
					};
				}
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	* @generated NOT
	*/
	protected IFigure createNodeShape() {
		URL url = FileLocator.find(ModelDiagramEditorPlugin.getInstance().getBundle(),
				new Path("icons/PrimitiveEvent.svg"), //$NON-NLS-1$
				null);
		return new ScalableImageFigure(RenderedImageFactory.getInstance(url), false, true, true);

	}

	/**
	* @generated
	*/
	public ScalableImageFigure getPrimaryShape() {
		return (ScalableImageFigure) primaryShape;
	}

	/**
	* @generated NOT
	*/
	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		if (borderItemEditPart instanceof PrimitiveEventNameEditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.SOUTH);
			locator.setBorderItemOffset(new Dimension(0, 0));
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
	}

	/**
	* @generated
	*/
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
	}

	/**
	* Creates figure for this edit part.
	* 
	* Body of this method does not depend on settings in generation model
	* so you may safely remove <i>generated</i> tag and modify it.
	* 
	* @generated
	*/
	protected NodeFigure createMainFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	* Default implementation treats passed figure as content pane.
	* Respects layout one may have set for generated figure.
	* @param nodeShape instance of generated figure class
	* @generated
	*/
	protected IFigure setupContentPane(IFigure nodeShape) {
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	* @generated
	*/
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	* @generated
	*/
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	* @generated
	*/
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	* @generated
	*/
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	* @generated
	*/
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	* @generated
	*/
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(ModelVisualIDRegistry.getType(PrimitiveEventNameEditPart.VISUAL_ID));
	}

	private void agentCreation() {
		// Creating AgentReference
		Command cmd = editor.createAndExecuteShapeRequestCommand(
				event.model.diagram.providers.ModelElementTypes.AgentReference_2016, editor.getDiagramEditPart());
		editor.getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack();

		// Creating and executing the command to set the properties
		Collection<?> results = DiagramCommandStack.getReturnValues(cmd);
		Iterator<?> iter = results.iterator();
		AgentReference newAgent = new AgentReferenceImpl();
		while (iter.hasNext()) {
			Object obj = iter.next();
			if (obj instanceof CreateElementRequestAdapter) {
				CreateElementRequestAdapter cra = (CreateElementRequestAdapter) obj;
				newAgent = (AgentReferenceImpl) cra.resolve();

				// Setting the AgentReference EReference of the Primitive Event
				System.out.println(editor.getEditingDomain());
				System.out.println(view.getElement());
				SetRequest setRequestAgent = new SetRequest(editor.getEditingDomain(), view.getElement(),
						ModelPackage.eINSTANCE.getPrimitiveEvent_Agent(), newAgent);
				SetValueCommand agentOperation = new SetValueCommand(setRequestAgent);
				editor.getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(agentOperation));
			}
		}
		// Refresh the diagram (it allows to render the connection between the Event and the Parameter
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				editor.getDiagramEditPart().addNotify();
			}
		});

	}

	private void observerCreation() {
		// Creating Observer
		Command cmd = editor.createAndExecuteShapeRequestCommand(
				event.model.diagram.providers.ModelElementTypes.ObserverReference_2017, editor.getDiagramEditPart());
		editor.getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack();

		// Creating and executing the command to set the properties
		Collection<?> results = DiagramCommandStack.getReturnValues(cmd);
		Iterator<?> iter = results.iterator();
		ObserverReference newObserver = new ObserverReferenceImpl();
		while (iter.hasNext()) {
			Object obj = iter.next();
			if (obj instanceof CreateElementRequestAdapter) {
				CreateElementRequestAdapter cra = (CreateElementRequestAdapter) obj;
				newObserver = (ObserverReferenceImpl) cra.resolve();

				// Setting the ObserverReference EReference of the Primitive Event
				SetRequest setRequestObserver = new SetRequest(editor.getEditingDomain(), view.getElement(),
						ModelPackage.eINSTANCE.getPrimitiveEvent_Observer(), newObserver);
				SetValueCommand observerOperation = new SetValueCommand(setRequestObserver);
				editor.getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(observerOperation));
			}
		}

		// Refresh the diagram (it allows to render the connection between the Event and the Parameter
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				editor.getDiagramEditPart().addNotify();
			}
		});
	}
}
