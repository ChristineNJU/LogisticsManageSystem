package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.TransferPO;
import data.Service.Search.SearchTransferService;

public class SearchTransferImpl extends UnicastRemoteObject implements SearchTransferService {

	public SearchTransferImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<TransferPO> searchTransfer(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
