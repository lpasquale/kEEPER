package behavDesc.model.diagram.edit.parts;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import model.Environment;
import model.ModelFactory;
import model.ModelPackage;

public class LoadParameters {
	
	private ModelPackage modelPackage;
	private ModelFactory modelFactory;
	private Environment env;
	private String path;
	
public LoadParameters(String path) throws IOException{
		
		System.out.println("I'm in loadParameters");
		System.out.println(path);

		this.path = path;
		modelPackage = ModelPackage.eINSTANCE;
		modelFactory = model.ModelFactory.eINSTANCE;
		
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		.put(Resource.Factory.Registry.DEFAULT_EXTENSION,new XMIResourceFactoryImpl());

		// Load the resource and resolve the proxies
		ResourceSet rs = new ResourceSetImpl();

		Resource r1 = rs.createResource(URI.createFileURI(path));
		r1.load(null);
		env = (Environment) r1.getContents().get(0);
		
	}
	
	public Environment getEnvironment(){
		return env;
	}
}
