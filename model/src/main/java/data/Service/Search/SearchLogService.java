package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.LogPO;

public interface SearchLogService extends Remote {
	public ArrayList<LogPO> searchLog(ArrayList<String> requirement) throws RemoteException;
}
