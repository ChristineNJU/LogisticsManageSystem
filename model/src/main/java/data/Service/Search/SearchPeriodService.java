package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.PeriodPO;

public interface SearchPeriodService extends Remote {
	public ArrayList<PeriodPO> searchPeriod(String DB_URL, ArrayList<String> requirement) throws RemoteException;
}
