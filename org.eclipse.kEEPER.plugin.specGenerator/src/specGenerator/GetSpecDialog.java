package specGenerator;



import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


public class GetSpecDialog extends TitleAreaDialog {

    private Text txtSpec;
    private String spec;
    

   
  
    

    public GetSpecDialog(String spec, Shell parentShell) {
        super(parentShell);
        this.spec = spec;
        
    }

    @Override
    public void create() {
        super.create();
        setTitle("Generated Specification");
        setMessage("\n", IMessageProvider.INFORMATION);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);
        Composite container = new Composite(area, SWT.NONE);
        container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        GridLayout layout = new GridLayout(1, false);
        container.setLayout(layout);
        createSpecArea(area);
       

        return area;
    }

    private void createSpecArea(Composite container) {
        

        GridData dataSpec = new GridData();
        dataSpec.grabExcessHorizontalSpace = true;
        dataSpec.horizontalAlignment = GridData.FILL;

        txtSpec = new Text(container, SWT.BORDER);
        txtSpec.setLayoutData(dataSpec);
        txtSpec.setText(spec);
    }
    
   



    @Override
    protected boolean isResizable() {
        return true;
    }

    

    @Override
    protected void okPressed() {
    	
        super.okPressed();
        this.close();
    }

    
}




