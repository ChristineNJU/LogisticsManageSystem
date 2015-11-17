package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.AccountPO;
import data.Service.Search.SearchAccountService;

public class SearchAccountImpl extends UnicastRemoteObject implements SearchAccountService {
	
	public SearchAccountImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<AccountPO> searchAccount(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
