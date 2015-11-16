package businesslogic.test.Manage;

import businesslogic.Impl.Manage.ManageController;
import junit.framework.TestCase;

public class TestAddInstitution extends TestCase {

	public void testAddInstitution(){
		ManageController manageController=new ManageController();
		
		assertEquals(null,manageController.addInstitution(null));
	}
}
