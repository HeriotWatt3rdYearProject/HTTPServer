package DataBase;
	import java.sql.Connection;
import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
import java.sql.Statement;
import DataStore.DataStore;

//Test class to check connection to DB, runs simple query and throws exception.
//Needs a serious re-factor once finished and tested the current system

	/**
	 * @author  lewismclean
	 */
	public class DBconnectionHardCoded {

	        Connection con = null;

	        public DBconnectionHardCoded(){}
	        
	        public void openConnection() throws Exception{
	        	
	        //test class just now, needs to return connection back
	        

	        	      Class.forName("com.mysql.jdbc.Driver").newInstance();
	        	       con = DriverManager.getConnection("jdbc:mysql://172.16.54.129:3306",
	        	        "java", "java");

	        }
	        
	        public ResultSet executeQuery(String query) throws SQLException{
	        	
	        	   Statement s = con.createStatement ();
	        	   s.executeQuery (query);
	        	   return s.getResultSet ();
	        	
	        }

	        public boolean closeConnection(){
	            
	        	try {

	                if (!con.isClosed()) {
	                    con.close();
	                }

	            } catch (SQLException ex) {
	            	System.out.println("issue disconnecting to DB");
	            	return false;
	            }
	        	return true;
	        }
	        
	}
	

