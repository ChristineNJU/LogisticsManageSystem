package businesslogic.Service.Admin;


import State.AddState;
import VO.UserVO;

public interface AddUserService {
	public AddState addUser(UserVO user);
}
