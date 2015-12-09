package businesslogic.Service.User;

import State.LoginState;

// TODO: Auto-generated Javadoc
/**
 * 登录接口.
 *
 * @author 尹子越
 * @version 1.0.0
 */
public interface LoginService {
	
	/**
	 * 登录用户名密码比对接口.
	 *
	 * @param userName 用户名
	 * @param password 密码
	 * @return 登录状态
	 */
	public LoginState login(String userName, String password);
}
