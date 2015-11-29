package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.EntruckingPO;

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public interface SearchEntruckingService extends Remote{
	
	/**
	 * 从数据库中搜索EntruckingPO
	 * 
	 * @param DB_URL 表链接
	 * @param requirement 搜索要求
	 * @return EntruckingPO的ArrayList 
	 * @exception RemoteException 如果RMI链接断开
	 */
	public ArrayList<EntruckingPO> searchEntrucking(String DB_URL, ArrayList<String> requirement) throws RemoteException;

}
