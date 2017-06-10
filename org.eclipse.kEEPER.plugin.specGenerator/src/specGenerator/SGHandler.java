package specGenerator;

import org.eclipse.core.commands.ExecutionEvent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.eclipse.emf.common.util.URI;


import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;





public class SGHandler extends AbstractHandler implements IHandler {

	private int hypNumber;
	private int historiesLength;
	private String targetDir;
	private URI projectURI;
	

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		GetInputDialog gid = new GetInputDialog(this, null);
		gid.create();
		gid.open();
		return null;
	}
	
	
	
	public static IProject getCurrentSelectedProject() {
	    IProject project = null;
	    ISelectionService selectionService = 
	        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();

	    ISelection selection = selectionService.getSelection();

	    if(selection instanceof IStructuredSelection) {
	        Object element = ((IStructuredSelection)selection).getFirstElement();

	        if (element instanceof IResource) {
	            project= ((IResource)element).getProject();
	        } 
	    }
	    return project;
	}
	
	
	private String getProjectURI(){
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		
		File workspaceDirectory = workspace.getRoot().getLocation().toFile();  

		projectURI = URI.createPlatformResourceURI(getCurrentSelectedProject().getName(), true);
		String projectName = projectURI.toString().replace("platform:/resource", "");

		

		return workspaceDirectory.getPath()+projectName;
	}
	
	public void invokeCommand(){
		String fromDir = getProjectURI();
		File env = new File(fromDir+"/environment.txt");
		if(!env.exists())
			MessageDialog.openError(null, "Error", "environment.txt is not present in the current project");
		
		try {
			File envExisting = new File(targetDir+"/environment.txt");
			if(envExisting.exists())
				envExisting.delete();
				
			Files.copy(Paths.get(fromDir+"/environment.txt"), Paths.get(targetDir+"/environment.txt"));
			int i=1;
			File hypFile = new File(fromDir+"/h"+i+".txt");
			if(!hypFile.exists())
				MessageDialog.openError(null, "Error", "No hypothesis was created");
			else{
				while(hypFile.exists()){
					File hypExisting = new File(targetDir+"/h"+i+".txt");
					if(hypExisting.exists())
						hypExisting.delete();
					Files.copy(Paths.get(fromDir+"/h"+i+".txt"), Paths.get(targetDir+"/h"+i+".txt"));
					i++;
					hypFile = new File(fromDir+"/h"+i+".txt");
				}
			}
			
			System.out.println("Spec Generator generated");
			SpecGenerator specGen = new SpecGenerator(targetDir, hypNumber, historiesLength);
			specGen.run();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	public void set(int hn, int hl, String targetDir){
		this.hypNumber = hn;
		this.historiesLength = hl;
		this.targetDir = targetDir;
	}

	

}
