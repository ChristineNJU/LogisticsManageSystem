package data.Service.Sundry;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.WareHousePO;
import State.StorageArea;

public interface WareHouseService extends Remote {
	
	public int getAmount(String DB_URL, StorageArea area) throws RemoteException;
	
	public ArrayList<WareHousePO> searchWareHouse(String DB_URL) throws RemoteException;
}
