package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.ArrivalPO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SearchArrivalService.
 *
 * @author 尹子越
 * @version 1.0.0
 */
public interface SearchArrivalService extends Remote {
	
	/**
	 * 从数据库中搜索ArrivalPO.
	 *
	 * @param DB_URL 表链接
	 * @param requirement 搜索要求
	 * @return ArrivalPO的ArrayList
	 * @exception RemoteException 如果RMI链接断开
	 */
	public ArrayList<ArrivalPO> searchArrival(String DB_URL, 
								ArrayList<String> requirement) throws RemoteException;
}
