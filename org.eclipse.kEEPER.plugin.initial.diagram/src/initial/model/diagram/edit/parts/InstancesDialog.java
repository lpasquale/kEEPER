package initial.model.diagram.edit.parts;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

import model.ContextRelation;
import model.Environment;

public class InstancesDialog extends Dialog {

	private Composite composite;
	private ContextRelation cr;
	private ArrayList<Group> groups = new ArrayList<Group>();
	private String path;
	private Environment env;
	
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

		    groups.add(group);
	    	
	    }
	   /*
	
	    Composite buttons = new Composite(middle, SWT.NONE);
	    buttons.setLayout(new GridLayout(1, false));
	
	    Button moveUp = new Button(buttons, SWT.PUSH);
	    moveUp.setText("Move up");
	    moveUp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
	    Button moveDown = new Button(buttons, SWT.PUSH);
	    moveDown.setText("Move down");
	    moveDown.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
	    Button modify = new Button(buttons, SWT.PUSH);
	    modify.setText("Modify");
	    modify.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
	    Button remove = new Button(buttons, SWT.PUSH);
	    remove.setText("Remove");
	    remove.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
	
	    Group rightGroup = new Group(middle, SWT.NONE);
	    rightGroup.setText("Source Library(s)");
	    rightGroup.setLayout(new GridLayout(1, false));
	    rightGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	
	    List rightList = new List(rightGroup, SWT.BORDER);
	    rightList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    rightList.add("DUMMY");
	    */
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
