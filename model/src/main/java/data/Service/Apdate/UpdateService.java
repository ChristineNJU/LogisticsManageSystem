package data.Service.Apdate;

import java.rmi.Remote;
import java.rmi.RemoteException;

import businesslogic.PO.PO;
import data.State.UpdateState;

public interface UpdateService extends Remote{
	
	public UpdateState update(PO statistics, String field, String value) throws RemoteException;

}
