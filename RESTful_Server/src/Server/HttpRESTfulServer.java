package Server;

import static org.junit.Assert.fail;

import java.io.IOException;

import java.net.InetSocketAddress;

import java.util.concurrent.Executors;


import DataBase.DBconnectionHardCoded;

import com.sun.net.httpserver.HttpServer;

public class HttpRESTfulServer {
	
  public static void main(String[] args) throws IOException {
    
	  DBconnectionHardCoded dBConn;
	  
	  InetSocketAddress addr = new InetSocketAddress(8080);
	  HttpServer server = HttpServer.create(addr, 0);

	  server.createContext("/", new HTTPHandler());
	  server.setExecutor(Executors.newCachedThreadPool());
	  server.start();
	  System.out.println("Server is listening on port 8080" );
    
    try{
		dBConn = new DBconnectionHardCoded();
		}
		catch(Exception e){
			fail("Couldn't open the database connection");
		}		

    

  }
}

