package contextRelation.model.diagram.edit.parts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineShape;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import contextRelation.model.diagram.part.ModelDiagramEditor;
import model.ContextRelation;

/**
 * @generated
 */
public class ContextRelationEditPart extends ShapeNodeEditPart {

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

	private ModelDiagramEditor editor;

	/*
	 * @generated NOT
	 */
	private ContextRelation cr;

	/**
	* @generated NOT
	*/
	public ContextRelationEditPart(View view) {
		super(view);
		this.cr = (ContextRelation) view.getElement();
		// Variables essentials to get the workbench of THIS Primitive Event
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
		/*	Thread thread = new Thread("New Thread") {
				public void run(){
					while(true){
						contentPane.repaint();
			        }
			        	
				}
			};
		
		
			   thread.start();
			*/

	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new contextRelation.model.diagram.edit.policies.ContextRelationItemSemanticEditPolicy());
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
		return primaryShape = new ContextRelationFigure();
	}

	/**
	* @generated
	*/
	public ContextRelationFigure getPrimaryShape() {
		return (ContextRelationFigure) primaryShape;
	}

	/**
	* @generated
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof contextRelation.model.diagram.edit.parts.ContextRelationNameEditPart) {
			((contextRelation.model.diagram.edit.parts.ContextRelationNameEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureContextRelationTitle());
			return true;
		}
		if (childEditPart instanceof contextRelation.model.diagram.edit.parts.ContextRelationName2EditPart) {
			((contextRelation.model.diagram.edit.parts.ContextRelationName2EditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureContextRelationName());
			return true;
		}
		if (childEditPart instanceof contextRelation.model.diagram.edit.parts.WrappingLabelEditPart) {
			((contextRelation.model.diagram.edit.parts.WrappingLabelEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureContextRelationTypes());
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof contextRelation.model.diagram.edit.parts.ContextRelationNameEditPart) {
			return true;
		}
		if (childEditPart instanceof contextRelation.model.diagram.edit.parts.ContextRelationName2EditPart) {
			return true;
		}
		if (childEditPart instanceof contextRelation.model.diagram.edit.parts.WrappingLabelEditPart) {
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	* @generated
	*/
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	* @generated
	*/
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		return getContentPane();
	}

	/**
	* @generated NOT
	*/
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 100);
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
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(contextRelation.model.diagram.part.ModelVisualIDRegistry
				.getType(contextRelation.model.diagram.edit.parts.ContextRelationNameEditPart.VISUAL_ID));
	}

	@Override
	public void performRequest(Request req) {
		if (req.getType() == RequestConstants.REQ_OPEN) {
			System.out.println("Double click!");
		}
	}

	/**
	 * @generated
	 */
	public class ContextRelationFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureContextRelationTitle;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureContextRelationName;

		private WrappingLabel fFigureContextRelationTypes;

		/**
		 * @generated
		 */
		public ContextRelationFigure() {

			FlowLayout layoutThis = new FlowLayout();
			layoutThis.setStretchMinorAxis(false);
			layoutThis.setMinorAlignment(FlowLayout.ALIGN_LEFTTOP);

			layoutThis.setMajorAlignment(FlowLayout.ALIGN_LEFTTOP);
			layoutThis.setMajorSpacing(5);
			layoutThis.setMinorSpacing(5);
			layoutThis.setHorizontal(true);

			this.setLayoutManager(layoutThis);

			createContents();
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			fFigureContextRelationName = new WrappingLabel();
			fFigureContextRelationName.setText("-- Insert name of Context Relation --");
			fFigureContextRelationName.setAlignment(PositionConstants.CENTER);

			fFigureContextRelationTitle = new WrappingLabel();
			fFigureContextRelationTitle.setText("<<Context Relation>>");
			fFigureContextRelationTitle.setAlignment(PositionConstants.CENTER);

			this.add(fFigureContextRelationTitle);
			this.add(fFigureContextRelationName);

			fFigureContextRelationTypes = new WrappingLabel();
			fFigureContextRelationTypes.setText("Define the types...");

			this.add(fFigureContextRelationTypes);

			PolylineShape segment0 = new PolylineShape();

			this.add(segment0);

		}

		/**
				 * @generated
				 */
		public WrappingLabel getFigureContextRelationTitle() {
			return fFigureContextRelationTitle;
		}

		/**
		* @generated
		*/
		public WrappingLabel getFigureContextRelationTypes() {
			return fFigureContextRelationTypes;
		}

		/**
			 * @generated
			 */
		public WrappingLabel getFigureContextRelationName() {
			return fFigureContextRelationName;
		}

	}

}
