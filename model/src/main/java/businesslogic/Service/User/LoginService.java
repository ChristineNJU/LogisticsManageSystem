package businesslogic.Service.User;

import businesslogic.State.LoginState;

public interface LoginService {
	public LoginState login(String userName, String password);
}
