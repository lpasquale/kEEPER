package behavDesc.model.diagram.edit.parts;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import model.Environment;
import model.Event;
import model.ModelFactory;
import model.ModelPackage;
import model.impl.EnvironmentImpl;

public class LoadEvents {
	
	private ModelPackage modelPackage;
	private ModelFactory modelFactory;
	private Environment env;
	private String path;
	
	public LoadEvents() throws IOException{
		
		System.out.println("I'm in loadEvents");
		path = System.getProperty("user.dir");
	    System.out.println("PATHH: "+ path);
		modelPackage = ModelPackage.eINSTANCE;
		modelFactory = model.ModelFactory.eINSTANCE;
		
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		.put(Resource.Factory.Registry.DEFAULT_EXTENSION,new XMIResourceFactoryImpl());

		// Load the resource and resolve the proxies
		ResourceSet rs = new ResourceSetImpl();

		Resource r1 = rs.createResource(URI.createFileURI("/Users/marco/Documents/runtime-EclipseApplication4/ApplicationInstance/default.eventModel"));
		r1.load(null);
		env = (Environment) r1.getContents().get(0);

		System.out.println(env.toString());
		System.out.println(env.getEvents().size());
		
		for (int i = 0; i< env.getEvents().size(); i++){
			System.out.println("Event: " + env.getEvents().get(i).getName());
		}
		
	}
	
	public Environment getEnvironment(){
		return env;
	}
	
}
