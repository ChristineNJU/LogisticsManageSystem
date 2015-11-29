package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.DeliveryPO;

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public interface SearchDeliveryService extends Remote {	
	
	/**
	 * 从数据库中搜索DeliveryPO
	 * 
	 * @param DB_URL 表链接
	 * @param requirement 搜索要求
	 * @return DeliveryPO的ArrayList 
	 * @throws RemoteException 如果RMI链接断开
	 */
	public ArrayList<DeliveryPO> searchDelivery(String DB_URL, 
						ArrayList<String> requirement) throws RemoteException;

}
