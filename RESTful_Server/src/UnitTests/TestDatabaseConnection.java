package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import DataBase.DBconnectionHardCoded;

public class TestDatabaseConnection {

	DBconnectionHardCoded dBConn;
	
	@Test
	public void testDBconnection() {
		
		try{
		dBConn = new DBconnectionHardCoded();
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
