package Server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import DataStore.DataStore;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class HTTPHandler implements HttpHandler {

	private DataStore ds;

	public HTTPHandler(DataStore ds) {

		//this needs to be tested
		this.ds = ds;
	}

	public void handle(HttpExchange exchange) throws IOException {

		long threadNumber = ds.getThreadNumber(); 
		
		String requestMethod = exchange.getRequestMethod();
		String request = exchange.getProtocol();
		
		//get variables and parse into K,V pairs
		URI str = exchange.getRequestURI();
		ApiParser aParse = new ApiParser();
		Object parseResult = aParse.parse(str.toASCIIString());

		// remove
		String s = null;

		if (parseResult instanceof String)
			s = (String) parseResult;
		if (parseResult instanceof HashMap) {

		}

		System.out.println(request + "   " + requestMethod + "    " + str);

		//send request to syncronised data store with thread number.
		//
		//
		//
		
		
		// return request part - REFACTOR to method with args..
		if (requestMethod.equalsIgnoreCase("GET")) {
			Headers responseHeaders = exchange.getResponseHeaders();
			responseHeaders.set("Content-Type", "text/plain");
			exchange.sendResponseHeaders(200, 0);

			OutputStream responseBody = exchange.getResponseBody();
			Headers requestHeaders = exchange.getRequestHeaders();

			responseBody.write(s.getBytes());

			responseBody.close();
		}
	}

}
