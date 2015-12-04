package businesslogic.Service.Repository;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import State.StorageArea;

public interface GetAmountService {
	
	public int getAmount(StorageArea area) throws RemoteException, MalformedURLException, NotBoundException;
}
