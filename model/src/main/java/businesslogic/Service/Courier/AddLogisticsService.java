package businesslogic.Service.Courier;

import State.AddState;
import VO.VO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AddLogisticsService.
 */
public interface AddLogisticsService {
	
	/**
	 * Adds the logistics.
	 *
	 * @param logistics_info the logistics_info
	 * @return the adds the state
	 */
	public AddState addLogistics(VO logistics_info);
}
