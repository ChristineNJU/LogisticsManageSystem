package dataservice.updateService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import businesslogic.PO.PO;
import dataservice.State.UpdateState;

public interface UpdateService extends Remote{
	
	public UpdateState update(PO statistics, String field, String value) throws RemoteException;

}
