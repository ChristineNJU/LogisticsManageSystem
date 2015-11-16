package businesslogic.Mock.Admin;

import java.util.ArrayList;

import businesslogic.Impl.Admin.AdminController;
import businesslogic.VO.UserVO;
import data.State.AddState;
import data.State.DeleteState;
import data.State.UpdateState;

public class MockAdminController extends AdminController{
	@Override
	public UpdateState updateUser(UserVO user, String field, String value) {
		// TODO Auto-generated method stub
		MockUpdateUser updateUser=new MockUpdateUser();
		return updateUser.updateUser(user, field, value);
	}

	@Override
	public ArrayList<UserVO> searchUser(String id) {
		// TODO Auto-generated method stub
		MockSearchUser searchUser=new MockSearchUser();
		return searchUser.searchUser(id);
	}

	@Override
	public DeleteState deleteUser(UserVO user) {
		// TODO Auto-generated method stub
		MockDeleteUser deleteUser=new MockDeleteUser();
		return deleteUser.deleteUser(user);
	}

	@Override
	public AddState addUser(UserVO user) {
		// TODO Auto-generated method stub
		MockAddUser addUser=new MockAddUser();
		return addUser.addUser(user);
	}
}
