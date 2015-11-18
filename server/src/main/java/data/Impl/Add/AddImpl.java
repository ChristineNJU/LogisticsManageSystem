package data.Impl.Add;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import PO.PO;
import State.AddState;
import data.Service.Add.AddService;

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
