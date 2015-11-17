package test.Stub.data;

import java.rmi.RemoteException;

import PO.PO;
import data.Service.Delete.DeleteService;
import data.State.DeleteState;

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
