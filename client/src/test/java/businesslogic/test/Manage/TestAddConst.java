package businesslogic.test.Manage;

import businesslogic.Impl.Manage.ManageController;
import junit.framework.TestCase;

public class TestAddConst extends TestCase {

	public void testAddConst(){
		ManageController manageController=new ManageController();
		
		assertEquals(null,manageController.addConst(null));
	}
}
