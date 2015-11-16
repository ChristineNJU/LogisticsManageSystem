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
	
	@Override
	public UpdateState updateDriver(DriverInfoVO driver, String field,
			String value) {
		// TODO Auto-generated method stub
		UpdateDriverImpl updateDriver=new UpdateDriverImpl();
		return updateDriver.updateDriver(driver, field, value);
	}
	
	@Override
	public UpdateState updateCar(CarInfoVO car, String field, String value) {
		// TODO Auto-generated method stub
		UpdateCarImpl updateCar=new UpdateCarImpl();
		return updateCar.updateCar(car, field, value);
	}
	
	@Override
	public ArrayList<DriverInfoVO> searchDriver(String id) {
		// TODO Auto-generated method stub
		SearchDriverImpl searchDriver=new SearchDriverImpl();
		return searchDriver.searchDriver(id);
	}
	
	@Override
	public ArrayList<CarInfoVO> searchCar(String id) {
		// TODO Auto-generated method stub
		SearchCarImpl searchCar=new SearchCarImpl();
		return searchCar.searchCar(id);
	}
	
	@Override
	public ArrayList<String> getNeedGathering() {
		// TODO Auto-generated method stub
		GetNeedGatheringImpl getNeedGathering=new GetNeedGatheringImpl();
		return getNeedGathering.getNeedGathering();
	}
	
	@Override
	public ArrayList<String> getNeedEntrucking() {
		// TODO Auto-generated method stub
		GetNeedEntruckingImpl getNeedEntrucking=new GetNeedEntruckingImpl();
		return getNeedEntrucking.getNeedEntrucking();
	}
	
	@Override
	public AddState gathering(GatheringVO gathering) {
		// TODO Auto-generated method stub
		GatheringImpl Gathering=new GatheringImpl();
		return Gathering.gathering(gathering);
	}
	
	@Override
	public AddState entrucking(EntruckingVO entrucking) {
		// TODO Auto-generated method stub
		EntruckingImpl Entrucking =new EntruckingImpl();
		return Entrucking.entrucking(entrucking);
	}
	
	@Override
	public DeleteState deleteCar(CarInfoVO car) {
		// TODO Auto-generated method stub
		DeleteCarImpl deleteCar=new DeleteCarImpl();
		return deleteCar.deleteCar(car);
	}
	
	@Override
	public AddState arrival(ArrayList<ArrivalVO> arrival) {
		// TODO Auto-generated method stub
		ArrivalImpl Arrival=new ArrivalImpl();
		return Arrival.arrival(arrival);
	}
	
	@Override
	public AddState AddDriver(DriverInfoVO driver) {
		// TODO Auto-generated method stub
		AddDriverImpl addDriver=new AddDriverImpl();
		return addDriver.AddDriver(driver);
	}
	
	@Override
	public AddState addCar(CarInfoVO car) {
		// TODO Auto-generated method stub
		AddCarImpl addCar=new AddCarImpl();
		return addCar.addCar(car);
	}
	
	

}
