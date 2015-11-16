package businesslogic.test.Manage;

import businesslogic.Impl.Manage.ManageController;
import junit.framework.TestCase;

public class TestDeleteStaff extends TestCase {

	public void testDeleteStaff(){
		ManageController manageController=new ManageController();
		
		assertEquals(null,manageController.DeleteStaff(null));
	}
}
