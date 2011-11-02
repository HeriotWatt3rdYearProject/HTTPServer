package Tools;
import java.net.*;
import java.io.*;

public class URLFetcher {
	
    public URLFetcher(){} 
    
    
    //TO-DO
    // format output and http response
    public String fetch(URL url){

    	try{
       
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();
        
    	}
    	catch(Exception e){
    		System.out.println("failed to get webpage");
    	}
    }
}