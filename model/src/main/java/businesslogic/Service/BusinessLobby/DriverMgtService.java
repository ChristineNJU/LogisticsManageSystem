package businesslogic.Service.BusinessLobby;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.DriverInfoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface DriverMgtService.
 */
public interface DriverMgtService{

	/**
	 * 添加司机.
	 *
	 * @param car the car
	 * @return 添加状态
	 */
	public AddState addDriver(DriverInfoVO car);
	
	/**
	 * 删除司机.
	 *
	 * @param driver 司机信息
	 * @return 删除状态
	 */
	public DeleteState deleteDriver(DriverInfoVO driver);
	
	/**
	 * 获取司机信息.
	 *
	 * @param id 司机ID
	 * @return DriverInfoVO的ArrayList
	 */
	public ArrayList<DriverInfoVO> searchDriver(String id);
	
	/**
	 * 更新车辆信息.
	 *
	 * @param driver the driver
	 * @return 更新状态
	 */
	public UpdateState updateDriver(DriverInfoVO driver);
	
}
