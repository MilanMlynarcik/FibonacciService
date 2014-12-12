package ie.gmit;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.*;

public class TimerClass {

	private static TimerClass instance = null;

	protected TimerClass() {

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				try {
					getSequence();
				} catch (RemoteException | MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}, 0, 2000);
	}

	public static TimerClass getInstance() {
		if (instance == null) {
			instance = new TimerClass();
		}
		return instance;
	}


	public static String getSequence() throws RemoteException,
			MalformedURLException {

		String seq = null;
		if (FibService.getInQueue().isEmpty() != true) {
			FibonacciRequest fibRequest = FibService.getInQueue().get(0);
			int i = fibRequest.getMax();
		
			FibonacciClient fc = new FibonacciClient();
			try {
				seq=fc.callRMI(i);
			} catch (NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			FibService.getInQueue().remove(0);
			FibService.getOutQueue().put(fibRequest.getJobNumber(), seq);
		}
		
		return seq;

	}
}
