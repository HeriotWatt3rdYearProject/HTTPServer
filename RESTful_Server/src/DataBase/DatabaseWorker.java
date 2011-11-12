package DataBase;

import DataStore.DataStore;

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
    	
    	while(ds.getRequest()!=null){
    		
    		//do database query
    		
    		
    		//then
    		//ds.putResponse(response);
    		
    	}
    	
    }

}
