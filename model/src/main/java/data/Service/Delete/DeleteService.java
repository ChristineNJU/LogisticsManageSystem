package data.Service.Delete;

import java.rmi.Remote;
import java.rmi.RemoteException;

import PO.PO;
import State.DeleteState;


/**
 * The Interface DeleteService.
 *
 * @author 尹子越
 * @version 1.0.0
 */
public interface DeleteService extends Remote{
	
	/**
	 * 从数据库中删除数据.
	 *
	 * @param statistics the statistics
	 * @return 删除状态
	 * @exception RemoteException 如果RMI链接断开
	 */
	public DeleteState delete(PO statistics) throws RemoteException;
	
}
