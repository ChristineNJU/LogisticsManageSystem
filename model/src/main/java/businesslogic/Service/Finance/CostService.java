package businesslogic.Service.Finance;

import java.util.ArrayList;

import State.AddState;
import VO.CostVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface CostService.
 */
public interface CostService {

	/**
	 * 添加出款单.
	 *
	 * @param cost CostVO
	 * @return 添加状态
	 */
	public AddState addCost(CostVO cost);

	/**
	 * 查询出款单.
	 *
	 * @param time_start 起始日期
	 * @param time_end 截止日期
	 * @return CostVO的ArrayList
	 */
	public ArrayList<CostVO> searchCost(String time_start, String time_end);
	
	/**
	 * 查询出款单.
	 *
	 * @param time 截止日期
	 * @return CostVO的ArrayList
	 */
	public ArrayList<CostVO> searchCost(String time);
	
}
