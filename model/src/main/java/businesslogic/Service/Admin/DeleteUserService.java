package businesslogic.Service.Admin;

import State.DeleteState;
import VO.UserVO;

public interface DeleteUserService {
	public DeleteState deleteUser(UserVO user);
}
