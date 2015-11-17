package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.StockTakingPO;
import data.Service.Search.SearchStockTakingService;

public class SearchStockTakingImpl extends UnicastRemoteObject implements SearchStockTakingService {

	public SearchStockTakingImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<StockTakingPO> searchStockTaking(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
