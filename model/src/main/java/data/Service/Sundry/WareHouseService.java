package data.Service.Sundry;

import java.rmi.Remote;
import java.rmi.RemoteException;

import State.StorageArea;

public interface WareHouseService extends Remote {
	
	public int getAmount(String DB_URL, StorageArea area) throws RemoteException;
}
