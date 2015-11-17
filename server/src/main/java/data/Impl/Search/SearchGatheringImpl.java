package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.GatheringPO;
import data.Service.Search.SearchGatheringService;

public class SearchGatheringImpl extends UnicastRemoteObject implements SearchGatheringService {

	public SearchGatheringImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<GatheringPO> searchGathering(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
