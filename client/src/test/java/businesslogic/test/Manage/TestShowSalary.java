package businesslogic.test.Manage;

import junit.framework.TestCase;
import businesslogic.Impl.Manage.ManageController;

public class TestShowSalary extends TestCase {

	public void testShowSalary(){
		ManageController manageController=new ManageController();
		
		assertEquals(null,manageController.showSalary());
	}
}
