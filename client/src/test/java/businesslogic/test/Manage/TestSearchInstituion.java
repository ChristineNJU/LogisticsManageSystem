package businesslogic.test.Manage;

import businesslogic.Impl.Manage.ManageController;
import junit.framework.TestCase;

public class TestSearchInstituion extends TestCase {

	public void testSearchInstitution(){
		ManageController manageController=new ManageController();
		
		assertEquals(null,manageController.searchInstitution(null));
	}
}
