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

// TODO: Auto-generated Javadoc
/**
 * 营业厅业务接口.
 *
 * @author 张晨剑
 * @version 1.0.0
 */
public interface BsLbService {
	
	/**
	 * 添加车辆.
	 *
	 * @param car 车辆信息
	 * @return 添加状态
	 */
	public AddState addCar(CarInfoVO car);
	
	/**
	 * 添加司机.
	 *
	 * @param driver 司机信息
	 * @return 添加状态
	 */
	public AddState AddDriver(DriverInfoVO driver);
	
	/**
	 * 添加到达单.
	 *
	 * @param arrival ArrivalVO的ArrayList
	 * @return 添加状态
	 */
	public AddState arrival(ArrayList<ArrivalVO> arrival);
	
	/**
	 * 删除车辆.
	 *
	 * @param car 车辆信息
	 * @return 删除状态
	 */
	public DeleteState deleteCar(CarInfoVO car);
	
	/**
	 * 删除司机.
	 *
	 * @param driver 司机信息
	 * @return 删除状态
	 */
	public DeleteState deleteDriver(DriverInfoVO driver);
	
	/**
	 * 添加装车单.
	 *
	 * @param entrucking 装车信息
	 * @return 添加状态
	 */
	public AddState entrucking(EntruckingVO entrucking);
	
	/**
	 * 添加收款单.
	 *
	 * @param gathering 收款信息
	 * @return 添加状态
	 */
	public AddState gathering(GatheringVO gathering);
	
	/**
	 * 添加派件单.
	 *
	 * @param delivery 派件信息
	 * @return 添加状态
	 */
	public AddState delivery(DeliveryVO delivery);
	
	/**
	 * 获取需要装车的快递.
	 *
	 * @return EntruckingVO的ArrayList
	 */
	public ArrayList<EntruckingVO> getNeedEntrucking();
	
	/**
	 * 获取需要派件的快递.
	 *
	 * @return GatheringVO的ArrayList
	 */
	public ArrayList<GatheringVO> getNeedGathering();
	
	/**
	 * 获取车辆信息.
	 *
	 * @param id 车辆ID
	 * @return CarInfoVO的ArrayList
	 */
	public ArrayList<CarInfoVO> searchCar(String id);
	
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
	 * @param car 车辆信息
	 * @return 更新状态
	 */
	public UpdateState updateCar(CarInfoVO car);
	
	/**
	 * 更新司机信息.
	 *
	 * @param driver 司机信息
	 * @return 更新状态
	 */
	public UpdateState updateDriver(DriverInfoVO driver);
}
