package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.GatheringPO;

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public interface SearchGatheringService extends Remote{
	
	/**
	 * 从数据库中搜索GatheringPO
	 * 
	 * @param DB_URL 表链接
	 * @param requirement 搜索要求
	 * @return GatheringPO的ArrayList 
	 * @throws RemoteException 如果RMI链接断开
	 */
	public ArrayList<GatheringPO> searchGathering(String DB_URL, ArrayList<String> requirement) throws RemoteException;

}
