package data.Impl.Search;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.PO.StockTakingPO;
import data.Service.Search.SearchStockTakingService;

public class SearchStockTakingImpl implements SearchStockTakingService {

	@Override
	public ArrayList<StockTakingPO> searchStockTaking(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
