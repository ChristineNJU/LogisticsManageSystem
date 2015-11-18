package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.RemovalPO;
import data.Service.Search.SearchRemovalService;

public class SearchRemovalImpl extends UnicastRemoteObject implements SearchRemovalService {

	public SearchRemovalImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<RemovalPO> searchRemoval(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
