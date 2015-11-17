package data.Impl.Add;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import PO.PO;
import data.Service.Add.AddService;
import data.State.AddState;

public class AddImpl extends UnicastRemoteObject implements AddService {

	public AddImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public AddState add(PO statistics) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
