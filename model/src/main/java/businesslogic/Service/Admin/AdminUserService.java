package businesslogic.Service.Admin;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.UserVO;

public interface AdminUserService {

	/**
	 * 添加人员信息
	 * @param user
	 * @return
	 */
	public AddState addUser(UserVO user);
	
	/**
	 * 删除人员
	 * @param user
	 * @return
	 */
	public DeleteState deleteUser(UserVO user);
	
	/**
	 * 添加人员
	 * @param user
	 * @return
	 */
	public UpdateState updateUser(UserVO user);
	
	/**
	 * 查询人员信息
	 * @param requirement
	 * @return
	 */
	public ArrayList<UserVO> searchUser(ArrayList<String> requirement);

}
