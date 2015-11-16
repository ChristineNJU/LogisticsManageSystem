package businesslogic.test.Admin;

import businesslogic.Impl.Admin.AdminController;
import junit.framework.TestCase;

public class TestDeleteUser extends TestCase {

	public void testDeleteUser() {
		
		AdminController admin = new AdminController();
		
		assertEquals(null, admin.deleteUser(null));
	}
}
