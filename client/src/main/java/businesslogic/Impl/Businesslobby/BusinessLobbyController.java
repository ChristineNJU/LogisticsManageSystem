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
import businesslogic.SystemLog.SystemLog;

public class BusinessLobbyController implements BsLbService{
	
	@Override
	public UpdateState updateDriver(DriverInfoVO driver) {
		// TODO Auto-generated method stub
		DriverMgt updateDriver=new DriverMgt();
		UpdateState state = updateDriver.updateDriver(driver);
		if(state==UpdateState.SUCCESS){
			SystemLog.addLog("更新司机信息");
		}
		return state;
	}
	
	@Override
	public UpdateState updateCar(CarInfoVO car) {
		// TODO Auto-generated method stub
		CarMgt updateCar=new CarMgt();
		UpdateState state = updateCar.updateCar(car);
		if(state==UpdateState.SUCCESS){
			SystemLog.addLog("更新车辆信息");
		}
		return state;
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
		AddState state = Gathering.gathering(gathering);
		if(state==AddState.SUCCESS){
			SystemLog.addLog("添加收款单信息");
		}
		return state;
	}
	
	@Override
	public AddState entrucking(EntruckingVO entrucking) {
		// TODO Auto-generated method stub
		EntruckingImpl Entrucking =new EntruckingImpl();
		AddState state = Entrucking.entrucking(entrucking);
		if(state==AddState.SUCCESS){
			SystemLog.addLog("添加装车单信息");
		}
		return state;
	}
	
	@Override
	public DeleteState deleteCar(CarInfoVO car) {
		// TODO Auto-generated method stub
		CarMgt deleteCar=new CarMgt();
		DeleteState state = deleteCar.deleteCar(car);
		if(state==DeleteState.SUCCESS){
			SystemLog.addLog("删除车辆信息");
		}
		return state;
	}
	
	@Override
	public AddState arrival(ArrayList<ArrivalVO> arrival) {
		// TODO Auto-generated method stub
		ArrivalImpl Arrival=new ArrivalImpl();
		AddState state = Arrival.arrival(arrival);
		if(state==AddState.SUCCESS){
			SystemLog.addLog("添加到达单信息");
		}
		return state;
	}
	
	@Override
	public AddState AddDriver(DriverInfoVO driver) {
		// TODO Auto-generated method stub
		DriverMgt addDriver=new DriverMgt();
		AddState state = addDriver.AddDriver(driver);
		if(state==AddState.SUCCESS){
			SystemLog.addLog("添加司机信息");
		}
		return state;
	}
	
	@Override
	public AddState addCar(CarInfoVO car) {
		// TODO Auto-generated method stub
		CarMgt addCar=new CarMgt();
		AddState state = addCar.addCar(car);
		if(state==AddState.SUCCESS){
			SystemLog.addLog("添加车辆信息");
		}
		return state;
	}

	@Override
	public DeleteState deleteDriver(DriverInfoVO driver) {
		// TODO Auto-generated method stub
		DriverMgt deleteDriver=new DriverMgt();
		DeleteState state = deleteDriver.deleteDriver(driver);
		if(state==DeleteState.SUCCESS){
			SystemLog.addLog("删除司机信息");
		}
		return state;
	}

	@Override
	public AddState delivery(DeliveryVO delivery) {
		// TODO Au
		DeliveryImpl deliveryImpl=new DeliveryImpl();
		
		return deliveryImpl.delivery(delivery);
	}
	
	

}
