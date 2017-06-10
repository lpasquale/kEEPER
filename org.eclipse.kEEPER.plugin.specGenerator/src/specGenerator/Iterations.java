package specGenerator;

import java.util.ArrayList;
import java.util.List;

public class Iterations {
	
	public static void main(String[] args){
		
		List<String> result = Iterations.printBin("",4, null);
		for(String s: result){
			System.out.println(s);
		}
	}
	
	public static  List<String> printBin(String soFar, int iterations,List<String> result) {
		if(iterations == 0){
	    	if(result == null)
	    		result = new ArrayList<String>();
	    	result.add(soFar);
	    }
	    
	    else {
	        result = printBin(soFar + "0", iterations - 1, result);
	        result =printBin(soFar + "1", iterations - 1, result);
	    }
	    return result;
	}


}
