package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.LogPO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SearchLogService.
 *
 * @author 尹子越
 * @version 1.0.0
 */
public interface SearchLogService extends Remote {
	
	/**
	 * 从数据库中搜索LogPO.
	 *
	 * @param requirement 搜索要求
	 * @return LogPO的ArrayList
	 * @exception RemoteException 如果RMI链接断开
	 */
	public ArrayList<LogPO> searchLog(ArrayList<String> requirement) throws RemoteException;
}
