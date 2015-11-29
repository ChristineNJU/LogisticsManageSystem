package data.Service.Sundry;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.WareHousePO;
import State.StorageArea;

/**
*
* @author 尹子越
* @version 1.0.0
*/
public interface WareHouseService extends Remote {
	
	/**
	 * 从数据库中获取仓库当前容量
	 * 
	 * @param DB_URL 数据库链接
	 * @param area 仓库区域
	 * @return 仓库当前容量
	 * @exception RemoteException 如果RMI链接断开
	 */
	public int getAmount(String DB_URL, StorageArea area) throws RemoteException;
	
	/**
	 * 从数据库中搜索WareHousePO
	 * 
	 * @param DB_URL 数据库链接
	 * @return WareHousePO的ArrayList
	 * @exception RemoteException 如果RMI链接断开
	 */
	public ArrayList<WareHousePO> searchWareHouse(String DB_URL) throws RemoteException;
}
