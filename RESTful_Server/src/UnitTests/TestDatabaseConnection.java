package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Server.DBconnectionHardCoded;

public class TestDatabaseConnection {

	DBconnectionHardCoded dBConn;
	
	@Test
	public void test() {
		
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
