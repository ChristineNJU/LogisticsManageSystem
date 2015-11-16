package businesslogic.test.Manage;

import businesslogic.Impl.Manage.ManageController;
import junit.framework.TestCase;

public class TestSearchStaff extends TestCase {

	public void testSearchStaff(){
		ManageController manageController=new ManageController();
		
		assertEquals(null,manageController.searchStaff(null));
	}
}
