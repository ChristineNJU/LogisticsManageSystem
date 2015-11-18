package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.DistancePO;

public interface SearchDistanceService extends Remote{
	
	public ArrayList<DistancePO> searchDistance(ArrayList<String> requirement) throws RemoteException;
	
}
