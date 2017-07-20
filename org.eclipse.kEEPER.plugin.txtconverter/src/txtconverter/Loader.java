package txtconverter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.ComplexEvent;
import model.Environment;
import model.Instance;
import model.ModelFactory;
import model.ModelPackage;
import model.Parameter;
import model.Type;
import model.impl.ComplexEventImpl;
import model.impl.EnvironmentImpl;


public class Loader {

	private ModelPackage modelPackage;
	//
	private ModelFactory modelFactory;
	
	public String filePath;
	
	/*
	 * Constructor of the class
	 */
	public Loader(String filePath) throws ParserConfigurationException{

		// Initialization
		modelPackage = ModelPackage.eINSTANCE;
		modelFactory = model.ModelFactory.eINSTANCE;
		this.filePath = filePath;
		System.out.println("I'm in loader and the path is: "+ filePath);
		System.out.println("I'm in loader and MY path variable is: "+ this.filePath);

	   
	}

	/*
	 * Methods that parses the XMI file of types and instances and memorize everything in the model
	 * Maybe I can find a more efficient solution later
	 */
	public Environment parseFiles() throws SAXException, IOException{
	    
		
		/************ SECOND VERSION ALGORITHM **********/
		Environment env = new EnvironmentImpl();
		Path path1 = Paths.get(filePath + "/default.bdModel");
		Path path2 = Paths.get(filePath + "/default.hypothesisModel");
		Charset charset = StandardCharsets.UTF_8;
		String content1 = new String(Files.readAllBytes(path1), charset);
		String content2 = new String(Files.readAllBytes(path2), charset);
		content1 = content1.replaceAll("file:" + filePath +"/", "");
		content2 = content2.replaceAll("file:" + filePath +"/", "");
		Files.write(path1, content1.getBytes(charset));
		Files.write(path2, content2.getBytes(charset));

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		.put(Resource.Factory.Registry.DEFAULT_EXTENSION,new XMIResourceFactoryImpl());

		// load the resource and resolve the proxies
		ResourceSet rs = new ResourceSetImpl();
		Resource r1 = rs.createResource(URI.createFileURI(filePath +"/default.typeInstanceModel"));
		Resource r2 = rs.createResource(URI.createFileURI(filePath +"/default.contextRelationModel"));
		Resource r3 = rs.createResource(URI.createFileURI(filePath +"/default.eventModel"));
		Resource r4 = rs.createResource(URI.createFileURI(filePath +"/default.bdModel"));	
		Resource r5 = rs.createResource(URI.createFileURI(filePath +"/default.hypothesisModel"));		
		Resource r6 = rs.createResource(URI.createFileURI(filePath +"/default.initialModel"));		

		r1.load(null);
		r2.load(null);
		r3.load(null);
		r4.load(null);
		r5.load(null);
		r6.load(null);
		
		//EcoreUtil.resolveAll(rs); 
		
		Environment env1 = (Environment) r1.getContents().get(0);
		Environment env2 = (Environment) r2.getContents().get(0);
		Environment env3 = (Environment) r3.getContents().get(0);
		Environment env4 = (Environment) r4.getContents().get(0);	
		Environment env5 = (Environment) r5.getContents().get(0);
		Environment env6 = (Environment) r6.getContents().get(0);	

						
		env.setTypes(env1.getTypes());
		env.setInstances(env1.getInstances());
		env.setContextRelations(env2.getContextRelations());
		env.setEvents(env3.getEvents());
		env.setBehavDescriptions(env4.getBehavDescriptions());
		env.setHypothesis(env5.getHypothesis());
		env.setInitials(env6.getInitials());
				
		// Verification
		
		for (int i = 0; i < env.getInstances().size(); i++){
			System.out.println("Instance: " + env.getInstances().get(i).getName() + "  Type: " + env.getInstances().get(i).getType().getName());
		}
		for (int i = 0; i < env.getContextRelations().size(); i++){
			if (env.getContextRelations().get(i).getInitialComplexEvent() != null && env.getContextRelations().get(i).getEndingComplexEvent() != null)
				System.out.println("Context Relation: " + env.getContextRelations().get(i).getName() + "  Parameter1: " + env.getContextRelations().get(i).getTypes().get(0).getName() +
						"  Initial Event: " + env.getContextRelations().get(i).getInitialComplexEvent().getName() +"  Ending Event: " + env.getContextRelations().get(i).getEndingComplexEvent().getName());
			else
				System.out.println("Context Relation: " + env.getContextRelations().get(i).getName() + "  Parameter1: " + env.getContextRelations().get(i).getTypes().get(0).getName());				
		}
		/*for (int i = 0; i < env.getEvents().size(); i++){
			System.out.println("Event --> "+ env.getEvents().get(i).toString() + "\nAgent: " + env.getEvents().get(i).getAgent() + "  Type: " + env.getEvents().get(i).getAgent().getType().getName());
			if (env.getEvents().get(i) instanceof ComplexEventImpl){
				ComplexEvent ce = (ComplexEvent) env.getEvents().get(i);
				for (int j = 0; j < ce.getTypes().size(); j++){
					System.out.println("Parameter " + (i+1) + ": " + ce.getParameters().get(j)+ "  Type: " + ce.getParameters().get(j).getType().getName());
				}
				for (int j = 0; j < ce.getBehaviouralDescriptions().size(); j++){
					System.out.println("Behavioural Description: " + ce.getBehaviouralDescriptions().get(j).getName());
					for (int k = 0; k < ce.getBehaviouralDescriptions().get(j).getHoldsAts().size(); k++){
						System.out.println("HoldsAt: " + (k+1) + ": " + ce.getBehaviouralDescriptions().get(j).getHoldsAts().get(k).getContextRelation().getName());
					}
					for (int k = 0; k < ce.getBehaviouralDescriptions().get(j).getHappens().size(); k++){
						System.out.println("Happens: " + (k+1) + ": " + ce.getBehaviouralDescriptions().get(j).getHappens().get(k).getEvent().getName());
					}
					for (int k = 0; k < ce.getBehaviouralDescriptions().get(j).getHoldsAtBetweens().size(); k++){
						System.out.println("HoldsAtBetween: " + (k+1) + ": " + ce.getBehaviouralDescriptions().get(j).getHoldsAtBetweens().get(k).getContextRelation().getName());
					}
				}
				System.out.println();
			}
		} */
		for (int i = 0; i < env.getInitials().size(); i++){
			System.out.println("Initial--> " + env.getInitials().get(i).getContextRelation().getName() + "  " + env.getInitials().get(i).getInstances().get(0));
		}

		return env; 
	} //parseFiles()
	
	public Environment parseDiagramFile() throws SAXException, IOException{
		Environment env = new EnvironmentImpl();	
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		.put(Resource.Factory.Registry.DEFAULT_EXTENSION,new XMIResourceFactoryImpl());

		// load the resource and resolve the proxies
		ResourceSet resSet = new ResourceSetImpl();

        // Get the resource
		System.out.println("Retrieving path again: " + this.filePath);
		File file = new File(filePath);
		System.out.println(file.canRead());
		System.out.println(file.exists());
        Resource r = resSet.createResource(URI.createFileURI(filePath));
		r.load(null);

		env = (Environment) r.getContents().get(0);
				
		// Verification
		/*
		for (int i = 0; i < env.getInstances().size(); i++){
			System.out.println("Instance: " + env.getInstances().get(i).getName() + "  Type: " + env.getInstances().get(i).getType().getName());
		}
		for (int i = 0; i < env.getContextRelations().size(); i++){
			if (env.getContextRelations().get(i).getInitialComplexEvent() != null && env.getContextRelations().get(i).getEndingComplexEvent() != null)
				System.out.println("Context Relation: " + env.getContextRelations().get(i).getName() +
						"  Parameter1: " + env.getContextRelations().get(i).getParameters().get(0).getType().getName() +
						"  Initial Event: " + env.getContextRelations().get(i).getInitialComplexEvent().getName() +
						"  Ending Event: " + env.getContextRelations().get(i).getEndingComplexEvent().getName());
			else
				System.out.println("Context Relation: " + env.getContextRelations().get(i).getName() + "  Parameter1: " + env.getContextRelations().get(i).getParameters().get(0).getType().getName());				
		}
		for (int i = 0; i < env.getEvents().size(); i++){
			if (env.getEvents().get(i) instanceof ComplexEvent){
				ComplexEvent ce = (ComplexEvent) env.getEvents().get(i);
				for (int j = 0; j < ce.getBehaviouralDescriptions().getHoldsAts().size(); j++){
					System.out.println("Event: " + env.getEvents().get(i).getName() + "  HoldsAt: " + ce.getBehaviouralDescriptions().getHoldsAts().get(j).getContextRelation().getName());
				}
				for (int j = 0; j < ce.getBehaviouralDescriptions().getHappens().size(); j++){
					System.out.println("Event: " + env.getEvents().get(i).getName() + "  Happens: " + ce.getBehaviouralDescriptions().getHappens().get(j).getEvent().getName());
				}
				for (int j = 0; j < ce.getBehaviouralDescriptions().getHoldsAtBetweens().size(); j++){
					System.out.println("Event: " + env.getEvents().get(i).getName() + "  HoldsAtBetween: " + ce.getBehaviouralDescriptions().getHoldsAtBetweens().get(j).getContextRelation().getName());
				}
			}
		}
		
		for (int i = 0; i < env.getInitials().size(); i++){
			System.out.println("Context relation: "+ env.getInitials().get(i).getContextRelation().getName() + " --> true");
		}
		
		for (int i = 0; i < env.getParameters().size(); i++){
			System.out.printf("Parameter %d: %s --> type: %s \n", i+1, env.getParameters().get(i).getName(), env.getParameters().get(i).getType().getName() );
		}
		*/
		return env;
	}

	
}
