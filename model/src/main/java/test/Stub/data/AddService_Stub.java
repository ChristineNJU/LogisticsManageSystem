package test.Stub.data;

import java.rmi.RemoteException;

import PO.PO;
import State.AddState;
import data.Service.Add.AddService;

public class AddService_Stub implements AddService {

	/*
	 * 添加新条目
	 * 返回AddState
	 * */
	@Override
	public AddState add(PO statistics) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Data_Stub "+"添加成功！");
		return AddState.SUCCESS;
	}

}
