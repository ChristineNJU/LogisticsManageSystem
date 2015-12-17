package data.RMIHelper;

import java.rmi.Remote;
import java.rmi.RemoteException;

// TODO: Auto-generated Javadoc
/**
 * 检查服务器连接状态.
 *
 * @author 尹子越
 * @version 1.0.0
 */
public interface RMIConnectionService extends Remote {
	
	/**
	 * 连接状态.
	 *
	 * @return true, if is connected
	 * @throws RemoteException
	 */
	public boolean isConnected() throws RemoteException;
}
