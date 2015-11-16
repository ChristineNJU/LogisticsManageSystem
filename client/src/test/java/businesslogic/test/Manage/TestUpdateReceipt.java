package businesslogic.test.Manage;

import businesslogic.Impl.Manage.ManageController;
import junit.framework.TestCase;

public class TestUpdateReceipt extends TestCase {
	
	public void testUpdateReceipt(){
		ManageController manageController=new ManageController();
	
		assertEquals(null,manageController.updateConst(null, "南京到上海的距离","200km"));
	}
}
