package businesslogic.Impl.Businesslobby;

import java.util.ArrayList;

import data.State.AddState;
import data.State.DeleteState;
import data.State.UpdateState;
import businesslogic.Service.BusinessLobby.*;
import businesslogic.VO.ArrivalVO;
import businesslogic.VO.CarInfoVO;
import businesslogic.VO.DriverInfoVO;
import businesslogic.VO.EntruckingVO;
import businesslogic.VO.GatheringVO;

public class BussinessLobbyController implements AddCarService,AddDriverService,ArrivalService,DeleteCarService,
												EntruckingService,GatheringService,GetNeedEntruckingService,
												GetNeedGatheringService,SearchCarService,SearchDriverService,
												UpdateCarService,UpdateDriverService{
	
	AddCarImpl addCar=new AddCarImpl();
	AddDriverImpl addDriver=new AddDriverImpl();
	ArrivalImpl Arrival=new ArrivalImpl();
	DeleteCarImpl deleteCar=new DeleteCarImpl();
	EntruckingImpl Entrucking =new EntruckingImpl();
	GatheringImpl Gathering=new GatheringImpl();
	GetNeedEntruckingImpl getNeedEntrucking=new GetNeedEntruckingImpl();
	GetNeedGatheringImpl getNeedGathering=new GetNeedGatheringImpl();
	SearchCarImpl searchCar=new SearchCarImpl();
	SearchDriverImpl searchDriver=new SearchDriverImpl();
	UpdateCarImpl updateCar=new UpdateCarImpl();
	UpdateDriverImpl updateDriver=new UpdateDriverImpl();
	
	@Override
	public UpdateState updateDriver(DriverInfoVO driver, String field,
			String value) {
		// TODO Auto-generated method stub
		return updateDriver.updateDriver(driver, field, value);
	}
	
	@Override
	public UpdateState updateCar(CarInfoVO car, String field, String value) {
		// TODO Auto-generated method stub
		return updateCar.updateCar(car, field, value);
	}
	
	@Override
	public ArrayList<DriverInfoVO> searchDriver(String id) {
		// TODO Auto-generated method stub
		return searchDriver.searchDriver(id);
	}
	
	@Override
	public ArrayList<CarInfoVO> searchCar(String id) {
		// TODO Auto-generated method stub
		return searchCar.searchCar(id);
	}
	
	@Override
	public ArrayList<String> getNeedGathering() {
		// TODO Auto-generated method stub
		return getNeedGathering.getNeedGathering();
	}
	
	@Override
	public ArrayList<String> getNeedEntrucking() {
		// TODO Auto-generated method stub
		return getNeedEntrucking.getNeedEntrucking();
	}
	
	@Override
	public AddState gathering(GatheringVO gathering) {
		// TODO Auto-generated method stub
		return Gathering.gathering(gathering);
	}
	
	@Override
	public AddState entrucking(EntruckingVO entrucking) {
		// TODO Auto-generated method stub
		return Entrucking.entrucking(entrucking);
	}
	
	@Override
	public DeleteState deleteCar(CarInfoVO car) {
		// TODO Auto-generated method stub
		return deleteCar.deleteCar(car);
	}
	
	@Override
	public AddState arrival(ArrayList<ArrivalVO> arrival) {
		// TODO Auto-generated method stub
		return Arrival.arrival(arrival);
	}
	
	@Override
	public AddState AddDriver(DriverInfoVO driver) {
		// TODO Auto-generated method stub
		return addDriver.AddDriver(driver);
	}
	
	@Override
	public AddState addCar(CarInfoVO car) {
		// TODO Auto-generated method stub
		return addCar.addCar(car);
	}
	
	

}
