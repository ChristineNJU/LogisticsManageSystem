package dataservice.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.PO.BalancePO;

public interface SearchBalanceService extends Remote{
	
	public ArrayList<BalancePO> searchBalannce(String DB_URL, ArrayList<String> requirement) throws RemoteException;

}
