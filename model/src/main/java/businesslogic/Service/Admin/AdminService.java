package businesslogic.Service.Admin;

import java.util.ArrayList;

import VO.UserVO;
import State.AddState;
import State.DeleteState;
import State.UpdateState;

/**
 * 管理员业务接口
 * 
 * @author 张斯栋
 * @version 1.0.0
 * */
public interface AdminService {
	
	/**
	 * 添加用户
	 * 
	 * @param user 用户信息
	 * @return 添加状态
	 * */
	public AddState addUser(UserVO user);
	
	/**
	 * 删除用户
	 * 
	 * @param user 用户信息
	 * @return 删除状态
	 * */
	public DeleteState deleteUser(UserVO user);
	
	/**
	 * 更新用户
	 * 
	 * @param user 用户信息
	 * @return 更新状态
	 * */
	public UpdateState updateUser(UserVO user);
	
	/**
	 * 查询用户
	 * 
	 * @param requirement 查询要求
	 * @return UserVO的ArrayList
	 * */
	public ArrayList<UserVO> searchUser(ArrayList<String> requirement);
}
