package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.StoragePO;
import data.Service.Search.SearchStorageService;

public class SearchStorageImpl extends UnicastRemoteObject implements SearchStorageService {

	public SearchStorageImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<StoragePO> searchStorage(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
