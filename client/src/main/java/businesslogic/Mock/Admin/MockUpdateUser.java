package businesslogic.Mock.Admin;

import data.State.UpdateState;
import businesslogic.Impl.Admin.UpdateUserImpl;
import businesslogic.VO.UserVO;

public class MockUpdateUser extends UpdateUserImpl{
	public UpdateState updateUser(UserVO user, String field, String value) {
		// TODO Auto-generated method stub
		return UpdateState.SUCCESS;
	}

}
