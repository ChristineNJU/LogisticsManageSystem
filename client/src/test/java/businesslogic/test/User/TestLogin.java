package businesslogic.test.User;

import junit.framework.TestCase;
import State.LoginState;
import businesslogic.Impl.User.UserController;

public class TestLogin extends TestCase {
	
	public void testTotal() {
		
		UserController user = new UserController();
		
		assertEquals(LoginState.SUCCESS, user.login("025100101", "12345678"));
	}
}
