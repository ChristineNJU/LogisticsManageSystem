package businesslogic.test.Manage;

import businesslogic.Impl.Manage.ManageController;
import junit.framework.TestCase;

public class TestDeleteInstitution extends TestCase {

	public void testDeleteInstitution(){
		ManageController manageController=new ManageController();
		
		assertEquals(null,manageController.deleteInstitution(null));
	}
}
