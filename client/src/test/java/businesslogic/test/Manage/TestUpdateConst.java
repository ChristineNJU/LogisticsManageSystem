package businesslogic.test.Manage;

import businesslogic.Impl.Manage.ManageController;
import junit.framework.TestCase;

public class TestUpdateConst extends TestCase {

	public void testUpdateConst(){
		ManageController manageController=new ManageController();
		
		assertEquals(null,manageController.updateConst(null, null, null));
	}
}
