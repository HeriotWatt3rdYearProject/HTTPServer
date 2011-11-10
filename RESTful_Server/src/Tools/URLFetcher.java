package Tools;
import java.net.*;
import java.io.*;

public class URLFetcher {
	
    public URLFetcher(){} 
    
    
    //TO-DO
    // format output and http response
    public String fetch(URL url){

    	StringBuilder stb = new StringBuilder();
    	
    	try{
       
        //URLConnection yc = url.openConnection();
        InputStream in  = url.openStream();
        DataInputStream dis = new DataInputStream(new BufferedInputStream(in));

        String inputLine;
        
        while ((inputLine = dis.readLine()) != null) 
        
        stb.append(inputLine+"\n");
        in.close();
        
    	}
    	catch(Exception e){
    		return null;
    	}
    		return(stb.toString());
    	
    }
}