package Tools;
import java.io.InputStream;
import java.util.Scanner;


//NOT USED YET -- DEPRECIATED --
public class InputStreamToString {
	
	public InputStreamToString(){}

	public String convertStreamToString(InputStream is) { 
	    return new Scanner(is).useDelimiter("\\A").next();
	}
	
}
