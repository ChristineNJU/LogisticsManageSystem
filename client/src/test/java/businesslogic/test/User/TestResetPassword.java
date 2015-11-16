package businesslogic.test.User;

import businesslogic.Impl.User.UserController;
import businesslogic.State.ResetState;
import junit.framework.TestCase;

public class TestResetPassword extends TestCase {
	
	public void tesetResetPassword() {
		
		UserController user = new UserController();
		
		assertEquals(ResetState.FAIL, user.reset("02501001", "3232434", "32523"));
	}
}
