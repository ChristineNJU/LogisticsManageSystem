package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.PO.DriverInfoPO;

public interface SearchDriverInfoService extends Remote{
	
	public ArrayList<DriverInfoPO> searchDriverInfo(String DB_URL, ArrayList<String> requirement) throws RemoteException;

}
