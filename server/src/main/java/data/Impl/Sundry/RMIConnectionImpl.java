package data.Impl.Sundry;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import data.RMIHelper.RMIConnectionService;

// TODO: Auto-generated Javadoc
/**
 * The Class RMIConnectionImpl.
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public class RMIConnectionImpl extends UnicastRemoteObject implements
		RMIConnectionService {

	/**
	 * Instantiates a new RMI connection impl.
	 *
	 * @throws RemoteException the remote exception
	 */
	public RMIConnectionImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see data.RMIHelper.RMIConnectionService#isConnected()
	 */
	@Override
	public boolean isConnected() throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
