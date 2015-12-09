package businesslogic.Mock.Admin;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.UserVO;
import businesslogic.Impl.Admin.AdminController;

public class MockAdminController extends AdminController{

	@Override
	public ArrayList<UserVO> searchUser(ArrayList<String> requirement) {
		// TODO Auto-generated method stub
		MockAdmin adminUser=new MockAdmin();
		return adminUser.searchUser(requirement);
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
