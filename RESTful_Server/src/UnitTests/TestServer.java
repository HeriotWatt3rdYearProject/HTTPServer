package UnitTests;

import static org.junit.Assert.*;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.junit.Test;

import Server.DBconnectionHardCoded;
import Server.HTTPHandler;

import com.sun.net.httpserver.HttpServer;

public class TestServer {

	@Test
	public void test() {
		
		InetSocketAddress addr = new InetSocketAddress(8080);
	    HttpServer server = HttpServer.create(addr, 0);

	    server.createContext("/", new HTTPHandler());
	    server.setExecutor(Executors.newCachedThreadPool());
	    server.start();
	   
	    
		
	}

}
