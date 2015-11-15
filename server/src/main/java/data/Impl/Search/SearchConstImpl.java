package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import businesslogic.PO.ConstPO;
import data.Service.Search.SearchConstService;

public class SearchConstImpl extends UnicastRemoteObject implements SearchConstService {

	public SearchConstImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<ConstPO> searchConst(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
