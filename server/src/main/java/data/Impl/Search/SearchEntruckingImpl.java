package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.EntruckingPO;
import data.Service.Search.SearchEntruckingService;

public class SearchEntruckingImpl extends UnicastRemoteObject implements SearchEntruckingService {

	public SearchEntruckingImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<EntruckingPO> searchEntrucking(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
