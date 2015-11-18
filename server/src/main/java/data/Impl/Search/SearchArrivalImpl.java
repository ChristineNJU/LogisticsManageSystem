package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.ArrivalPO;
import data.Service.Search.SearchArrivalService;

public class SearchArrivalImpl extends UnicastRemoteObject implements SearchArrivalService {

	public SearchArrivalImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<ArrivalPO> searchArrival(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
