package test.Stub.data;

import java.rmi.RemoteException;

import PO.PO;
import State.UpdateState;
import data.Service.Update.UpdateService;

public class UpdateService_Stub implements UpdateService {
	
	@Override
	public UpdateState update(PO statistics) throws RemoteException {
		// TODO Auto-generated method stub
		return UpdateState.SUCCESS;
	}

}
