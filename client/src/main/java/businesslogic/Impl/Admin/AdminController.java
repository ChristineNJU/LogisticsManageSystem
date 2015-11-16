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
	
	@Override
	public UpdateState updateUser(UserVO user, String field, String value) {
		// TODO Auto-generated method stub
		UpdateUserImpl updateUser=new UpdateUserImpl();
		return updateUser.updateUser(user, field, value);
	}

	@Override
	public ArrayList<UserVO> searchUser(String id) {
		// TODO Auto-generated method stub
		SearchUserImpl searchUser=new SearchUserImpl();
		return searchUser.searchUser(id);
	}

	@Override
	public DeleteState deleteUser(UserVO user) {
		// TODO Auto-generated method stub
		DeleteUserImpl deleteUser=new DeleteUserImpl();
		return deleteUser.deleteUser(user);
	}

	@Override
	public AddState addUser(UserVO user) {
		// TODO Auto-generated method stub
		AddUserImpl addUser=new AddUserImpl();
		return addUser.addUser(user);
	}

}
