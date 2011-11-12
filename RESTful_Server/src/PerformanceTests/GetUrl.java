package PerformanceTests;


import java.util.Random;


public class GetUrl {
    public static void main(String[] args) throws Exception {
    	
    	Random rand = new Random();
    	
    	for(int i=0;i<300;i++){
    		
    		GetUrlWorker temp = new GetUrlWorker();
    		temp.start();
    		//Thread.sleep(rand.nextInt(1000));
    		
    	}
    	
    }
}