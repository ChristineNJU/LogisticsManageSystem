package businesslogic.Service.Admin;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.UserVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AdminUserService.
 */
public interface AdminUserService {

	/**
	 * 添加人员信息.
	 *
	 * @param user the user
	 * @return the adds the state
	 */
	public AddState addUser(UserVO user);
	
	/**
	 * 删除人员.
	 *
	 * @param user the user
	 * @return the delete state
	 */
	public DeleteState deleteUser(UserVO user);
	
	/**
	 * 添加人员.
	 *
	 * @param user the user
	 * @return the update state
	 */
	public UpdateState updateUser(UserVO user);
	
	/**
	 * 查询人员信息.
	 *
	 * @param requirement the requirement
	 * @return the array list
	 */
	public ArrayList<UserVO> searchUser(ArrayList<String> requirement);

}
