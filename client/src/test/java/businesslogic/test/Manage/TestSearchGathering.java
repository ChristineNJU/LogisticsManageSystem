package businesslogic.test.Manage;

import junit.framework.TestCase;
import businesslogic.Impl.Manage.ManageController;

public class TestSearchGathering extends TestCase {

	public void testSearchGathering(){
		ManageController manageController=new ManageController();
		
		assertEquals(null,manageController.searchGathering(null, "025000"));
	}
}
