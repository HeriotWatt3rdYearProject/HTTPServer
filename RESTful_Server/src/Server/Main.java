package Server;

import java.io.IOException;

//needs no introduction...

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		HttpRESTfulServer boss;
		try {
			boss = new HttpRESTfulServer();
			boss.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
