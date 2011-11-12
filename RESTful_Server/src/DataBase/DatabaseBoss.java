package DataBase;

import java.sql.ResultSet;
import java.util.Random;

import com.mysql.jdbc.Connection;

import DataStore.DataStore;
import DataStore.Request;
import DataStore.Response;



//Class to handle the Database side of the API, threaded to allow it to run independently of the http server
//Uses the final syncronised Datastore class

/**
 * @author  lewismclean
 */
public class DatabaseBoss extends Thread {
	
	/**
	 * @uml.property  name="ds"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	DataStore ds;
	/**
	 * @uml.property  name="dbConn"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	DBconnectionHardCoded dbConn;

	public DatabaseBoss(DataStore ds){
		
		this.ds = ds;
		dbConn = new DBconnectionHardCoded();
		
	}

    public void run(){
    	
    	while(true){
    		
    		Request currentRequest = ds.getRequest();
    		
    		if(currentRequest!=null){
    			
    			DatabaseWorker dbWorker = new DatabaseWorker(ds,currentRequest, (Connection) dbConn.con);
    			dbWorker.start();
    		}

    		
    	}
    	
    }

}
