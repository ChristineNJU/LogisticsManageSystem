package businesslogic.Service.Admin;

import dataservice.State.DeleteState;

public interface DeleteUserService {
	public DeleteState deleteUser(UserVO user);
}
