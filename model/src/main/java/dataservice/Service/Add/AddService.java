package dataservice.Service.Add;

import java.rmi.Remote;
import java.rmi.RemoteException;

import businesslogic.PO.PO;
import dataservice.State.AddState;

public interface AddService extends Remote{
	
	public AddState add(PO statistics) throws RemoteException;

}
