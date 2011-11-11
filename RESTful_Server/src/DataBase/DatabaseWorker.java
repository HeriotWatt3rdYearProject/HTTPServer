package DataBase;

import DataStore.DataStore;

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
