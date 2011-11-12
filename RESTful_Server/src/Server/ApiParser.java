package Server;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DataStore.Request;




//parses the URL requested and splits the variables and returns a hash map
//should look at changing to a hashset?

public class ApiParser {

	public ApiParser(){}
	
	public Object parse(String request, long requestNumber){
			
		String response = "";
		
		if(request.equals("/favicon.ico") )return response = "501 Not Implemented";
		
		
		Request req = new Request(requestNumber);
		
		//request
		
	    String re1="(\\/)(\\?)((?:[a-z][a-z]+))(=)((?:[a-z][a-z]+))(&)((?:[a-z][a-z]+))(=)((?:[a-z][a-z]+))";	// Any Single Character 1

		
	    Pattern p = Pattern.compile(re1,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Matcher m = p.matcher(request);
	    if (m.find()){

	    	req.addVariable(m.group(3), m.group(5));
	    	req.addVariable(m.group(7), m.group(8));
	    	
	    }
	    
		if(req.isEmpty()) return response = "400 Bad Request";;
		
		return req;
	}
	
	

    
}
