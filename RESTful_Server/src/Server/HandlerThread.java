package Server;

import java.net.URI;

import com.sun.net.httpserver.HttpExchange;

import DataStore.DataStore;
import DataStore.Request;
import DataStore.Response;

//depreciated and not used....... keeping in project for the moment until I can work out why wait(); isn;t working as I want it too.

public class HandlerThread extends Thread {
	
	DataStore ds;
	HttpExchange ex;
	
	public HandlerThread(DataStore ds, HttpExchange ex){
	
		this.ds = ds;
		this.ex = ex;
		
	}
	
	public void run(){
		
	long requestNumber = ds.getThreadNumber(); 
	
	long startTime = System.currentTimeMillis();
	
	String requestMethod = ex.getRequestMethod();
	String request = ex.getProtocol();
	
	//get variables and parse into K,V pairs
	URI str = ex.getRequestURI();
	ApiParser aParse = new ApiParser();
	Object parseResult = aParse.parse(str.toASCIIString(), requestNumber);

	// remove
	String s = null;

	if (parseResult instanceof String)
		s = (String) parseResult;
	if (parseResult instanceof Request) {

		ds.putRequest((Request)parseResult);
		//System.out.println("put request from httpHandler  = " + requestNumber);
		
		boolean gotResponse = false;
		
		//this needs to be changed, readup on notify() rather than constantly calling peekResponse(); 
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			if(ds.peekResponse() == requestNumber){
				
				long endTime = System.currentTimeMillis();
				
				Response resp = ds.getResponse();
				gotResponse = true;
				System.out.println("Got response from DBworker  = " + requestNumber + "Response time = " + ((endTime - startTime)/1000));
				s=Long.toString(requestNumber);
				
			}
			
		}
	}
}
