package Server;

import java.io.IOException;

import java.net.InetSocketAddress;

import java.util.concurrent.Executors;


import com.sun.net.httpserver.HttpServer;

public class HttpRESTfulServer {
	
  public static void main(String[] args) throws IOException {
    
	  
	  InetSocketAddress addr = new InetSocketAddress(8080);
    HttpServer server = HttpServer.create(addr, 0);

    server.createContext("/", new HTTPHandler());
    server.setExecutor(Executors.newCachedThreadPool());
    server.start();
    System.out.println("Server is listening on port 8080" );
    



  }
}

