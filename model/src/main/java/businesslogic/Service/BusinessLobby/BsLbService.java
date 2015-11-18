package businesslogic.Service.BusinessLobby;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.ArrivalVO;
import VO.CarInfoVO;
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
	public ArrayList<String> getNeedEntrucking();
	public ArrayList<String> getNeedGathering();
	public ArrayList<CarInfoVO> searchCar(String id);
	public ArrayList<DriverInfoVO> searchDriver(String id);
	public UpdateState updateCar(CarInfoVO car, String field, String value);
	public UpdateState updateDriver(DriverInfoVO driver, String field, String value);
}
