package businesslogic.Service.Admin;

import java.util.ArrayList;

import VO.UserVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface GetUserService.
 */
public interface GetUserService {
	
	/**
	 * Search user.
	 *
	 * @param requirement the requirement
	 * @return the array list
	 */
	public ArrayList<UserVO> searchUser(ArrayList<String> requirement);
}
