package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.DistancePO;

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public interface SearchDistanceService extends Remote{
	
	/**
	 * 从数据库中搜索DistancePO
	 * 
	 * @param requirement 搜索要求
	 * @return DistancePO的ArrayList 
	 * @throws RemoteException 如果RMI链接断开
	 */
	public ArrayList<DistancePO> searchDistance(ArrayList<String> requirement) throws RemoteException;
	
}
