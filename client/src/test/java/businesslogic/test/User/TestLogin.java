package businesslogic.test.User;

import junit.framework.TestCase;
import businesslogic.Impl.User.UserController;
import data.State.LoginState;

public class TestLogin extends TestCase {
	
	public void testTotal() {
		
		UserController user = new UserController();
		
		assertEquals(LoginState.FAIL, user.login("025100101", "12345678"));
	}
}
