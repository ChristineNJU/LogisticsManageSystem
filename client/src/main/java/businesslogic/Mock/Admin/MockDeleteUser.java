package businesslogic.Mock.Admin;

import data.State.DeleteState;
import businesslogic.Impl.Admin.DeleteUserImpl;
import businesslogic.VO.UserVO;

public class MockDeleteUser extends DeleteUserImpl{
	public DeleteState deleteUser(UserVO user) {
		// TODO Auto-generated method stub
		return DeleteState.SUCCESS;
	}
}
