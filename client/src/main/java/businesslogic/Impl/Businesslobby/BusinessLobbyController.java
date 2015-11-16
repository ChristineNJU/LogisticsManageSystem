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

public class BusinessLobbyController implements AddCarService,AddDriverService,ArrivalService,DeleteCarService,
												DeleteDriverService,EntruckingService,GatheringService,GetNeedEntruckingService,
												GetNeedGatheringService,SearchCarService,SearchDriverService,
												UpdateCarService,UpdateDriverService{
	
	@Override
	public UpdateState updateDriver(DriverInfoVO driver, String field,
			String value) {
		// TODO Auto-generated method stub
		DriverMgt updateDriver=new DriverMgt();
		return updateDriver.updateDriver(driver, field, value);
	}
	
	@Override
	public UpdateState updateCar(CarInfoVO car, String field, String value) {
		// TODO Auto-generated method stub
		CarMgt updateCar=new CarMgt();
		return updateCar.updateCar(car, field, value);
	}
	
	@Override
	public ArrayList<DriverInfoVO> searchDriver(String id) {
		// TODO Auto-generated method stub
		DriverMgt searchDriver=new DriverMgt();
		return searchDriver.searchDriver(id);
	}
	
	@Override
	public ArrayList<CarInfoVO> searchCar(String id) {
		// TODO Auto-generated method stub
		CarMgt searchCar=new CarMgt();
		return searchCar.searchCar(id);
	}
	
	@Override
	public ArrayList<GatheringVO> getNeedGathering() {
		// TODO Auto-generated method stub
		GetNeedGatheringImpl getNeedGathering=new GetNeedGatheringImpl();
		return getNeedGathering.getNeedGathering();
	}
	
	@Override
	public ArrayList<EntruckingVO> getNeedEntrucking() {
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
		CarMgt deleteCar=new CarMgt();
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
		DriverMgt addDriver=new DriverMgt();
		return addDriver.AddDriver(driver);
	}
	
	@Override
	public AddState addCar(CarInfoVO car) {
		// TODO Auto-generated method stub
		CarMgt addCar=new CarMgt();
		return addCar.addCar(car);
	}

	@Override
	public DeleteState deleteDriver(DriverInfoVO driver) {
		// TODO Auto-generated method stub
		DriverMgt deleteDriver=new DriverMgt();
		return deleteDriver.deleteDriver(driver);
	}
	
	

}
