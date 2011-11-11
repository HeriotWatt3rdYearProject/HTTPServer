package DataBase;

import DataStore.DataStore;

//Class to handle the Database side of the API, threaded to allow it to run independently of the http server
//Uses the final syncronised Datastore class

public class DatabaseWorker extends Thread {
	
	DataStore ds;
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
