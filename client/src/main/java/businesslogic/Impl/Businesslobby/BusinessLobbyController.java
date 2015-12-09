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

// TODO: Auto-generated Javadoc
/**
 * The Class BusinessLobbyController.
 */
public class BusinessLobbyController implements BsLbService{
	
	/* (non-Javadoc)
	 * @see businesslogic.Service.BusinessLobby.BsLbService#updateDriver(VO.DriverInfoVO)
	 */
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
	
	/* (non-Javadoc)
	 * @see businesslogic.Service.BusinessLobby.BsLbService#updateCar(VO.CarInfoVO)
	 */
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
	
	/* (non-Javadoc)
	 * @see businesslogic.Service.BusinessLobby.BsLbService#searchDriver(java.lang.String)
	 */
	@Override
	public ArrayList<DriverInfoVO> searchDriver(String id) {
		// TODO Auto-generated method stub
		DriverMgt searchDriver=new DriverMgt();
		return searchDriver.searchDriver(id);
	}
	
	/* (non-Javadoc)
	 * @see businesslogic.Service.BusinessLobby.BsLbService#searchCar(java.lang.String)
	 */
	@Override
	public ArrayList<CarInfoVO> searchCar(String id) {
		// TODO Auto-generated method stub
		CarMgt searchCar=new CarMgt();
		return searchCar.searchCar(id);
	}
	
	/* (non-Javadoc)
	 * @see businesslogic.Service.BusinessLobby.BsLbService#getNeedGathering()
	 */
	@Override
	public ArrayList<GatheringVO> getNeedGathering() {
		// TODO Auto-generated method stub
		GetNeedGatheringImpl getNeedGathering=new GetNeedGatheringImpl();
		return getNeedGathering.getNeedGathering();
	}
	
	/* (non-Javadoc)
	 * @see businesslogic.Service.BusinessLobby.BsLbService#getNeedEntrucking()
	 */
	@Override
	public ArrayList<EntruckingVO> getNeedEntrucking() {
		// TODO Auto-generated method stub
		GetNeedEntruckingImpl getNeedEntrucking=new GetNeedEntruckingImpl();
		return getNeedEntrucking.getNeedEntrucking();
	}
	
	/* (non-Javadoc)
	 * @see businesslogic.Service.BusinessLobby.BsLbService#gathering(VO.GatheringVO)
	 */
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
	
	/* (non-Javadoc)
	 * @see businesslogic.Service.BusinessLobby.BsLbService#entrucking(VO.EntruckingVO)
	 */
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
	
	/* (non-Javadoc)
	 * @see businesslogic.Service.BusinessLobby.BsLbService#deleteCar(VO.CarInfoVO)
	 */
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
	
	/* (non-Javadoc)
	 * @see businesslogic.Service.BusinessLobby.BsLbService#arrival(java.util.ArrayList)
	 */
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
	
	/* (non-Javadoc)
	 * @see businesslogic.Service.BusinessLobby.BsLbService#AddDriver(VO.DriverInfoVO)
	 */
	@Override
	public AddState AddDriver(DriverInfoVO driver) {
		// TODO Auto-generated method stub
		DriverMgt addDriver=new DriverMgt();
		AddState state = addDriver.addDriver(driver);
		if(state==AddState.SUCCESS){
			SystemLog.addLog("添加司机信息");
		}
		return state;
	}
	
	/* (non-Javadoc)
	 * @see businesslogic.Service.BusinessLobby.BsLbService#addCar(VO.CarInfoVO)
	 */
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

	/* (non-Javadoc)
	 * @see businesslogic.Service.BusinessLobby.BsLbService#deleteDriver(VO.DriverInfoVO)
	 */
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

	/* (non-Javadoc)
	 * @see businesslogic.Service.BusinessLobby.BsLbService#delivery(VO.DeliveryVO)
	 */
	@Override
	public AddState delivery(DeliveryVO delivery) {
		// TODO Au
		DeliveryImpl deliveryImpl=new DeliveryImpl();
		
		return deliveryImpl.delivery(delivery);
	}
	
	

}
