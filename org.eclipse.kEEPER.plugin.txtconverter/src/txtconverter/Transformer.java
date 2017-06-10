package txtconverter;

import model.ComplexEvent;
import model.ContextRelation;
import model.Environment;
import model.Event;
import model.Happens;
import model.HoldsAt;
import model.HoldsAtBetween;
import model.Type;
import model.Parameter;
import model.ModelFactory;
import model.PrimitiveEvent;
import model.impl.ComplexEventImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
	
	public void createTxtFile(Environment env) throws FileNotFoundException, UnsupportedEncodingException{
	    
		PrintWriter writer = new PrintWriter(directoryPath +"/environment.txt", "UTF-8");
		
		writer.println("% ****************** Environment Description ******************\n");
		writer.println("% ********* Context Description *********\n");
		writer.println("% ***** Types and Instances *****\n");
		
		// Creating list of types-instances
		for (int i = 0; i < env.getInstances().size(); i++){
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
			for (int j = 0; j < env.getContextRelations().get(i).getParameters().size(); j++){
				if (j != env.getContextRelations().get(i).getParameters().size()-1)
					writer.printf("%s(%c), ", env.getContextRelations().get(i).getParameters().get(j).getType().getName(),env.getContextRelations().get(i).getParameters().get(j).getType().getName().charAt(0));
				else
					writer.printf("%s(%c).\n", env.getContextRelations().get(i).getParameters().get(j).getType().getName(),env.getContextRelations().get(i).getParameters().get(j).getType().getName().charAt(0));				
			}
		} // Context Relations
		
		
		// EVENTS OUTPUT ALGORITHM
		
		writer.println("\n\n% ********* Behaviour Description *********\n");
		writer.println("% ***** Primitive Events *****\n");
		writer.println("event(V):-\n\tpe(V)\n\n");
		// Creating list of primitive events
		for (int i = 0; i < env.getEvents().size(); i++){
			if (env.getEvents().get(i) instanceof PrimitiveEvent){
				System.out.println("Primitive event");
				writer.printf("pe("+ env.getEvents().get(i).getName());
				writeEventParameters(env.getEvents().get(i), writer);
				writer.printf("):-\n\t");
				for (int j = 0; j < env.getEvents().get(i).getParameters().size(); j++){
					if (j != env.getEvents().get(i).getParameters().size()-1)
						writer.printf("%s(%c),", env.getEvents().get(i).getParameters().get(j).getType().getName(), env.getEvents().get(i).getParameters().get(j).getType().getName().charAt(0));
					else
						writer.printf("%s(%c).\n", env.getEvents().get(i).getParameters().get(j).getType().getName(), env.getEvents().get(i).getParameters().get(j).getType().getName().charAt(0));
				}
				
			
			}
		} // Primitive events
		
		writer.println("\n% ***** Complex Events *****\n");		
		writer.printf("event(V):-\nce(V)\n\n");
		// Creating list of complex events
		for (int i = 0; i < env.getEvents().size(); i++){
			if (env.getEvents().get(i) instanceof ComplexEvent){
				writer.printf("ce("+ env.getEvents().get(i).getName());
				
				writeEventParameters(env.getEvents().get(i), writer);
				writer.printf("):-\n\t");
				for (int j = 0; j < env.getEvents().get(i).getParameters().size(); j++){
					if (j != env.getEvents().get(i).getParameters().size()-1)
						writer.printf("%s(%c),", env.getEvents().get(i).getParameters().get(j).getType().getName(), env.getEvents().get(i).getParameters().get(j).getType().getName().charAt(0));
					else
						writer.printf("%s(%c).\n", env.getEvents().get(i).getParameters().get(j).getType().getName(), env.getEvents().get(i).getParameters().get(j).getType().getName().charAt(0));
				}
			}
		} // Complex events
		// Events
		
		
		// BEHAVIOURAL DESCRIPTIONS OUTPUT ALGORITHM
		
		writer.println("\n\n% ***** Composite Definitions *****\n");
		for (int i = 0; i < env.getBehavDescriptions().size(); i++){
			ComplexEvent event = new ComplexEventImpl(); //Because it is a complexEvent for sure
			writer.printf("happens("+ env.getBehavDescriptions().get(i).getName());
			for (int j = 0; j < env.getEvents().size(); j++){
				if (env.getEvents().get(j).getName().equals(env.getBehavDescriptions().get(i).getName())){
					event = (ComplexEvent) env.getEvents().get(j); //Casting to ComplexEvent because for sure is a complex event
				}	
			}
			//writer.printf("happens("+ event.getName());
			writeEventParameters(event, writer);
			
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
			HashSet<Type> behTypes = new HashSet<Type>();
			for (int n = 0; n < env.getBehavDescriptions().get(i).getHoldsAts().size(); n++){
				for (int m = 0; m < env.getBehavDescriptions().get(i).getHoldsAts().get(n).getContextRelation().getParameters().size(); m++){
					behTypes.add(env.getBehavDescriptions().get(i).getHoldsAts().get(n).getContextRelation().getParameters().get(m).getType());
				};
			}
			for (int n = 0; n < env.getBehavDescriptions().get(i).getHoldsAtBetweens().size(); n++){
				for (int m = 0; m < env.getBehavDescriptions().get(i).getHoldsAtBetweens().get(n).getContextRelation().getParameters().size(); m++){
					behTypes.add(env.getBehavDescriptions().get(i).getHoldsAtBetweens().get(n).getContextRelation().getParameters().get(m).getType());
				};
			}
			for (int n = 0; n < env.getBehavDescriptions().get(i).getHappens().size(); n++){
				for (int m = 0; m < env.getBehavDescriptions().get(i).getHappens().get(n).getEvent().getParameters().size(); m++){
					behTypes.add(env.getBehavDescriptions().get(i).getHappens().get(n).getEvent().getParameters().get(m).getType());
				};
			}
			// Writing all the types on file
			Iterator<Type> iter = behTypes.iterator();
			System.out.println(iter.hasNext());
			while(iter.hasNext()){
				Type type = iter.next();
			//	System.out.println(type.toString());
				writer.println("\t"+type.getName()+"("+type.getName().charAt(0)+"),");
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
			
			for (int j = 0; j < env.getBehavDescriptions().get(i).getHoldsAts().size(); j++){				
				writer.printf("\tholdsAt("+env.getBehavDescriptions().get(i).getHoldsAts().get(j).getContextRelation().getName());
				writeContextRelationParameters(env.getBehavDescriptions().get(i).getHoldsAts().get(j).getContextRelation(), writer);
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
			for (int j = 0; j < env.getBehavDescriptions().get(i).getHappens().size(); j++){				
				writer.printf("\thappens("+env.getBehavDescriptions().get(i).getHappens().get(j).getEvent().getName());
				writeEventParameters(env.getBehavDescriptions().get(i).getHappens().get(j).getEvent(), writer);
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
			for (int j = 0; j < env.getBehavDescriptions().get(i).getHoldsAtBetweens().size(); j++){
				HoldsAtBetween h = env.getBehavDescriptions().get(i).getHoldsAtBetweens().get(j);
				if (h.isIsHolding()){
					writer.printf("\tholdsAt_between(T"+h.getInitialTime()+"," + h.getContextRelation().getName());
				}
				else if (!h.isIsHolding()){
					writer.printf("\tneg_holdsAt_between(T"+h.getInitialTime()+"," + h.getContextRelation().getName());
				}
				writeContextRelationParameters(h.getContextRelation(), writer);
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
			
		} // Behavioural Descriptions 
		
		
		// INITIAL STATES OUTPUT ALGORITHM
		
		writer.println("% Initial state \n");
		
		for (int i = 0; i < env.getInitials().size(); i++){
			writer.printf("initially("+ env.getInitials().get(i).getContextRelation().getName());
			writeInstances(env.getInitials().get(i).getContextRelation(), writer);
			writer.printf(").\n");
		} // Initial states
		
		
		writer.println();
		writer.println("% Version 3");
		Calendar rightNow = Calendar.getInstance();
		writer.println("Time: " + rightNow.get(Calendar.HOUR_OF_DAY) +":"+ rightNow.get(Calendar.MINUTE));
		writer.close();

	}
	
	private void writeContextRelationParameters(ContextRelation cr, PrintWriter writer){
		writer.printf("(");
		for (int j = 0; j < cr.getParameters().size(); j++){
			if (j != cr.getParameters().size()-1)
				writer.printf("%c,", cr.getParameters().get(j).getType().getName().charAt(0));
			else
				writer.printf("%c)", cr.getParameters().get(j).getType().getName().charAt(0));	
		}
	}
	
	private void writeEventParameters(Event ev, PrintWriter writer){
		writer.printf("(");
		for (int j = 0; j < ev.getParameters().size(); j++){
			System.out.println("Parametro: "+ ev.getParameters().get(j));
			if (j != ev.getParameters().size()-1)
				writer.printf("%c,", ev.getParameters().get(j).getType().getName().charAt(0));
			else
				writer.printf("%c)", ev.getParameters().get(j).getType().getName().charAt(0));
		}	
	}
	
	private void writeInstances(ContextRelation cr, PrintWriter writer){
		writer.printf("(");
		for (int j = 0; j < cr.getParameters().size(); j++){
			if (j != cr.getParameters().size()-1)
				writer.printf("%s,", cr.getParameters().get(j).getInstance().getName());
			else
				writer.printf("%s)", cr.getParameters().get(j).getInstance().getName());
		}	
	}
			
	public void createHypothesisFiles(Environment env) throws FileNotFoundException, UnsupportedEncodingException{
		
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
				HashSet<Type> behTypes = new HashSet<Type>();
				for (int n = 0; n < env.getHypothesis().get(i).getHoldsAts().size(); n++){
					for (int m = 0; m < env.getHypothesis().get(i).getHoldsAts().get(n).getContextRelation().getParameters().size(); m++){
						behTypes.add(env.getHypothesis().get(i).getHoldsAts().get(n).getContextRelation().getParameters().get(m).getType());
					};
				}
				for (int n = 0; n < env.getHypothesis().get(i).getHoldsAtBetweens().size(); n++){
					for (int m = 0; m < env.getHypothesis().get(i).getHoldsAtBetweens().get(n).getContextRelation().getParameters().size(); m++){
						behTypes.add(env.getHypothesis().get(i).getHoldsAtBetweens().get(n).getContextRelation().getParameters().get(m).getType());
					};
				}
				for (int n = 0; n < env.getHypothesis().get(i).getHappens().size(); n++){
					for (int m = 0; m < env.getHypothesis().get(i).getHappens().get(n).getEvent().getParameters().size(); m++){
						behTypes.add(env.getHypothesis().get(i).getHappens().get(n).getEvent().getParameters().get(m).getType());
					};
				}
				// Writing all the types on file
				Iterator<Type> iter = behTypes.iterator();
				System.out.println(iter.hasNext());
				while(iter.hasNext()){
					Type type = iter.next();
				//	System.out.println(type.toString());
					writer2.println("\t"+type.getName()+"("+type.getName().charAt(0)+"),");
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
				
				for (int j = 0; j < env.getHypothesis().get(i).getHoldsAts().size(); j++){				
					writer2.printf("\tholdsAt("+env.getHypothesis().get(i).getHoldsAts().get(j).getContextRelation().getName());
					writeContextRelationParameters(env.getHypothesis().get(i).getHoldsAts().get(j).getContextRelation(), writer2);
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
				for (int j = 0; j < env.getHypothesis().get(i).getHappens().size(); j++){				
					writer2.printf("\thappens("+env.getHypothesis().get(i).getHappens().get(j).getEvent().getName());
					writeEventParameters(env.getHypothesis().get(i).getHappens().get(j).getEvent(), writer2);
					writer2.printf(",T"+env.getHypothesis().get(i).getHappens().get(j).getTime() +",TR)");
					if (j < env.getHypothesis().get(i).getHappens().size() - 1)
						writer2.printf(",\n");
					else if (j == env.getHypothesis().get(i).getHoldsAts().size() - 1){
						if (env.getHypothesis().get(i).getHoldsAtBetweens().size() == 0)
							writer2.printf(".");
						else
							writer2.printf(",\n");
					}
				}
				for (int j = 0; j < env.getHypothesis().get(i).getHoldsAtBetweens().size(); j++){
					HoldsAtBetween h = env.getHypothesis().get(i).getHoldsAtBetweens().get(j);
					if (h.isIsHolding()){
						writer2.printf("\tholdsAt_between(T"+h.getInitialTime()+"," + h.getContextRelation().getName());
					}
					else if (!h.isIsHolding()){
						writer2.printf("\tneg_holdsAt_between(T"+h.getInitialTime()+"," + h.getContextRelation().getName());
					}
					writeContextRelationParameters(h.getContextRelation(), writer2);
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

		}
	
	public Loader getLoader(){
		return this.loader;
	}
}
