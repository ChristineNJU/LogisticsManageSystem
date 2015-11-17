package businesslogic.Service.Admin;


import VO.UserVO;
import data.State.AddState;

public interface AddUserService {
	public AddState addUser(UserVO user);
}
