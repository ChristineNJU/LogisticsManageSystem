package businesslogic.test.Admin;

import junit.framework.TestCase;
import State.UpdateState;
import businesslogic.Impl.Admin.AdminController;

public class TestUpdateUser extends TestCase {
	
	public void testUpdateUser() {
		
		AdminController admin = new AdminController();
		
		assertEquals(UpdateState.NOTFOUND, admin.updateUser(null, "name", "hy"));
	}
}
