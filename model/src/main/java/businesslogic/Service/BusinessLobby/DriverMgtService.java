package businesslogic.Service.BusinessLobby;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.DriverInfoVO;

public interface DriverMgtService{

	/**
	 * 添加司机
	 * 
	 * @param driver 司机信息
	 * @return 添加状态
	 * */
	public AddState addDriver(DriverInfoVO car);
	
	/**
	 * 删除司机
	 * 
	 * @param driver 司机信息
	 * @return 删除状态
	 * */
	public DeleteState deleteDriver(DriverInfoVO driver);
	
	/**
	 * 获取司机信息
	 * 
	 * @param id 司机ID
	 * @return DriverInfoVO的ArrayList
	 * */
	public ArrayList<DriverInfoVO> searchDriver(String id);
	
	/**
	 * 更新车辆信息
	 * 
	 * @param car 车辆信息
	 * @return 更新状态
	 * */
	public UpdateState updateDriver(DriverInfoVO driver);
	
}
