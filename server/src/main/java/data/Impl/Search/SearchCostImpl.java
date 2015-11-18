package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.CostPO;
import data.Service.Search.SearchCostService;

public class SearchCostImpl extends UnicastRemoteObject implements SearchCostService {

	public SearchCostImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<CostPO> searchCost(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
