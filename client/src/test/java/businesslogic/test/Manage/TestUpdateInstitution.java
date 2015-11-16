package businesslogic.test.Manage;

import businesslogic.Impl.Manage.ManageController;
import junit.framework.TestCase;

public class TestUpdateInstitution extends TestCase {

	public void testUpdateInstitution(){
		ManageController manageController=new ManageController();
		
		assertEquals(null,manageController.UpdateInstitution(null, null, null));
	}
}
