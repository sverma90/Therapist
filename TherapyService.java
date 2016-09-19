import java.rmi.Remote;


public interface TherapyService extends Remote	//#1 for RMI 
{
	public String getAnswer(String question) throws RemoteException; //#2  
	
}
