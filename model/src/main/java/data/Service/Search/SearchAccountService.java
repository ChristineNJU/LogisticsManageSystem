package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.AccountPO;

/**
*
* @author 尹子越
* @version 1.0.0
*/
public interface SearchAccountService extends Remote {
	
	/**
	 * 从数据库中搜索AccountPO
	 * 
	 * @param requirement 搜索要求
	 * @return AccountPO的ArrayList
	 * @throws RemoteException 如果RMI链接断开
	 */
	public ArrayList<AccountPO> searchAccount(ArrayList<String> requirement) throws RemoteException;
}
