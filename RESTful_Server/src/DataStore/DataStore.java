package DataStore;

import java.util.*;
import java.util.concurrent.*;

public class DataStore {
	private Queue requestQueue = new ConcurrentLinkedQueue();
	private Queue responseQueue = new ConcurrentLinkedQueue();
	private boolean available = false;
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
	
	public synchronized Request getResponse() {
		notifyAll();
		
		if (!responseQueue.isEmpty()) {
			
			return (Request) responseQueue.poll();
			
		}
		return null;
	}
	
	public synchronized int peekResponse() {
		notifyAll();
		
		if (!responseQueue.isEmpty()) {
			
			return (int) ((Response) responseQueue.peek()).getOwnerThread();
			
		}
		return (Integer) null;
	}
	
	public synchronized long getThreadNumber(){
		notifyAll();
		threadNumber++;
		return threadNumber;
		
	}
	
	
}