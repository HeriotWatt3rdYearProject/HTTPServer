package DataStore;

import java.util.*;
import java.util.concurrent.*;

//Holds the queues for communication between threads, need to write classes to monitor the size
//of the queues to ensure timely response. Might be an Idea to create a cache too.
//!! NEEDS TESTED !!

/**
 * @author  lewismclean
 */
public class DataStore  {

	private Queue requestQueue = new ConcurrentLinkedQueue();

	private Queue responseQueue = new ConcurrentLinkedQueue();

	private boolean available = false;

	private long threadNumber = 0;

	public DataStore() {
	}


	public synchronized void putRequest(Request request) {
		requestQueue.add(request);
		//notifyAll();
	}
	

	public synchronized void putResponse(Response response) {
		responseQueue.add(response);
		//notify();
	}


	public synchronized Request getRequest() {
		//notifyAll();
		
		if (!requestQueue.isEmpty()) {
			
			return (Request) requestQueue.poll();
			
		}
		return null;
	}
	


	public synchronized Response getResponse() {
		//notifyAll();
		
		if (!responseQueue.isEmpty()) {
			
			return (Response) responseQueue.poll();
			
		}
		return null;
	}
	

	
	public synchronized long peekResponse() {
	
		//notifyAll();
		if(!responseQueue.isEmpty()){
		return (long) ((Response) responseQueue.peek()).getOwnerThread();
		}
		else{return -1;}
	}

	public synchronized long getThreadNumber(){
		//notifyAll();
		threadNumber++;
		if(threadNumber>10000)threadNumber=0;
		return threadNumber;
		
	}
	
	
}