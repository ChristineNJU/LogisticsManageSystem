package businesslogic.Service.Manage;

import State.UpdateState;
import VO.DistanceVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface UpdateDistanceService.
 */
public interface UpdateDistanceService {
	
	/**
	 * Update distance.
	 *
	 * @param distance the distance
	 * @return the update state
	 */
	public UpdateState updateDistance(DistanceVO distance);
}
