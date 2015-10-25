package test.Stub.data;

import java.rmi.RemoteException;

import businesslogic.PO.PO;
import data.Service.Add.AddService;
import data.State.AddState;

public class AddService_Stub implements AddService {

	/*
	 * 添加新条目
	 * 返回AddState
	 * */
	@Override
	public AddState add(PO statistics) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("添加成功！");
		return AddState.SUCCESS;
	}

}
