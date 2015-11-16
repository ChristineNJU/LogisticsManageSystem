package businesslogic.test.Manage;

import businesslogic.Impl.Manage.ManageController;
import junit.framework.TestCase;

public class TestUpdatePayment extends TestCase {

	public void testUpdatePayment(){
		ManageController manageController=new ManageController();
		
		assertEquals(null,manageController.updatePayment(null, null, null));
	}
}
