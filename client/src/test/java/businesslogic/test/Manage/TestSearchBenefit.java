package businesslogic.test.Manage;

import businesslogic.Impl.Manage.ManageController;
import junit.framework.TestCase;

public class TestSearchBenefit extends TestCase {

	public void testSearchBenefit(){
		ManageController manageController=new ManageController();
		
		assertEquals(null,manageController.searchBenefit(null));
	}
}
