package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.BalancePO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SearchBalanceService.
 *
 * @author 尹子越
 * @version 1.0.0
 */
public interface SearchBalanceService extends Remote{
	
	/**
	 * 从数据库中搜索BalancePO.
	 *
	 * @param DB_URL 表链接
	 * @param requirement 搜索要求
	 * @return BalancePO的ArrayList
	 * @exception RemoteException 如果RMI链接断开
	 */
	public ArrayList<BalancePO> searchBalannce(String DB_URL, ArrayList<String> requirement) throws RemoteException;

}
