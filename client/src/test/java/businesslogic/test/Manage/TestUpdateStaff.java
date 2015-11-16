package businesslogic.test.Manage;

import businesslogic.Impl.Manage.ManageController;
import junit.framework.TestCase;

public class TestUpdateStaff extends TestCase {

	
	public void testUpdateStaff(){
		ManageController manageController=new ManageController();
		
		assertEquals(null,manageController.updateStaff(null, null,null));
	}
}
