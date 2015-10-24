package businesslogic.Implement;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;




import businesslogic.Service.ArrivalVO;
import businesslogic.Service.BusinessLobbyBlService;
import businesslogic.Service.CarInfoVO;
import businesslogic.Service.DriverInfoVO;
import businesslogic.Service.EntruckingVO;
import businesslogic.Service.GatheringVO;
import dataservice.State.AddState;
import dataservice.State.DeleteState;
import dataservice.State.UpdateState;

public class BusinessLobbyBlImpl extends UnicastRemoteObject implements BusinessLobbyBlService{
	
	public BusinessLobbyBlImpl() throws RemoteException{
		super();
	}

	@Override
	public AddState arrival(ArrayList<ArrivalVO> arrival)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getNeedGathering() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddState gathering(GatheringVO gathering) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getNeedEntrucking() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddState entrucking(EntruckingVO entrucking) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CarInfoVO> searchCar(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateState updateCar(CarInfoVO car, String field, String value)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddState addCar(CarInfoVO car) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteState deleteCar(CarInfoVO car) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DriverInfoVO> searchDriver(String id)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateState updateDriver(DriverInfoVO driver, String field,
			String value) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddState AddDriver(DriverInfoVO driver) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
