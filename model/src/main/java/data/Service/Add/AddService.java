package data.Service.Add;

import java.rmi.Remote;
import java.rmi.RemoteException;

import PO.PO;
import State.AddState;

/**
*
* @author 尹子越
* @version 1.0.0
*/
public interface AddService extends Remote{
	
	/**
	 * 向数据库中添加数据
	 * 
	 * @param statistics
	 * @return 添加状态
	 * @exception RemoteException 如果RMI链接断开
	 */
	public AddState add(PO statistics) throws RemoteException;

}
