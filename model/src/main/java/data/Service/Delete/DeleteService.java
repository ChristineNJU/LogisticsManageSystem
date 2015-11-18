package data.Service.Delete;

import java.rmi.Remote;
import java.rmi.RemoteException;

import PO.PO;
import State.DeleteState;

public interface DeleteService extends Remote{
	
	public DeleteState delete(PO statistics) throws RemoteException;
	
}
