package businesslogic.Service.Admin;

import java.util.ArrayList;

import VO.UserVO;

public interface GetUserService {
	public ArrayList<UserVO> searchUser(ArrayList<String> requirement);
}
