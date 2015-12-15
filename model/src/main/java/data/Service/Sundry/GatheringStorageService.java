package data.Service.Sundry;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.GatheringStoragePO;
import State.AddState;
import State.DeleteState;

// TODO: Auto-generated Javadoc
/**
 * The Interface GatheringStorageService.
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public interface GatheringStorageService extends Remote {
	
	/**
	 * 获取需要建立收款单的快递
	 *
	 * @param DB_URL 数据库连接
	 * @return 所有需要建立收款单的数据
	 * @throws RemoteException the remote exception
	 */
	public ArrayList<GatheringStoragePO> getGatheringStorage(String DB_URL) throws RemoteException;
	
	/**
	 * 添加需要建立收款单的快递
	 *
	 * @param bar_code 快递编号
	 * @param amount 运费
	 * @param DB_URL 数据库连接
	 * @return 添加状态
	 * @throws RemoteException the remote exception
	 */
	public AddState addGatheringStorage(String bar_code, double amount, String DB_URL) throws RemoteException;
	
	/**
	 * 删除需要建立收款单的快递
	 *
	 * @param bar_code 快递编号
	 * @param DB_URL 数据库连接
	 * @return 删除状态
	 * @throws RemoteException the remote exception
	 */
	public DeleteState deleteGatheringStorage(String bar_code, String DB_URL) throws RemoteException;
	
}
