package businesslogic.Mock.Admin;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.UserVO;
import businesslogic.Impl.Admin.AdminController;

public class MockAdminController extends AdminController{
	@Override
	public UpdateState updateUser(UserVO user, String field, String value) {
		// TODO Auto-generated method stub
		MockAdmin adminUser=new MockAdmin();
		return adminUser.updateUser(user, field, value);
	}

	@Override
	public ArrayList<UserVO> searchUser(String id) {
		// TODO Auto-generated method stub
		MockAdmin adminUser=new MockAdmin();
		return adminUser.searchUser(id);
	}

	@Override
	public DeleteState deleteUser(UserVO user) {
		// TODO Auto-generated method stub
		MockAdmin adminUser=new MockAdmin();
		return adminUser.deleteUser(user);
	}

	@Override
	public AddState addUser(UserVO user) {
		// TODO Auto-generated method stub
		MockAdmin adminUser=new MockAdmin();
		return adminUser.addUser(user);
	}
}
