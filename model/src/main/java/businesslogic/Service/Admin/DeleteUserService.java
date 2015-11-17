package businesslogic.Service.Admin;

import VO.UserVO;
import data.State.DeleteState;

public interface DeleteUserService {
	public DeleteState deleteUser(UserVO user);
}
