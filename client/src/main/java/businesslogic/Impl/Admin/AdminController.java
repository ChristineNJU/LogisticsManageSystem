package businesslogic.Impl.Admin;

import java.util.ArrayList;

import data.State.AddState;
import data.State.DeleteState;
import data.State.UpdateState;
import businesslogic.Service.Admin.AddUserService;
import businesslogic.Service.Admin.DeleteUserService;
import businesslogic.Service.Admin.SearchUserService;
import businesslogic.Service.Admin.UpdateUserService;
import businesslogic.VO.UserVO;

public class AdminController implements AddUserService,DeleteUserService,SearchUserService,UpdateUserService{
	
	AddUserImpl addUser=new AddUserImpl();
	DeleteUserImpl deleteUser=new DeleteUserImpl();
	SearchUserImpl searchUser=new SearchUserImpl();
	UpdateUserImpl updateUser=new UpdateUserImpl();

	@Override
	public UpdateState updateUser(UserVO user, String field, String value) {
		// TODO Auto-generated method stub
		return updateUser.updateUser(user, field, value);
	}

	@Override
	public ArrayList<UserVO> searchUser(String id) {
		// TODO Auto-generated method stub
		return searchUser.searchUser(id);
	}

	@Override
	public DeleteState deleteUser(UserVO user) {
		// TODO Auto-generated method stub
		return deleteUser.deleteUser(user);
	}

	@Override
	public AddState addUser(UserVO user) {
		// TODO Auto-generated method stub
		return addUser.addUser(user);
	}

}
