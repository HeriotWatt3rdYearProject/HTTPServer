package PerformanceTests;
import java.net.*;
import java.io.*;

public class GetUrlWorker extends Thread {
	
	public GetUrlWorker() {}
	
	public void run(){
		
		try{
		
	        URL yahoo = new URL("http://127.0.0.1:8080/?test=foo&bar=test");
	        URLConnection yc = yahoo.openConnection();
	        BufferedReader in = new BufferedReader(
	                                new InputStreamReader(
	                                yc.getInputStream()));
	       
	        in.close();
		}
		catch(Exception e){}
	    }
	}
	
