package businesslogic.Service.Admin;

import java.util.ArrayList;

import VO.UserVO;
import data.State.AddState;
import data.State.DeleteState;
import data.State.UpdateState;

public interface AdminService {
	
	public AddState addUser(UserVO user);
	public DeleteState deleteUser(UserVO user);
	public UpdateState updateUser(UserVO user, String field, String value);
	public ArrayList<UserVO> searchUser(String id);
}
