package businesslogic.test.Admin;

import junit.framework.TestCase;
import businesslogic.Impl.Admin.AdminController;

public class TestSearchUser extends TestCase {
	
	public void testSearchUser() {
		
		AdminController admin = new AdminController();
		
		assertEquals(null, admin.searchUser("100200252"));
	}
}
