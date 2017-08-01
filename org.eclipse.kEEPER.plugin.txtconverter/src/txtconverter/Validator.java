package txtconverter;

import org.eclipse.jface.dialogs.MessageDialog;

import model.ComplexEvent;
import model.Environment;
import model.PrimitiveEvent;

public class Validator {

	private Environment env;
	public Validator(Environment env){
		this.env = env;
	}
	
	public boolean validate(){
		
		// Check if all files have been created
		
		// Validate Types and Instances
		for (int i = 0; i < env.getInstances().size(); i++){
			if (env.getInstances().get(i).getName() == null){
				MessageDialog.openError(null, "Error", "Not all Instances have a name defined");
				return false;
			}
			if (env.getInstances().get(i).getType() == null){
				MessageDialog.openError(null, "Error", "The Instance " + env.getInstances().get(i).getName() + " doesn't have a Type defined");
				return false;
			}
			if (env.getInstances().get(i).getType().getName().isEmpty()){
				MessageDialog.openError(null, "Error", "Not all Types have a name defined");
				return false;
			}
		}
		
		// Validate Events
		for (int i = 0; i < env.getEvents().size(); i++){
			if (env.getEvents().get(i).getName() == null){
				MessageDialog.openError(null, "Error", "Not all Events have a name defined");
				return false;
			}
			if (env.getEvents().get(i) instanceof PrimitiveEvent){
				if (((PrimitiveEvent)env.getEvents().get(i)).getAgent() == null){
					MessageDialog.openError(null, "Error", "The Event "+ env.getEvents().get(i).getName() + " doesn't have an Agent defined");
					return false;
				}
				if (((PrimitiveEvent)env.getEvents().get(i)).getObserver() == null){
					MessageDialog.openError(null, "Error", "The Event "+ env.getEvents().get(i).getName() + " doesn't have an Observer defined");
					return false;
				}
			}
			
			if (env.getEvents().get(i) instanceof ComplexEvent){
				if (((ComplexEvent)env.getEvents().get(i)).getAgent() == null){
					MessageDialog.openError(null, "Error", "The Event "+ env.getEvents().get(i).getName() + " doesn't have an Agent defined");
					return false;
				}
			}
		}
		
		// Validate Context Relations
		for (int i = 0; i < env.getContextRelations().size(); i++){
			if (env.getContextRelations().get(i).getName() == null){
				MessageDialog.openError(null, "Error", "Not all Context Relations have a name defined");
				return false;
			}
			if (env.getContextRelations().get(i).getTypes().isEmpty()){
				MessageDialog.openError(null, "Error", "The Context Relation "+ env.getContextRelations().get(i).getName() + " doesn't have any Type defined");
				return false;
			}
		}
		
		// Validate Behavioral Descriptions
		for (int i = 0; i < env.getBehavDescriptions().size(); i++){
			if (env.getBehavDescriptions().get(i).getName() == null){
				MessageDialog.openError(null, "Error", "Not all Behavioral Descriptions have a name defined");
				return false;
			}
			if (env.getBehavDescriptions().get(i).getTimeInstants() == 0){
				MessageDialog.openError(null, "Error", "The Behavioral Description "+ env.getBehavDescriptions().get(i).getName() + " doesn't have the number of time instants defined");
				return false;
			}
			if ((env.getBehavDescriptions().get(i).getHappens().isEmpty())&&(env.getBehavDescriptions().get(i).getHoldsAts().isEmpty())&&(env.getBehavDescriptions().get(i).getHoldsAtBetweens().isEmpty())){
				MessageDialog.openError(null, "Error", "The Behavioral Description "+ env.getBehavDescriptions().get(i).getName() + " doesn't have any predicate defined");
				return false;
			}
		}
		
		// Validate Hypotheses
		for (int i = 0; i < env.getHypothesis().size(); i++){
			if (env.getHypothesis().get(i).getName() == null){
				MessageDialog.openError(null, "Error", "Not all Hypotheses have a name defined");
				return false;
			}
			if (env.getHypothesis().get(i).getTimeInstants() == 0){
				MessageDialog.openError(null, "Error", "The Hypothesis "+ env.getHypothesis().get(i).getName() + " doesn't have the number of time instants defined");
				return false;
			}
			if ((env.getHypothesis().get(i).getHappens().isEmpty())&&(env.getHypothesis().get(i).getHoldsAts().isEmpty())&&(env.getHypothesis().get(i).getHoldsAtBetweens().isEmpty())){
				MessageDialog.openError(null, "Error", "The Hypothesis "+ env.getHypothesis().get(i).getName() + " doesn't have any predicate defined");
				return false;
			}
		}
		
		// Validate Initially
		for (int i = 0; i < env.getInitials().size(); i++){
			if (env.getInitials().get(i).getContextRelation() == null){
				MessageDialog.openError(null, "Error", "Not all Initials have a Context Relation defined");
				return false;
			}
			if (env.getInitials().get(i).getInstances().isEmpty()){
				MessageDialog.openError(null, "Error", "Not all Initials have the Instances defined");
				return false;
			}
		}
		
		return true;
	}
}
