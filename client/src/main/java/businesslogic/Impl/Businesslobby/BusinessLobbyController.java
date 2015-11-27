package businesslogic.Impl.Businesslobby;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.ArrivalVO;
import VO.CarInfoVO;
import VO.DeliveryVO;
import VO.DriverInfoVO;
import VO.EntruckingVO;
import VO.GatheringVO;
import businesslogic.Service.BusinessLobby.BsLbService;

public class BusinessLobbyController implements BsLbService{
	
	@Override
	public UpdateState updateDriver(DriverInfoVO driver) {
		// TODO Auto-generated method stub
		DriverMgt updateDriver=new DriverMgt();
		return updateDriver.updateDriver(driver);
	}
	
	@Override
	public UpdateState updateCar(CarInfoVO car) {
		// TODO Auto-generated method stub
		CarMgt updateCar=new CarMgt();
		return updateCar.updateCar(car);
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

	@Override
	public AddState delivery(DeliveryVO delivery) {
		// TODO Au
		DeliveryImpl deliveryImpl=new DeliveryImpl();
		
		return deliveryImpl.delivery(delivery);
	}
	
	

}
