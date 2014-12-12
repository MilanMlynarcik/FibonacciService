package ie.gmit;
import java.rmi.*;

public interface RemoteFibonacciService extends Remote {
	
	public String getFibonacci(int max) throws RemoteException;
}
