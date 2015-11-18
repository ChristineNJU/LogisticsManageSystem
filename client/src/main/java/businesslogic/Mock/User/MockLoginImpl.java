package businesslogic.Mock.User;

import State.LoginState;
import businesslogic.Impl.User.LoginImpl;

public class MockLoginImpl extends LoginImpl {
	
	public LoginState login(String userName, String password) {
		
		return LoginState.SUCCESS;
	}
}
