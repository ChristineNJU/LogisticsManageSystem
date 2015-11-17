package businesslogic.Impl.Admin;

import java.util.ArrayList;

import data.State.AddState;
import data.State.DeleteState;
import data.State.UpdateState;
import VO.UserVO;
import businesslogic.Service.Admin.AddUserService;
import businesslogic.Service.Admin.AdminService;
import businesslogic.Service.Admin.DeleteUserService;
import businesslogic.Service.Admin.SearchUserService;
import businesslogic.Service.Admin.UpdateUserService;

public class AdminController implements AdminService{
	
	@Override
	public UpdateState updateUser(UserVO user, String field, String value) {
		// TODO Auto-generated method stub
		AdminImpl adminUser=new AdminImpl();
		return adminUser.updateUser(user, field, value);
	}

	@Override
	public ArrayList<UserVO> searchUser(String id) {
		// TODO Auto-generated method stub
		AdminImpl adminUser=new AdminImpl();
		return adminUser.searchUser(id);
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
