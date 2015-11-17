package data.Impl.Update;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import PO.PO;
import data.Service.Update.UpdateService;
import data.State.UpdateState;

public class UpdateImpl extends UnicastRemoteObject implements UpdateService {

	public UpdateImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public UpdateState update(PO statistics, String field, String value)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
