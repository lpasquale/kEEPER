package behavDesc.model.diagram.edit.parts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import behavDesc.model.diagram.part.ModelDiagramEditor;
import model.Agent;
import model.AgentParam;
import model.BehaviouralDescription;
import model.ComplexEvent;
import model.GeneralParam;
import model.Happens;
import model.HoldsAt;
import model.HoldsAtBetween;
import model.ModelPackage;
import model.ObserverParam;
import model.PrimitiveEvent;
import model.impl.AgentImpl;
import model.impl.AgentParamImpl;
import model.impl.GeneralParamImpl;
import model.impl.HappensImpl;
import model.impl.ObserverParamImpl;

public class DynamicParametersDialog extends Dialog{

	private Composite composite;
	private BehaviouralDescription bd;
	private Happens newHappens = null;
	private HoldsAt newHoldsAt = null;
	private HoldsAtBetween newHoldsAtBetween = null;
	private Listener listener;
	private ModelDiagramEditor editor;
	private String editFilesPath, diagramFilePath;
	
	private ArrayList<List> lists = new ArrayList<List>();
	private ArrayList<String> results = new ArrayList<String>();
	
	protected DynamicParametersDialog(Shell parentShell, BehaviouralDescription bd, Object newPredicate, ModelDiagramEditor editor, String editFilesPath, String diagramFilePath) {
		super(parentShell);
		this.bd = bd;
		this.editor = editor;
		this.editFilesPath= editFilesPath;
		this.diagramFilePath = diagramFilePath;
		
		if (newPredicate instanceof Happens)
			this.newHappens = (Happens) newPredicate;
		if (newPredicate instanceof HoldsAt)
			this.newHoldsAt = (HoldsAt) newPredicate;
		if (newPredicate instanceof HoldsAtBetween)
			this.newHoldsAtBetween = (HoldsAtBetween) newPredicate;
		
		this.listener = new Listener() {
	            public void handleEvent(Event event) {
	            
	              if (event.widget instanceof Button){
	            	   Button b = (Button) event.widget;
	            	   Composite c = b.getParent();
	            	   Group g = (Group) c.getChildren()[0];
	            	   List l = (List) g.getChildren()[0];
	            	   
	            	   System.out.println(l.getSelection());
	            	   
	            	   //TODO: Create Input Validator
	            	  InputDialog id = new InputDialog(parentShell, "Name of parameter", "Enter name", null, null);
	            	  
	            	  if (id.open()!= Window.OK){
	            		  return;
	            	  }
	            	  l.add(id.getValue());
	            	  
	              }
	             
	            }
	          }; 
	}
	
	protected Control createDialogArea(Composite parent) {
        this.composite = (Composite) super.createDialogArea(parent);
        this.composite.setSize(1000,1000);
        GridLayout layout = new GridLayout();

        // Setting the number of columns of the dialog
        if (newHappens != null){
        	if (newHappens.getEvent() instanceof PrimitiveEvent)
        		layout.numColumns = newHappens.getEvent().getTypes().size() +2;
        	if (newHappens.getEvent() instanceof ComplexEvent)
        		layout.numColumns = newHappens.getEvent().getTypes().size() + 1;
        	layout.makeColumnsEqualWidth = true;
        }
		if (newHoldsAt != null){
        	layout.numColumns = newHoldsAt.getContextRelation().getTypes().size();
        	layout.makeColumnsEqualWidth = true;

		}
		if (newHoldsAtBetween != null){
        	layout.numColumns = newHoldsAtBetween.getContextRelation().getTypes().size();
        	layout.makeColumnsEqualWidth = true;
		}
        layout.marginHeight = 10;
        layout.marginWidth = 50;
        composite.setLayout(layout);
        try {
			createContent();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return composite;
    }

    private void createContent() throws IOException{ 
    	if (newHappens != null){
        	createEventMainContent();
    	}
    	else if (newHoldsAt != null){
    		createCrMainContent();
    	}
    	else if (newHoldsAtBetween != null){
    		createCrMainContent();
    	}
    }
    
    
    
    private void createEventMainContent() throws IOException{ 
    	diagramFilePath = diagramFilePath.replace("_diagram", "");
	    LoadParameters loadParameters = new LoadParameters(diagramFilePath);
	    System.out.println(diagramFilePath);
	    
	    if (newHappens.getEvent() instanceof PrimitiveEvent){
	    	PrimitiveEvent ev = (PrimitiveEvent) newHappens.getEvent();
	    	
	    	// List of the AGENT PARAMETERS
	    	Composite agentComp = new Composite(composite, SWT.NONE);
	    	agentComp.setLayout(new GridLayout(1, true));
	    	agentComp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    	Group agentGroup = new Group(agentComp, SWT.NONE);
	    	agentGroup.setText("Select a parameter");
	    	agentGroup.setLayout(new GridLayout(1, false));
	    	agentGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    	List agentList = new List(agentGroup, SWT.BORDER);
	    	agentList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    	// Looking for parameters for the agent type
	    	for (int i = 0; i < loadParameters.getEnvironment().getParameters().size(); i++){
	    		if (loadParameters.getEnvironment().getParameters().get(i) instanceof AgentParam){
	    			if (((AgentParam)loadParameters.getEnvironment().getParameters().get(i)).getAgent().getName().equals(ev.getAgent().getReference().getName())){
	    				agentList.add(loadParameters.getEnvironment().getParameters().get(i).getName());
	    			}
	    		}
	    		
	    		if (loadParameters.getEnvironment().getParameters().get(i) instanceof ObserverParam){
	    			if (((ObserverParam)loadParameters.getEnvironment().getParameters().get(i)).getObserver().getName().equals(ev.getAgent().getReference().getName())){
	    				agentList.add(loadParameters.getEnvironment().getParameters().get(i).getName());
	    			}
	    		}
	    		
	    		if (loadParameters.getEnvironment().getParameters().get(i) instanceof GeneralParam){
	    			if (((GeneralParam)loadParameters.getEnvironment().getParameters().get(i)).getGeneralType().getName().equals(ev.getAgent().getReference().getName())){
	    				agentList.add(loadParameters.getEnvironment().getParameters().get(i).getName());
	    			}
	    		}
	    	}
	    	
	    	// Removing duplicates
	    	HashSet <String> agentSet = new HashSet<String>();
	    	agentSet.addAll(Arrays.asList(agentList.getItems()));
	    	agentList.removeAll();
	    	
	    	Iterator <String> agentIt = agentSet.iterator();
	    	while (agentIt.hasNext()){
	    		agentList.add(agentIt.next());
	    	}

	    	lists.add(agentList);

	        Button agentButton = new Button(agentComp, SWT.PUSH);
	        agentButton.setText("Add Parameter");
	        agentButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
	        agentButton.addListener(SWT.Selection, listener);
	    	
	        // List of the GENERAL PARAMETERS
	    	for (int j = 0; j < newHappens.getEvent().getTypes().size(); j++){
	    		Composite paramComp = new Composite(composite, SWT.NONE);
		    	paramComp.setLayout(new GridLayout(1, true));
		    	paramComp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		    	Group paramGroup = new Group(paramComp, SWT.NONE);
		    	paramGroup.setText("Select a parameter");
		    	paramGroup.setLayout(new GridLayout(1, false));
		    	paramGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		    	List paramList = new List(paramGroup, SWT.BORDER);
		    	paramList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		    	// Looking for parameters for the general type
		    	for (int i = 0; i < loadParameters.getEnvironment().getParameters().size(); i++){
		    		if (loadParameters.getEnvironment().getParameters().get(i) instanceof AgentParam){
		    			if (((AgentParam)loadParameters.getEnvironment().getParameters().get(i)).getAgent().getName().equals(ev.getTypes().get(j).getReference().getName())){
		    				paramList.add(loadParameters.getEnvironment().getParameters().get(i).getName());
		    			}
		    		}
		    		
		    		if (loadParameters.getEnvironment().getParameters().get(i) instanceof ObserverParam){
		    			if (((ObserverParam)loadParameters.getEnvironment().getParameters().get(i)).getObserver().getName().equals(ev.getTypes().get(j).getReference().getName())){
		    				paramList.add(loadParameters.getEnvironment().getParameters().get(i).getName());
		    			}
		    		}
		    		
		    		if (loadParameters.getEnvironment().getParameters().get(i) instanceof GeneralParam){
		    			if (((GeneralParam)loadParameters.getEnvironment().getParameters().get(i)).getGeneralType().getName().equals(ev.getTypes().get(j).getReference().getName())){
		    				paramList.add(loadParameters.getEnvironment().getParameters().get(i).getName());
		    			}
		    		}
		    	}
		    	Button paramButton = new Button(paramComp, SWT.PUSH);
			    paramButton.setText("Add Parameter");
			    paramButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
			    paramButton.addListener(SWT.Selection, listener);
			    
			    // Removing duplicates
			    HashSet <String> paramSet = new HashSet<String>();
			    paramSet.addAll(Arrays.asList(paramList.getItems()));
			    paramList.removeAll();
		    	
		    	Iterator <String> paramIt = paramSet.iterator();
		    	while (paramIt.hasNext()){
		    		paramList.add(paramIt.next());
		    	}
		    	
			    lists.add(paramList);
		    	
	    	}
	    	
	    	// List of the OBSERVER PARAMETERS
	    	Composite observerComp = new Composite(composite, SWT.NONE);
	    	observerComp.setLayout(new GridLayout(1, true));
	    	observerComp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    	Group observerGroup = new Group(observerComp, SWT.NONE);
	    	observerGroup.setText("Select a parameter");
	    	observerGroup.setLayout(new GridLayout(1, false));
	    	observerGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    	List observerList = new List(observerGroup, SWT.BORDER);
	    	observerList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    	// Looking for parameters for the observer type
	    	for (int i = 0; i < loadParameters.getEnvironment().getParameters().size(); i++){
	    		if (loadParameters.getEnvironment().getParameters().get(i) instanceof AgentParam){
	    			if (((AgentParam)loadParameters.getEnvironment().getParameters().get(i)).getAgent().getName().equals(ev.getObserver().getReference().getName())){
	    				observerList.add(loadParameters.getEnvironment().getParameters().get(i).getName());
	    			}
	    		}
	    		
	    		if (loadParameters.getEnvironment().getParameters().get(i) instanceof ObserverParam){
	    			if (((ObserverParam)loadParameters.getEnvironment().getParameters().get(i)).getObserver().getName().equals(ev.getObserver().getReference().getName())){
	    				observerList.add(loadParameters.getEnvironment().getParameters().get(i).getName());
	    			}
	    		}
	    		
	    		if (loadParameters.getEnvironment().getParameters().get(i) instanceof GeneralParam){
	    			if (((GeneralParam)loadParameters.getEnvironment().getParameters().get(i)).getGeneralType().getName().equals(ev.getObserver().getReference().getName())){
	    				observerList.add(loadParameters.getEnvironment().getParameters().get(i).getName());
	    			}
	    		}
	    	}
	    	Button observerButton = new Button(observerComp, SWT.PUSH);
		    observerButton.setText("Add Parameter");
		    observerButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
		    observerButton.addListener(SWT.Selection, listener);
		    
		    // Removing duplicates
		    HashSet <String> observerSet = new HashSet<String>();
		    observerSet.addAll(Arrays.asList(observerList.getItems()));
		    observerList.removeAll();
	    	
	    	Iterator <String> observerIt = observerSet.iterator();
	    	while (observerIt.hasNext()){
	    		observerList.add(observerIt.next());
	    	}
		    lists.add(observerList);
	    	
	    	
	    } // Primitive Event
	    if (newHappens.getEvent() instanceof ComplexEvent){
	    	ComplexEvent ev = (ComplexEvent) newHappens.getEvent();
	    	
	    	// List of the AGENT PARAMETERS
	    	Composite agentComp = new Composite(composite, SWT.NONE);
	    	agentComp.setLayout(new GridLayout(1, true));
	    	agentComp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    	Group agentGroup = new Group(agentComp, SWT.NONE);
	    	agentGroup.setText("Select a parameter");
	    	agentGroup.setLayout(new GridLayout(1, false));
	    	agentGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    	List agentList = new List(agentGroup, SWT.BORDER);
	    	agentList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    	// Looking for parameters for the agent type
	    	for (int i = 0; i < loadParameters.getEnvironment().getParameters().size(); i++){
	    		if (loadParameters.getEnvironment().getParameters().get(i) instanceof AgentParam){
	    			if (((AgentParam)loadParameters.getEnvironment().getParameters().get(i)).getAgent().getName().equals(ev.getAgent().getReference().getName())){
	    				agentList.add(loadParameters.getEnvironment().getParameters().get(i).getName());
	    			}
	    		}
	    		
	    		if (loadParameters.getEnvironment().getParameters().get(i) instanceof ObserverParam){
	    			if (((ObserverParam)loadParameters.getEnvironment().getParameters().get(i)).getObserver().getName().equals(ev.getAgent().getReference().getName())){
	    				agentList.add(loadParameters.getEnvironment().getParameters().get(i).getName());
	    			}
	    		}
	    		
	    		if (loadParameters.getEnvironment().getParameters().get(i) instanceof GeneralParam){
	    			if (((GeneralParam)loadParameters.getEnvironment().getParameters().get(i)).getGeneralType().getName().equals(ev.getAgent().getReference().getName())){
	    				agentList.add(loadParameters.getEnvironment().getParameters().get(i).getName());
	    			}
	    		}
	    	}
	    	List temp = agentList;
	    	for (int i = 0; i < agentList.getItems().length; i++){
	    		for (int j = 0; j < temp.getItems().length; j++){
	    			if ((i != j) && (agentList.getItems()[i].equals(temp.getItems()[j]))){
	    				temp.remove(j);
	    				j--;
	    			}
	    		}
	    	}
	    	agentList = temp;
	    	lists.add(agentList);

	        Button agentButton = new Button(agentComp, SWT.PUSH);
	        agentButton.setText("Add Parameter");
	        agentButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
	        agentButton.addListener(SWT.Selection, listener);
	    	
	        // List of the GENERAL PARAMETERS
	    	for (int j = 0; j < newHappens.getEvent().getTypes().size(); j++){
	    		Composite paramComp = new Composite(composite, SWT.NONE);
		    	paramComp.setLayout(new GridLayout(1, true));
		    	paramComp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		    	Group paramGroup = new Group(paramComp, SWT.NONE);
		    	paramGroup.setText("Select a parameter");
		    	paramGroup.setLayout(new GridLayout(1, false));
		    	paramGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		    	List paramList = new List(paramGroup, SWT.BORDER);
		    	paramList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		    	// Looking for parameters for the general type
		    	for (int i = 0; i < loadParameters.getEnvironment().getParameters().size(); i++){
		    		if (loadParameters.getEnvironment().getParameters().get(i) instanceof AgentParam){
		    			if (((AgentParam)loadParameters.getEnvironment().getParameters().get(i)).getAgent().getName().equals(ev.getTypes().get(j).getReference().getName())){
		    				paramList.add(loadParameters.getEnvironment().getParameters().get(i).getName());
		    			}
		    		}
		    		
		    		if (loadParameters.getEnvironment().getParameters().get(i) instanceof ObserverParam){
		    			if (((ObserverParam)loadParameters.getEnvironment().getParameters().get(i)).getObserver().getName().equals(ev.getTypes().get(j).getReference().getName())){
		    				paramList.add(loadParameters.getEnvironment().getParameters().get(i).getName());
		    			}
		    		}
		    		
		    		if (loadParameters.getEnvironment().getParameters().get(i) instanceof GeneralParam){
		    			if (((GeneralParam)loadParameters.getEnvironment().getParameters().get(i)).getGeneralType().getName().equals(ev.getTypes().get(j).getReference().getName())){
		    				paramList.add(loadParameters.getEnvironment().getParameters().get(i).getName());
		    			}
		    		}
		    	}
		    	Button paramButton = new Button(paramComp, SWT.PUSH);
			    paramButton.setText("Add Parameter");
			    paramButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
			    paramButton.addListener(SWT.Selection, listener);
			    List temp2 = paramList;
		    	for (int i = 0; i < agentList.getItems().length; i++){
		    		for (int m = 0; m < temp2.getItems().length; m++){
		    			if ((i != m) && (agentList.getItems()[i].equals(temp2.getItems()[m]))){
		    				temp2.remove(m);
		    				m--;
		    			}
		    		}
		    	}
		    	paramList = temp2;
			    lists.add(paramList);
		    	
	    	} 
	    
	    } // Complex event
	    
	  
	    /*
	    if (newHappens.getEvent() instanceof PrimitiveEvent){
	    	PrimitiveEvent ev = (PrimitiveEvent) newHappens.getEvent();
	    	
	    	// LIST OF THE AGENT PARAMETERS
	    	Composite agentComp = new Composite(composite, SWT.NONE);
	    	agentComp.setLayout(new GridLayout(1, true));
	    	agentComp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    	Group agentGroup = new Group(agentComp, SWT.NONE);
	    	agentGroup.setText("Select a parameter");
	    	agentGroup.setLayout(new GridLayout(1, false));
	    	agentGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    	List agentList = new List(agentGroup, SWT.BORDER);
	    	agentList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		    
		    // Looking for all the agents parameters of the predicate Happens
		    for (int j = 0; j < bd.getHappens().size(); j++){
		    	Happens h = bd.getHappens().get(j);
		    	for (int m = 0; m < h.getParameters().size(); m++){
		    		if (h.getParameters().get(m) instanceof AgentParam){
		    			if (((AgentParam) (h.getParameters().get(m))).getAgent().getName().equals(ev.getAgent().getReference().getName())){
		    				agentList.add(h.getParameters().get(m).getName());
		    			}
		    		}
		    	}
		    }
		    
		    // Looking for all the dynamic parameters of the predicate HoldsAt
		    for (int j = 0; j < bd.getHoldsAts().size(); j++){
		    	HoldsAt h = bd.getHoldsAts().get(j);
		    	for (int m = 0; m < h.getParameters().size(); m++){
		    		if (h.getParameters().get(m) instanceof AgentParam){
		    			if (((AgentParam)h.getParameters().get(m)).getAgent().getName().equals(ev.getAgent().getReference().getName())){
		    				agentList.add(h.getParameters().get(m).getName());
		    			}
		    		}
		    		if (h.getParameters().get(m) instanceof ObserverParam){
		    			if (((ObserverParam)h.getParameters().get(m)).getObserver().getName().equals(ev.getAgent().getReference().getName())){
		    				agentList.add(h.getParameters().get(m).getName());
		    			}
		    		}
		    		if (h.getParameters().get(m) instanceof GeneralParam){
		    			if (((GeneralParam)h.getParameters().get(m)).getGeneralParam().getName().equals(ev.getAgent().getReference().getName())){
		    				agentList.add(h.getParameters().get(m).getName());
		    			}
		    		}
		    	}
		    }
		    
		    // Looking for all the dynamic parameters of the predicate HoldsAtBetween
		    for (int j = 0; j < bd.getHoldsAtBetweens().size(); j++){
		    	HoldsAtBetween h = bd.getHoldsAtBetweens().get(j);
		    	for (int m = 0; m < h.getParameters().size(); m++){
		    		if (h.getParameters().get(m) instanceof AgentParam){
		    			if (((AgentParam)h.getParameters().get(m)).getAgent().getName().equals(ev.getAgent().getReference().getName())){
		    				agentList.add(h.getParameters().get(m).getName());
		    			}
		    		}
		    		if (h.getParameters().get(m) instanceof ObserverParam){
		    			if (((ObserverParam)h.getParameters().get(m)).getObserver().getName().equals(ev.getAgent().getReference().getName())){
		    				agentList.add(h.getParameters().get(m).getName());
		    			}
		    		}
		    		if (h.getParameters().get(m) instanceof GeneralParam){
		    			if (((GeneralParam)h.getParameters().get(m)).getGeneralParam().getName().equals(ev.getAgent().getReference().getName())){
		    				agentList.add(h.getParameters().get(m).getName());
		    			}
		    		}
		    	}		    
		    }
		    lists.add(agentList);

	        Button agentButton = new Button(agentComp, SWT.PUSH);
	        agentButton.setText("Add Parameter");
	        agentButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
	        agentButton.addListener(SWT.Selection, listener);

	         
		    // LIST OF THE GENERIC PARAMETERS
		    for (int i = 0; i < ev.getTypes().size(); i++){
		    	Composite paramComp = new Composite(composite, SWT.NONE);
		    	paramComp.setLayout(new GridLayout(1, true));
		    	paramComp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		    	Group paramGroup = new Group(paramComp, SWT.NONE);
		    	paramGroup.setText("Select a parameter");
		    	paramGroup.setLayout(new GridLayout(1, false));
		    	paramGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		    	List paramList = new List(paramGroup, SWT.BORDER);
		    	paramList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		    	
		    	for (int j = 0; j < bd.getHappens().size(); j++){
			    	Happens h = bd.getHappens().get(j);
			    	for (int m = 0; m < h.getParameters().size(); m++){
			    		if (h.getParameters().get(m) instanceof GeneralParam){
			    			if (((GeneralParam) (h.getParameters().get(m))).getGeneralParam().getName().equals(ev.getTypes().get(i).getReference().getName())){
			    				paramList.add(h.getParameters().get(m).getName());
			    			}
			    		}
			    	}
			    }
		    	
		    	 // Looking for all the dynamic parameters of the predicate HoldsAt
			    for (int j = 0; j < bd.getHoldsAts().size(); j++){
			    	HoldsAt h = bd.getHoldsAts().get(j);
			    	for (int m = 0; m < h.getParameters().size(); m++){
			    		if (h.getParameters().get(m) instanceof AgentParam){
			    			if (((AgentParam)h.getParameters().get(m)).getAgent().getName().equals(ev.getTypes().get(i).getReference().getName())){
			    				paramList.add(h.getParameters().get(m).getName());
			    			}
			    		}
			    		if (h.getParameters().get(m) instanceof ObserverParam){
			    			if (((ObserverParam)h.getParameters().get(m)).getObserver().getName().equals(ev.getTypes().get(i).getReference().getName())){
			    				paramList.add(h.getParameters().get(m).getName());
			    			}
			    		}
			    		if (h.getParameters().get(m) instanceof GeneralParam){
			    			if (((GeneralParam)h.getParameters().get(m)).getGeneralParam().getName().equals(ev.getTypes().get(i).getReference().getName())){
			    				paramList.add(h.getParameters().get(m).getName());
			    			}
			    		}
			    	}
			    }
		    	 // Looking for all the dynamic parameters of the predicate HoldsAtBetween
			    for (int j = 0; j < bd.getHoldsAtBetweens().size(); j++){
			    	HoldsAtBetween h = bd.getHoldsAtBetweens().get(j);
			    	for (int m = 0; m < h.getParameters().size(); m++){
			    		if (h.getParameters().get(m) instanceof AgentParam){
			    			if (((AgentParam)h.getParameters().get(m)).getAgent().getName().equals(ev.getTypes().get(i).getReference().getName())){
			    				paramList.add(h.getParameters().get(m).getName());
			    			}
			    		}
			    		if (h.getParameters().get(m) instanceof ObserverParam){
			    			if (((ObserverParam)h.getParameters().get(m)).getObserver().getName().equals(ev.getTypes().get(i).getReference().getName())){
			    				paramList.add(h.getParameters().get(m).getName());
			    			}
			    		}
			    		if (h.getParameters().get(m) instanceof GeneralParam){
			    			if (((GeneralParam)h.getParameters().get(m)).getGeneralParam().getName().equals(ev.getTypes().get(i).getReference().getName())){
			    				paramList.add(h.getParameters().get(m).getName());
			    			}
			    		}
			    	}
			    }
			    
			    Button paramButton = new Button(paramComp, SWT.PUSH);
			    paramButton.setText("Add Parameter");
			    paramButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
			    paramButton.addListener(SWT.Selection, listener);
			    
			    lists.add(paramList);
		    	
		    }
		    
		    
		    // List of the OBSERVER PARAMETERS
	    	Composite observerComp = new Composite(composite, SWT.NONE);
	    	observerComp.setLayout(new GridLayout(1, true));
	    	observerComp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    	Group observerGroup = new Group(observerComp, SWT.NONE);
	    	observerGroup.setText("Select a parameter");
	    	observerGroup.setLayout(new GridLayout(1, false));
	    	observerGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    	List observerList = new List(observerGroup, SWT.BORDER);
	    	observerList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		    
	    	// Looking for all the observer parameters of the predicate Happens
		    for (int j = 0; j < bd.getHappens().size(); j++){
		    	Happens h = bd.getHappens().get(j);
		    	for (int m = 0; m < h.getParameters().size(); m++){
		    		if (h.getParameters().get(m) instanceof ObserverParam){
		    			if (((ObserverParam) (h.getParameters().get(m))).getObserver().getName().equals(ev.getObserver().getReference().getName())){
		    				observerList.add(h.getParameters().get(m).getName());
		    			}
		    		}
		    	}
		    }
		    
		    // Looking for all the dynamic parameters of the predicate HoldsAt
		    for (int j = 0; j < bd.getHoldsAts().size(); j++){
		    	HoldsAt h = bd.getHoldsAts().get(j);
		    	for (int m = 0; m < h.getParameters().size(); m++){
		    		if (h.getParameters().get(m) instanceof AgentParam){
		    			if (((AgentParam)h.getParameters().get(m)).getAgent().getName().equals(ev.getObserver().getReference().getName())){
		    				observerList.add(h.getParameters().get(m).getName());
		    			}
		    		}
		    		if (h.getParameters().get(m) instanceof ObserverParam){
		    			if (((ObserverParam)h.getParameters().get(m)).getObserver().getName().equals(ev.getObserver().getReference().getName())){
		    				observerList.add(h.getParameters().get(m).getName());
		    			}
		    		}
		    		if (h.getParameters().get(m) instanceof GeneralParam){
		    			if (((GeneralParam)h.getParameters().get(m)).getGeneralParam().getName().equals(ev.getObserver().getReference().getName())){
		    				observerList.add(h.getParameters().get(m).getName());
		    			}
		    		}
		    	}
		    }
		    
		    // Looking for all the dynamic parameters of the predicate HoldsAtBetween
		    for (int j = 0; j < bd.getHoldsAtBetweens().size(); j++){
		    	HoldsAtBetween h = bd.getHoldsAtBetweens().get(j);
		    	for (int m = 0; m < h.getParameters().size(); m++){
		    		if (h.getParameters().get(m) instanceof AgentParam){
		    			if (((AgentParam)h.getParameters().get(m)).getAgent().getName().equals(ev.getObserver().getReference().getName())){
		    				observerList.add(h.getParameters().get(m).getName());
		    			}
		    		}
		    		if (h.getParameters().get(m) instanceof ObserverParam){
		    			if (((ObserverParam)h.getParameters().get(m)).getObserver().getName().equals(ev.getObserver().getReference().getName())){
		    				observerList.add(h.getParameters().get(m).getName());
		    			}
		    		}
		    		if (h.getParameters().get(m) instanceof GeneralParam){
		    			if (((GeneralParam)h.getParameters().get(m)).getGeneralParam().getName().equals(ev.getObserver().getReference().getName())){
		    				observerList.add(h.getParameters().get(m).getName());
		    			}
		    		}
		    	}
		    }
		    
		    Button observerButton = new Button(observerComp, SWT.PUSH);
		    observerButton.setText("Add Parameter");
		    observerButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
		    observerButton.addListener(SWT.Selection, listener);

		    lists.add(observerList);
		    
	    } // Primitive Event
	    
	    
	    
	    
	    if (newHappens.getEvent() instanceof ComplexEvent){
	    	ComplexEvent ev = (ComplexEvent) newHappens.getEvent();
	    	// LIST OF THE AGENT PARAMETERS
	    	Composite agentComp = new Composite(composite, SWT.NONE);
	    	agentComp.setLayout(new GridLayout(1, true));
	    	agentComp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    	Group agentGroup = new Group(agentComp, SWT.NONE);
	    	agentGroup.setText("Select a parameter");
	    	agentGroup.setLayout(new GridLayout(1, false));
	    	agentGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    	List agentList = new List(agentGroup, SWT.BORDER);
	    	agentList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		    
		    // Looking for all the agents parameters of the predicate Happens
		    for (int j = 0; j < bd.getHappens().size(); j++){
		    	Happens h = bd.getHappens().get(j);
		    	for (int m = 0; m < h.getParameters().size(); m++){
		    		if (h.getParameters().get(m) instanceof AgentParam){
		    			if (((AgentParam) (h.getParameters().get(m))).getAgent().getName().equals(ev.getAgent().getReference().getName())){
		    				agentList.add(h.getParameters().get(m).getName());
		    			}
		    		}
		    	}
		    }
		    
		    // Looking for all the dynamic parameters of the predicate HoldsAt
		    for (int j = 0; j < bd.getHoldsAts().size(); j++){
		    	HoldsAt h = bd.getHoldsAts().get(j);
		    	for (int m = 0; m < h.getParameters().size(); m++){
		    		if (h.getParameters().get(m) instanceof AgentParam){
		    			if (((AgentParam)h.getParameters().get(m)).getAgent().getName().equals(ev.getAgent().getReference().getName())){
		    				agentList.add(h.getParameters().get(m).getName());
		    			}
		    		}
		    		if (h.getParameters().get(m) instanceof ObserverParam){
		    			if (((ObserverParam)h.getParameters().get(m)).getObserver().getName().equals(ev.getAgent().getReference().getName())){
		    				agentList.add(h.getParameters().get(m).getName());
		    			}
		    		}
		    		if (h.getParameters().get(m) instanceof GeneralParam){
		    			if (((GeneralParam)h.getParameters().get(m)).getGeneralParam().getName().equals(ev.getAgent().getReference().getName())){
		    				agentList.add(h.getParameters().get(m).getName());
		    			}
		    		}
		    	}
		    }
		    
		    // Looking for all the dynamic parameters of the predicate HoldsAtBetween
		    for (int j = 0; j < bd.getHoldsAtBetweens().size(); j++){
		    	HoldsAtBetween h = bd.getHoldsAtBetweens().get(j);
		    	for (int m = 0; m < h.getParameters().size(); m++){
		    		if (h.getParameters().get(m) instanceof AgentParam){
		    			if (((AgentParam)h.getParameters().get(m)).getAgent().getName().equals(ev.getAgent().getReference().getName())){
		    				agentList.add(h.getParameters().get(m).getName());
		    			}
		    		}
		    		if (h.getParameters().get(m) instanceof ObserverParam){
		    			if (((ObserverParam)h.getParameters().get(m)).getObserver().getName().equals(ev.getAgent().getReference().getName())){
		    				agentList.add(h.getParameters().get(m).getName());
		    			}
		    		}
		    		if (h.getParameters().get(m) instanceof GeneralParam){
		    			if (((GeneralParam)h.getParameters().get(m)).getGeneralParam().getName().equals(ev.getAgent().getReference().getName())){
		    				agentList.add(h.getParameters().get(m).getName());
		    			}
		    		}
		    	}		    
		    }
		    lists.add(agentList);

	        Button agentButton = new Button(agentComp, SWT.PUSH);
	        agentButton.setText("Add Parameter");
	        agentButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
	        agentButton.addListener(SWT.Selection, listener);

	         
		    // LIST OF THE GENERIC PARAMETERS
		    for (int i = 0; i < ev.getTypes().size(); i++){
		    	Composite paramComp = new Composite(composite, SWT.NONE);
		    	paramComp.setLayout(new GridLayout(1, true));
		    	paramComp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		    	Group paramGroup = new Group(paramComp, SWT.NONE);
		    	paramGroup.setText("Select a parameter");
		    	paramGroup.setLayout(new GridLayout(1, false));
		    	paramGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		    	List paramList = new List(paramGroup, SWT.BORDER);
		    	paramList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		    	
		    	for (int j = 0; j < bd.getHappens().size(); j++){
			    	Happens h = bd.getHappens().get(j);
			    	for (int m = 0; m < h.getParameters().size(); m++){
			    		if (h.getParameters().get(m) instanceof GeneralParam){
			    			if (((GeneralParam) (h.getParameters().get(m))).getGeneralParam().getName().equals(ev.getTypes().get(i).getReference().getName())){
			    				paramList.add(h.getParameters().get(m).getName());
			    			}
			    		}
			    	}
			    }
		    	
		    	 // Looking for all the dynamic parameters of the predicate HoldsAt
			    for (int j = 0; j < bd.getHoldsAts().size(); j++){
			    	HoldsAt h = bd.getHoldsAts().get(j);
			    	for (int m = 0; m < h.getParameters().size(); m++){
			    		if (h.getParameters().get(m) instanceof AgentParam){
			    			if (((AgentParam)h.getParameters().get(m)).getAgent().getName().equals(ev.getTypes().get(i).getReference().getName())){
			    				paramList.add(h.getParameters().get(m).getName());
			    			}
			    		}
			    		if (h.getParameters().get(m) instanceof ObserverParam){
			    			if (((ObserverParam)h.getParameters().get(m)).getObserver().getName().equals(ev.getTypes().get(i).getReference().getName())){
			    				paramList.add(h.getParameters().get(m).getName());
			    			}
			    		}
			    		if (h.getParameters().get(m) instanceof GeneralParam){
			    			if (((GeneralParam)h.getParameters().get(m)).getGeneralParam().getName().equals(ev.getTypes().get(i).getReference().getName())){
			    				paramList.add(h.getParameters().get(m).getName());
			    			}
			    		}
			    	}
			    }
		    	 // Looking for all the dynamic parameters of the predicate HoldsAtBetween
			    for (int j = 0; j < bd.getHoldsAtBetweens().size(); j++){
			    	HoldsAtBetween h = bd.getHoldsAtBetweens().get(j);
			    	for (int m = 0; m < h.getParameters().size(); m++){
			    		if (h.getParameters().get(m) instanceof AgentParam){
			    			if (((AgentParam)h.getParameters().get(m)).getAgent().getName().equals(ev.getTypes().get(i).getReference().getName())){
			    				paramList.add(h.getParameters().get(m).getName());
			    			}
			    		}
			    		if (h.getParameters().get(m) instanceof ObserverParam){
			    			if (((ObserverParam)h.getParameters().get(m)).getObserver().getName().equals(ev.getTypes().get(i).getReference().getName())){
			    				paramList.add(h.getParameters().get(m).getName());
			    			}
			    		}
			    		if (h.getParameters().get(m) instanceof GeneralParam){
			    			if (((GeneralParam)h.getParameters().get(m)).getGeneralParam().getName().equals(ev.getTypes().get(i).getReference().getName())){
			    				paramList.add(h.getParameters().get(m).getName());
			    			}
			    		}
			    	}
			    }
			    
			    Button paramButton = new Button(paramComp, SWT.PUSH);
			    paramButton.setText("Add Parameter");
			    paramButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
			    paramButton.addListener(SWT.Selection, listener);
			    
			    lists.add(paramList);
		    	
		    } 

	    } */

    }
	    
    private void createCrMainContent() throws IOException{ 

    	if (newHoldsAt != null){
    		System.out.println("NEW HOLDS AT");

    	}
    	
    	if (newHoldsAtBetween != null){
    		
    		System.out.println("NEW HOLDS AT BETWEEN");
    	}
    }
    
    public ArrayList<String> getResults(){
    	return results;
    }
    
    
    public void okPressed(){
    	for (int i = 0; i < lists.size(); i++){
			results.add(lists.get(i).getSelection()[0]);
		}
    	if (newHappens != null){    		
    		if (newHappens.getEvent() instanceof PrimitiveEvent){   			
    			try{
    				createDynamicHappensParameter(1, results.get(0), 1);        		
        			for (int i = 1; i < results.size() - 1; i++ ){
            			createDynamicHappensParameter(3, results.get(i), i+1);
        			}
        			createDynamicHappensParameter(2, results.get(results.size()-1), results.size());
        			System.out.println("I finished to save the Primitive Event");
    			}catch(IOException e ){	
    			}
    		}
    		if (newHappens.getEvent() instanceof ComplexEvent){   			
    			try{
    				createDynamicHappensParameter(1, results.get(0), 1);        		
        			for (int i = 1; i < results.size(); i++){
            			createDynamicHappensParameter(3, results.get(i), i+1);
        			}
        			System.out.println("I finished to save the Complex Event");
    			}catch(IOException e ){	
    			}
    		}
    	}
    	
    	this.close();
    }
    /*
     * 1: agentparam
     * 2: observerparam
     * 3: generalparam
     */
    private void createDynamicHappensParameter(int number, String param, int position) throws IOException{
    	
    	LoadParameters loadParam = new LoadParameters(editFilesPath + "/default.typeInstanceModel");
    	diagramFilePath = diagramFilePath.replace("_diagram", "");
	    LoadParameters loadDynParam = new LoadParameters(diagramFilePath);

  /*  	// Check if the dynamic parameter already exists
    	for (int i = 0; i < loadDynParam.getEnvironment().getParameters().size(); i++){
    		if (loadDynParam.getEnvironment().getParameters().get(i).getName().equals(param)){
    			// Linking the newHappens with the already existing parameter
				SetRequest setRequestParameter = new SetRequest(editor.getEditingDomain(), newHappens,
						ModelPackage.eINSTANCE.getHappens_Parameters(), loadDynParam.getEnvironment().getParameters().get(i));
				SetValueCommand paramOperation = new SetValueCommand(setRequestParameter);
				editor.getDiagramEditDomain().getDiagramCommandStack()
						.execute(new ICommandProxy(paramOperation));
				System.out.println("I did it");
				System.out.println("This one: "+loadDynParam.getEnvironment().getParameters().get(i).getName() + " is equal to this one: " + param);

    			return;
    		}
    	} */
    	
    	switch(number){
	    	case 1:{

	    		// Creating AgentParam and Agent
    			Command cmd = editor.createAndExecuteShapeRequestCommand(
    					behavDesc.model.diagram.providers.ModelElementTypes.AgentParam_2005, editor.getDiagramEditPart());
    			editor.getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack();
    
    			
    			// Creating and executing the command to set the properties
    			Collection<?> result = DiagramCommandStack.getReturnValues(cmd);
    			Iterator<?> iter = result.iterator();
    			AgentParam newAgent = new AgentParamImpl();
    			while (iter.hasNext()) {
    				Object obj = iter.next();
    				if (obj instanceof CreateElementRequestAdapter) {
    					CreateElementRequestAdapter cra = (CreateElementRequestAdapter) obj;
    					
    					if (cra.resolve() instanceof AgentParamImpl){
    						System.out.println("Creating AgentParam...");
    						newAgent = (AgentParamImpl) cra.resolve();
    						
        					// Setting the AgentParam EReference of the Happens
        					SetRequest setRequestAgent = new SetRequest(editor.getEditingDomain(), newHappens,
        							ModelPackage.eINSTANCE.getHappens_Parameters(), newAgent);
        					SetValueCommand agentOperation = new SetValueCommand(setRequestAgent);
        					editor.getDiagramEditDomain().getDiagramCommandStack()
        							.execute(new ICommandProxy(agentOperation));
        					
        					SetRequest setRequestAgentName = new SetRequest(editor.getEditingDomain(), newAgent,
        							ModelPackage.eINSTANCE.getParameter_Name(), param);
        					SetValueCommand agentNameOperation = new SetValueCommand(setRequestAgentName);
        					editor.getDiagramEditDomain().getDiagramCommandStack()
        							.execute(new ICommandProxy(agentNameOperation));
        					
        					SetRequest setRequestAgentPosition = new SetRequest(editor.getEditingDomain(), newAgent,
        							ModelPackage.eINSTANCE.getParameter_Position(), position);
        					SetValueCommand agentPositionOperation = new SetValueCommand(setRequestAgentPosition);
        					editor.getDiagramEditDomain().getDiagramCommandStack()
        							.execute(new ICommandProxy(agentPositionOperation));
        					
    					}
    					
    				}
    			}
    			
    			// Looking for the Agent the user decided to associate to the AgentParam
    			for (int i = 0; i < loadParam.getEnvironment().getTypes().size(); i++) {
    				if (newHappens.getEvent() instanceof PrimitiveEvent){
    					if (((PrimitiveEvent) newHappens.getEvent()).getAgent().getReference().getName().equals(loadParam.getEnvironment().getTypes().get(i).getName())){
    						SetRequest setRequestAgentAgent = new SetRequest(editor.getEditingDomain(), newAgent,
        							ModelPackage.eINSTANCE.getAgentParam_Agent(), loadParam.getEnvironment().getTypes().get(i));
        					SetValueCommand agentAgentOperation = new SetValueCommand(setRequestAgentAgent);
        					editor.getDiagramEditDomain().getDiagramCommandStack()
        							.execute(new ICommandProxy(agentAgentOperation));
    					}
    						
    				}
    				if (newHappens.getEvent() instanceof ComplexEvent){
    					if (((ComplexEvent) newHappens.getEvent()).getAgent().getReference().getName().equals(loadParam.getEnvironment().getTypes().get(i).getName())){
    						SetRequest setRequestAgentAgent = new SetRequest(editor.getEditingDomain(), newAgent,
        							ModelPackage.eINSTANCE.getAgentParam_Agent(), loadParam.getEnvironment().getTypes().get(i));
        					SetValueCommand agentAgentOperation = new SetValueCommand(setRequestAgentAgent);
        					editor.getDiagramEditDomain().getDiagramCommandStack()
        							.execute(new ICommandProxy(agentAgentOperation));
    					}
    						
    				}
    				
    				
    				
    			}
	    		
	    		
	    	} break;
	    	
	    	case 2:{
	    		// Creating ObserverParam and Observer
    			Command cmd = editor.createAndExecuteShapeRequestCommand(
    					behavDesc.model.diagram.providers.ModelElementTypes.ObserverParam_2006, editor.getDiagramEditPart());
    			editor.getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack();
    
    			
    			// Creating and executing the command to set the properties
    			Collection<?> result = DiagramCommandStack.getReturnValues(cmd);
    			Iterator<?> iter = result.iterator();
    			ObserverParam newObserver = new ObserverParamImpl();
    			while (iter.hasNext()) {
    				Object obj = iter.next();
    				if (obj instanceof CreateElementRequestAdapter) {
    					CreateElementRequestAdapter cra = (CreateElementRequestAdapter) obj;
    					
    					if (cra.resolve() instanceof ObserverParamImpl){
    						System.out.println("Creating ObserverParam...");
    						newObserver = (ObserverParamImpl) cra.resolve();
    						
        					// Setting the ObserverParam EReference of the Happens
        					SetRequest setRequestObserver = new SetRequest(editor.getEditingDomain(), newHappens,
        							ModelPackage.eINSTANCE.getHappens_Parameters(), newObserver);
        					SetValueCommand observerOperation = new SetValueCommand(setRequestObserver);
        					editor.getDiagramEditDomain().getDiagramCommandStack()
        							.execute(new ICommandProxy(observerOperation));
        					
        					SetRequest setRequestObserverName = new SetRequest(editor.getEditingDomain(), newObserver,
        							ModelPackage.eINSTANCE.getParameter_Name(), param);
        					SetValueCommand observerNameOperation = new SetValueCommand(setRequestObserverName);
        					editor.getDiagramEditDomain().getDiagramCommandStack()
        							.execute(new ICommandProxy(observerNameOperation));
        					
        					//TODO: assign position
        					SetRequest setRequestObserverPosition = new SetRequest(editor.getEditingDomain(), newObserver,
        							ModelPackage.eINSTANCE.getParameter_Position(), position);
        					SetValueCommand observerPositionOperation = new SetValueCommand(setRequestObserverPosition);
        					editor.getDiagramEditDomain().getDiagramCommandStack()
        							.execute(new ICommandProxy(observerPositionOperation));
        					
    					}
    					
    				}
    			}
    			
    			// Looking for the Observer the user decided to associate to the ObserverParam
    			for (int i = 0; i < loadParam.getEnvironment().getTypes().size(); i++) {
    				if (newHappens.getEvent() instanceof PrimitiveEvent){
    					if (((PrimitiveEvent) newHappens.getEvent()).getObserver().getReference().getName().equals(loadParam.getEnvironment().getTypes().get(i).getName())){
    						SetRequest setRequestObserverObserver = new SetRequest(editor.getEditingDomain(), newObserver,
        							ModelPackage.eINSTANCE.getObserverParam_Observer(), loadParam.getEnvironment().getTypes().get(i));
        					SetValueCommand observerObserverOperation = new SetValueCommand(setRequestObserverObserver);
        					editor.getDiagramEditDomain().getDiagramCommandStack()
        							.execute(new ICommandProxy(observerObserverOperation));
    					}
    						
    				}
	
    			}
	    		
    			// No observers in ComplexEvent
	    		
	    	} break;
	    	
	    	case 3:{
		    		// Creating GeneralParam and GeneralType
	    			Command cmd = editor.createAndExecuteShapeRequestCommand(
	    					behavDesc.model.diagram.providers.ModelElementTypes.GeneralParam_2007, editor.getDiagramEditPart());
	    			editor.getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack();
	    
	    			
	    			// Creating and executing the command to set the properties
	    			Collection<?> result = DiagramCommandStack.getReturnValues(cmd);
	    			Iterator<?> iter = result.iterator();
	    			GeneralParam newParam = new GeneralParamImpl();
	    			while (iter.hasNext()) {
	    				Object obj = iter.next();
	    				if (obj instanceof CreateElementRequestAdapter) {
	    					CreateElementRequestAdapter cra = (CreateElementRequestAdapter) obj;
	    					
	    					if (cra.resolve() instanceof GeneralParamImpl){
	    						System.out.println("Creating GeneralParam...");
	    						newParam = (GeneralParamImpl) cra.resolve();
	    						
	        					// Setting the GeneralParam EReference of the Happens
	        					SetRequest setRequestParam = new SetRequest(editor.getEditingDomain(), newHappens,
	        							ModelPackage.eINSTANCE.getHappens_Parameters(), newParam);
	        					SetValueCommand paramOperation = new SetValueCommand(setRequestParam);
	        					editor.getDiagramEditDomain().getDiagramCommandStack()
	        							.execute(new ICommandProxy(paramOperation));
	        					
	        					SetRequest setRequestParamName = new SetRequest(editor.getEditingDomain(), newParam,
	        							ModelPackage.eINSTANCE.getParameter_Name(), param);
	        					SetValueCommand paramNameOperation = new SetValueCommand(setRequestParamName);
	        					editor.getDiagramEditDomain().getDiagramCommandStack()
	        							.execute(new ICommandProxy(paramNameOperation));

	        					SetRequest setRequestParamPosition = new SetRequest(editor.getEditingDomain(), newParam,
	        							ModelPackage.eINSTANCE.getParameter_Position(), position);
	        					SetValueCommand paramPositionOperation = new SetValueCommand(setRequestParamPosition);
	        					editor.getDiagramEditDomain().getDiagramCommandStack()
	        							.execute(new ICommandProxy(paramPositionOperation));
	    					}
	    					
	    				}
	    			}
	    			
	    			// Looking for the Type the user decided to associate to the GeneralParam
	    			for (int i = 0; i < loadParam.getEnvironment().getTypes().size(); i++) {
	    				for (int m = 0; m < newHappens.getEvent().getTypes().size(); m++){
	    					if (newHappens.getEvent().getTypes().get(m).getReference().getName().equals(loadParam.getEnvironment().getTypes().get(i).getName())){
	    						SetRequest setRequestParamParam = new SetRequest(editor.getEditingDomain(), newParam,
	        							ModelPackage.eINSTANCE.getGeneralParam_GeneralType(), loadParam.getEnvironment().getTypes().get(i));
	        					SetValueCommand paramParamOperation = new SetValueCommand(setRequestParamParam);
	        					editor.getDiagramEditDomain().getDiagramCommandStack()
	        							.execute(new ICommandProxy(paramParamOperation));
	    					}
    					}			
	    			}

	    	
	    		
	    	} break;
	    		
	    } 
    }
    
    private void createDynamicHoldsAtParameter(int number, String param) throws IOException{
    	
    }
    
    private void createDynamicHoldsAtBetweenParameter(int number, String param) throws IOException{
    	
    }
}
    

    

