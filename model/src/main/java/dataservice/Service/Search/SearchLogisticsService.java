package dataservice.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface SearchLogisticsService extends Remote{
	
	public ArrayList<LogisticsInfoPO> searchLogisticsInfo(ArrayList<String> requirement) throws RemoteException;

}
