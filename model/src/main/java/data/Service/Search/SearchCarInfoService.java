package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.PO.CarInfoPO;

public interface SearchCarInfoService extends Remote{
	
	public ArrayList<CarInfoPO> searchCarInfo(String DB_URL, ArrayList<String> requirement) throws RemoteException;
	
}
