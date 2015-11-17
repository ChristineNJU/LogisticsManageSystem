package businesslogic.Impl.User;

import businesslogic.Service.User.LoginService;
import businesslogic.Service.User.ResetPasswordService;
import businesslogic.State.ResetState;
import data.State.LoginState;

public class UserController implements LoginService, ResetPasswordService{
	
	
	@Override
	public ResetState reset(String userName, String oldPassword,
			String newPassword) {
		// TODO Auto-generated method stub
		
		ResetPasswordImpl rpi = new ResetPasswordImpl();
		ResetState state = rpi.reset(userName, oldPassword, newPassword);
		
		return state;
	}

	@Override
	public LoginState login(String userName, String password) {
		// TODO Auto-generated method stub
		
		LoginImpl login = new LoginImpl();
		LoginState state = login.login(userName, password);
		
		return state;
	}

}
