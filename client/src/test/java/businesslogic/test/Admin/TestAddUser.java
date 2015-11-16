package businesslogic.test.Admin;

import junit.framework.TestCase;
import businesslogic.Impl.Admin.AdminController;

public class TestAddUser extends TestCase {
	
	public void testAddUser() {
		
		AdminController admin = new AdminController();
		
		assertEquals(null, admin.addUser(null));
	}
}
