package businesslogic.test.Manage;

import businesslogic.Impl.Manage.ManageController;
import junit.framework.TestCase;

public class TestShowReceipt extends TestCase {

	public void testShowReceipt(){
		ManageController manageController=new ManageController();
		
		assertEquals(null,manageController.showReceipt());
	}
}
