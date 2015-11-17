package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.DriverInfoPO;
import data.Service.Search.SearchDriverInfoService;

public class SearchDriverInfoImpl extends UnicastRemoteObject implements SearchDriverInfoService {

	public SearchDriverInfoImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<DriverInfoPO> searchDriverInfo(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
