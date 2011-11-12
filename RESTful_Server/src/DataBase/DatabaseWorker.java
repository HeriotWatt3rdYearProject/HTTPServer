package DataBase;

import java.sql.ResultSet;

import DataStore.DataStore;
import DataStore.Request;
import DataStore.Response;



//Class to handle the Database side of the API, threaded to allow it to run independently of the http server
//Uses the final syncronised Datastore class

/**
 * @author  lewismclean
 */
public class DatabaseWorker extends Thread {
	
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

	public DatabaseWorker(DataStore ds){
		
		this.ds = ds;
		dbConn = new DBconnectionHardCoded();
		
	}

    public void run(){
    	
    	while(true){
    		
    		Request currentRequest = ds.getRequest();
    		
    		if(currentRequest!=null){
    			
    			long owner = currentRequest.getRequestNumber();
    			
    			try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			ResultSet rs = null;
    	
				Response resp = new Response(rs, owner);
				ds.putResponse(resp);
    			
    		}
    		
    		//do database query
    		
    		
    		//then
    		//ds.putResponse(response);
    		
    	}
    	
    }

}
