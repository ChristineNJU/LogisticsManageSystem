package businesslogic.Service.Repository;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import State.StorageArea;

// TODO: Auto-generated Javadoc
/**
 * The Interface GetAmountService.
 */
public interface GetAmountService {
	
	/**
	 * Gets the amount.
	 *
	 * @param area the area
	 * @return the amount
	 * @throws RemoteException the remote exception
	 * @throws MalformedURLException the malformed url exception
	 * @throws NotBoundException the not bound exception
	 */
	public int getAmount(StorageArea area) throws RemoteException, MalformedURLException, NotBoundException;
}
