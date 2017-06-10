package specGenerator;



import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class GetInputDialog extends TitleAreaDialog {

    private Text txtHLength;
    private Text txtHNum;
    private Text txtTargetDir;

   
    private SGHandler handler;
    

    public GetInputDialog(SGHandler handler, Shell parentShell) {
        super(parentShell);
        this.handler = handler;
    }

    @Override
    public void create() {
        super.create();
        setTitle("Get Input");
        setMessage("Insert maximum length of histories, hypothesis number and target directory", IMessageProvider.INFORMATION);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);
        Composite container = new Composite(area, SWT.NONE);
        container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        GridLayout layout = new GridLayout(2, false);
        container.setLayout(layout);

        createHystoriesLength(container);
        createHypothesisNumber(container);
        createTargetDir(container);

        return area;
    }

    private void createTargetDir(Composite container) {
        Label lbhTDir = new Label(container, SWT.NONE);
        lbhTDir.setText("Target Directory");

        GridData dataFirstName = new GridData();
        dataFirstName.grabExcessHorizontalSpace = true;
        dataFirstName.horizontalAlignment = GridData.FILL;

        txtTargetDir = new Text(container, SWT.BORDER);
        txtTargetDir.setLayoutData(dataFirstName);
    }
    
    private void createHystoriesLength(Composite container) {
        Label lbhLength = new Label(container, SWT.NONE);
        lbhLength.setText("Maximum length of hystories");

        GridData dataFirstName = new GridData();
        dataFirstName.grabExcessHorizontalSpace = true;
        dataFirstName.horizontalAlignment = GridData.FILL;

        txtHLength = new Text(container, SWT.BORDER);
        txtHLength.setLayoutData(dataFirstName);
    }

    private void createHypothesisNumber(Composite container) {
        Label lbhNum = new Label(container, SWT.NONE);
        lbhNum.setText("Hypothesis Number");

        GridData dataLastName = new GridData();
        dataLastName.grabExcessHorizontalSpace = true;
        dataLastName.horizontalAlignment = GridData.FILL;
        txtHNum = new Text(container, SWT.BORDER);
        txtHNum.setLayoutData(dataLastName);
    }



    @Override
    protected boolean isResizable() {
        return true;
    }

    

    @Override
    protected void okPressed() {
    	int hnum= 0;
    	int hLength=0;
    	try{
    		hnum = Integer.parseInt(txtHNum.getText());
    	} catch(NumberFormatException ex){
    		MessageDialog.openError(null, "Error", "Hypothesis number is incorrect");
    	}
    	try{
    		hLength = Integer.parseInt(txtHLength.getText());
    	} catch(NumberFormatException ex){
    		MessageDialog.openError(null, "Error", "Maximum Length of Histories is incorrect");	
    	}
    	handler.set(hnum, hLength, txtTargetDir.getText());
        handler.invokeCommand();
        super.okPressed();
        this.close();
    }

    
}

