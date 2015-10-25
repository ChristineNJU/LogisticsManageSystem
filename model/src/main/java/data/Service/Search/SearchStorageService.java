package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.PO.StoragePO;

public interface SearchStorageService extends Remote{
	
	public ArrayList<StoragePO> searchStorage(String DB_URL, ArrayList<String> requirement) throws RemoteException;

}
