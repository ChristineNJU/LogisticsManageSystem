package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.CarInfoPO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SearchCarInfoService.
 *
 * @author 尹子越
 * @version 1.0.0
 */
public interface SearchCarInfoService extends Remote{
	
	/**
	 * 从数据库中搜索CarInfoPO.
	 *
	 * @param DB_URL 表链接
	 * @param requirement 搜索要求
	 * @return CarInfoPO的ArrayList
	 * @exception RemoteException 如果RMI链接断开
	 */
	public ArrayList<CarInfoPO> searchCarInfo(String DB_URL, ArrayList<String> requirement) throws RemoteException;
	
}
