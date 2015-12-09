package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.PeriodPO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SearchPeriodService.
 *
 * @author 尹子越
 * @version 1.0.0
 */
public interface SearchPeriodService extends Remote {
	
	/**
	 * 从数据库中搜索PeriodPO.
	 *
	 * @return Period
	 * @exception RemoteException 如果RMI链接断开
	 */
	public PeriodPO searchPeriod() throws RemoteException;
}
