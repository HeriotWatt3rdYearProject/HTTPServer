package Server;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;


	public class DBconnectionHardCoded {


	        Connection con = null;
	        Statement st = null;
	        ResultSet rs = null;

	        String url = "jdbc:mysql://172.16.226.133:3306/testdb";
	        String user = "JavaApp";
	        String password = "JavaApp";

	        public DBconnectionHardCoded(){
	        
	        try {
	            con = DriverManager.getConnection(url, user, password);
	            st = con.createStatement();
	            rs = st.executeQuery("SELECT VERSION()");

	            if (rs.next()) {
	                System.out.println(rs.getString(1));
	            }

	        } catch (SQLException ex) {
	           System.out.println("issue connecting to DB");

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
	

