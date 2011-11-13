package DataBase;
import java.util.LinkedList;
import java.util.Queue;

import com.mysql.jdbc.Connection;
import DataStore.DataStore;
import DataStore.Request;


//Class to handle the Database side of the API, threaded to allow it to run independently of the http server
//Uses the final syncronised Datastore class

/**
 * @author  lewismclean
 */
public class DatabaseBoss extends Thread {
	

	DataStore ds;
	DBconnectionHardCoded dbConn;
	Queue dbQueue;

	public DatabaseBoss(DataStore ds){
		
		this.ds = ds;
		dbConn = new DBconnectionHardCoded();
		dbQueue = new LinkedList();
		
	}

    public void run(){
    	
    	while(true){
    		
    		Request currentRequest = ds.getRequest();
    		
    		if(currentRequest!=null){
    			
    			// need to use wait() here for the database connection pool/queue if there are too many requests
    			//perhaps limit the volume of threads spawned here and rely on the datastore.request queue for storage
    			
    			DatabaseWorker dbWorker = new DatabaseWorker(ds,currentRequest, (Connection) dbConn.con);
    			dbWorker.start();
    		}

    		
    	}
    	
    }

}
