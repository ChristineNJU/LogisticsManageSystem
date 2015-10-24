package businesslogic.Service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.State.AddState;
import dataservice.State.DeleteState;
import dataservice.State.UpdateState;

public interface BusinessLobbyBlService extends Remote{
	
	public AddState arrival(ArrayList<ArrivalVO> arrival) throws RemoteException;
	
	public ArrayList<String> getNeedGathering() throws RemoteException;
	
	public AddState gathering(GatheringVO gathering) throws RemoteException;
	
	public ArrayList<String> getNeedEntrucking() throws RemoteException;
	
	public AddState entrucking(EntruckingVO entrucking) throws RemoteException;
	
	public ArrayList<CarInfoVO> searchCar(String id) throws RemoteException;
	
	public UpdateState updateCar(CarInfoVO car, String field, String value) throws RemoteException;
	
	public AddState addCar(CarInfoVO car) throws RemoteException;
	
	public DeleteState deleteCar(CarInfoVO car) throws RemoteException;
	
	public ArrayList<DriverInfoVO> searchDriver(String id) throws RemoteException;
	
	public UpdateState updateDriver(DriverInfoVO driver, String field, String value) throws RemoteException;
	
	public AddState AddDriver(DriverInfoVO driver) throws RemoteException

}
