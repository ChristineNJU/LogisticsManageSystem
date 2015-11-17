package data.Impl.Delete;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import PO.PO;
import data.Service.Delete.DeleteService;
import data.State.DeleteState;

public class DeleteImpl extends UnicastRemoteObject implements DeleteService {

	public DeleteImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public DeleteState delete(PO statistics) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
