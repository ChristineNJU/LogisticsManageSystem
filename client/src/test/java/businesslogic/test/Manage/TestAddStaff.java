package businesslogic.test.Manage;

import businesslogic.Impl.Manage.ManageController;
import junit.framework.TestCase;

public class TestAddStaff extends TestCase {

	public void testAddStaff(){
		ManageController manageController=new ManageController();
		
		assertEquals(null,manageController.addStaff(null));
	}
}
