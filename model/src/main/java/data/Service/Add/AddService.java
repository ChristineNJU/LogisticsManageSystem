package data.Service.Add;

import java.rmi.Remote;
import java.rmi.RemoteException;

import PO.PO;
import data.State.AddState;

public interface AddService extends Remote{
	
	public AddState add(PO statistics) throws RemoteException;

}
