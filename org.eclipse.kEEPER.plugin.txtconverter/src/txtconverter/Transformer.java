package txtconverter;

import model.AgentParam;
import model.BehaviouralDescription;
import model.ComplexEvent;
import model.ContextRelation;
import model.Environment;
import model.Event;
import model.GeneralParam;
import model.Happens;
import model.HoldsAt;
import model.HoldsAtBetween;
import model.Initially;
import model.Type;
import model.Parameter;
import model.ModelFactory;
import model.ObserverParam;
import model.PrimitiveEvent;
import model.impl.ComplexEventImpl;
import model.impl.PrimitiveEventImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

/*
 * This class has to create a new file .txt based on the information saved in the model
 * This class has to call the loader to parse the files XMI and then has to create the new file .txt
 * For now the Main class is calling all the methods in loader but later this class has to do this job
 */
public class Transformer {
	
	private Loader loader;
	private ModelFactory modelFactory;
	private String directoryPath;
	
	public Transformer(String filePath) throws ParserConfigurationException{

		this.directoryPath = filePath;
		
		System.out.println("I'm in transformer and the path is: "+ filePath);
		modelFactory = model.ModelFactory.eINSTANCE;
		
		this.loader = new Loader(filePath);
		
	}
	
	public boolean createTxtFile(Environment env) throws FileNotFoundException, UnsupportedEncodingException{
	    
		PrintWriter writer = new PrintWriter(directoryPath +"/environment.txt", "UTF-8");
		
		writer.println("% ****************** Environment Description ******************\n");
		writer.println("% ********* Context Description *********\n");
		writer.println("% ***** Types and Instances *****\n");
		
		// Creating list of types-instances checking duplicates
		for (int i = 0; i < env.getInstances().size(); i++){
			int counter = 0;
			for (int j = 0; j < i; j++){
				if ((env.getInstances().get(i).getName().equals(env.getInstances().get(j).getName())) && (j!=i)){
					counter++;
				}
			}
			if (counter == 0)
				writer.println(env.getInstances().get(i).getType().getName() + "(" + 
					env.getInstances().get(i).getName() + ")" + ".");
			
		}
		
		
		// CONTEXT RELATIONS OUTPUT ALGORITHM
		
		writer.println("\n\n% **** Context Relations ****\n");
		//Creating list of Context Relations
		for (int i = 0; i < env.getContextRelations().size(); i++){
			writer.printf("fluent(%s", env.getContextRelations().get(i).getName());
			writeContextRelationParameters(env.getContextRelations().get(i), writer);
			writer.printf("):-\n\t");
			for (int j = 0; j < env.getContextRelations().get(i).getTypes().size(); j++){
				if (j != env.getContextRelations().get(i).getTypes().size()-1)
					writer.printf("%s(%c), ", env.getContextRelations().get(i).getTypes().get(j).getName(),Character.toUpperCase(env.getContextRelations().get(i).getTypes().get(j).getName().charAt(0)));
				else
					writer.printf("%s(%c).\n", env.getContextRelations().get(i).getTypes().get(j).getName(),Character.toUpperCase(env.getContextRelations().get(i).getTypes().get(j).getName().charAt(0)));				
			}
		} // Context Relations
		
		
		// EVENTS OUTPUT ALGORITHM
		
		writer.println("\n\n% ********* Behaviour Description *********\n");
		writer.println("% ***** Primitive Events *****\n");
		writer.println("event(V):-\n\tpe(V).\n\n");
		// Creating list of primitive events
		for (int i = 0; i < env.getEvents().size(); i++){
			if (env.getEvents().get(i) instanceof PrimitiveEvent){
				System.out.println("Primitive event");
				writer.printf("pe("+ env.getEvents().get(i).getName());
				writeEventParameters(env.getEvents().get(i), writer);
				writer.printf("):-\n\t");
				
				writer.printf("%s(%c)", ((PrimitiveEvent)env.getEvents().get(i)).getAgent().getReference().getName(), Character.toUpperCase(((PrimitiveEvent)env.getEvents().get(i)).getAgent().getReference().getName().charAt(0)));
				for (int j = 0; j < env.getEvents().get(i).getTypes().size(); j++){
					writer.printf(", %s(%c)", env.getEvents().get(i).getTypes().get(j).getReference().getName(), Character.toUpperCase(env.getEvents().get(i).getTypes().get(j).getReference().getName().charAt(0)));
				}
				writer.printf(", %s(%c).", ((PrimitiveEvent) env.getEvents().get(i)).getObserver().getReference().getName(), Character.toUpperCase(((PrimitiveEvent) env.getEvents().get(i)).getObserver().getReference().getName().charAt(0)));
				writer.println();
				writer.println();
				if (i == env.getEvents().size() -1)
					writer.println();
			}

		} // Primitive events
		
		writer.println("% ***** Complex Events *****\n");		
		writer.printf("event(V):-\nce(V).\n\n");
		// Creating list of complex events
		for (int i = 0; i < env.getEvents().size(); i++){
			if (env.getEvents().get(i) instanceof ComplexEvent){
				writer.printf("ce("+ env.getEvents().get(i).getName());
				writeEventParameters(env.getEvents().get(i), writer);
				writer.printf("):-\n\t");
				
				writer.printf("%s(%c)", ((ComplexEvent)env.getEvents().get(i)).getAgent().getReference().getName(), Character.toUpperCase(((ComplexEvent)env.getEvents().get(i)).getAgent().getReference().getName().charAt(0)));

				for (int j = 0; j < env.getEvents().get(i).getTypes().size(); j++){
					if (j != env.getEvents().get(i).getTypes().size() - 1){
						writer.printf(", %s(%c)", env.getEvents().get(i).getTypes().get(j).getReference().getName(), Character.toUpperCase(env.getEvents().get(i).getTypes().get(j).getReference().getName().charAt(0)));
					}
					else
						writer.printf(", %s(%c).", env.getEvents().get(i).getTypes().get(j).getReference().getName(), Character.toUpperCase(env.getEvents().get(i).getTypes().get(j).getReference().getName().charAt(0)));
				}
				if (i == env.getEvents().size() -1)
					writer.println();
				writer.println();
				writer.println();
			}
		} // Complex events
		// Events
		
		
		// BEHAVIOURAL DESCRIPTIONS OUTPUT ALGORITHM
		
		writer.println("% ***** Composite Definitions *****\n");	
		
		for (int i = 0; i < env.getBehavDescriptions().size(); i++){
			
			//TODO: implementing algorithm any 
			
			// Counting how many predicates there are between the two time Instants
	        if ((env.getBehavDescriptions().get(i).isAny())&&(env.getBehavDescriptions().get(i).getFirstTimeInstant() > 0)&&(env.getBehavDescriptions().get(i).getFirstTimeInstant() < env.getBehavDescriptions().get(i).getTimeInstants()) && (env.getBehavDescriptions().get(i).getSecondTimeInstant() > 1) && (env.getBehavDescriptions().get(i).getSecondTimeInstant() <= env.getBehavDescriptions().get(i).getTimeInstants()) && (env.getBehavDescriptions().get(i).getSecondTimeInstant() > env.getBehavDescriptions().get(i).getFirstTimeInstant())){        	
	        	writeAnyBehavDesc(env.getBehavDescriptions().get(i));        	
	        }
	        else{
				System.out.println("BEHAV DESC: " + env.getBehavDescriptions().get(i).getName());
				ComplexEvent event = new ComplexEventImpl(); //Because it is a complexEvent for sure
				writer.printf("happens("+ env.getBehavDescriptions().get(i).getName());
				for (int j = 0; j < env.getEvents().size(); j++){
					if (env.getEvents().get(j).getName().equals(env.getBehavDescriptions().get(i).getName())){
						event = (ComplexEvent) env.getEvents().get(j); //Casting to ComplexEvent because for sure is a complex event
					}	
				} 
				if (event != null){
					writeEventParameters(event, writer);
				}
				
				
				// Computing the maximum time between context relations and events of a specified complex event and
				// memorizing the integer found in the arraylist for later computations
				int timeMax = -1;
				ArrayList<Integer> times = new ArrayList<Integer>();
				for (Happens h: env.getBehavDescriptions().get(i).getHappens()){
					if (h.getTime() > timeMax)
						timeMax = h.getTime();
					
					int timesCounter = 0;
					for (int j = 0; j < times.size(); j++){
						if (h.getTime() == times.get(j))
							timesCounter++;
					}
					if (timesCounter == 0)
						times.add(h.getTime());
				}
				for (HoldsAt h: env.getBehavDescriptions().get(i).getHoldsAts()){
					if (h.getTime() > timeMax)
						timeMax = h.getTime();
					
					int timesCounter = 0;
					for (int j = 0; j < times.size(); j++){
						if (h.getTime() == times.get(j))
							timesCounter++;
					}
					if (timesCounter == 0)
						times.add(h.getTime());
				}
				for (HoldsAtBetween h: env.getBehavDescriptions().get(i).getHoldsAtBetweens()){
					if (h.getInitialTime() > timeMax)
						timeMax = h.getInitialTime();
					if (h.getEndingTime() > timeMax)
						timeMax = h.getEndingTime();
					
					int timesCounter = 0;
					for (int j = 0; j < times.size(); j++){
						if (h.getInitialTime() == times.get(j))
							timesCounter++;
					}
					if (timesCounter == 0)
						times.add(h.getInitialTime());
					timesCounter = 0;
					for (int j = 0; j < times.size(); j++){
						if (h.getEndingTime() == times.get(j))
							timesCounter++;
					}
					if (timesCounter == 0)
						times.add(h.getEndingTime());				
				}
				
				// Writing the computed maximum time instant
				writer.println(",T" + timeMax + ",TR):-");
				writer.println("\ttrace(TR),");
				
				// Memorizing all the types of events and context relations related to the behavioural description
				//HashSet<Parameter> behTypes = new HashSet<Parameter>();
				ArrayList<Parameter> behTypes = new ArrayList<Parameter>();
				for (int n = 0; n < env.getBehavDescriptions().get(i).getHoldsAts().size(); n++){
					for (int m = 0; m < env.getBehavDescriptions().get(i).getHoldsAts().get(n).getParameters().size(); m++){
						System.out.println(env.getBehavDescriptions().get(i).getHoldsAts().get(n).getParameters());
						behTypes.add(env.getBehavDescriptions().get(i).getHoldsAts().get(n).getParameters().get(m));
	
					}
				}
				
				for (int n = 0; n < env.getBehavDescriptions().get(i).getHoldsAtBetweens().size(); n++){
					for (int m = 0; m < env.getBehavDescriptions().get(i).getHoldsAtBetweens().get(n).getParameters().size(); m++){
						behTypes.add(env.getBehavDescriptions().get(i).getHoldsAtBetweens().get(n).getParameters().get(m));
					}
				}
				for (int n = 0; n < env.getBehavDescriptions().get(i).getHappens().size(); n++){
					for (int m = 0; m < env.getBehavDescriptions().get(i).getHappens().get(n).getParameters().size(); m++){
						behTypes.add(env.getBehavDescriptions().get(i).getHappens().get(n).getParameters().get(m));
					}
				}
				
				// Removing doubles
				for (int j = 0; j < behTypes.size(); j++){
					int h = 0;
					while (h < behTypes.size()){
						if ((behTypes.get(j).getName().equals(behTypes.get(h).getName()))&&(h!=j)){
							behTypes.remove(h);
							h--;
						}
						h++;
					}
				} 
				
				// Writing all the types on file
				Iterator<Parameter> iter = behTypes.iterator();
				System.out.println(iter.hasNext());
				while(iter.hasNext()){
					Parameter param = iter.next();
				//	System.out.println(type.toString());
					if (param instanceof AgentParam)
						writer.println("\t"+((AgentParam)param).getAgent().getName()+"("+ param.getName() +"),"); 
						
					if (param instanceof ObserverParam)
						writer.println("\t"+((ObserverParam)param).getObserver().getName()+"("+ param.getName() +"),");
					
					if (param instanceof GeneralParam)
						writer.println("\t"+((GeneralParam)param).getGeneralType().getName()+"("+ param.getName() +"),"); 
				}
				
				// Writing all time instants
				for (int j = 0; j < times.size(); j++){
					writer.println("\ttime(T"+times.get(j)+"),");				
				}
				
				
				// Writing all the time constraints
				for (int j = 0; j < times.size(); j++){
					for (int m = 0; m < times.size(); m++){
						if (times.get(j) < times.get(m)){
							writer.println("\tT"+times.get(j)+"<T"+times.get(m)+",");
						}
					}
				}
				
				// Writing all the predicates
				
				// HOLDS AT
				for (int j = 0; j < env.getBehavDescriptions().get(i).getHoldsAts().size(); j++){
					HoldsAt h = env.getBehavDescriptions().get(i).getHoldsAts().get(j);
					if (h.isIsHolding()){
						writer.printf("\tholdsAt("+env.getBehavDescriptions().get(i).getHoldsAts().get(j).getContextRelation().getName());	
					}
					else if (!h.isIsHolding()){
						writer.printf("\tnot holdsAt("+env.getBehavDescriptions().get(i).getHoldsAts().get(j).getContextRelation().getName());
					}
					writeHoldsAtDynParameters(env.getBehavDescriptions().get(i).getHoldsAts().get(j), writer);
					writer.printf(",T"+env.getBehavDescriptions().get(i).getHoldsAts().get(j).getTime() +",TR)");
					if (j < env.getBehavDescriptions().get(i).getHoldsAts().size() - 1)
						writer.printf(",\n");
					else if (j == env.getBehavDescriptions().get(i).getHoldsAts().size() - 1){
						if (env.getBehavDescriptions().get(i).getHappens().size() == 0 && env.getBehavDescriptions().get(i).getHoldsAtBetweens().size() == 0)
							writer.printf(".");
						else
							writer.printf(",\n");
					}
				}
				
				// HAPPENS
				for (int j = 0; j < env.getBehavDescriptions().get(i).getHappens().size(); j++){
					writer.printf("\thappens("+env.getBehavDescriptions().get(i).getHappens().get(j).getEvent().getName());
					writeHappensDynParameters(env.getBehavDescriptions().get(i).getHappens().get(j), writer);
					writer.printf(",T"+env.getBehavDescriptions().get(i).getHappens().get(j).getTime() +",TR)");
					if (j < env.getBehavDescriptions().get(i).getHappens().size() - 1)
						writer.printf(",\n");
					else if (j == env.getBehavDescriptions().get(i).getHappens().size() - 1){
						if (env.getBehavDescriptions().get(i).getHoldsAtBetweens().size() == 0)
							writer.printf(".");
						else
							writer.printf(",\n");
					}
				}
				
				// HOLDS AT BETWEEN
				for (int j = 0; j < env.getBehavDescriptions().get(i).getHoldsAtBetweens().size(); j++){
					HoldsAtBetween h = env.getBehavDescriptions().get(i).getHoldsAtBetweens().get(j);
					if (h.isIsHolding()){
						writer.printf("\tholdsAt_between(T"+h.getInitialTime()+"," + h.getContextRelation().getName());
	
					}
					else if (!h.isIsHolding()){
						writer.printf("\tneg_holdsAt_between(T"+h.getInitialTime()+"," + h.getContextRelation().getName());
					}
					writeHoldsAtBetweenDynParameters(h, writer);
					writer.printf(",T"+h.getEndingTime() +",TR)");
					if (j < env.getBehavDescriptions().get(i).getHoldsAtBetweens().size() - 1){
						writer.printf(",\n");
					}
					else if (j == env.getBehavDescriptions().get(i).getHoldsAtBetweens().size() - 1){
						writer.printf(".");
					}
				}
	
				writer.println();
				writer.println();
				
		 	}
		}// Behavioural Descriptions 
			
			// INITIATES OUTPUT ALGORITHM
			
			writer.println("\n\n% +++ Context Relation Definitions +++\n");
			for (int i = 0; i < env.getContextRelations().size(); i++){
				if (env.getContextRelations().get(i).getInitialComplexEvent() != null){
					writer.printf("initiates("+ env.getContextRelations().get(i).getInitialComplexEvent().getName());
					writeEventParameters(env.getContextRelations().get(i).getInitialComplexEvent(),writer);
					writer.printf(",");
					writer.printf(env.getContextRelations().get(i).getName());
					writeContextRelationParameters(env.getContextRelations().get(i) ,writer);
					writer.printf(", T):-\n");
					
					HashSet<Type> crTypes = new HashSet<Type>();
					for (int n = 0; n < env.getContextRelations().get(i).getInitialComplexEvent().getTypes().size(); n++){
						crTypes.add(env.getContextRelations().get(i).getInitialComplexEvent().getTypes().get(n).getReference());
					}
					for (int n = 0; n < env.getContextRelations().get(i).getTypes().size(); n++){
						crTypes.add(env.getContextRelations().get(i).getTypes().get(n));
					}
					
					Iterator<Type> iter = crTypes.iterator();
					while(iter.hasNext()){
						Type type = iter.next();
						writer.printf("\t"+type.getName()+"("+Character.toUpperCase(type.getName().charAt(0))+"),");
					}
					writer.printf(" time(T).\n");
					
				}
				
				if (env.getContextRelations().get(i).getEndingComplexEvent() != null){
					writer.printf("terminates("+ env.getContextRelations().get(i).getEndingComplexEvent().getName());
					writeEventParameters(env.getContextRelations().get(i).getEndingComplexEvent(),writer);
					writer.printf(",");
					writer.printf(env.getContextRelations().get(i).getName());
					writeContextRelationParameters(env.getContextRelations().get(i) ,writer);
					writer.printf(", T):-\n");
					
					HashSet<Type> crTypes = new HashSet<Type>();
					for (int n = 0; n < env.getContextRelations().get(i).getEndingComplexEvent().getTypes().size(); n++){
						crTypes.add(env.getContextRelations().get(i).getEndingComplexEvent().getTypes().get(n).getReference());
					}
					for (int n = 0; n < env.getContextRelations().get(i).getTypes().size(); n++){
						crTypes.add(env.getContextRelations().get(i).getTypes().get(n));
					}
					
					Iterator<Type> iter = crTypes.iterator();
					while(iter.hasNext()){
						Type type = iter.next();
						writer.printf("\t"+type.getName()+"("+Character.toUpperCase(type.getName().charAt(0))+"),");
					}
					writer.printf(" time(T).\n");	
				}
			} writer.println();
			
			
			// INITIAL STATES OUTPUT ALGORITHM
			
			writer.println("% Initial state \n");
			
			for (int i = 0; i < env.getInitials().size(); i++){
				writer.printf("initially("+ env.getInitials().get(i).getContextRelation().getName());
				writeInstances(env.getInitials().get(i), writer);
				writer.printf(").\n");
			} // Initial states
			
			
			writer.println();
			writer.println("% Version 3");
			Calendar rightNow = Calendar.getInstance();
			writer.println("% Time: " + rightNow.get(Calendar.HOUR_OF_DAY) +":"+ rightNow.get(Calendar.MINUTE)); 
			writer.close();
			return true;
		}

	
	private void writeContextRelationParameters(ContextRelation cr, PrintWriter writer){
		writer.printf("(");
		for (int j = 0; j < cr.getTypes().size(); j++){
			if (j != cr.getTypes().size()-1)
				writer.printf("%c,", Character.toUpperCase(cr.getTypes().get(j).getName().charAt(0)));
			else
				writer.printf("%c)", Character.toUpperCase(cr.getTypes().get(j).getName().charAt(0)));	
		}
	}
	
	/*
	 * Write the parameters of the event on file
	 * If the flag is true it means that one or more parameters of that event have been modified by the user while creating the predicate (Ex. E2, E3, ..)
	 */
	private void writeEventParameters(Event ev, PrintWriter writer){
		writer.printf("(");
		if (ev instanceof PrimitiveEvent){
			writer.printf("%c", Character.toUpperCase(((PrimitiveEvent)ev).getAgent().getReference().getName().charAt(0)));
			for (int j = 0; j < ev.getTypes().size(); j++){
				writer.printf(", %c", Character.toUpperCase(ev.getTypes().get(j).getReference().getName().charAt(0)));
			}
			writer.printf(", %c", Character.toUpperCase(((PrimitiveEvent)ev).getObserver().getReference().getName().charAt(0)));
		}
		
		if (ev instanceof ComplexEvent){
			writer.printf("%c", Character.toUpperCase(((ComplexEvent)ev).getAgent().getReference().getName().charAt(0)));
			for (int j = 0; j < ev.getTypes().size(); j++){
				writer.printf(", %c", Character.toUpperCase(ev.getTypes().get(j).getReference().getName().charAt(0)));
			}
		}
				
		writer.printf(")");
	}
	

	private void writeInstances(Initially in, PrintWriter writer){
		writer.printf("(");
		for (int j = 0; j < in.getInstances().size(); j++){
			if (j != in.getInstances().size()-1)
				writer.printf("%s,", in.getInstances().get(j).getName());
			else
				writer.printf("%s)", in.getInstances().get(j).getName());
		}	
	}
			
	public boolean createHypothesisFiles(Environment env) throws FileNotFoundException, UnsupportedEncodingException{
		
		for (int i = 0; i < env.getHypothesis().size(); i++){
			
			String fileName = "h"+ (i+1) +".txt";
			
			System.out.println("HYPOTHESIS: " + fileName);
			
			PrintWriter writer2 = new PrintWriter(directoryPath + "/" +fileName, "UTF-8");
			
			// HYPOTHESIS OUTPUT ALGORITHM
				writer2.printf("hypothesis("+ "h"+ (i+1));
				
				// Computing the maximum time between context relations and events of a specified complex event and
				// memorizing the integer found in the arraylist for later computations
				int timeMax = -1;
				ArrayList<Integer> times = new ArrayList<Integer>();
				for (Happens h: env.getHypothesis().get(i).getHappens()){
					if (h.getTime() > timeMax)
						timeMax = h.getTime();
					
					int timesCounter = 0;
					for (int j = 0; j < times.size(); j++){
						if (h.getTime() == times.get(j))
							timesCounter++;
					}
					if (timesCounter == 0)
						times.add(h.getTime());
				}
				for (HoldsAt h: env.getHypothesis().get(i).getHoldsAts()){
					if (h.getTime() > timeMax)
						timeMax = h.getTime();
					
					int timesCounter = 0;
					for (int j = 0; j < times.size(); j++){
						if (h.getTime() == times.get(j))
							timesCounter++;
					}
					if (timesCounter == 0)
						times.add(h.getTime());
				}
				for (HoldsAtBetween h: env.getHypothesis().get(i).getHoldsAtBetweens()){
					if (h.getInitialTime() > timeMax)
						timeMax = h.getInitialTime();
					if (h.getEndingTime() > timeMax)
						timeMax = h.getEndingTime();
					
					int timesCounter = 0;
					for (int j = 0; j < times.size(); j++){
						if (h.getInitialTime() == times.get(j))
							timesCounter++;
					}
					if (timesCounter == 0)
						times.add(h.getInitialTime());
					timesCounter = 0;
					for (int j = 0; j < times.size(); j++){
						if (h.getEndingTime() == times.get(j))
							timesCounter++;
					}
					if (timesCounter == 0)
						times.add(h.getEndingTime());				
				}
				
				// Writing the computed maximum time instant
				writer2.println(",T" + timeMax + ",TR):-");
				writer2.println("\ttrace(TR),");
				
				// Memorizing all the types of events and context relations related to the hypothesis
				ArrayList<Parameter> behTypes = new ArrayList<Parameter>();
				for (int n = 0; n < env.getHypothesis().get(i).getHoldsAts().size(); n++){
					for (int m = 0; m < env.getHypothesis().get(i).getHoldsAts().get(n).getParameters().size(); m++){
						System.out.println(env.getHypothesis().get(i).getHoldsAts().get(n).getParameters());
						behTypes.add(env.getHypothesis().get(i).getHoldsAts().get(n).getParameters().get(m));
					}
				}
				for (int n = 0; n < env.getHypothesis().get(i).getHoldsAtBetweens().size(); n++){
					for (int m = 0; m < env.getHypothesis().get(i).getHoldsAtBetweens().get(n).getParameters().size(); m++){
						behTypes.add(env.getHypothesis().get(i).getHoldsAtBetweens().get(n).getParameters().get(m));
					}
				}
				for (int n = 0; n < env.getHypothesis().get(i).getHappens().size(); n++){
					for (int m = 0; m < env.getHypothesis().get(i).getHappens().get(n).getParameters().size(); m++){
						behTypes.add(env.getHypothesis().get(i).getHappens().get(n).getParameters().get(m));
					}
				}
				
				for (int j = 0; j < behTypes.size(); j++){
					int h = 0;
					while (h < behTypes.size()){
						if ((behTypes.get(j).getName().equals(behTypes.get(h).getName()))&&(h!=j)){
							behTypes.remove(h);
							h--;
						}
						h++;
					}
				} 
				
				Iterator<Parameter> iter = behTypes.iterator();
				System.out.println(iter.hasNext());
				while(iter.hasNext()){
					Parameter param = iter.next();
				//	System.out.println(type.toString());
					if (param instanceof AgentParam)
						writer2.println("\t"+((AgentParam)param).getAgent().getName()+"("+ param.getName() +"),"); 
						
					if (param instanceof ObserverParam)
						writer2.println("\t"+((ObserverParam)param).getObserver().getName()+"("+ param.getName() +"),");
					
					if (param instanceof GeneralParam)
						writer2.println("\t"+((GeneralParam)param).getGeneralType().getName()+"("+ param.getName() +"),"); 
				}
				
				// Writing all time instants
				for (int j = 0; j < times.size(); j++){
					writer2.println("\ttime(T"+times.get(j)+"),");				
				}
				
				// Writing all the time constraints
				for (int j = 0; j < times.size(); j++){
					for (int m = 0; m < times.size(); m++){
						if (times.get(j) < times.get(m)){
							writer2.println("\tT"+times.get(j)+"<T"+times.get(m)+",");
						}
					}
				}
				
				// HOLDS AT
				for (int j = 0; j < env.getHypothesis().get(i).getHoldsAts().size(); j++){		
					HoldsAt h = env.getHypothesis().get(i).getHoldsAts().get(j);
					if (h.isIsHolding()){
						writer2.printf("\tholdsAt("+env.getHypothesis().get(i).getHoldsAts().get(j).getContextRelation().getName());
					}
					else if (!h.isIsHolding()){
						writer2.printf("\tnot holdsAt("+env.getHypothesis().get(i).getHoldsAts().get(j).getContextRelation().getName());
					}
					writeHoldsAtDynParameters(env.getHypothesis().get(i).getHoldsAts().get(j), writer2);
					writer2.printf(",T"+env.getHypothesis().get(i).getHoldsAts().get(j).getTime() +",TR)");
					if (j < env.getHypothesis().get(i).getHoldsAts().size() - 1)
						writer2.printf(",\n");
					else if (j == env.getHypothesis().get(i).getHoldsAts().size() - 1){
						if (env.getHypothesis().get(i).getHappens().size() == 0 && env.getHypothesis().get(i).getHoldsAtBetweens().size() == 0)
							writer2.printf(".");
						else
							writer2.printf(",\n");
					}
				}
				
				// HAPPENS		
				for (int j = 0; j < env.getHypothesis().get(i).getHappens().size(); j++){		
					writer2.printf("\thappens("+env.getHypothesis().get(i).getHappens().get(j).getEvent().getName());
					writeHappensDynParameters(env.getHypothesis().get(i).getHappens().get(j), writer2);
					writer2.printf(",T"+env.getHypothesis().get(i).getHappens().get(j).getTime() +",TR)");
					if (j < env.getHypothesis().get(i).getHappens().size() - 1)
						writer2.printf(",\n");
					else if (j == env.getHypothesis().get(i).getHappens().size() - 1){
						if (env.getHypothesis().get(i).getHoldsAtBetweens().size() == 0)
							writer2.printf(".");
						else
							writer2.printf(",\n");
					}
				}
				
				// HOLDS AT BETWEEN
				for (int j = 0; j < env.getHypothesis().get(i).getHoldsAtBetweens().size(); j++){
					HoldsAtBetween h = env.getHypothesis().get(i).getHoldsAtBetweens().get(j);
					if (h.isIsHolding()){						
						writer2.printf("\tholdsAt_between(T"+h.getInitialTime()+"," + h.getContextRelation().getName());
					}
					else if (!h.isIsHolding()){
						writer2.printf("\tneg_holdsAt_between(T"+h.getInitialTime()+"," + h.getContextRelation().getName());
					}
					writeHoldsAtBetweenDynParameters(h, writer2);
					writer2.printf(",T"+h.getEndingTime() +",TR)");
					if (j < env.getHypothesis().get(i).getHoldsAtBetweens().size() - 1){
						writer2.printf(",\n");
					}
					else if (j == env.getHypothesis().get(i).getHoldsAtBetweens().size() - 1){
						writer2.printf(".");
					}
				}

				writer2.println();
				writer2.println();
				
				System.out.println("Hypothesis written on file");
				
				writer2.close();

			} // Behavioural Descriptions 
		return true;
		}
	
	private void writeHoldsAtDynParameters(HoldsAt h, PrintWriter writer){
		writer.printf("(");
		for (int j = 0; j < h.getParameters().size(); j++){
			if (j != h.getParameters().size()-1)
				writer.printf("%s,", h.getParameters().get(j).getName());
			else
				writer.printf("%s)", h.getParameters().get(j).getName());	
		}
		
	}
	
	private void writeHoldsAtBetweenDynParameters(HoldsAtBetween h, PrintWriter writer){
		writer.printf("(");
		for (int j = 0; j < h.getParameters().size(); j++){
			if (j != h.getParameters().size()-1)
				writer.printf("%s,", h.getParameters().get(j).getName());
			else
				writer.printf("%s)", h.getParameters().get(j).getName());	
		}
	}
	
	private void writeHappensDynParameters(Happens h, PrintWriter writer){
		writer.printf("(");
		for (int j = 0; j < h.getParameters().size(); j++){
			if (j != h.getParameters().size()-1)
				writer.printf("%s,", h.getParameters().get(j).getName());
			else
				writer.printf("%s)", h.getParameters().get(j).getName());	
		}
	}
	
	private void writeAnyBehavDesc(BehaviouralDescription bd){
		int counter = 0;
    	for (Happens h: bd.getHappens()){
    		if ((h.getTime() <= bd.getSecondTimeInstant())&&(h.getTime() >= bd.getFirstTimeInstant())) 
    			counter++;
    	}
    	for (HoldsAt h: bd.getHoldsAts()){
    		if ((h.getTime() <= bd.getSecondTimeInstant())&&(h.getTime() >= bd.getFirstTimeInstant())) 
    			counter++;
    	}
    	for (HoldsAtBetween h: bd.getHoldsAtBetweens()){
    		if ((h.getEndingTime() <= bd.getSecondTimeInstant())&&(h.getInitialTime() >= bd.getFirstTimeInstant())) 
    			counter++;
    	}
    	
    	System.out.println("Predicates compresi nell'any: " + counter);
	}
	
	//TODO: implement all the algorithm. I can create a temporary behavDesc for each one I need to parser
	
	
	public Loader getLoader(){
		return this.loader;
	}
}
