package dataservice.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.PO.RemovalPO;

public interface SearchRemovalService extends Remote{
	
	public ArrayList<RemovalPO> searchRemoval(String DB_URL, ArrayList<String> requirement) throws RemoteException;

}
