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


	        /**
			 * @uml.property  name="con"
			 */
	        Connection con = null;
	        /**
			 * @uml.property  name="st"
			 */
	        Statement st = null;
	        /**
			 * @uml.property  name="rs"
			 */
	        ResultSet rs = null;

	        // pass connection string via text file or XML config file
	        
	        /**
			 * @uml.property  name="url"
			 */
	        String url = "jdbc:mysql://******:3306/mysql";
	        /**
			 * @uml.property  name="user"
			 */
	        String user = "JavaApp";
	        /**
			 * @uml.property  name="password"
			 */
	        String password = "JavaApp";
	        
	      

	        public DBconnectionHardCoded(){
	        	
	        //test class just now, needs to return connection back
	        
	        try {
	            con = DriverManager.getConnection(url, user, password);
	            st = con.createStatement();
	            rs = st.executeQuery("SELECT VERSION()");

	            if (rs.next()) {
	                System.out.println(rs.getString(1));
	            }

	        } catch (SQLException ex) {
	           System.out.println("issue connecting to DB - exception thrown at connection string");

	        }
	        }

	        public boolean closeConnection(){
	            
	        	try {
	                if (rs != null) {
	                    rs.close();
	                }
	                if (st != null) {
	                    st.close();
	                }
	                if (con != null) {
	                    con.close();
	                }

	            } catch (SQLException ex) {
	            	System.out.println("issue disconnecting to DB");
	            	return false;
	            }
	        	return true;
	        }
	        
	}
	

