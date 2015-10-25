package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.PO.ArrivalPO;

public interface SearchArrivalService extends Remote {
	public ArrayList<ArrivalPO> searchArrival(String DB_URL, 
								ArrayList<String> requirement) throws RemoteException;
}
