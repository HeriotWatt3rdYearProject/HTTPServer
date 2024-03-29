package Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import DataBase.DatabaseBoss;
import DataStore.DataStore;

import Tools.LogWriter;

import com.sun.net.httpserver.HttpServer;

//this is the main thread called by the main.class and spawns the other threads. 
//creates the top level datastore class

/**
 * @author  lewismclean
 */
public class HttpRESTfulServer extends Thread {


	private final DataStore dataStore;
	private HttpServer server;
	private DatabaseBoss dBWorker;
	private LogWriter log;

	public HttpRESTfulServer() throws IOException {

		dataStore = new DataStore();
		InetSocketAddress addr = new InetSocketAddress(8080);
		server = HttpServer.create(addr, 0);
		server.createContext("/", new HttpRequest(dataStore));
		server.setExecutor(Executors.newCachedThreadPool());
		dBWorker = new DatabaseBoss(dataStore);
		
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
