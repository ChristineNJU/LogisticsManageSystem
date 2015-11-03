package data.Impl.Search;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.PO.StoragePO;
import data.Service.Search.SearchStorageService;

public class SearchStorageImpl implements SearchStorageService {

	@Override
	public ArrayList<StoragePO> searchStorage(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
