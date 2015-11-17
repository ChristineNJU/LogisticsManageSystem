package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.BalancePO;
import data.Service.Search.SearchBalanceService;

public class SearchBalanceImpl extends UnicastRemoteObject implements SearchBalanceService {

	public SearchBalanceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<BalancePO> searchBalannce(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
