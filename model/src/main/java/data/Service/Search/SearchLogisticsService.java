package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.LogisticsInfoPO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SearchLogisticsService.
 *
 * @author 尹子越
 * @version 1.0.0
 */
public interface SearchLogisticsService extends Remote{
	
	/**
	 * 从数据库中搜索LogisticsInfoPO.
	 *
	 * @param requirement 搜索要求
	 * @return LogisticsInfoPO的ArrayList
	 * @exception RemoteException 如果RMI链接断开
	 */
	public ArrayList<LogisticsInfoPO> searchLogisticsInfo(ArrayList<String> requirement) throws RemoteException;

}
