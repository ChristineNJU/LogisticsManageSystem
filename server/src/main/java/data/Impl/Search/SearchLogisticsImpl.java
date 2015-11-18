package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.LogisticsInfoPO;
import data.Service.Search.SearchLogisticsService;

public class SearchLogisticsImpl extends UnicastRemoteObject implements SearchLogisticsService {

	public SearchLogisticsImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<LogisticsInfoPO> searchLogisticsInfo(
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
