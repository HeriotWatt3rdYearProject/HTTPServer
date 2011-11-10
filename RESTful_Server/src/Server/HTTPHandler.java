package Server;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import Tools.InputStreamToString;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


public class HTTPHandler implements HttpHandler {

	public void handle(HttpExchange exchange) throws IOException {
		
		
		String requestMethod = exchange.getRequestMethod();
		String request  = exchange.getProtocol();
		URI str = exchange.getRequestURI();
		ApiParser aParse = new ApiParser();
		Object parseResult = aParse.parse(str.toASCIIString());
		
		//remove
		String s = null;
		
		if(parseResult instanceof String)s=(String) parseResult;
		if(parseResult instanceof HashMap){
			
			
			
			
		}
		
		System.out.println(request +"   " + requestMethod+"    "+str);
		
		
		
		
		
		//return request part - REFACTOR to method with args..
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
