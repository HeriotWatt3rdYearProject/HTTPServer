package DataBase;

import java.sql.ResultSet;
import java.util.Random;

import com.mysql.jdbc.Connection;

import DataStore.DataStore;
import DataStore.Request;
import DataStore.Response;


public class DatabaseWorker extends Thread {

	private DataStore ds;
	private Connection conn;
	private Request req;
	
	public DatabaseWorker(DataStore ds, Request req, Connection conn){
		
		this.conn = conn;
		this.req = req;
		this.ds = ds;
		
		
	}
	
	
	public void run(){
		
		
		//simulate the SQL running at different speeds
		Random rand = new Random();
		long owner = req.getRequestNumber();
		
		//System.out.println("got request from httpHandler  = " + owner +"  "+this.getId());
		
//		try {
//			//Thread.sleep(rand.nextInt(5000));
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ResultSet rs = null;

		Response resp = new Response(rs, owner);
		ds.putResponse(resp);
		//System.out.println("put response from dbworker  = " + owner +"  "+this.getId());
	
		this.stop();
	}
	
}
