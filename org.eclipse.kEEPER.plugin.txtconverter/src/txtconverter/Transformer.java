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
import model.impl.PrimitiveEventImpl;

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
			if (!env.getContextRelations().get(i).isFlag()){
				writer.printf("fluent(%s", env.getContextRelations().get(i).getName());
				writeContextRelationParameters(env.getContextRelations().get(i), writer);
				writer.printf("):-\n\t");
				for (int j = 0; j < env.getContextRelations().get(i).getParameters().size(); j++){
					if (j != env.getContextRelations().get(i).getParameters().size()-1)
						writer.printf("%s(%c), ", env.getContextRelations().get(i).getParameters().get(j).getType().getName(),Character.toUpperCase(env.getContextRelations().get(i).getParameters().get(j).getType().getName().charAt(0)));
					else
						writer.printf("%s(%c).\n", env.getContextRelations().get(i).getParameters().get(j).getType().getName(),Character.toUpperCase(env.getContextRelations().get(i).getParameters().get(j).getType().getName().charAt(0)));				
				}
			}
			
		} // Context Relations
		
		
		// EVENTS OUTPUT ALGORITHM
		
		writer.println("\n\n% ********* Behaviour Description *********\n");
		writer.println("% ***** Primitive Events *****\n");
		writer.println("event(V):-\n\tpe(V).\n\n");
		// Creating list of primitive events
		for (int i = 0; i < env.getEvents().size(); i++){
			if ((env.getEvents().get(i) instanceof PrimitiveEvent)&&(!env.getEvents().get(i).isFlag())){
				System.out.println("Primitive event");
				writer.printf("pe("+ env.getEvents().get(i).getName());
				writeEventParameters(env.getEvents().get(i), writer, false);
				writer.printf("):-\n\t");
				
				writer.printf("%s(%c)", env.getEvents().get(i).getAgent().getType().getName(), Character.toUpperCase(env.getEvents().get(i).getAgent().getType().getName().charAt(0)));
				for (int j = 0; j < env.getEvents().get(i).getParameters().size(); j++){
					writer.printf(", %s(%c)", env.getEvents().get(i).getParameters().get(j).getType().getName(), Character.toUpperCase(env.getEvents().get(i).getParameters().get(j).getType().getName().charAt(0)));
				}
				writer.printf(", %s(%c).", ((PrimitiveEvent) env.getEvents().get(i)).getObserver().getType().getName(), Character.toUpperCase(((PrimitiveEvent) env.getEvents().get(i)).getObserver().getType().getName().charAt(0)));
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
			if ((env.getEvents().get(i) instanceof ComplexEvent)&&(!env.getEvents().get(i).isFlag())){
				writer.printf("ce("+ env.getEvents().get(i).getName());
				
				writeEventParameters(env.getEvents().get(i), writer, false);
				writer.printf("):-\n\t");
				
				writer.printf("%s(%c)", env.getEvents().get(i).getAgent().getType().getName(), Character.toUpperCase(env.getEvents().get(i).getAgent().getType().getName().charAt(0)));

				for (int j = 0; j < env.getEvents().get(i).getParameters().size(); j++){
					if (j != env.getEvents().get(i).getParameters().size() - 1){
						writer.printf(", %s(%c)", env.getEvents().get(i).getParameters().get(j).getType().getName(), Character.toUpperCase(env.getEvents().get(i).getParameters().get(j).getType().getName().charAt(0)));
					}
					else
						writer.printf(", %s(%c).", env.getEvents().get(i).getParameters().get(j).getType().getName(), Character.toUpperCase(env.getEvents().get(i).getParameters().get(j).getType().getName().charAt(0)));
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
		
		// TODO: Better version of the algorithm
	/*	for (int i = 0; i < env.getEvents().size(); i++){
			if (env.getEvents().get(i) instanceof ComplexEvent){
				for (int j = 0; j < (((ComplexEvent) (env.getEvents().get(i))).getBehaviouralDescriptions().size()); j++){
		*/	
		
		for (int i = 0; i < env.getBehavDescriptions().size(); i++){
			System.out.println("BEHAV DESC: " + env.getBehavDescriptions().get(i).getName());
			ComplexEvent event = new ComplexEventImpl(); //Because it is a complexEvent for sure
			writer.printf("happens("+ env.getBehavDescriptions().get(i).getName());
			for (int j = 0; j < env.getEvents().size(); j++){
				if (env.getEvents().get(j).getName().equals(env.getBehavDescriptions().get(i).getName())){
					event = (ComplexEvent) env.getEvents().get(j); //Casting to ComplexEvent because for sure is a complex event
				}	
			} 
			//writer.printf("happens("+ event.getName());
			if (event != null){
				writeEventParameters(event, writer, false);
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
				for (int m = 0; m < env.getBehavDescriptions().get(i).getHoldsAts().get(n).getContextRelation().getParameters().size(); m++){
					behTypes.add(env.getBehavDescriptions().get(i).getHoldsAts().get(n).getContextRelation().getParameters().get(m));
				}
			}
			for (int n = 0; n < env.getBehavDescriptions().get(i).getHoldsAtBetweens().size(); n++){
				for (int m = 0; m < env.getBehavDescriptions().get(i).getHoldsAtBetweens().get(n).getContextRelation().getParameters().size(); m++){
					behTypes.add(env.getBehavDescriptions().get(i).getHoldsAtBetweens().get(n).getContextRelation().getParameters().get(m));
				}
			}
			for (int n = 0; n < env.getBehavDescriptions().get(i).getHappens().size(); n++){
					behTypes.add(env.getBehavDescriptions().get(i).getHappens().get(n).getEvent().getAgent());
				for (int m = 0; m < env.getBehavDescriptions().get(i).getHappens().get(n).getEvent().getParameters().size(); m++){
					behTypes.add(env.getBehavDescriptions().get(i).getHappens().get(n).getEvent().getParameters().get(m));
				}
				if  (env.getBehavDescriptions().get(i).getHappens().get(n).getEvent() instanceof PrimitiveEventImpl){
					behTypes.add((((PrimitiveEventImpl)env.getBehavDescriptions().get(i).getHappens().get(n).getEvent()).getObserver()));
				}
			}
			
			// Removing doubles
			for (int j = 0; j < behTypes.size(); j++){
				int h = 0;
				while (h < behTypes.size()){
					if ((behTypes.get(j).getType().getName().equals(behTypes.get(h).getType().getName()))&&(h!=j) && (behTypes.get(j).getNumber() == behTypes.get(h).getNumber())){
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
				writer.println("\t"+param.getType().getName()+"("+Character.toUpperCase(param.getType().getName().charAt(0)) + ((param.getNumber() > 0) ? param.getNumber() + ")," : "),"));
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
					if (!env.getBehavDescriptions().get(i).getHoldsAts().get(j).getContextRelation().isFlag())
						writer.printf("\tholdsAt("+env.getBehavDescriptions().get(i).getHoldsAts().get(j).getContextRelation().getName());
					else{
						System.out.println("Trying to REPLACE THE DIGITS");
						writer.printf("\tholdsAt("+env.getBehavDescriptions().get(i).getHoldsAts().get(j).getContextRelation().getName().replaceAll("\\d", ""));
						System.out.println(env.getBehavDescriptions().get(i).getHoldsAts().get(j).getContextRelation().getName());
					}
				}
				else if (!h.isIsHolding()){
					if (!env.getBehavDescriptions().get(i).getHoldsAts().get(j).getContextRelation().isFlag())
						writer.printf("\tnot holdsAt("+env.getBehavDescriptions().get(i).getHoldsAts().get(j).getContextRelation().getName());
					else
						writer.printf("\tnot holdsAt("+env.getBehavDescriptions().get(i).getHoldsAts().get(j).getContextRelation().getName().replaceAll("\\d", ""));

				}
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
			
			// HAPPENS
			for (int j = 0; j < env.getBehavDescriptions().get(i).getHappens().size(); j++){
				if (!env.getBehavDescriptions().get(i).getHappens().get(j).getEvent().isFlag())
					writer.printf("\thappens("+env.getBehavDescriptions().get(i).getHappens().get(j).getEvent().getName());
				else{
					System.out.println("Trying to REPLACE THE DIGITS");
					writer.printf("\thappens("+env.getBehavDescriptions().get(i).getHappens().get(j).getEvent().getName().replaceAll("\\d", ""));
				}

				writeEventParameters(env.getBehavDescriptions().get(i).getHappens().get(j).getEvent(), writer, true);
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
					if (!env.getBehavDescriptions().get(i).getHoldsAtBetweens().get(j).getContextRelation().isFlag())
						writer.printf("\tholdsAt_between(T"+h.getInitialTime()+"," + h.getContextRelation().getName());
					else{
						System.out.println("Trying to REPLACE THE DIGITS");
						writer.printf("\tholdsAt_between(T"+h.getInitialTime()+"," + h.getContextRelation().getName().replaceAll("\\d", ""));
					}
				}
				else if (!h.isIsHolding()){
					if (!env.getBehavDescriptions().get(i).getHoldsAtBetweens().get(j).getContextRelation().isFlag())
						writer.printf("\tneg_holdsAt_between(T"+h.getInitialTime()+"," + h.getContextRelation().getName());
					else{
						System.out.println("Trying to REPLACE THE DIGITS");
						writer.printf("\tneg_holdsAt_between(T"+h.getInitialTime()+"," + h.getContextRelation().getName().replaceAll("\\d", ""));
					}
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
		
		// INITIATES OUTPUT ALGORITHM
		
		writer.println("\n\n% +++ Context Relation Definitions +++\n");
		for (int i = 0; i < env.getContextRelations().size(); i++){
			if (env.getContextRelations().get(i).getInitialComplexEvent() != null){
				writer.printf("initiates("+ env.getContextRelations().get(i).getInitialComplexEvent().getName());
				writeEventParameters(env.getContextRelations().get(i).getInitialComplexEvent(),writer, false);
				writer.printf(",");
				writer.printf(env.getContextRelations().get(i).getName());
				writeContextRelationParameters(env.getContextRelations().get(i) ,writer);
				writer.printf(", T):-\n");
				
				HashSet<Type> crTypes = new HashSet<Type>();
				for (int n = 0; n < env.getContextRelations().get(i).getInitialComplexEvent().getParameters().size(); n++){
					crTypes.add(env.getContextRelations().get(i).getInitialComplexEvent().getParameters().get(n).getType());
				}
				for (int n = 0; n < env.getContextRelations().get(i).getParameters().size(); n++){
					crTypes.add(env.getContextRelations().get(i).getParameters().get(n).getType());
				}
				
				Iterator<Type> iter = crTypes.iterator();
				while(iter.hasNext()){
					Type type = iter.next();
					writer.printf("\t"+type.getName()+"("+Character.toUpperCase(type.getName().charAt(0))+"),");
				}
				writer.printf(", time(T).\n");
				
			}
			
			if (env.getContextRelations().get(i).getEndingComplexEvent() != null){
				writer.printf("terminates("+ env.getContextRelations().get(i).getEndingComplexEvent().getName());
				writeEventParameters(env.getContextRelations().get(i).getEndingComplexEvent(),writer, false);
				writer.printf(",");
				writer.printf(env.getContextRelations().get(i).getName());
				writeContextRelationParameters(env.getContextRelations().get(i) ,writer);
				writer.printf(", T):-\n");
				
				HashSet<Type> crTypes = new HashSet<Type>();
				for (int n = 0; n < env.getContextRelations().get(i).getEndingComplexEvent().getParameters().size(); n++){
					crTypes.add(env.getContextRelations().get(i).getEndingComplexEvent().getParameters().get(n).getType());
				}
				for (int n = 0; n < env.getContextRelations().get(i).getParameters().size(); n++){
					crTypes.add(env.getContextRelations().get(i).getParameters().get(n).getType());
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
			writeInstances(env.getInitials().get(i).getContextRelation(), writer);
			writer.printf(").\n");
		} // Initial states
		
		
		writer.println();
		writer.println("% Version 3");
		Calendar rightNow = Calendar.getInstance();
		writer.println("% Time: " + rightNow.get(Calendar.HOUR_OF_DAY) +":"+ rightNow.get(Calendar.MINUTE));
		writer.close();

	}
	
	private void writeContextRelationParameters(ContextRelation cr, PrintWriter writer){
		writer.printf("(");
		for (int j = 0; j < cr.getParameters().size(); j++){
			
			if (cr.getParameters().get(j).getNumber() == 0){
				System.out.println("NUMBER IS ZERO");
				if (j != cr.getParameters().size()-1)
					writer.printf("%c,", Character.toUpperCase(cr.getParameters().get(j).getType().getName().charAt(0)));
				else
					writer.printf("%c)", Character.toUpperCase(cr.getParameters().get(j).getType().getName().charAt(0)));	
			}
			else{
				System.out.println("NUMBER IS NOT ZERO");
				if (j != cr.getParameters().size()-1)
					writer.printf("%c%d,", Character.toUpperCase(cr.getParameters().get(j).getType().getName().charAt(0)), cr.getParameters().get(j).getNumber());
				else
					writer.printf("%c%d)", Character.toUpperCase(cr.getParameters().get(j).getType().getName().charAt(0)), cr.getParameters().get(j).getNumber());
			}
			
		}
	}
	
	/*
	 * Write the parameters of the event on file
	 * If the flag is true it means that one or more parameters of that event have been modified by the user while creating the predicate (Ex. E2, E3, ..)
	 */
	private void writeEventParameters(Event ev, PrintWriter writer, boolean flag){
		writer.printf("(");
		System.out.println(ev.getName());
		System.out.println("Event2 --> " + ev.getName() + 
				ev.getAgent().
				getName() + 
				ev.getAgent().getType().getName());
		if (ev.getAgent().getNumber() == 0)
			writer.printf("%c", Character.toUpperCase(ev.getAgent().getType().getName().charAt(0)));
		else
			writer.printf("%c%d", Character.toUpperCase(ev.getAgent().getType().getName().charAt(0)), ev.getAgent().getNumber());

		for (int j = 0; j < ev.getParameters().size(); j++){
			if (ev.getParameters().get(j).getNumber() == 0)
				writer.printf(",%c", Character.toUpperCase(ev.getParameters().get(j).getType().getName().charAt(0)));
			else
				writer.printf(",%c%d", Character.toUpperCase(ev.getParameters().get(j).getType().getName().charAt(0)), ev.getParameters().get(j).getNumber());

		}	
		
		if (ev instanceof PrimitiveEventImpl){
			if (((PrimitiveEvent) ev).getObserver().getNumber() == 0)
				writer.printf(",%c)", Character.toUpperCase((((PrimitiveEvent) ev).getObserver().getType().getName().charAt(0))));
			else
				writer.printf(",%c%d)", Character.toUpperCase((((PrimitiveEvent) ev).getObserver().getType().getName().charAt(0))), ((PrimitiveEvent) ev).getObserver().getNumber());

		}
		else 
			writer.printf(")");
		
		//writer.printf("%c)", ev.getObserver().getType().getName().charAt(0));
	}
	
/*	private void writeModifiedEventParameters(Happens h, PrintWriter writer){
		writer.printf("(");
		for (int j = 0; j < h.getEvent().getCorrectedParams().size(); j++){
			writer.printf("%c", Character.toUpperCase(h.getEvent().getCorrectedParams().get(j).getType().getName().charAt(0)));
			writer.printf("%c", h.getEvent().getCorrectedParams().get(j).getNewNumber());
		}	
		
		
		writer.printf("%c", Character.toUpperCase(h.getEvent().getCorrectgetAgent().getType().getName().charAt(0)));
		for (int j = 0; j < ev.getParameters().size(); j++){
			writer.printf(",%c", Character.toUpperCase(ev.getParameters().get(j).getType().getName().charAt(0)));
		}	
		
		if (ev instanceof PrimitiveEventImpl){
			writer.printf(",%c)", Character.toUpperCase((((PrimitiveEvent) ev).getObserver().getType().getName().charAt(0))));

		}
		else 
			writer.printf(")");
	}
	*/
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
				ArrayList<Parameter> behTypes = new ArrayList<Parameter>();
				for (int n = 0; n < env.getHypothesis().get(i).getHoldsAts().size(); n++){
					for (int m = 0; m < env.getHypothesis().get(i).getHoldsAts().get(n).getContextRelation().getParameters().size(); m++){
						behTypes.add(env.getHypothesis().get(i).getHoldsAts().get(n).getContextRelation().getParameters().get(m));
					};
				}
				for (int n = 0; n < env.getHypothesis().get(i).getHoldsAtBetweens().size(); n++){
					for (int m = 0; m < env.getHypothesis().get(i).getHoldsAtBetweens().get(n).getContextRelation().getParameters().size(); m++){
						behTypes.add(env.getHypothesis().get(i).getHoldsAtBetweens().get(n).getContextRelation().getParameters().get(m));
					};
				}
				for (int n = 0; n < env.getHypothesis().get(i).getHappens().size(); n++){
					behTypes.add(env.getHypothesis().get(i).getHappens().get(n).getEvent().getAgent());
					for (int m = 0; m < env.getHypothesis().get(i).getHappens().get(n).getEvent().getParameters().size(); m++){
						behTypes.add(env.getHypothesis().get(i).getHappens().get(n).getEvent().getParameters().get(m));
					}
					if  (env.getHypothesis().get(i).getHappens().get(n).getEvent() instanceof PrimitiveEventImpl){
						behTypes.add((((PrimitiveEventImpl)env.getHypothesis().get(i).getHappens().get(n).getEvent()).getObserver()));
					}
				}
				
				// Removing doubles
				for (int j = 0; j < behTypes.size(); j++){
					int h = 0;
					while (h < behTypes.size()){
						if ((behTypes.get(j).getType().getName().equals(behTypes.get(h).getType().getName()))&&(h!=j) && (behTypes.get(j).getNumber() == behTypes.get(h).getNumber())){
							behTypes.remove(h);
							h--;
						}
						h++;
					}
				} 
				
				// Writing all the types on file
				Iterator<Parameter> iter = behTypes.iterator();
				//System.out.println(iter.hasNext());
				while(iter.hasNext()){
					Parameter param = iter.next();
				//	System.out.println(type.toString());
					writer2.println("\t"+param.getType().getName()+"("+Character.toUpperCase(param.getType().getName().charAt(0)) + ((param.getNumber() > 0) ? param.getNumber() + ")," : "),"));

					//writer2.println("\t"+type.getName()+"("+Character.toUpperCase(type.getName().charAt(0))+"),");
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
					
					HoldsAt h = env.getHypothesis().get(i).getHoldsAts().get(j);

					if (h.isIsHolding()){
						if (!env.getHypothesis().get(i).getHoldsAts().get(j).getContextRelation().isFlag())
							writer2.printf("\tholdsAt("+env.getHypothesis().get(i).getHoldsAts().get(j).getContextRelation().getName());
						else{
							System.out.println("Trying to REPLACE THE DIGITS");
							writer2.printf("\tholdsAt("+env.getHypothesis().get(i).getHoldsAts().get(j).getContextRelation().getName().replaceAll("\\d", ""));
						}
					}
					else if (!h.isIsHolding()){
						if (!env.getHypothesis().get(i).getHoldsAts().get(j).getContextRelation().isFlag())
							writer2.printf("\tnot holdsAt("+env.getHypothesis().get(i).getHoldsAts().get(j).getContextRelation().getName());
						else
							writer2.printf("\tnot holdsAt("+env.getHypothesis().get(i).getHoldsAts().get(j).getContextRelation().getName().replaceAll("\\d", ""));
					}
					
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
				
				// HAPPENS
				
				for (int j = 0; j < env.getHypothesis().get(i).getHappens().size(); j++){	
					
					if (!env.getHypothesis().get(i).getHappens().get(j).getEvent().isFlag())
						writer2.printf("\thappens("+env.getHypothesis().get(i).getHappens().get(j).getEvent().getName());
					else{
						System.out.println("Trying to REPLACE THE DIGITS");
						writer2.printf("\thappens("+env.getHypothesis().get(i).getHappens().get(j).getEvent().getName().replaceAll("\\d", ""));
					}
					
					writeEventParameters(env.getHypothesis().get(i).getHappens().get(j).getEvent(), writer2, false);
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
				
				// HOLDS AT BETWEEN
				for (int j = 0; j < env.getHypothesis().get(i).getHoldsAtBetweens().size(); j++){
					HoldsAtBetween h = env.getHypothesis().get(i).getHoldsAtBetweens().get(j);
					
					if (h.isIsHolding()){						
						if (!env.getHypothesis().get(i).getHoldsAtBetweens().get(j).getContextRelation().isFlag())
							writer2.printf("\tholdsAt_between(T"+h.getInitialTime()+"," + h.getContextRelation().getName());
						else{
							System.out.println("Trying to REPLACE THE DIGITS");
							writer2.printf("\tholdsAt_between(T"+h.getInitialTime()+"," + h.getContextRelation().getName().replaceAll("\\d", ""));
						}
					}
					else if (!h.isIsHolding()){
						if (!env.getHypothesis().get(i).getHoldsAtBetweens().get(j).getContextRelation().isFlag())
							writer2.printf("\tneg_holdsAt_between(T"+h.getInitialTime()+"," + h.getContextRelation().getName());
						else{
							System.out.println("Trying to REPLACE THE DIGITS");
							writer2.printf("\tneg_holdsAt_between(T"+h.getInitialTime()+"," + h.getContextRelation().getName().replaceAll("\\d", ""));
						}
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
