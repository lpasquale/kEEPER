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

import model.ContextRelation;
import model.Environment;
import model.ModelFactory;
import model.ModelPackage;

public class LoadContextRelation {
	
	private ModelPackage modelPackage;
	private ModelFactory modelFactory;
	private Environment env;
	private IPath path;
	
	public LoadContextRelation() throws IOException{
		
		System.out.println("I'm in LoadContextRelation");

		modelPackage = ModelPackage.eINSTANCE;
		modelFactory = model.ModelFactory.eINSTANCE;
		
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		.put(Resource.Factory.Registry.DEFAULT_EXTENSION,new XMIResourceFactoryImpl());

		// Load the resource and resolve the proxies
		ResourceSet rs = new ResourceSetImpl();
		Resource r1 = rs.createResource(URI.createFileURI("/Users/marco/Documents/runtime-EclipseApplication4/ApplicationInstance/default.contextRelationmodel"));
		r1.load(null);
		env = (Environment) r1.getContents().get(0);

		System.out.println(env.toString());
		System.out.println(env.getContextRelations().size());
		
		for (int i = 0; i< env.getContextRelations().size(); i++){
			System.out.println("Context Relation: " + env.getContextRelations().get(i).getName());
		}
		
	}
	
	public Environment getEnvironment(){
		return env;
	}
}
