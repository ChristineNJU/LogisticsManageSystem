package businesslogic.Impl.Admin;

import java.util.ArrayList;

import data.State.AddState;
import data.State.DeleteState;
import data.State.UpdateState;
import VO.UserVO;
import businesslogic.Service.Admin.AddUserService;
import businesslogic.Service.Admin.DeleteUserService;
import businesslogic.Service.Admin.SearchUserService;
import businesslogic.Service.Admin.UpdateUserService;

public class AdminImpl implements AddUserService,DeleteUserService,SearchUserService,UpdateUserService{

	@Override
	public UpdateState updateUser(UserVO user, String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserVO> searchUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteState deleteUser(UserVO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddState addUser(UserVO user) {
		// TODO Auto-generated method stub
		return null;
	}

}
