package businesslogic.test.Manage;

import junit.framework.TestCase;
import businesslogic.Impl.Manage.ManageController;

public class TestUpdateReceipt extends TestCase {
	
	public void testUpdateReceipt(){
		ManageController manageController=new ManageController();
	
		assertEquals(null,manageController.updateReceipt(null));
	}
}
