package businesslogic.Impl.User;

import State.LoginState;
import State.ResetState;
import businesslogic.Service.User.LoginService;
import businesslogic.Service.User.ResetPasswordService;

/**
 * 用户操作的控制类
 * 
 * @author 尹子越
 * @version 1.0.0
 * */
public class UserController implements LoginService, ResetPasswordService{
	
	/**
	 * @see ResetPasswordImpl#reset(String, String, String)
	 * */
	@Override
	public ResetState reset(String userName, String oldPassword,
			String newPassword) {
		// TODO Auto-generated method stub
		
		ResetPasswordImpl rpi = new ResetPasswordImpl();
		ResetState state = rpi.reset(userName, oldPassword, newPassword);
		
		return state;
	}
	
	/**
	 * @see LoginImpl#login(String, String)
	 * */
	@Override
	public LoginState login(String userName, String password) {
		// TODO Auto-generated method stub
		
		LoginImpl login = new LoginImpl();
		LoginState state = login.login(userName, password);
		
		return state;
	}

}
