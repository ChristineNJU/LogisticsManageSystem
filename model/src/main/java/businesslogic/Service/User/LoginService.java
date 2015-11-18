package businesslogic.Service.User;

import State.LoginState;

public interface LoginService {
	public LoginState login(String userName, String password);
}
