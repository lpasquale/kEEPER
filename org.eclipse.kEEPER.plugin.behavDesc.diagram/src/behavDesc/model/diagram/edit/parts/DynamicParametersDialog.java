package behavDesc.model.diagram.edit.parts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.dialogs.Dialog;
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
	private String editFilesPath;
	
	private ArrayList<List> lists = new ArrayList<List>();
	private ArrayList<String> results = new ArrayList<String>();
	
	protected DynamicParametersDialog(Shell parentShell, BehaviouralDescription bd, Object newPredicate, ModelDiagramEditor editor, String editFilesPath) {
		super(parentShell);
		this.bd = bd;
		this.editor = editor;
		this.editFilesPath= editFilesPath;
		
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
	            	   
	            	   l.add("It works!");
	              }
	             
	            }
	          }; 
	}
	
	protected Control createDialogArea(Composite parent) {
        this.composite = (Composite) super.createDialogArea(parent);
        this.composite.setSize(1000,1000);

        GridLayout layout = new GridLayout(1, false);
        layout.marginHeight = 5;
        layout.marginWidth = 10;
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

	    }

    }
	    
    private void createCrMainContent() throws IOException{ 

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
    				createDynamicHappensParameter(1, results.get(0));        		
        			for (int i = 1; i < results.size() - 1; i++ ){
            			createDynamicHappensParameter(3, results.get(i));
        			}
        			createDynamicHappensParameter(2, results.get(results.size()-1));
        			System.out.println("I finished");
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
    private void createDynamicHappensParameter(int number, String param) throws IOException{
    	
    	LoadParameters loadParam = new LoadParameters(editFilesPath + "/default.typeInstanceModel");
    	
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
        					
    					}
    					
    				}
    			}
    			
    			// Looking for the Agent the user decided to associate to the AgentParam
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
	    		System.out.println(newHappens.getParameters().size());
	    		for (int j = 0; j < newHappens.getParameters().size(); j++){
	    			System.out.println(newHappens.getParameters().get(j));
	    		
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
	        					
	        					SetRequest setRequestParamName = new SetRequest(editor.getEditingDomain(), newHappens,
	        							ModelPackage.eINSTANCE.getParameter_Name(), param);
	        					SetValueCommand paramNameOperation = new SetValueCommand(setRequestParamName);
	        					editor.getDiagramEditDomain().getDiagramCommandStack()
	        							.execute(new ICommandProxy(paramNameOperation));
	        					
	    					}
	    					
	    				}
	    			}
	    			
	    			// Looking for the Type the user decided to associate to the GeneralParam
	    			for (int i = 0; i < loadParam.getEnvironment().getTypes().size(); i++) {
	    				for (int m = 0; m < newHappens.getEvent().getTypes().size(); m++){
	    					if (newHappens.getEvent().getTypes().get(m).getReference().getName().equals(loadParam.getEnvironment().getTypes().get(i).getName())){
	    						SetRequest setRequestParamParam = new SetRequest(editor.getEditingDomain(), newHappens,
	        							ModelPackage.eINSTANCE.getGeneralParam_GeneralParam(), loadParam.getEnvironment().getTypes().get(i));
	        					SetValueCommand paramParamOperation = new SetValueCommand(setRequestParamParam);
	        					editor.getDiagramEditDomain().getDiagramCommandStack()
	        							.execute(new ICommandProxy(paramParamOperation));
	    					}
    					}			
	    			}

	    		} // FOR
	    		
	    	} break;
	    		
	    } 
    }
    
    private void createDynamicHoldsAtParameter(int number, String param) throws IOException{
    	
    }
    
    private void createDynamicHoldsAtBetweenParameter(int number, String param) throws IOException{
    	
    }
}
    

    

