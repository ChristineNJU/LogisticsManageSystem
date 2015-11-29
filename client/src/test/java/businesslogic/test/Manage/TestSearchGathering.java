package businesslogic.test.Manage;

import businesslogic.Impl.Manage.ManageController;
import junit.framework.TestCase;

public class TestSearchGathering extends TestCase {

	public void testSearchGathering(){
		ManageController manageController=new ManageController();
		
		assertEquals(null,manageController.searchGathering(null, "025000"));
	}
}
