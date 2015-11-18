package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.DistancePO;
import data.Service.Search.SearchDistanceService;

public class SearchDistanceImpl extends UnicastRemoteObject implements SearchDistanceService {

	public SearchDistanceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<DistancePO> searchDistance(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
