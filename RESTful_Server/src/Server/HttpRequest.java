package Server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;

import DataStore.DataStore;
import DataStore.Request;
import DataStore.Response;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

//threaded class to handle the http requests as they come in, Datastore (I hope?) will be syncronised 
//with the others when I test.
//Need to refactor the methods into a smaller methods.

/**
 * @author  lewismclean
 */
public class HttpRequest implements HttpHandler  {


	private DataStore ds;

	public HttpRequest(DataStore ds) {

		//this needs to be tested
		this.ds = ds;
	}

	public void handle(HttpExchange exchange) throws IOException {

		
		
		long requestNumber = ds.getThreadNumber(); 
		
		long startTime = System.currentTimeMillis();
		
		String requestMethod = exchange.getRequestMethod();
		String request = exchange.getProtocol();
		
		//get variables and parse into K,V pairs
		URI str = exchange.getRequestURI();
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

			
			while(!gotResponse){
				
				
				//WORK GOD DAMMIT !!
/*				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				
				if(ds.peekResponse() == requestNumber){
					
					long endTime = System.currentTimeMillis();
					
					Response resp = ds.getResponse();
					gotResponse = true;
					System.out.println("Got response from DBworker  = " + requestNumber + "Response time = " + ((endTime - startTime)));
					s=Long.toString(requestNumber);
					
				}
				
			}
			
			
		}

		
		
		// return request part - REFACTOR to method with args..
		if (requestMethod.equalsIgnoreCase("GET")) {
//			Headers responseHeaders = exchange.getResponseHeaders();
//			responseHeaders.set("Content-Type", "text/plain");
//			exchange.sendResponseHeaders(200, 0);
//
			OutputStream responseBody = exchange.getResponseBody();
//			Headers requestHeaders = exchange.getRequestHeaders();

			responseBody.write(s.getBytes());

			responseBody.close();
		}
	}

}
