package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.CostPO;

public interface SearchCostService extends Remote {
	public ArrayList<CostPO> searchCost(ArrayList<String> requirement) throws RemoteException;
}
