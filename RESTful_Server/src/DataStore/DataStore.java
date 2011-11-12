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
	/**
	 * @uml.property  name="requestQueue"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="DataStore.Request"
	 */
	private Queue requestQueue = new ConcurrentLinkedQueue();
	/**
	 * @uml.property  name="responseQueue"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="DataStore.Response"
	 */
	private Queue responseQueue = new ConcurrentLinkedQueue();
	/**
	 * @uml.property  name="available"
	 */
	private boolean available = false;
	/**
	 * @uml.property  name="threadNumber"
	 */
	private long threadNumber = 0;

	public DataStore() {
	}


	public synchronized void putRequest(Request request) {
		requestQueue.add(request);
		notifyAll();
	}
	

	public synchronized void putResponse(Response response) {
		responseQueue.add(response);
		notifyAll();
	}


	public synchronized Request getRequest() {
		notifyAll();
		
		if (!requestQueue.isEmpty()) {
			
			return (Request) requestQueue.poll();
			
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see DataStore.DataStoreInterface#getResponse()
	 */

	public synchronized Response getResponse() {
		notifyAll();
		
		if (!responseQueue.isEmpty()) {
			
			return (Response) responseQueue.poll();
			
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see DataStore.DataStoreInterface#peekResponse()
	 */
	
	public synchronized long peekResponse() {
		

		notifyAll();
		if(!responseQueue.isEmpty()){
		return (long) ((Response) responseQueue.peek()).getOwnerThread();
		}
		else{return -1;}
	}
	
	/* (non-Javadoc)
	 * @see DataStore.DataStoreInterface#getThreadNumber()
	 */
	public synchronized long getThreadNumber(){
		notifyAll();
		threadNumber++;
		return threadNumber;
		
	}
	
	
}