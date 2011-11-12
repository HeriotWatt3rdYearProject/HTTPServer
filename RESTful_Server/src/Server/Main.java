package Server;

import java.io.IOException;

import Tools.SendMail;

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
			SendMail sm = new SendMail(args[0],"API problem, exception caught but shutting down. Exception = "  + e.getMessage());
			e.printStackTrace();
		}
	
		
	}

}
