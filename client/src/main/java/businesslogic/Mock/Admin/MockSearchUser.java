package businesslogic.Mock.Admin;

import java.util.ArrayList;

import businesslogic.Impl.Admin.SearchUserImpl;
import businesslogic.VO.UserVO;

public class MockSearchUser extends SearchUserImpl{
	public ArrayList<UserVO> searchUser(String id) {
		// TODO Auto-generated method stub
		return new ArrayList<UserVO>();
	}
}
