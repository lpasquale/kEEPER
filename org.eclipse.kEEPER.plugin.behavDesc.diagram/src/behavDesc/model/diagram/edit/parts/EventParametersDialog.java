package behavDesc.model.diagram.edit.parts;

import model.ComplexEvent;
import model.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class EventParametersDialog extends TitleAreaDialog{
	
	private Event event;
	private Object[] results;
	private ArrayList<Text> fields = new ArrayList<Text>();
	private ArrayList<Integer> newNumbers = new ArrayList<Integer>();
	private Map<String, Integer> map = new HashMap<String, Integer>();
	
	public EventParametersDialog(Object[] results, Shell parent){
		super(parent);
		//this.event = event;
		this.results = results;
		System.out.println("Sono in EventParametersDialog");

	}
	
	@Override
	public void create() {
	    super.create();
	    setTitle("This is my first custom dialog");
        setMessage("This is a TitleAreaDialog", IMessageProvider.INFORMATION);
	    
	}

    @Override
    protected Control createDialogArea(Composite parent) {
    	Composite area = (Composite) super.createDialogArea(parent);
        Composite container = new Composite(area, SWT.NONE);
        container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        GridLayout layout = new GridLayout(2, false);
        container.setLayout(layout);
        
        for (int i = 0; i < results.length; i++){
        	Label label = new Label(container, SWT.NONE);
        	label.setText("Parameter " + results[i]);
        	GridData data = new GridData();
            data.grabExcessHorizontalSpace = true;
            data.horizontalAlignment = GridData.FILL;
            Text field = (new Text(container, SWT.BORDER));
            field.setLayoutData(data);
            fields.add(field);

        }

        return area;
    }
    
    @Override
    protected boolean isResizable() {
        return true;
    }
    // save content of the Text fields because they get disposed
    // as soon as the Dialog closes
    private void saveInput() {
    	
    	for (int i = 0; i < fields.size(); i++){
    		map.put((String) results[i], Integer.parseInt(fields.get(i).getText()));
    	}
    }

    @Override
    protected void okPressed() {
        saveInput();
        super.okPressed();
    }

    public Map<String, Integer> getMap() {
        return map;
    }

}
