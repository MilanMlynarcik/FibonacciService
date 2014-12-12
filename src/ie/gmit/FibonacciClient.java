package ie.gmit;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.servlet.ServletContext;

public class FibonacciClient {
	
	private static String hostName;
	private static String rmi;
	private static String port;
	private static String objectname;

	

	public String callRMI(int max) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		//Ask the registry running on 10.2.2.65 and listening in port 1099 for the instannce of
		//the MessageService object that is bound to the RMI registry with the name howdayService.
		
		//"rmi://localhost:1099/howdayService"
		
		//String email= getServletContext().getInitParameter("AdministratorEmail");
		
		RemoteFibonacciService fibService = (RemoteFibonacciService) Naming.lookup(rmi+"://"+hostName+":"+port+"/"+objectname);
		
		//Make the remote method invocation. This results in the RemoteMessage object being transferred
		//to us over the network in serialized form. 
		String message = fibService.getFibonacci(max);
		
		return message;
	}
	public static String getHostName() {
		return hostName;
	}

	public static void setHostName(String hostName) {
		FibonacciClient.hostName = hostName;
	}

	public static String getRmi() {
		return rmi;
	}

	public static void setRmi(String rmi) {
		FibonacciClient.rmi = rmi;
	}

	public static String getPort() {
		return port;
	}

	public static void setPort(String port) {
		FibonacciClient.port = port;
	}

	public static String getObjectname() {
		return objectname;
	}

	public static void setObjectname(String objectname) {
		FibonacciClient.objectname = objectname;
	}

}
