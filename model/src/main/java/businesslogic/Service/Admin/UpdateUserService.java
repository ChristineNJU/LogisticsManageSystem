package businesslogic.Service.Admin;

import State.UpdateState;
import VO.UserVO;

public interface UpdateUserService {
	public UpdateState updateUser(UserVO user, String field, String value);
}
