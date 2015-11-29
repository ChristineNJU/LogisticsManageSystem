package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.TransferPO;

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public interface SearchTransferService extends Remote{
	
	/**
	 * 从数据库中搜索TransferPO
	 * 
	 * @param DB_URL 表链接
	 * @param requirement 搜索要求
	 * @return TransferPO的ArrayList 
	 * @throws RemoteException 如果RMI链接断开
	 */
	public ArrayList<TransferPO> searchTransfer(String DB_URL, ArrayList<String> requirement) throws RemoteException;

}
