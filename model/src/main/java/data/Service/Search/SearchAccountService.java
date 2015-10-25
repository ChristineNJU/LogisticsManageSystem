package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.PO.AccountPO;

public interface SearchAccountService extends Remote {
	public ArrayList<AccountPO> searchAccount(ArrayList<String> requirement) throws RemoteException;
}
