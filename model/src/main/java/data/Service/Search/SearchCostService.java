package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.CostPO;

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public interface SearchCostService extends Remote {
	
	/**
	 * 从数据库中搜索CostPO
	 * 
	 * @param requirement 搜索要求
	 * @return CostPO的ArrayList 
	 * @exception RemoteException 如果RMI链接断开
	 */
	public ArrayList<CostPO> searchCost(ArrayList<String> requirement) throws RemoteException;
}
