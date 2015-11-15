package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import businesslogic.PO.UserPO;
import data.Service.Search.SearchUserService;

public class SearchUserImpl extends UnicastRemoteObject implements SearchUserService {

	public SearchUserImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<UserPO> searchUser(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
