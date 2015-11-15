package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import businesslogic.PO.LogPO;
import data.Service.Search.SearchLogService;

public class SearchLogImpl extends UnicastRemoteObject implements SearchLogService {

	public SearchLogImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<LogPO> searchLog(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
