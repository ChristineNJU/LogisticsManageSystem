package businesslogic.test.Manage;

import businesslogic.Impl.Manage.ManageController;
import junit.framework.TestCase;

public class TestUpdateReceipt extends TestCase {
	
	public void testUpdateReceipt(){
		ManageController manageController=new ManageController();
	
		assertEquals(null,manageController.updateReceipt(null));
	}
}
