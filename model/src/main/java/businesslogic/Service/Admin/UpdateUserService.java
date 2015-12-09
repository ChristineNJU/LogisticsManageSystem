package businesslogic.Service.Admin;

import State.UpdateState;
import VO.UserVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface UpdateUserService.
 */
public interface UpdateUserService {
	
	/**
	 * Update user.
	 *
	 * @param user the user
	 * @return the update state
	 */
	public UpdateState updateUser(UserVO user);
}
