package specGenerator;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.print.attribute.standard.PDLOverrideSupported;

import org.eclipse.jface.dialogs.MessageDialog;

public class SpecGenerator {

	private final String e = "environment.txt";
	private final String d= "domain_ind_axioms.txt";
	private final String he="heuristics.txt";
	private final String t1="tail.txt";
	private final String t2="tail2.txt";
	private final String s="spec.txt";
	private final String sver="spec-ver.txt";
	private final String p="pos.txt";
	private final String n="neg.txt";
	private final String r="req.txt";
	private Set<String> relEvents = null;

	private String clasp = "";
	private String gringo = "";
	private String xhail = "";

	private String clingo = "";

	private String targetDir;
	int hypNumber; 
	int hLength;

	public SpecGenerator(String targetDir, int hypNumber, int hLength){
		this.targetDir = targetDir;
		this.hypNumber = hypNumber;
		this.hLength = hLength;
	}


	private void setDir(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(targetDir+"/conf.txt"))); 
			String line;
			while ((line = br.readLine()) != null) {
				/* if(line.contains("dir")){
	    	  if(line.contains("\n"))
	    		  dir = line.substring(4, line.indexOf("\n"));
	    	  else
	    		  dir = line.substring(4);
	      }*/
				if(line.contains("clingo")){
					if(line.contains("\n"))
						clingo = line.substring(7, line.indexOf("\n"));
					else
						clingo = line.substring(7);
				}
			}
			br.close();
		} catch(IOException ex){
			MessageDialog.openError(null, "Error", "File "+ targetDir +"/conf.txt does not exist");
		}
	}

	public String readFile(File file) throws IOException {
		return new String(Files.readAllBytes(file.toPath()));
	}

	private List<List<String>> historyIdentification(){
		List<List<String>> histories = null;
		File addFile = new File(targetDir+"/AddFiles");
		if(!addFile.exists())
			MessageDialog.openError(null, "Error", "Directory AddFiles not placed in "+targetDir);
		File dFile = new File(targetDir+"/AddFiles/"+d);
		if(!dFile.exists())
			MessageDialog.openError(null, "Error", "Domain independent axioms file "+d +" not present in "+targetDir+"/AddFiles");
		File heFile = new File(targetDir+"/AddFiles/"+he);
		if(!heFile.exists())
			MessageDialog.openError(null, "Error", "Heuristics file "+he +" not present in "+targetDir+"/AddFiles");
		File t1File = new File(targetDir+"/AddFiles/"+t1);
		if(!t1File.exists())
			MessageDialog.openError(null, "Error", "Optimisation extension file "+he +" not present in "+targetDir+"/AddFiles");
		File env = new File(targetDir+"/"+e);
		BufferedWriter hi;
		try {
			hi = new BufferedWriter(new FileWriter(targetDir+"/"+"history_iden-h"+hypNumber+".lp"));
			hi.write("time(0.."+hLength+").\n\n");
			hi.append("trace(tr1).\n\n");
			hi.append(readFile(env));

			File hyp = new File(targetDir+"/"+"h"+hypNumber+".txt");
			hi.append("hyp(h"+hypNumber+").\n\n");
			hi.append(readFile(hyp));
			hi.append("\nhypothesis(h"+hypNumber+",TR):-\n");
			hi.append("\ttrace(TR),\n");
			hi.append("\ttime(T),\n");
			hi.append("\thypothesis(h"+hypNumber+",T,TR).\n");
			hi.append(":- trace(TR), not hypothesis(h"+hypNumber+",TR).\n\n");
			hi.append(readFile(dFile));
			hi.append("\n\n\n");

			hi.append(readFile(heFile));
			hi.append("\n\n\n");

			hi.append(readFile(t1File));
			hi.append("\n");
			hi.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		String bashCmd1 = clingo+" -n 0 "+targetDir+"/history_iden-h"+hypNumber+".lp";
		System.out.println(bashCmd1);
		Process p= null;
		try {
			p = Runtime.getRuntime().exec(bashCmd1);
			p.waitFor();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		byte[] buffer;
		 File out1 = null;
		try {
			buffer = new byte[p.getInputStream().available()];
			p.getInputStream().read(buffer);
			 
		   out1 = new File(targetDir+"/out1");
		    OutputStream outStream = new FileOutputStream(out1);
		    outStream.write(buffer);
		    outStream.close();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		if (!out1.exists()){
			MessageDialog.openError(null, "Error", "Problem in the generated Hystories");
		}
		else{
			System.out.println("Histories identified");
			boolean firstOptFound = false;
			boolean secondOptFound = false;
			String opt = "";
			BufferedReader in = null;
			try {
				in = new BufferedReader(new InputStreamReader(new ReverseLineInputStream(out1)));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while(true){
				int i=0;
				String line;
				try {
					line = in.readLine();
					if(line == null)
						break;

					if (line.contains("Optimization: ") && !firstOptFound){
						opt = line.replaceAll("\\s+","");

						firstOptFound = true;
						continue;		
					}
					if (line.contains("Optimization: ") && firstOptFound){
						if(line.replaceAll("\\s+","").equals(opt)){

							secondOptFound = true;
							continue;
						}
						else break;
					}

					if(secondOptFound){

						if(i==0){
							histories = new ArrayList<List<String>>(); 

						}

						String[] hist = line.trim().split("\\s+");

						histories.add(i, Arrays.asList(hist));
						i++;
						secondOptFound = false;      
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}



			}
		}
		out1.delete(); 

		return histories;	

	}



	private List<List<String>> specVerification(){
		List<List<String>> presHistories = null;
		File sFile = new File(targetDir+"/AddFiles/"+s);
		if(!sFile.exists())
			MessageDialog.openError(null, "Error", "Spec file "+s +" not present in "+targetDir+"/AddFiles");
		File t2File = new File(targetDir+"/AddFiles/"+t2);
		if(!t2File.exists())
			MessageDialog.openError(null, "Error", "Optimisation extension file  "+t2 +" not present in "+targetDir+"/AddFiles");

		BufferedWriter sv;
		try {
			sv = new BufferedWriter(new FileWriter(targetDir+"/Spec-Ver-h"+hypNumber+".lp"));
			sv.append("time(0.."+hLength+").\n\n");
			sv.append("trace(tr1).\n\n");

			File env = new File(targetDir+"/"+e);
			sv.append(readFile(env));
			sv.append("\nhyp(h"+hypNumber+").\n\n");
			File hyp = new File (targetDir+"/h"+hypNumber+".txt");
			sv.append(readFile(hyp));

			sv.append("\nhypothesis(h"+hypNumber+",TR):-\n");
			sv.append("\ttrace(TR),\n");
			sv.append("\ttime(T),\n");
			sv.append("\thypothesis(h"+hypNumber+",T,TR).\n");
			sv.append(":- trace(TR), not hypothesis(h"+hypNumber+",TR).\n\n");

			File ax = new File(targetDir+"/AddFiles/"+d);
			sv.append(readFile(ax));
			sv.append("\n\n\n");

			File heuristics = new File(targetDir+"/AddFiles/"+he);
			sv.append(readFile(heuristics));
			sv.append("\n\n\n");
			sv.append("clock(0.."+String.valueOf(hLength+1)+").\n\n");

			File spec = new File(targetDir+"/AddFiles/"+sver);
			sv.append(readFile(spec));
			sv.append("\n\n\n");

			File tail2 = new File(targetDir+"/AddFiles/"+t2);
			sv.append(readFile(tail2));
			sv.close();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} 

		String bashCmd1 = clingo+" -n 0 "+targetDir+"/Spec-Ver-h"+hypNumber+".lp";
		Process p= null;
		try {
			p = Runtime.getRuntime().exec(bashCmd1);
			p.waitFor();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		byte[] buffer;
		File out2 = null;
		try {
			buffer = new byte[p.getInputStream().available()];
			p.getInputStream().read(buffer);
			 
		    out2 = new File(targetDir+"/out2");
		    OutputStream outStream = new FileOutputStream(out2);
		    outStream.write(buffer);
		    outStream.close();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	
		if (!out2.exists()){
			MessageDialog.openError(null, "Error", "Problem in the Preservation Hystories verification");
		}
		else{
			String opt="";

			boolean firstOptFound = false;
			boolean secondOptFound = false;
			BufferedReader in = null;
			
			try {
				in = new BufferedReader(new InputStreamReader(new ReverseLineInputStream(out2)));
				while(true){
					int i=0;
					String line;
					try {
						line = in.readLine();
						if(line == null)
							break;

						if (line.contains("Optimization: ") && !firstOptFound){
							opt = line.replaceAll("\\s+","");

							firstOptFound = true;
							continue;		
						}
						if (line.contains("Optimization: ") && firstOptFound){
							if(line.replaceAll("\\s+","").equals(opt)){

								secondOptFound = true;
								continue;
							}
							else break;
						}

						if(secondOptFound){

							if(i==0){
								presHistories = new ArrayList<List<String>>(); 

							}

							String[] phist = line.trim().split("\\s+");

							presHistories.add(i, Arrays.asList(phist));
							i++;
							secondOptFound = false;      
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}



				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}      
		}
		out2.delete();
		return presHistories;
	}












	public void run(){
		List<List<String>> histories = null;
		List<List<String>> presHistories = null;
		setDir();
		histories  = historyIdentification();
		if(histories.size() < 1)
			MessageDialog.openInformation(null, "Info", "hypothesis h"+hypNumber+" is not supported in the environment");
		else{

			String tempString = "";
			int i =0;
			try {
				BufferedWriter pw = new BufferedWriter(new FileWriter(targetDir+"/"+p));
				for(List<String> hist: histories){
					for(String prEv: hist){
						if(i==0)
							pw.append(prEv.substring(3)+".\n");
						else
							pw.append(prEv.substring(3, prEv.lastIndexOf("tr"))+"tr"+String.valueOf(i+1)+").\n");
						tempString = tempString+ prEv.substring(3)+".\n";
					}
					i++;
				}
				pw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	 

			MessageDialog.openInformation(null, "Primitive histories supporting h"+hypNumber, tempString);
			presHistories = specVerification();
			tempString = "";

			if(presHistories.size() > 0){
				for(List<String> pHist: presHistories){
					for(String presEv: pHist){
						tempString = tempString+ presEv+".\n";
					}
					MessageDialog.openInformation(null, "The following preservation histories are not covered", tempString);
				}          
			}
		}
		specGeneration();
	}


	private void specGeneration(){
		File rFile = new File(targetDir+"/AddFiles/"+r);
		if(!rFile.exists())
			MessageDialog.openError(null, "Error", "Requirements file  "+r +" not present in "+targetDir+"/AddFiles");
		else{

			BufferedWriter sg;
			try {
				sg = new BufferedWriter(new FileWriter(targetDir+"/Spec-Learn-h"+hypNumber+".lp"));
				sg.write("time(0.."+hLength+").\n\n");
				for(int i=0; i<=hLength +1; i++)
					sg.append("next("+i+","+String.valueOf(i+1)+").\n");

				File env = new File(targetDir+"/"+e);
				sg.append(readFile(env));
				File hyp = new File(targetDir+"/"+'h'+hypNumber+".txt");

				sg.append("\nnhyp(h"+hypNumber+").\n\n");
				sg.append(readFile(hyp));
				sg.append("\nhypothesis(h"+hypNumber+",TR):-\n");

				sg.append("\ttrace(TR),\n");
				sg.append("\ttime(T),\n");
				sg.append("\thypothesis(h"+hypNumber+",T,TR).\n\n");

				sg.append("% ----- * Satisfaction Argument E and H is  consistent  * -----\n\n");
				sg.append(":- trace(TR), pos(TR), not hypothesis(h"+hypNumber+",TR).\n\n");
				sg.append("% ----- * Satisfaction Argument E and !H is consistent (if needed)*  -----\n\n");
				sg.append(":- trace(TR), neg(TR), hypothesis(h"+hypNumber+",TR).\n\n");
				sg.append("%-------");

				File ax = new File(targetDir+"/AddFiles/"+d);
				sg.append(readFile(ax));
				sg.append("\n\n\n");
				MessageDialog.openInformation(null, "Info", "Click ok only after you provide examples of\n positive and negative histories in file pos.txt and neg.txt, respectively.");				   

				File pos =new File(targetDir+"/"+p);
				if(!pos.exists()){
					MessageDialog.openError(null, "Error", "Insufficient number of positive histories provided");
					System.exit(-1);
				}
				sg.append("%-------\n");

				BufferedReader br = new BufferedReader(new FileReader(pos)); 
				String line;
				List<String> relPosTraces = null;
				while ((line = br.readLine()) != null) {
					if(line.equals("\n") || line.equals("\r\n"))
						continue;
					String trace = line.substring((line.lastIndexOf(",tr")+1), line.lastIndexOf(")."));
					if(relPosTraces == null)
						relPosTraces = new ArrayList<String>();
					if(!relPosTraces.contains(trace))
						relPosTraces.add(trace);
				}
				br.close();

				File neg = new File(targetDir+"/"+n);
				List<String> relNegTraces = new ArrayList<String>();
				if(neg.exists()){
					BufferedReader nb = new BufferedReader(new FileReader(neg)); 
					String negLine = null;

					while ((negLine = nb.readLine()) != null) {
						if(negLine.equals("\n") || negLine.equals("\r\n"))
							continue;
						String trace = negLine.substring((negLine.lastIndexOf(",tr")+1), negLine.lastIndexOf(")."));
						
						if(!relNegTraces.contains(trace))
							relNegTraces.add(trace);
					}
					nb.close();
				}
				int i=0;
				sg.append("trace(");
				for(String tr: relPosTraces){
					if(i>0)
						sg.append(";");
					sg.append(tr);
					i++;
				}
				
				for(String tr: relNegTraces){
					sg.append(";");
					sg.append(tr);

				}

				sg.append(").\n");
				i = 0;
				sg.append("pos(");
				for(String tr: relPosTraces){
					if(i>0)
						sg.append(";");
					sg.append(tr);
					i++;
				}
				if(relPosTraces.size() > 0)
					sg.append(").\n\n");
				int j = 0;
				if(relNegTraces.size() > 0){
					sg.append("neg(");
					for(String tr: relNegTraces){
						if(j > 0)
							sg.append(";");
						sg.append(tr);
						j++;
						sg.append(").\n\n");
					}
				}


				sg.append(readFile(pos));
				sg.append("\n\n");
				if(relNegTraces.size()>0){
					sg.append(readFile(neg));
					sg.append("\n\n");
				}

				File heuristics = new File(targetDir+"/AddFiles/"+he);
				sg.append(readFile(heuristics));
				sg.append("\n\n\n");
				sg.append("clock(0.."+String.valueOf(hLength+1)+").\n\n");

				File spec = new File(targetDir+"/AddFiles/"+s);
				sg.append(readFile(spec));
				sg.append("\n\n\n");

				File req = new File(targetDir+"/"+r);
				sg.append(readFile(req));
				sg.append("\n\n\n");
				sg.append("example(");       

				for( i=0; i< relPosTraces.size()+relNegTraces.size();i++){
					if(i>0)
						sg.append(";");
					sg.append("ex"+String.valueOf(i+1));
				}

				sg.append(").\n\n");

				List<List<String>> presTraces = getPresTraces(relPosTraces);

				List<List<String>> negPresTraces = null;
				if(relNegTraces.size()>0){
					negPresTraces = getNegPresTraces(relNegTraces);
				}

				for (i =0; i< relPosTraces.size(); i++){
					sg.append("ex"+String.valueOf(i+1)+":-\n");
					for(j =0; j < presTraces.size(); j++){
						if(j>0)
							sg.append(",\n");
						sg.append("\t"+presTraces.get(i).get(j));

					}
					sg.append(".\n\n");
				}

				for (i =0; i< relPosTraces.size(); i++)
					sg.append("#example ex"+String.valueOf(i + 1)+".\n");
				for(i = 0; i < relNegTraces.size(); i++){
					sg.append("ex"+String.valueOf(i+1 + relPosTraces.size())+":-\n");
					for(j=0; j< relNegTraces.size(); j++){
						if(j>0)
							sg.append(",\n");
						sg.append("\t"+negPresTraces.get(i).get(j));
					}
					sg.append(".\n\n");
				}

				for(i =0; i< relNegTraces.size(); i++)
					sg.append("#example not ex"+String.valueOf(i + 1 + relPosTraces.size())+".\n");


				HashMap<String, List<String>>events = getPrimEvents();

				writeModels(sg, events);
				sg.close();

				BufferedReader cr = new BufferedReader(new FileReader(targetDir+"/conf.txt")); 
				String rLine;

				while ((rLine = cr.readLine()) != null) {
					if(rLine.contains("clasp")){
						if(rLine.contains("\n"))
							clasp = rLine.substring(6, rLine.indexOf("\n"));
						else
							clasp = rLine.substring(6);
					}
					if(rLine.contains("gringo")){
						if(rLine.contains("\n"))
							gringo = rLine.substring(7, rLine.indexOf("\n"));
						else
							gringo = rLine.substring(7);
					}
					if(rLine.contains("xhail")){
						if(rLine.contains("\n"))
							xhail = rLine.substring(6, rLine.indexOf("\n"));
						else
							xhail = rLine.substring(6);
					}

				}
				cr.close();
				String bashCmd = "java -jar "+xhail+" -a  -b  -f  -m  -c "+clasp+" -g "+gringo +" "+targetDir+"/Spec-Learn-h"+hypNumber+".lp";
				
				System.out.println(bashCmd);
				Process p = null;
				try {
					p = Runtime.getRuntime().exec(bashCmd);
					p.waitFor();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				byte[] buffer;
				File out3 = null;
				try {
					buffer = new byte[p.getInputStream().available()];
					p.getInputStream().read(buffer);
					 
				    out3 = new File(targetDir+"/out3");
				    OutputStream outStream = new FileOutputStream(out3);
				    outStream.write(buffer);
				    outStream.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if (!out3.exists()){
					MessageDialog.openError(null, "Error", "Problem in the Specification Generation");
				}
				else{
					boolean uncFound = false;
					String tempString="";

					BufferedReader in = null;
					try {
						in = new BufferedReader(new InputStreamReader(new ReverseLineInputStream(out3)));
						while ((line = in.readLine()) != null) {
							if(line.contains("uncovered"))
								uncFound = true;
							else{
								if(line.contains("hypothesis") && uncFound)
									break;
								else{
									if(!line.contains("hypothesis:") && uncFound){
										String prec = line.substring(line.indexOf("rtrig"));
										tempString = tempString + prec.substring(0, prec.indexOf(":-")+2);
										tempString = tempString +"\n\t" + prec.substring(prec.indexOf(":-")+2)+"\n";
									}
								}
							}
						}
					GetSpecDialog sd = new GetSpecDialog(tempString, null);
					sd.open();
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					out3.delete();

				}

			} catch(IOException ex){
				ex.printStackTrace();

			}		

		}


	}




	private void writeModels(BufferedWriter sg, HashMap<String, List<String>> events) throws IOException{
		sg.append("\n\n");
		sg.append("% ----- * Specification Language * -----\n\n");
		for(String ev: events.keySet()){
			sg.append("#modeh rtrig(preserve(");
			sg.append(ev+"(");
			int k=0;
			for(String p: events.get(ev)){
				if(k >0)
					sg.append(",");
				sg.append("+"+p);
				k++;
			}
			sg.append("),+clock), +time, +trace).\n");
		}
		sg.append("\n");


		for(String ev: events.keySet()){
			sg.append("#modeb happens(receive(");
			sg.append(ev+"(");
			int k=0;
			for(String p: events.get(ev)){
				if(k >0)
					sg.append(",");
				sg.append("+"+p);
				k ++;
			}
			sg.append("),+clock), +time, +trace).\n");
		}
		sg.append("\n");

		for(String ev: events.keySet()){
			sg.append("#modeb happens(receive(");
			sg.append(ev+"(");
			int k=0;
			for(String p: events.get(ev)){
				if(k >0)
					sg.append(",");
				sg.append("+"+p);
				k ++;
			}
			sg.append("),+clock), +time, +trace).\n");
		}
		sg.append("\n");


		for(String ev: events.keySet()){
			List<String> list = Iterations.printBin("",events.get(ev).size(), null);
			sg.append("\n");
			for(String conf: list){
				int k = 0;
				sg.append("#modeb happens_pred(preserve("+ev+"(");
				for(String e: events.get(ev)){
					if(k>0)
						sg.append(",");
					if(conf.charAt(k) == '0')
						sg.append("-");
					else sg.append("+");
					sg.append(e);
					k++;
				}
				sg.append("),+clock), +time, +trace).\n");
			}
		}
		sg.append("\n");

		for(String ev: events.keySet()){
			List<String> list = Iterations.printBin("",events.get(ev).size(), null);
			sg.append("\n");
			for(String conf: list){
				int k = 0;
				sg.append("#modeb not_happens_pred(preserve("+ev+"(");
				for(String e: events.get(ev)){
					if(k>0)
						sg.append(",");
					if(conf.charAt(k) == '0')
						sg.append("-");
					else sg.append("+");
					sg.append(e);
					k++;
				}
				sg.append("),+clock), +time, +trace).\n");
			}
		}
		sg.append("\n");

	}




	private HashMap<String, List<String>> getPrimEvents(){
		HashMap<String, List<String>> events = null;
		String event = "";
		boolean evFound = false;
		boolean zeroParams = true;
		List<String> params = null;

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(targetDir+"/"+e)));
			String line;
			while ((line = br.readLine()) != null) {
				if(line.startsWith("pe(")  && !evFound && !line.contains(".")){
					line =line.substring(line.indexOf("pe(")+3);
					event = line.substring(0, line.indexOf("("));
					if(relEvents.contains(event))
						evFound = true;
				} else{
					if(line.contains("pe(") && evFound){
						MessageDialog.openError(null, "Error", "Primitive events in the Environment Definition wrongly specified");
						System.exit(-1);
					} else{
						if(evFound){
							if(!line.contains("\n") && !line.contains("\r\n")){
								if(zeroParams)
									params = new ArrayList<String>();
								for(String p: line.split(" ")){
									if(p.equals("\t"))
										continue;
									String st = p.substring(0, p.indexOf("("));
									if(!st.contentEquals("")){
										st = st.replace(" ","");
										st =st.replace("\t","");
										params.add(st);
									}
									if(zeroParams)
										zeroParams = false;
								}
								if(line.contains(".")){
									evFound = false;
									zeroParams = true;
									if(events== null)
										events = new HashMap<String, List<String>>();
									events.put(event,params);
								}

							}
						}
					}

				}

			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return events;

	}




	private List<List<String>> getNegPresTraces(List<String> relNegTraces){
		List<List<String>> presTraces = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(targetDir+"/"+n)));
			for(String tr: relNegTraces){

				String line;
				List<String> list = null;
				while ((line = br.readLine()) != null) {
					if(line.contains(","+tr+").")){
						String newLine1 = line.replace("happens","op_happens(preserve");
						if(!newLine1.contains(".\n"))
							newLine1= newLine1.replace(","+tr+").","");
						else
							newLine1= newLine1.replace(","+tr+").\n","");
						String ti = newLine1.substring(newLine1.lastIndexOf(",")+1);
						newLine1 = newLine1+"),"+ti+","+tr+")";
						if(list== null)
							list = new ArrayList<String>();
						list.add(newLine1);
					}
				}
				br.close();
				if(presTraces== null)
					presTraces = new ArrayList<List<String>>();
				presTraces.add(list);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return presTraces;			
	}



	private List<List<String>> getPresTraces(List<String> relPosTraces){
		List<List<String>> results = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(targetDir+"/"+p)));
			for(String tr: relPosTraces){


				String line;
				List<String> list = null;
				while ((line = br.readLine()) != null) {
					if(line.contains(","+tr+").")){
						String eventName = line.substring(line.indexOf("happens")+8);
						eventName = eventName.substring(0,eventName.indexOf("("));
						if(relEvents == null)
							relEvents = new HashSet<String>();
						relEvents.add(eventName);
						String newLine1 = line.replace("happens","op_happens(preserve");
						if(!newLine1.contains(".\n"))
							newLine1 = newLine1.replace(","+tr+").","");
						else
							newLine1 = newLine1.replace(","+tr+").\n","");
						String ti = newLine1.substring(newLine1.lastIndexOf(",")+1);
						newLine1 = newLine1+"),"+ti+","+tr+")";
						if(list == null)
							list = new ArrayList<String>();
						list.add(newLine1);

					}
				}
				br.close();
				if(results== null)
					results = new ArrayList<List<String>>();
				results.add(list);
			}
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return results;
	}


}   

























