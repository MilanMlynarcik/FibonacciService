package ie.gmit;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class FibService {
	
	private static LinkedList<FibonacciRequest> inQueue = new LinkedList<FibonacciRequest>();
	
	private static Map<Integer,String> outQueue = new HashMap<Integer,String>();
	
	
	public static LinkedList<FibonacciRequest> getInQueue() {
		return inQueue;
	}

	public static void setInQueue(LinkedList<FibonacciRequest> inQueue) {
		FibService.inQueue = inQueue;
	}

	public static Map<Integer, String> getOutQueue() {
		return outQueue;
	}

	public void setOutQueue(Map<Integer, String> outQueue) {
		FibService.outQueue = outQueue;
	}

	public static int add(int max){
		// generate a random number
		int random = (int)(Math.random() * (100000 - 5) + 5);
		
		inQueue.addLast(new FibonacciRequest(random, max));
		
		return random;
	}
	
	public String getRequest(int jobNumber) {
		if (outQueue.containsKey(jobNumber)) {
			String result = outQueue.get(jobNumber);
			outQueue.remove(jobNumber);
			return result;
		}
		else {
			return null;
		}
	}
}
