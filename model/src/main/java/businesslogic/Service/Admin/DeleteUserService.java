package businesslogic.Service.Admin;

import businesslogic.VO.UserVO;
import data.State.DeleteState;

public interface DeleteUserService {
	public DeleteState deleteUser(UserVO user);
}
