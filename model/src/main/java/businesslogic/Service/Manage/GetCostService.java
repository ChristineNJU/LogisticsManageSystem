package businesslogic.Service.Manage;

import java.util.ArrayList;

import VO.ConstVO;
import VO.CostVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface GetCostService.
 */
public interface GetCostService {
	
	/**
	 * Search cost.
	 *
	 * @param time_start the time_start
	 * @param time_end the time_end
	 * @return the array list
	 */
	public ArrayList<CostVO> searchCost(String time_start, String time_end);
}
