package data.Service.Update;

import java.rmi.Remote;
import java.rmi.RemoteException;

import PO.PO;
import State.UpdateState;

/**
*
* @author 尹子越
* @version 1.0.0
*/
public interface UpdateService extends Remote{
	
	/**
	 * 从数据库中更新数据
	 * 
	 * @param statistics
	 * @return 更新状态
	 * @exception RemoteException 如果RMI链接断开
	 */
	public UpdateState update(PO statistics) throws RemoteException;

}
