package businesslogic.Service.Admin;

import java.util.ArrayList;

import businesslogic.VO.UserVO;

public interface SearchUserService {
	public ArrayList<UserVO> searchUser(String id);
}
