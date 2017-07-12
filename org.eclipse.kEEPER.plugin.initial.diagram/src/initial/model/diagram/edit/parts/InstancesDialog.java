package initial.model.diagram.edit.parts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

import model.ContextRelation;
import model.Environment;
import model.Instance;
import model.Type;

public class InstancesDialog extends Dialog {

	private Composite composite;
	private ContextRelation cr;
	private ArrayList<List> lists = new ArrayList<List>();
	private String path;
	private Environment env;
	private Map<Type, String> results = new HashMap<Type, String>();
	
	protected InstancesDialog(Shell parentShell, ContextRelation cr, String path) {
		super(parentShell);
		this.cr = cr;
		this.path = path;
		try {
			readInstancesFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
    	createMainContent();
    }

    private void createMainContent() throws IOException{ 
	    Composite middle = new Composite(composite, SWT.NONE);
	    middle.setLayout(new GridLayout(2, true));
	    middle.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	
	    System.out.println(cr.getTypes().size());
	    System.out.println(env.getInstances());

	    for (int i = 0; i < cr.getTypes().size(); i++){
	    	Group group = new Group(middle, SWT.NONE);
	    	group.setText("Select an instance of the parameter " + cr.getTypes().get(i).getName());
		    group.setLayout(new GridLayout(1, false));
		    group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    	List list = new List(group, SWT.BORDER);
		    list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		    // Loop on all instances of the environment (I need to read the file)
		    readInstancesFile();
		    for (int j = 0; j < env.getInstances().size(); j++){
		    	System.out.println(env.getInstances().get(j).getType().getName());
		    	System.out.println(cr.getTypes().get(i).getName());

		    	if (env.getInstances().get(j).getType().getName().equals(cr.getTypes().get(i).getName())){
		    		list.add (env.getInstances().get(j).getName());
		    		System.out.println(env.getInstances().get(j).getName());
		    	}
		    }
		    lists.add(list);
	    }
	    
    }
    
    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        super.createButtonsForButtonBar(parent);

        Button ok = getButton(IDialogConstants.OK_ID);
        ok.setText("Ok");
        setButtonLayoutData(ok);

        Button cancel = getButton(IDialogConstants.CANCEL_ID);
        cancel.setText("Cancel");
        setButtonLayoutData(cancel);
    }
    
    public void okPressed()
    {
    	for (int i = 0; i < lists.size(); i++){
    		if (lists.get(i).getSelection().length > 0){
    			results.put(cr.getTypes().get(i), lists.get(i).getSelection()[0]);
    		}
    	}

    	System.out.println(results);

    	
        this.close();
        
        
    }
    
    public Map<Type, String> getResults(){
    	return results;
    }
    
   private void readInstancesFile() throws IOException{
	   
	   Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		.put(Resource.Factory.Registry.DEFAULT_EXTENSION,new XMIResourceFactoryImpl());

		// Load the resource and resolve the proxies
		ResourceSet rs = new ResourceSetImpl();
		Resource r1 = rs.createResource(URI.createFileURI(path));
		r1.load(null);
		env = (Environment) r1.getContents().get(0);
   }
}
