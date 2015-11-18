package test.Stub.data;

import java.rmi.RemoteException;

import PO.PO;
import State.DeleteState;
import data.Service.Delete.DeleteService;

public class DeleteService_Stub implements DeleteService {

	/*
	 * 删除条目
	 * 返回DeleteState
	 * */
	@Override
	public DeleteState delete(PO statistics) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Data_Stub "+"删除成功！");
		return DeleteState.SUCCESS;
	}
	
	
}
