package DataStore;

import java.sql.ResultSet;

//wrapper class for the response, may look at formating the result before sending back to HTTP
//perhaps write a formatting tool class

/**
 * @author  lewismclean
 */
public class Response {

	/**
	 * @uml.property  name="rs"
	 */
	private ResultSet rs;
	/**
	 * @uml.property  name="threadNumber"
	 */
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
