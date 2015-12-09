package businesslogic.Service.Manage;

import State.UpdateState;
import VO.ConstVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface UpdateConstService.
 */
public interface UpdateConstService {
	
	/**
	 * Update const.
	 *
	 * @param constant the constant
	 * @return the update state
	 */
	public UpdateState updateConst(ConstVO constant);
}
