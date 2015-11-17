package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.GatheringPO;

public interface SearchGatheringService extends Remote{
	
	public ArrayList<GatheringPO> searchGathering(String DB_URL, ArrayList<String> requirement) throws RemoteException;

}
