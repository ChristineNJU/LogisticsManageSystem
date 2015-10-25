package businesslogic.Service.Admin;

import dataservice.State.UpdateState;

public interface UpdateUserService {
	public UpdateState updateUser(UserVO user, String field, String value);
}
