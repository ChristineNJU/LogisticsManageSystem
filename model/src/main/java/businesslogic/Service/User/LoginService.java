package businesslogic.Service.User;

import data.State.LoginState;

public interface LoginService {
	public LoginState login(String userName, String password);
}
