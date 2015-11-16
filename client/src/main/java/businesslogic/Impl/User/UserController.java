package businesslogic.Impl.User;

import businesslogic.Service.User.LoginService;
import businesslogic.Service.User.ResetPasswordService;
import businesslogic.State.LoginState;
import businesslogic.State.ResetState;

public class UserController implements LoginService, ResetPasswordService{
	
	private LoginImpl login = new LoginImpl();
	private ResetPasswordImpl rpi = new ResetPasswordImpl();
	
	@Override
	public ResetState reset(String userName, String oldPassword,
			String newPassword) {
		// TODO Auto-generated method stub
		
		ResetState state = login.reset(userName, oldPassword, newPassword);
		
		return state;
	}

	@Override
	public LoginState login(String userName, String password) {
		// TODO Auto-generated method stub
		
		LoginState state = rpi.login(userName, password);
		
		return state;
	}

}
