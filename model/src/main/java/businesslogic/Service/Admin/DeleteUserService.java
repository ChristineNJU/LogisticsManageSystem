package businesslogic.Service.Admin;

import State.DeleteState;
import VO.UserVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface DeleteUserService.
 */
public interface DeleteUserService {
	
	/**
	 * Delete user.
	 *
	 * @param user the user
	 * @return the delete state
	 */
	public DeleteState deleteUser(UserVO user);
}
