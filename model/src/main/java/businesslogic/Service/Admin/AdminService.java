package businesslogic.Service.Admin;

import java.util.ArrayList;

import VO.UserVO;
import State.AddState;
import State.DeleteState;
import State.UpdateState;

public interface AdminService {
	
	public AddState addUser(UserVO user);
	public DeleteState deleteUser(UserVO user);
	public UpdateState updateUser(UserVO user);
	public ArrayList<UserVO> searchUser(ArrayList<String> requirement);
}
