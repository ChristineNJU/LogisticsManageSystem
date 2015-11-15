package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import businesslogic.PO.PeriodPO;
import data.Service.Search.SearchPeriodService;

public class SearchPeriodImpl extends UnicastRemoteObject implements SearchPeriodService {

	public SearchPeriodImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<PeriodPO> searchPeriod(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
