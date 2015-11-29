package businesslogic.test.Manage;

import junit.framework.TestCase;
import businesslogic.Impl.Manage.ManageController;

public class TestSearchBenefit extends TestCase {

	public void testSearchBenefit(){
		ManageController manageController=new ManageController();
		
		assertEquals(null,manageController.searchBenefit(null));
	}
}
