package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.CarInfoPO;
import data.Service.Search.SearchCarInfoService;

public class SearchCarInfoImpl extends UnicastRemoteObject implements SearchCarInfoService {

	public SearchCarInfoImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<CarInfoPO> searchCarInfo(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
