package businesslogic.Service.Admin;


import State.AddState;
import VO.UserVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AddUserService.
 */
public interface AddUserService {
	
	/**
	 * Adds the user.
	 *
	 * @param user the user
	 * @return the adds the state
	 */
	public AddState addUser(UserVO user);
}
