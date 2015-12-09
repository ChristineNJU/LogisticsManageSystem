package businesslogic.Service.MediumCenter;

import java.util.ArrayList;

import State.AddState;
import VO.ArrivalVO;
import VO.EntruckingVO;
import VO.TransferVO;

// TODO: Auto-generated Javadoc
/**
 * 中转中心业务接口.
 *
 * @author 张晨剑
 * @version 1.0.0
 */
public interface MCService {
	
	/**
	 * 添加到达单.
	 *
	 * @param arrival ArrivalVO的ArrayList
	 * @return 添加状态
	 */
	public AddState arrival(ArrayList<ArrivalVO> arrival);
	
	/**
	 * 添加装车单.
	 *
	 * @param entrucking EntruckingVO的ArrayList
	 * @return 添加状态
	 */
	public AddState entrucking(EntruckingVO entrucking);
	
	/**
	 * 获取需要装车的快递.
	 *
	 * @return EntruckingVO的ArrayList
	 */
	public ArrayList<EntruckingVO> getNeedEntrucking();
	
	/**
	 * 获取需要中转的快递.
	 *
	 * @return TransferVO的ArrayList
	 */
	public ArrayList<TransferVO> getNeedTransfer();
	
	/**
	 * 添加中转单.
	 *
	 * @param transfer TransferVO
	 * @return 添加状态
	 */
	public AddState transfer(TransferVO transfer);
}
