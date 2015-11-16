package businesslogic.Mock.Admin;

import data.State.AddState;
import businesslogic.Impl.Admin.AddUserImpl;
import businesslogic.VO.UserVO;

public class MockAddUser extends AddUserImpl{
	public AddState addUser(UserVO user) {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}
}
