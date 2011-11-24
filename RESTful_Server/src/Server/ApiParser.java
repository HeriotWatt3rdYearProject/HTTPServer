package Server;

import java.util.ArrayList;
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
		
		String[] variables = request.split("&");
		variables[0] = variables[0].substring(3);
	    
		for(int i=0; i<variables.length;i++){
			
			String[] temp = variables[0].split("=");
			
			
			req.addVariable(temp[0], temp[1]);
			System.out.println(temp[0]+" = "+ temp[1]);
			
		}
			
			
		
	    
	    
		if(req.isEmpty()) return response = "400 Bad Request";;
		
		return req;
	}
	
	

    
}
