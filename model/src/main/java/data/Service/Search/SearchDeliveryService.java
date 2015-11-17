package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.DeliveryPO;

public interface SearchDeliveryService extends Remote {	
	public ArrayList<DeliveryPO> searchDelivery(String DB_URL, 
						ArrayList<String> requirement) throws RemoteException;

}
