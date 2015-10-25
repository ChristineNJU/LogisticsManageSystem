package dataservice.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.PO.TransferPO;

public interface SearchTransferService extends Remote{
	
	public ArrayList<TransferPO> searchTransfer(String DB_URL, ArrayList<String> requirement) throws RemoteException;

}
