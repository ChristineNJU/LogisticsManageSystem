package businesslogic.Service.BusinessLobby;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.CarInfoVO;

public interface CarMgtService {

	/**
	 * 添加车辆
	 * 
	 * @param car 车辆信息
	 * @return 添加状态
	 * */
	public AddState addCar(CarInfoVO car);
	
	/**
	 * 删除车辆
	 * 
	 * @param car 车辆信息
	 * @return 删除状态
	 * */
	public DeleteState deleteCar(CarInfoVO car);
	
	/**
	 * 获取车辆信息
	 * 
	 * @param id 车辆ID
	 * @return CarInfoVO的ArrayList
	 * */
	public ArrayList<CarInfoVO> searchCar(String id);
	
	/**
	 * 更新车辆信息
	 * 
	 * @param car 车辆信息
	 * @return 更新状态
	 * */
	public UpdateState updateCar(CarInfoVO car);
	
}
