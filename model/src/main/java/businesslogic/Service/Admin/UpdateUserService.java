package businesslogic.Service.Admin;

import VO.UserVO;
import data.State.UpdateState;

public interface UpdateUserService {
	public UpdateState updateUser(UserVO user, String field, String value);
}
