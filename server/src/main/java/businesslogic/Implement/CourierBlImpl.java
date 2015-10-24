package businesslogic.Implement;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import businesslogic.Service.CourierBlService;
import businesslogic.State.LogisticsType;
import businesslogic.State.PackingCharge;
import dataservice.State.AddState;
import dataservice.State.UpdateState;

public class CourierBlImpl extends UnicastRemoteObject implements CourierBlService{
	public CourierBlImpl() throws RemoteException{
		super();
	}

	@Override
	public AddState addLogistics(VO logistics_info) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateState receiveConfirm(VO logistics_info, String field,
			String value) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getAmount(String starting, String destination,
			LogisticsType type, PackingCharge charge, double weight, double height)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<String> getCity() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
