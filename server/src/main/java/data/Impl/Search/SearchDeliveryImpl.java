package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.DeliveryPO;
import data.Service.Search.SearchDeliveryService;

public class SearchDeliveryImpl extends UnicastRemoteObject implements SearchDeliveryService {

	public SearchDeliveryImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<DeliveryPO> searchDelivery(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
