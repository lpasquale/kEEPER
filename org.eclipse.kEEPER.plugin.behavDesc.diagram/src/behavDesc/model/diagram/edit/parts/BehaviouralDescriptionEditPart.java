package behavDesc.model.diagram.edit.parts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.kEEPER.plugin.ui.figures.BehaviouralDescriptionFigure;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.ListDialog;

import behavDesc.model.diagram.part.ModelDiagramEditor;
import model.Agent;
import model.BehaviouralDescription;
import model.ComplexEvent;
import model.Event;
import model.Happens;
import model.HoldsAt;
import model.HoldsAtBetween;
import model.ModelPackage;
import model.Observer;
import model.Parameter;
import model.PrimitiveEvent;
import model.impl.AgentImpl;
import model.impl.ComplexEventImpl;
import model.impl.EventImpl;
import model.impl.HappensImpl;
import model.impl.HoldsAtBetweenImpl;
import model.impl.HoldsAtImpl;
import model.impl.ObserverImpl;
import model.impl.ParameterImpl;
import model.impl.PrimitiveEventImpl;

/**
 * @generated
 */
public class BehaviouralDescriptionEditPart extends ShapeNodeEditPart {

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

	private TransactionalEditingDomain editingDomain;

	private View view;

	private BehaviouralDescription bd;

	private String editFilesPath, diagramFileName;

	/**
	* @generated NOT
	*/
	public BehaviouralDescriptionEditPart(View view) {
		super(view);
		System.out.println("TITLE view: " + view.eResource().getURI().lastSegment());
		System.out.println("Constructor of BehaviouralDescriptorEditPart");
		// Variables essentials to get the workbench of THIS behavioural description
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
		IWorkbenchPage workbenchPage = workbenchWindow.getActivePage();
		IEditorReference[] editorPart = workbenchPage.getEditorReferences();

		// Initializing the editor
		for (int i = 0; i < editorPart.length; i++) {
			if (editorPart[i].getEditor(true) instanceof behavDesc.model.diagram.part.ModelDiagramEditor) {
				System.out.println("Title: " + editorPart[i].getEditor(true).getTitle());
				if (editorPart[i].getEditor(true).getTitle().equals(view.eResource().getURI().lastSegment())) {
					editor = (ModelDiagramEditor) editorPart[i].getEditor(true);
				}
				System.out.println("Editor: " + editor);
			}
		}

		// Variables essentials to get the path of the diagram file
		Resource diagram = editor.getDiagram().eResource();
		String path = ((Resource) diagram).getURI().toPlatformString(true);
		IResource workspaceResource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(path));
		diagramFileName = workspaceResource.getLocation().lastSegment();
		editFilesPath = workspaceResource.getLocation().removeLastSegments(1).toString();

		this.view = view;
		this.bd = (BehaviouralDescription) view.getElement();

		System.out.println("FileName: " + diagramFileName + "  Domain File path: " + editFilesPath);
		System.out.println("Final editor: " + editor);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new behavDesc.model.diagram.edit.policies.BehaviouralDescriptionItemSemanticEditPolicy());
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
	protected IFigure createNodeShape(RectangleFigure r) {
		return primaryShape = new BehaviouralDescriptionFigure(r, bd);

	}

	/**
	* @generated NOT
	*/
	public BehaviouralDescriptionFigure getPrimaryShape() {
		return (BehaviouralDescriptionFigure) primaryShape;
	}

	/**
	* @generated NOT
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
	* @generated NOT
	*/
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		RectangleFigure r = new RectangleFigure();
		r.setLineWidth(5);
		r.setSize(270, 210);
		figure.add(r);
		IFigure shape = createNodeShape(r);
		figure.add(shape);
		contentPane = setupContentPane(shape);
		/*	SetRequest setRequestTimeInstant = new SetRequest(editor.getEditingDomain(), bd,
					ModelPackage.eINSTANCE.getBehaviouralDescription_TimeInstants(), ((BehaviouralDescriptionFigure) shape).getTimeInstants());
			SetValueCommand propertyOperation = new SetValueCommand(setRequestTimeInstant);
			editor.getDiagramEditDomain().getDiagramCommandStack()
					.execute(new ICommandProxy(propertyOperation));
		*/
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

	@Override
	public void performRequest(Request req) {
		if (req.getType() == RequestConstants.REQ_OPEN) {

			// Proceed only if the user has already set up the number of time instants
			if (bd.getTimeInstants() == 0) {
				MessageDialog.openError(null, "Error", "You must define the number of time instants before!");
				return;
			}
			ElementListSelectionDialog dialog = new ElementListSelectionDialog(null, new LabelProvider());
			dialog.setElements(
					new String[] { "Happens", "Holds at", "Not Holds at", "Holds at between", "Not holds at between" });
			dialog.setMultipleSelection(false);
			dialog.setTitle("Which predicate do you want to select");
			// user pressed cancel
			if (dialog.open() != Window.OK) {
				return;
			}
			String predicateSelected = (String) dialog.getResult()[0];

			switch (predicateSelected) {
			case "Happens": {
				Happens newHappens = happensSelected();
				if (newHappens != null)
					getPrimaryShape().setHappens(newHappens);
				getPrimaryShape().repaint();
			} // Happens
				break;

			case "Holds at": {
				HoldsAt newHoldsAt = holdsAtSelected(true);
				if (newHoldsAt != null)
					getPrimaryShape().setHoldsAt(newHoldsAt);
				getPrimaryShape().repaint();
			} // Holds at
				break;

			case "Not Holds at": {
				HoldsAt newHoldsAt = holdsAtSelected(false);
				if (newHoldsAt != null)
					getPrimaryShape().setHoldsAt(newHoldsAt);
				getPrimaryShape().repaint();

			} // Holds at
				break;
			case "Holds at between": {
				HoldsAtBetween newHoldsAtBetween = holdsAtBetweenSelected(true);
				if (newHoldsAtBetween != null)
					getPrimaryShape().setHoldsAtBetween(newHoldsAtBetween);
				getPrimaryShape().repaint();
			} // Holds at between
				break;

			case "Not holds at between": {
				HoldsAtBetween newHoldsAtBetween = holdsAtBetweenSelected(false);
				if (newHoldsAtBetween != null)
					getPrimaryShape().setHoldsAtBetween(newHoldsAtBetween);
				getPrimaryShape().repaint();
			} // Not holds at between
				break;

			}
		}
	}

	/*
	 * It shows the list of events and sets the happens predicate attributes
	 */
	private Happens happensSelected() {
		try {
			// Parsing event file
			LoadEvents loadEvents = new LoadEvents(editFilesPath + "/default.eventModel");

			Display display = PlatformUI.getWorkbench().getDisplay();
			Shell shell = new Shell(display);

			Event ev = null;

			// Creating second dialog to show the list of the available events
			ElementListSelectionDialog showEventsDialog = new ElementListSelectionDialog(null, new LabelProvider());
			String[] eventsNameArray = new String[loadEvents.getEnvironment().getEvents().size()];
			for (int i = 0; i < loadEvents.getEnvironment().getEvents().size(); i++) {
				eventsNameArray[i] = loadEvents.getEnvironment().getEvents().get(i).getName();
			}
			showEventsDialog.setElements(eventsNameArray);
			showEventsDialog.setMultipleSelection(false);
			showEventsDialog.setTitle("Select an event");
			// User pressed cancel
			if (showEventsDialog.open() != Window.OK) {
				return null;
			}

			String eventSelected = (String) showEventsDialog.getResult()[0];

			System.out.println("event selected: " + eventSelected);
			int index = 0;
			do {
				if (eventSelected.equals(loadEvents.getEnvironment().getEvents().get(index).getName())) {
					ev = loadEvents.getEnvironment().getEvents().get(index);
				}
				index++;
			} while ((index < loadEvents.getEnvironment().getEvents().size()) && ev == null);

			// Creating third dialog where the user inputs the time instant where to place the event
			int timeSelection = createSingleTimeInstantsDialog();

			if (timeSelection == -1)
				return null;

			// Creating Happens
			Command cmd = editor.createAndExecuteShapeRequestCommand(
					behavDesc.model.diagram.providers.ModelElementTypes.Happens_2002, editor.getDiagramEditPart());
			editor.getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack();

			// Creating and executing the command to set the properties
			Collection<?> results = DiagramCommandStack.getReturnValues(cmd);
			Iterator<?> iter = results.iterator();
			Happens newHappens = new HappensImpl();
			while (iter.hasNext()) {
				Object obj = iter.next();
				if (obj instanceof CreateElementRequestAdapter) {
					CreateElementRequestAdapter cra = (CreateElementRequestAdapter) obj;
					newHappens = (HappensImpl) cra.resolve();

					// Setting the happens EReference of the Behavioural Description
					SetRequest setRequestHappens = new SetRequest(editor.getEditingDomain(), view.getElement(),
							ModelPackage.eINSTANCE.getBehaviouralDescription_Happens(), newHappens);
					SetValueCommand behavDescOperation = new SetValueCommand(setRequestHappens);
					editor.getDiagramEditDomain().getDiagramCommandStack()
							.execute(new ICommandProxy(behavDescOperation));

					// Setting the property of Happens
					SetRequest setRequestTimeInstant = new SetRequest(editor.getEditingDomain(), newHappens,
							ModelPackage.eINSTANCE.getHappens_Time(), timeSelection);
					SetValueCommand propertyOperation = new SetValueCommand(setRequestTimeInstant);
					editor.getDiagramEditDomain().getDiagramCommandStack()
							.execute(new ICommandProxy(propertyOperation));
				}
			}

			// Looking for the event the user decided to associate with the new 'happens' predicate and setting the property
			for (int i = 0; i < loadEvents.getEnvironment().getEvents().size(); i++) {
				if (eventSelected.equals(loadEvents.getEnvironment().getEvents().get(i).getName())) {
					SetRequest setRequestEvent = new SetRequest(editor.getEditingDomain(), newHappens,
							ModelPackage.eINSTANCE.getHappens_Event(), loadEvents.getEnvironment().getEvents().get(i));
					SetValueCommand operation = new SetValueCommand(setRequestEvent);
					editor.getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(operation));

				}
			}

			// TODO: Creating the dynamic parameters HERE
			DynamicParametersDialog dpd = new DynamicParametersDialog(null, bd, newHappens, editor, editFilesPath);

			if (dpd.open() != Window.OK) {
				return null;
			}

			System.out.println("SONO IN BDEDITPART!");
			if (newHappens.getParameters().isEmpty()) {
				for (int i = 0; i < dpd.getResults().size(); i++) {

				}
			} else {
				for (int i = 0; i < dpd.getResults().size(); i++) {
					// Add the parameters that are new

				}
			}

			return newHappens;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private HoldsAt holdsAtSelected(boolean isHolding) {
		try {
			// Parsing event file
			LoadContextRelation loadContextRelations = new LoadContextRelation(
					editFilesPath + "/default.contextRelationModel");

			// Creating second dialog to show the list of the available events
			ElementListSelectionDialog showContextRelationsDialog = new ElementListSelectionDialog(null,
					new LabelProvider());
			String[] contextRelationsNameArray = new String[loadContextRelations.getEnvironment().getContextRelations()
					.size()];
			for (int i = 0; i < loadContextRelations.getEnvironment().getContextRelations().size(); i++) {
				contextRelationsNameArray[i] = loadContextRelations.getEnvironment().getContextRelations().get(i)
						.getName();
			}
			showContextRelationsDialog.setElements(contextRelationsNameArray);
			showContextRelationsDialog.setMultipleSelection(false);
			showContextRelationsDialog.setTitle("Select a Context Relation");
			// User pressed cancel
			if (showContextRelationsDialog.open() != Window.OK) {
				return null;
			}

			String contextRelationSelected = (String) showContextRelationsDialog.getResult()[0];
			System.out.println("CR selected: " + contextRelationSelected);

			// Creating third dialog where the user inputs the time instant where to place the event
			int timeSelection = createSingleTimeInstantsDialog();

			if (timeSelection == -1)
				return null;

			// Creating HoldsAt
			Command cmd = editor.createAndExecuteShapeRequestCommand(
					behavDesc.model.diagram.providers.ModelElementTypes.HoldsAt_2003, editor.getDiagramEditPart());
			editor.getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack();

			// Creating and executing the command to set the properties
			Collection<?> results = DiagramCommandStack.getReturnValues(cmd);
			Iterator<?> iter = results.iterator();
			HoldsAt newHoldsAt = new HoldsAtImpl();
			while (iter.hasNext()) {
				Object obj = iter.next();
				if (obj instanceof CreateElementRequestAdapter) {
					CreateElementRequestAdapter cra = (CreateElementRequestAdapter) obj;
					newHoldsAt = (HoldsAtImpl) cra.resolve();

					// Setting the HoldsAt EReference of the Behavioural Description
					SetRequest setRequestHoldsAt = new SetRequest(editor.getEditingDomain(), view.getElement(),
							ModelPackage.eINSTANCE.getBehaviouralDescription_HoldsAts(), newHoldsAt);
					SetValueCommand behavDescOperation = new SetValueCommand(setRequestHoldsAt);
					editor.getDiagramEditDomain().getDiagramCommandStack()
							.execute(new ICommandProxy(behavDescOperation));

					// Setting the property of HoldsAt
					SetRequest setRequestTimeInstant = new SetRequest(editor.getEditingDomain(), newHoldsAt,
							ModelPackage.eINSTANCE.getHoldsAt_Time(), timeSelection);
					SetRequest setRequestIsHolding = new SetRequest(editor.getEditingDomain(), newHoldsAt,
							ModelPackage.eINSTANCE.getHoldsAt_IsHolding(), isHolding);
					SetValueCommand operation1 = new SetValueCommand(setRequestTimeInstant);
					SetValueCommand operation2 = new SetValueCommand(setRequestIsHolding);

					editor.getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(operation1));
					editor.getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(operation2));
				}
			}

			// Looking for the context relation the user decided to associate with the new 'holds at' predicate and setting the property
			for (int i = 0; i < loadContextRelations.getEnvironment().getContextRelations().size(); i++) {
				if (contextRelationSelected
						.equals(loadContextRelations.getEnvironment().getContextRelations().get(i).getName())) {
					SetRequest setRequestContextRelation = new SetRequest(editor.getEditingDomain(), newHoldsAt,
							ModelPackage.eINSTANCE.getHoldsAt_ContextRelation(),
							loadContextRelations.getEnvironment().getContextRelations().get(i));
					SetValueCommand operation = new SetValueCommand(setRequestContextRelation);
					editor.getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(operation));
				}
			}

			return newHoldsAt;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	private HoldsAtBetween holdsAtBetweenSelected(boolean isHolding) {

		try {
			// Parsing event file
			LoadContextRelation loadContextRelations = new LoadContextRelation(
					editFilesPath + "/default.contextRelationModel");

			// Creating second dialog to show the list of the available events
			ElementListSelectionDialog showContextRelationsDialog = new ElementListSelectionDialog(null,
					new LabelProvider());
			String[] contextRelationsNameArray = new String[loadContextRelations.getEnvironment().getContextRelations()
					.size()];
			for (int i = 0; i < loadContextRelations.getEnvironment().getContextRelations().size(); i++) {
				contextRelationsNameArray[i] = loadContextRelations.getEnvironment().getContextRelations().get(i)
						.getName();
			}
			showContextRelationsDialog.setElements(contextRelationsNameArray);
			showContextRelationsDialog.setMultipleSelection(false);
			showContextRelationsDialog.setTitle("Select a Context Relation");

			// User pressed cancel
			if (showContextRelationsDialog.open() != Window.OK) {
				return null;
			}

			String contextRelationSelected = (String) showContextRelationsDialog.getResult()[0];
			System.out.println("CR selected: " + contextRelationSelected);

			// Creating third dialog where the user inputs the time instant where to place the event
			int[] timeSelectedArray = createMultipleTimeInstantsDialog();
			if (timeSelectedArray == null)
				return null;

			// Creating HoldsAtBetween
			Command cmd = editor.createAndExecuteShapeRequestCommand(
					behavDesc.model.diagram.providers.ModelElementTypes.HoldsAtBetween_2004,
					editor.getDiagramEditPart());
			editor.getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack();

			// Creating and executing the command to set the properties
			Collection<?> results = DiagramCommandStack.getReturnValues(cmd);
			Iterator<?> iter = results.iterator();
			HoldsAtBetween newHoldsAtBetween = new HoldsAtBetweenImpl();
			while (iter.hasNext()) {
				Object obj = iter.next();
				if (obj instanceof CreateElementRequestAdapter) {
					CreateElementRequestAdapter cra = (CreateElementRequestAdapter) obj;
					newHoldsAtBetween = (HoldsAtBetweenImpl) cra.resolve();

					// Setting the holdsAtBetween EReference of the Behavioural Description
					SetRequest setRequestHoldsAtBetween = new SetRequest(editor.getEditingDomain(), view.getElement(),
							ModelPackage.eINSTANCE.getBehaviouralDescription_HoldsAtBetweens(), newHoldsAtBetween);
					SetValueCommand behavDescOperation = new SetValueCommand(setRequestHoldsAtBetween);
					editor.getDiagramEditDomain().getDiagramCommandStack()
							.execute(new ICommandProxy(behavDescOperation));

					// Setting the property of HoldsAtBetween
					SetRequest setRequestTimeInstant1 = new SetRequest(editor.getEditingDomain(), newHoldsAtBetween,
							ModelPackage.eINSTANCE.getHoldsAtBetween_InitialTime(), timeSelectedArray[0]);
					SetRequest setRequestTimeInstant2 = new SetRequest(editor.getEditingDomain(), newHoldsAtBetween,
							ModelPackage.eINSTANCE.getHoldsAtBetween_EndingTime(), timeSelectedArray[1]);
					SetRequest setRequestIsHolding = new SetRequest(editor.getEditingDomain(), newHoldsAtBetween,
							ModelPackage.eINSTANCE.getHoldsAtBetween_IsHolding(), isHolding);
					SetValueCommand operation1 = new SetValueCommand(setRequestTimeInstant1);
					SetValueCommand operation2 = new SetValueCommand(setRequestTimeInstant2);
					SetValueCommand operation3 = new SetValueCommand(setRequestIsHolding);

					editor.getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(operation1));
					editor.getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(operation2));
					editor.getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(operation3));
				}
			}

			// Looking for the context relation the user decided to associate with the new 'holds at between' predicate and setting the property
			for (int i = 0; i < loadContextRelations.getEnvironment().getContextRelations().size(); i++) {
				if (contextRelationSelected
						.equals(loadContextRelations.getEnvironment().getContextRelations().get(i).getName())) {
					SetRequest setRequestContextRelation = new SetRequest(editor.getEditingDomain(), newHoldsAtBetween,
							ModelPackage.eINSTANCE.getHoldsAtBetween_ContextRelation(),
							loadContextRelations.getEnvironment().getContextRelations().get(i));
					SetValueCommand operation = new SetValueCommand(setRequestContextRelation);
					editor.getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(operation));
				}
			}

			return newHoldsAtBetween;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * It creates the dialog where the user inputs the time instant where to place the event/context relation
	 */
	public int createSingleTimeInstantsDialog() {
		// Creating third dialog
		ElementListSelectionDialog timeInstantDialog = new ElementListSelectionDialog(null, new LabelProvider());
		String[] timeInstantsArray = new String[bd.getTimeInstants()];
		System.out.println("NUMBERS: " + bd.getTimeInstants());
		for (int i = 0; i < bd.getTimeInstants(); i++) {
			timeInstantsArray[i] = Integer.toString(i + 1);
		}
		timeInstantDialog.setElements(timeInstantsArray);
		timeInstantDialog.setMultipleSelection(false);
		timeInstantDialog.setTitle("Select a time instant");
		// user pressed cancel
		if (timeInstantDialog.open() != Window.OK) {
			return -1;
		}
		String timeSelection = (String) timeInstantDialog.getResult()[0];
		System.out.println("time selected: " + timeSelection);

		return Integer.parseInt(timeSelection);
	}

	/*
	 * It creates the dialog where the user inputs the TWO time instants where to place the context relation
	 */
	public int[] createMultipleTimeInstantsDialog() {
		// Creating third dialog
		ElementListSelectionDialog timeInstantDialog = new ElementListSelectionDialog(null, new LabelProvider());
		String[] timeInstantsArray = new String[bd.getTimeInstants()];
		for (int i = 0; i < bd.getTimeInstants(); i++) {
			timeInstantsArray[i] = Integer.toString(i + 1);
		}
		timeInstantDialog.setElements(timeInstantsArray);
		timeInstantDialog.setMultipleSelection(true);
		timeInstantDialog.setTitle("Select TWO time instants");
		// user pressed cancel
		do {
			if (timeInstantDialog.open() != Window.OK) {
				return null;
			} else if (timeInstantDialog.getResult().length < 2) {
				MessageDialog.openError(null, "Error",
						"You must select two time instants in order to create a \"Holds At Between\" predicate");
			}
		} while (timeInstantDialog.getResult().length < 2);

		String timeSelection1 = (String) timeInstantDialog.getResult()[0];
		String timeSelection2 = (String) timeInstantDialog.getResult()[1];
		System.out.println("time selected: " + timeSelection1);
		System.out.println("time selected: " + timeSelection2);
		int[] timeSelectedArray = new int[2];
		timeSelectedArray[0] = Integer.parseInt(timeSelection1);
		;
		timeSelectedArray[1] = Integer.parseInt(timeSelection2);
		;

		return timeSelectedArray;
	}

	/*	private ArrayList<Parameter> handlingEventParameters(Event ev, Shell shell){
			
			ArrayList<Parameter> newParameters = new ArrayList<Parameter>();
			
			ElementListSelectionDialog parametersSelection = new ElementListSelectionDialog(null, new LabelProvider());
		
			ArrayList<String> param = new ArrayList<String>();
			
			System.out.println("Evento selezionato: " + ev);
		
			param.add(ev.getAgent().getName());
			
			for (int i = 0; i < ev.getParameters().size(); i++){
				System.out.println("Param " + ev.getParameters().get(i).getType().getName());
				
				param.add(ev.getParameters().get(i).getName());
			}
			if (ev instanceof PrimitiveEventImpl){
				param.add(((PrimitiveEventImpl)ev).getObserver().getName());
			}
			
			parametersSelection.setElements(param.toArray());
			parametersSelection.setMultipleSelection(true);
			parametersSelection.setTitle("Select the parameters of the event you want to create");
			parametersSelection.open();
			
			
			EventParametersDialog dialog = new EventParametersDialog(parametersSelection.getResult(), shell);
			dialog.create();
			if (dialog.open() == Window.OK) {
				
				// Creating the new Agent
				Agent newAgent = new AgentImpl();
				newAgent.setName(ev.getAgent().getName());
				newAgent.setPosition(ev.getAgent().getPosition());
				newAgent.setType(ev.getAgent().getType());
				newParameters.add(newAgent);
				
				// Creating the new parameters
				for (int i = 0; i < ev.getParameters().size(); i++){
					Parameter newParameter = new ParameterImpl();
					newParameter.setName(ev.getParameters().get(i).getName());
					newParameter.setPosition(ev.getParameters().get(i).getPosition());
					newParameter.setType(ev.getParameters().get(i).getType());
					newParameters.add(newParameter);
				}
				
				if (ev instanceof PrimitiveEventImpl){
					// Creating the new Observer
					Observer newObserver = new ObserverImpl();
					newObserver.setName(((PrimitiveEvent) ev).getObserver().getName());
					newObserver.setPosition(((PrimitiveEvent) ev).getObserver().getPosition());
					newObserver.setType(((PrimitiveEvent) ev).getObserver().getType());
					newParameters.add(newObserver);
				}
				
				for (int i = 0; i < newParameters.size(); i++){
					System.out.println("Parameter: " + newParameters.get(i) + "  newNumber: " + newParameters.get(i).getNewNumber());
	
				}
			
				System.out.println(dialog.getMap());
				
				// Handling result
				// Loop for each parameter the user wants to change			
				for (int i = 0; i < newParameters.size(); i++){
					Iterator it = dialog.getMap().entrySet().iterator();
					while (it.hasNext()) {
						Map.Entry entry = (Map.Entry)it.next();
						// Compare the keys of the map with the names of the new parameters in the list newParameters
						if (((String)entry.getKey()).equals(newParameters.get(i).getName())){
							newParameters.get(i).setNewNumber((int) entry.getValue());
						} 
					}
				}
				
				// Verification
				for (int i = 0; i < newParameters.size(); i++){
					System.out.println("Parameter_NEW: " + newParameters.get(i) + "  newNumber: " + newParameters.get(i).getNewNumber());
	
				}	
			}
			
			return newParameters;
		}
	*/
}
