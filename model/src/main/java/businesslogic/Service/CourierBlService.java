package businesslogic.Service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.State.LogisticsType;
import businesslogic.State.PackingCharge;
import dataservice.State.AddState;
import dataservice.State.UpdateState;

public interface CourierBlService extends Remote{
	
	public AddState addLogistics(VO logistics_info) throws RemoteException;
	
	public UpdateState receiveConfirm(VO logistics_info, String field, String value) throws RemoteException;
	
	public double getAmount(String starting, String destination, LogisticsType type, PackingCharge charge, double weight, double height) throws RemoteException;
    
    public ArrayList<String> getCity() throws RemoteException;
	
}
