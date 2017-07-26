package hypothesis.model.diagram.edit.parts;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

public class CustomListDialog extends ElementListSelectionDialog {

	public CustomListDialog(Shell parent, ILabelProvider renderer) {
		super(parent, renderer);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected Control createDialogArea(Composite parent){
		Composite control = (Composite) super.createDialogArea(parent);
		System.out.println(control.getChildren()[0].toString() + control.getChildren()[1].toString() +control.getChildren()[2].toString());
		control.getChildren()[1].setVisible(false);
		return control;
	}

}
