package businesslogic.Service.Admin;


import businesslogic.VO.UserVO;

import dataservice.State.AddState;

public interface AddUserService {
	public AddState addUser(UserVO user);
}
