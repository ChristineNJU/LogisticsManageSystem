package businesslogic.test.Manage;

import junit.framework.TestCase;
import businesslogic.Impl.Manage.ManageController;

public class TestShowReceipt extends TestCase {

	public void testShowReceipt(){
		ManageController manageController=new ManageController();
		
		assertEquals(null,manageController.showReceipt());
	}
}
