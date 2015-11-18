package data.Service.Update;

import java.rmi.Remote;
import java.rmi.RemoteException;

import PO.PO;
import State.UpdateState;

public interface UpdateService extends Remote{
	
	public UpdateState update(PO statistics, String field, String value) throws RemoteException;

}
