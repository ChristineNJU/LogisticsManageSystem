package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.StockTakingPO;

public interface SearchStockTakingService extends Remote{
	
	public ArrayList<StockTakingPO> searchStockTaking(String DB_URL, ArrayList<String> requirement) throws RemoteException;

}
