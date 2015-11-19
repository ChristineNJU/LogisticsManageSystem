package businesslogic.Mock.Admin;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.UserVO;
import businesslogic.Impl.Admin.AdminImpl;

public class MockAdmin extends AdminImpl{
	@Override
	public UpdateState updateUser(UserVO user, String field, String value) {
		// TODO Auto-generated method stub
		return UpdateState.NOTFOUND;
	}

	@Override
	public ArrayList<UserVO> searchUser(ArrayList<String> requirement) {
		// TODO Auto-generated method stub
		return new ArrayList<UserVO>();
	}

	@Override
	public DeleteState deleteUser(UserVO user) {
		// TODO Auto-generated method stub
		return DeleteState.FAIL;
	}

	@Override
	public AddState addUser(UserVO user) {
		// TODO Auto-generated method stub
		return AddState.FAIL;
	}
}
