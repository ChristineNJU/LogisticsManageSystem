package businesslogic.Mock.User;

import businesslogic.Impl.User.LoginImpl;
import data.State.LoginState;

public class MockLoginImpl extends LoginImpl {
	
	public LoginState login(String userName, String password) {
		
		return LoginState.SUCCESS;
	}
}
