package behavDesc.model.diagram.edit.parts;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

import model.AgentParam;
import model.BehaviouralDescription;
import model.ComplexEvent;
import model.GeneralParam;
import model.Happens;
import model.HoldsAt;
import model.HoldsAtBetween;
import model.ObserverParam;
import model.PrimitiveEvent;

public class DynamicParametersDialog extends Dialog{

	private Composite composite;
	private BehaviouralDescription bd;
	private Happens newHappens = null;
	private HoldsAt newHoldsAt = null;
	private HoldsAtBetween newHoldsAtBetween = null;
	
	private ArrayList<List> lists = new ArrayList<List>();
	
	
	protected DynamicParametersDialog(Shell parentShell, BehaviouralDescription bd, Object newPredicate) {
		super(parentShell);
		this.bd = bd;
		if (newPredicate instanceof Happens)
			this.newHappens = (Happens) newPredicate;
		if (newPredicate instanceof HoldsAt)
			this.newHoldsAt = (HoldsAt) newPredicate;
		if (newPredicate instanceof HoldsAtBetween)
			this.newHoldsAtBetween = (HoldsAtBetween) newPredicate;
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
	    Composite middle = new Composite(composite, SWT.NONE);
	    middle.setLayout(new GridLayout(2, true));
	    middle.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

	    if (newHappens.getEvent() instanceof PrimitiveEvent){
	    	PrimitiveEvent ev = (PrimitiveEvent) newHappens.getEvent();
	    	
	    	// LIST OF THE AGENT PARAMETERS
	    	Group agentGroup = new Group(middle, SWT.NONE);
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
		    
		    
		    
		    
		    //TODO: Handle the generic parameters
		    
		    
		    
		    
		    // List of the OBSERVER PARAMETERS
	    	Group observerGroup = new Group(middle, SWT.NONE);
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
		    
		    
	    	
	    	
	    } // Primitive Event
	    
	    
	    
	    
	    if (newHappens.getEvent() instanceof ComplexEvent){
	    	ComplexEvent ev = (ComplexEvent) newHappens.getEvent();
	    	//TODO: to implement

	    }
	    
	    
	    
	    
	 /*   
	    
	    
	    
	    // Main cycle depending on the number of types of the event
	    for (int i = 0; i < newHappens.getEvent().getTypes().size(); i++){
	    	Group group = new Group(middle, SWT.NONE);
	    	group.setText("Select a parameter");
		    group.setLayout(new GridLayout(1, false));
		    group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    	List list = new List(group, SWT.BORDER);
		    list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		    
		    // Looking for all the dynamic parameters of the predicate Happens
		    for (int j = 0; j < bd.getHappens().size(); j++){
		    	
		    }
		    
		    // Looking for all the dynamic parameters of the predicate HoldsAt
		    for (int j = 0; j < bd.getHoldsAts().size(); j++){
		    	
		    }
		    
		    // Looking for all the dynamic parameters of the predicate HoldsAtBetween
		    for (int j = 0; j < bd.getHoldsAtBetweens().size(); j++){
		    	
		    }

		    lists.add(list);
	    } // Main cycle
	    
	    */
    }
	    
	    private void createCrMainContent() throws IOException{ 

    }
}
