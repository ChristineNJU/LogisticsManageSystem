package businesslogic.Service.Admin;

import java.util.ArrayList;

import VO.UserVO;

public interface SearchUserService {
	public ArrayList<UserVO> searchUser(String id);
}
