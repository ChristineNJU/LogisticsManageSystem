package businesslogic.Service.Finance;

import State.AddState;
import VO.CostVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AddCostService.
 */
public interface AddCostService {
	
	/**
	 * Adds the cost.
	 *
	 * @param cost the cost
	 * @return the adds the state
	 */
	public AddState addCost(CostVO cost);
}
