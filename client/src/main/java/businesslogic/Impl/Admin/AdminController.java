package businesslogic.Impl.Admin;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.UserVO;
import businesslogic.Service.Admin.AdminService;

public class AdminController implements AdminService{
	
	@Override
	public UpdateState updateUser(UserVO user, String field, String value) {
		// TODO Auto-generated method stub
		AdminImpl adminUser=new AdminImpl();
		return adminUser.updateUser(user, field, value);
	}

	@Override
	public ArrayList<UserVO> searchUser(ArrayList<String> requirement) {
		// TODO Auto-generated method stub
		AdminImpl adminUser=new AdminImpl();
		return adminUser.searchUser(requirement);
	}

	@Override
	public DeleteState deleteUser(UserVO user) {
		// TODO Auto-generated method stub
		AdminImpl adminUser=new AdminImpl();
		return adminUser.deleteUser(user);
	}

	@Override
	public AddState addUser(UserVO user) {
		// TODO Auto-generated method stub
		AdminImpl adminUser=new AdminImpl();
		return adminUser.addUser(user);
	}

}
