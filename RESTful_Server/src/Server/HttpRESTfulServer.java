package Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import DataBase.DatabaseWorker;
import com.sun.net.httpserver.HttpServer;

//this is the main thread called by the main.class and spawns the other threads. 
//creates the top level datastore class

public class HttpRESTfulServer extends Thread {

	private final DataStore.DataStore dataStore;
	HttpServer server;
	DatabaseWorker dBWorker;

	public HttpRESTfulServer() throws IOException {

		dataStore = new DataStore.DataStore();
		InetSocketAddress addr = new InetSocketAddress(8080);
		server = HttpServer.create(addr, 0);
		server.createContext("/", new HTTPHandler(dataStore));
		server.setExecutor(Executors.newCachedThreadPool());
		dBWorker = new DatabaseWorker(dataStore);
		
	}
	
	public void run() {
		try {
			server.start();
			System.out.println("Server is listening on port 8080");
			dBWorker.start();
			System.out.println("Database worker has been started");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
