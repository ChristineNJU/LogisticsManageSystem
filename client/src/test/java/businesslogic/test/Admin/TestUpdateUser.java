package businesslogic.test.Admin;

import data.State.UpdateState;
import junit.framework.TestCase;
import businesslogic.Impl.Admin.AdminController;

public class TestUpdateUser extends TestCase {
	
	public void testUpdateUser() {
		
		AdminController admin = new AdminController();
		
		assertEquals(UpdateState.FAIL, admin.updateUser(null, "name", "hy"));
	}
}
