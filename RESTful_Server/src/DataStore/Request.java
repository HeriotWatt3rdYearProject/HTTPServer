package DataStore;

import java.util.HashSet;

//Wrapper class for the request, inner class to handle the K,V pairs
//Look at using hash map and remove the set although need to ensure no duplication from parsed API request.

public class Request {

	private HashSet <Variable> request;
	
	public Request(){
		request = new HashSet();
	}
	
	public void addVariable(String key, String value, int threadNumber){
		
		Variable temp = new Variable(key, value, threadNumber);
		request.add(temp);
		
	}
	
	
	class Variable{
		public String key;
		public String value;
		public int threadNumber;
		
		public Variable(String key, String value, int threadNumber){
			this.key = key;
			this.value = value;
			this.threadNumber = threadNumber;
			
		}
	}
	
}
