package businesslogic.test.Manage;

import businesslogic.Impl.Manage.ManageController;
import junit.framework.TestCase;

public class TestSearchCost extends TestCase {

	public void testSearchCost(){
		ManageController manageController=new ManageController();
		
		assertEquals(null,manageController.searchCost(null, null));
	}
}
