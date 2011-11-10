package Server;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApiParser {

	public ApiParser(){}
	
	public Object parse(String request){
			
		String response = "";
		
		if(request.equals("/favicon.ico") )return response = "501 Not Implemented";
		
		HashMap <String, String> req = new HashMap<String, String>();
		
		//request
		
	    String re1="(\\/)(\\?)((?:[a-z][a-z]+))(=)((?:[a-z][a-z]+))(&)((?:[a-z][a-z]+))(=)((?:[a-z][a-z]+))";	// Any Single Character 1

		
	    Pattern p = Pattern.compile(re1,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Matcher m = p.matcher(request);
	    if (m.find()){

	    	req.put(m.group(3), m.group(5));
	    	req.put(m.group(7), m.group(8));
	    	
	    }
	    
		if(req.isEmpty()) return response = "400 Bad Request";;
		
		return req;
	}
	
	

    
}
