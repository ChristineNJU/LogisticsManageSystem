package businesslogic.Service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.State.AddState;

public interface MediumCenterBlService extends Remote{
	
	public AddState arrival(ArrayList<ArrivalVO> arrival) throws RemoteException;
	
	public ArrayList<String> getNeedEntrucking() throws RemoteException;
	
	public AddState entrucking(EntruckingVO entrucking) throws RemoteException;
	
	public ArrayList<String> getNeedTransfer() throws RemoteException;
	
	public AddState transfer(TransferVO transfer) throws RemoteException;

}
