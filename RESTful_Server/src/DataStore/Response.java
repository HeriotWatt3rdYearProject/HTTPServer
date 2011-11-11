package DataStore;

import java.sql.ResultSet;

//wrapper class for the response, may look at formating the result before sending back to HTTP
//perhaps write a formatting tool class

public class Response {

	private ResultSet rs;
	private int threadNumber;
	
	public Response(ResultSet rs, int threadNumber) throws Exception{
		
		if(rs != null || rs.getFetchSize() == 0){
		
		this.rs = rs;
		this.threadNumber = threadNumber;
		}
		else {throw new Exception("result set is empty/null");}
	}
	
	public ResultSet getResultSet(){
		
		return rs;
		
	}
	
	public int getOwnerThread(){
		
		return threadNumber;
		
	}
	
}
