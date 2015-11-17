package test.Stub.data;

import java.rmi.RemoteException;

import PO.PO;
import data.Service.Update.UpdateService;
import data.State.UpdateState;

public class UpdateService_Stub implements UpdateService {
	
	/*
	 * 更新条目
	 * 返回UpdateState
	 * */
	public UpdateState update(PO statistics, String field, String value)
			throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Data_Stub "+"更新成功！");
		return UpdateState.SUCCESS;
	}

}
