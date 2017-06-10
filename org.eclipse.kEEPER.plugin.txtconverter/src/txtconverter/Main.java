package txtconverter;

import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import model.Environment;

public class Main {
	
	private static Scanner scan;
	
	public static void main(String args[]){
		
		scan = new Scanner(System.in);
		int num=0;
		Transformer transform;
		try {
			transform = new Transformer("just a string");
			
			do{
				System.out.println("What do you want to do?");
				System.out.println("1. Parse files and output to txt");
				//System.out.println("2. Parse Types and Instances file and output to txt (gmf diagram instance)");
				System.out.println("10. Exit the program");
				
				num = scan.nextInt();
				
				switch(num){
					case 1:{
							Environment env;
							env = transform.getLoader().parseFiles();
							transform.createTxtFile(env);
							transform.createHypothesisFiles(env);
					}break;
					case 2:{
							Environment env;
							env = transform.getLoader().parseDiagramFile();
							transform.createTxtFile(env);
					}break;
				}
				
			}while(num!=10);
					
		} catch (ParserConfigurationException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SAXException | IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("program terminated");
	}
	

}
