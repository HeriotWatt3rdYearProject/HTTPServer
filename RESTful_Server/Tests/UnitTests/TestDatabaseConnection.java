package UnitTests;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;



import DataBase.DBconnectionHardCoded;

/**
 * @author  lewismclean
 */
public class TestDatabaseConnection {

	/**
	 * @uml.property  name="dBConn"
	 * @uml.associationEnd  
	 */
	DBconnectionHardCoded dBConn;
	
	@Test
	public void testDBconnection() {
		
		try{
		dBConn = new DBconnectionHardCoded();
		Connection temp =  dBConn.openConnection();
		}
		catch(Exception e){
			fail("Couldn't open the database connection");
		}
		
		try{
			dBConn.closeConnection();
		}
		catch(Exception e){
			fail("Couldn't close the connection");
		}
		
	}

}
