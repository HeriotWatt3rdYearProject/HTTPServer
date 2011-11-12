package DataStore;

import java.util.HashSet;

//Wrapper class for the request, inner class to handle the K,V pairs
//Look at using hash map and remove the set although need to ensure no duplication from parsed API request.

/**
 * @author lewismclean
 */
public class Request  {

	private long requestNumber;

	private HashSet<Variable> request;

	public Request(long requestNumber) {
		request = new HashSet();
		this.requestNumber = requestNumber;
	}


	public void addVariable(String key, String value) {

		Variable temp = new Variable(key, value);
		request.add(temp);

	}

	public long getRequestNumber() {

		return requestNumber;

	}


	public boolean isEmpty() {

		return request.isEmpty();

	}

}
