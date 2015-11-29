package businesslogic.test.User;

import junit.framework.TestCase;
import State.ResetState;
import businesslogic.Impl.User.UserController;

public class TestResetPassword extends TestCase {
	
	public void tesetResetPassword() {
		
		UserController user = new UserController();
		
		assertEquals(ResetState.SUCCESS, user.reset("02501001", "3232434", "32523"));
	}
}
