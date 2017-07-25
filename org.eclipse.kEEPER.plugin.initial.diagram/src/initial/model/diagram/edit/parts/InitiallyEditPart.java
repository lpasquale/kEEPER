package initial.model.diagram.edit.parts;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Color;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import initial.model.diagram.edit.policies.InitiallyItemSemanticEditPolicy;
import initial.model.diagram.edit.policies.ModelTextSelectionEditPolicy;
import initial.model.diagram.part.ModelDiagramEditor;
import initial.model.diagram.part.ModelVisualIDRegistry;
import initial.model.diagram.providers.ModelElementTypes;
import model.Initially;
import model.Instance;
import model.ModelPackage;
import model.Type;
import model.impl.InstanceImpl;

/**
 * @generated
 */
public class InitiallyEditPart extends ShapeNodeEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 2001;

	/**
	* @generated
	*/
	protected IFigure contentPane;

	/**
	* @generated
	*/
	protected IFigure primaryShape;

	protected String editFilesPath;

	private ModelDiagramEditor editor;

	protected Initially in;

	protected View view;

	/**
	* @generated NOT
	*/
	public InitiallyEditPart(View view) {
		super(view);
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
		IWorkbenchPage workbenchPage = workbenchWindow.getActivePage();
		IEditorReference[] editorPart = workbenchPage.getEditorReferences();

		// Initializing the editor
		for (int i = 0; i < editorPart.length; i++) {
			if (editorPart[i].getEditor(true) instanceof ModelDiagramEditor) {
				System.out.println("Title: " + editorPart[i].getEditor(true).getTitle());
				if (editorPart[i].getEditor(true).getTitle().equals(view.eResource().getURI().lastSegment())) {
					editor = (ModelDiagramEditor) editorPart[i].getEditor(true);
				}
				System.out.println("Editor: " + editor);
			}
		}
		Resource diagram = editor.getDiagram().eResource();
		String path = ((Resource) diagram).getURI().toPlatformString(true);
		IResource workspaceResource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(path));
		editFilesPath = workspaceResource.getLocation().removeLastSegments(1).toString();

		this.view = view;
		this.in = (Initially) view.getElement();
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicyWithCustomReparent(ModelVisualIDRegistry.TYPED_INSTANCE));
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new InitiallyItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	* @generated
	*/
	protected LayoutEditPolicy createLayoutEditPolicy() {

		FlowLayoutEditPolicy lep = new FlowLayoutEditPolicy() {

			protected Command createAddCommand(EditPart child, EditPart after) {
				return null;
			}

			protected Command createMoveChildCommand(EditPart child, EditPart after) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	* @generated
	*/
	protected IFigure createNodeShape() {
		return primaryShape = new InitialFigure();
	}

	/**
	* @generated
	*/
	public InitialFigure getPrimaryShape() {
		return (InitialFigure) primaryShape;
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
	protected NodeFigure createNodeFigure() {
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
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
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
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor()
					.getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
			if (type == ModelElementTypes.ContextRelation_3003) {
				return getChildBySemanticHint(
						ModelVisualIDRegistry.getType(InitiallyInstancesNameCompartmentEditPart.VISUAL_ID));
			}
			if (type == ModelElementTypes.Instance_3002) {
				return getChildBySemanticHint(
						ModelVisualIDRegistry.getType(InitiallyInstancesNameCompartment2EditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	public class InitialFigure extends RoundedRectangle {

		/**
		* @generated
		*/
		private RectangleFigure fFigureInitialNameFigure;

		/**
				 * @generated
				 */
		public InitialFigure() {

			FlowLayout layoutThis = new FlowLayout();
			layoutThis.setStretchMinorAxis(false);
			layoutThis.setMinorAlignment(FlowLayout.ALIGN_CENTER);

			layoutThis.setMajorAlignment(FlowLayout.ALIGN_CENTER);
			layoutThis.setMajorSpacing(5);
			layoutThis.setMinorSpacing(5);
			layoutThis.setHorizontal(false);

			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(20), getMapMode().DPtoLP(20)));
			this.setLineWidth(3);
			this.setForegroundColor(THIS_FORE);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureInitialNameFigure = new RectangleFigure();

			fFigureInitialNameFigure.setOutline(false);

			this.add(fFigureInitialNameFigure);
			fFigureInitialNameFigure.setLayoutManager(new StackLayout());

			RectangleFigure instancesListFigure0 = new RectangleFigure();

			this.add(instancesListFigure0);
			instancesListFigure0.setLayoutManager(new StackLayout());

		}

		/**
		* @generated
		*/
		public RectangleFigure getFigureInitialNameFigure() {
			return fFigureInitialNameFigure;
		}

	}

	/**
	* @generated
	*/
	static final Color THIS_FORE = new Color(null, 0, 0, 255);

	@Override
	public void performRequest(Request req) {
		if (req.getType() == RequestConstants.REQ_OPEN) {

			if (in.getContextRelation() == null) {
				MessageDialog.openError(null, "Error", "You must select a Context Relation from the property tab");
				return;
			}

			InstancesDialog id = new InstancesDialog(null, this.in.getContextRelation(),
					editFilesPath + "/default.typeInstanceModel");

			if (id.open() != Window.OK) {
				System.out.println("User pressed Cancel");
				return;
			}

			if (id.getResults().isEmpty()) {
				MessageDialog.openError(null, "Error", "You didn't select any instance");
				return;
			}
			if (id.getResults().size() != in.getContextRelation().getTypes().size()) {
				MessageDialog.openError(null, "Error",
						"You must select an instance for each parameter of the Context Relation");
				return;
			}

			updateModel(id.getResults());
		}
	}

	private void updateModel(Map<Type, String> results) {

		for (int i = 0; i < in.getContextRelation().getTypes().size(); i++) {
			for (Map.Entry<Type, String> entry : results.entrySet()) {
				if (entry.getKey().getName().equals(in.getContextRelation().getTypes().get(i).getName())) {
					System.out.println("FOUND");
					// Looking for the instance already present in the other file
					// It's probably unfeasible (I need to look at the LoadResource feature to see how it works
					Command cmd = editor.createAndExecuteShapeRequestCommand(ModelElementTypes.Instance_2002,
							editor.getDiagramEditPart());
					editor.getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack();

					// Creating and executing the command to set the properties
					Collection<?> values = DiagramCommandStack.getReturnValues(cmd);
					Iterator<?> iter = values.iterator();
					System.out.println(values.size());
					Instance instance = new InstanceImpl();
					while (iter.hasNext()) {
						System.out.println("FOUND1");

						Object obj = iter.next();
						if (obj instanceof CreateElementRequestAdapter) {
							System.out.println("FOUND2");

							CreateElementRequestAdapter cra = (CreateElementRequestAdapter) obj;
							// This new instance is only useful for the parsing of Initial states so I just need to set its name
							instance = (InstanceImpl) cra.resolve();

							System.out.println("Setting the instance " + instance.getName() + " associated to the type "
									+ entry.getKey().getName());
							// Create the transaction with that type/instance
							SetRequest setRequestInstance = new SetRequest(editor.getEditingDomain(), view.getElement(),
									ModelPackage.eINSTANCE.getInitially_Instances(), instance);
							SetValueCommand initialOperation = new SetValueCommand(setRequestInstance);
							editor.getDiagramEditDomain().getDiagramCommandStack()
									.execute(new ICommandProxy(initialOperation));

							// Setting name of Instance
							SetRequest setRequestName = new SetRequest(editor.getEditingDomain(), instance,
									ModelPackage.eINSTANCE.getInstance_Name(), entry.getValue());
							SetValueCommand operation = new SetValueCommand(setRequestName);
							editor.getDiagramEditDomain().getDiagramCommandStack()
									.execute(new ICommandProxy(operation));

							// No need to set the type of the instance.

						}
					}

				}
			}
		}

	}
}
