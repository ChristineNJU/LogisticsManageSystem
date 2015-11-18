package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.EntruckingPO;

public interface SearchEntruckingService extends Remote{
	
	public ArrayList<EntruckingPO> searchEntrucking(String DB_URL, ArrayList<String> requirement) throws RemoteException;

}
