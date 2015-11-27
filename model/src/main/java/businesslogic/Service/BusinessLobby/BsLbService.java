package businesslogic.Service.BusinessLobby;

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

public interface BsLbService {
	
	public AddState addCar(CarInfoVO car);
	public AddState AddDriver(DriverInfoVO driver);
	public AddState arrival(ArrayList<ArrivalVO> arrival);
	public DeleteState deleteCar(CarInfoVO car);
	public DeleteState deleteDriver(DriverInfoVO driver);
	public AddState entrucking(EntruckingVO entrucking);
	public AddState gathering(GatheringVO gathering);
	public AddState delivery(DeliveryVO delivery);
	public ArrayList<EntruckingVO> getNeedEntrucking();
	public ArrayList<GatheringVO> getNeedGathering();
	public ArrayList<CarInfoVO> searchCar(String id);
	public ArrayList<DriverInfoVO> searchDriver(String id);
	public UpdateState updateCar(CarInfoVO car);
	public UpdateState updateDriver(DriverInfoVO driver);
}
