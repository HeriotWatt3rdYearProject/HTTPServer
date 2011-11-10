package UnitTests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URL;
import java.util.concurrent.Executors;

import org.junit.Test;

import DataBase.DBconnectionHardCoded;
import Server.HTTPHandler;
import Tools.URLFetcher;

import com.sun.net.httpserver.HttpServer;

public class TestServer {

	//Caveat with this simple test dsegined to run on my machine as it tests for my user agent, will change
	// once I've got the database connected
	
	@Test
	public void testServer() throws IOException, InterruptedException {
		
		InetSocketAddress addr = new InetSocketAddress(8080);
	    HttpServer server = HttpServer.create(addr, 0);

	    server.createContext("/", new HTTPHandler());
	    server.setExecutor(Executors.newCachedThreadPool());
	    server.start();
	   
	    URLFetcher urlHelper = new URLFetcher();
	    
	    Thread.sleep(1000);
	    
	    URL url = new URL("http:localhost:8080");
	    String response = urlHelper.fetch(url);
	
	    System.out.print(response);
	    assertNotNull(response);
	    
	}

}
