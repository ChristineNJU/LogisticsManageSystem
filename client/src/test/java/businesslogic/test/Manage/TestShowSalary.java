package businesslogic.test.Manage;

import businesslogic.Impl.Manage.ManageController;
import junit.framework.TestCase;

public class TestShowSalary extends TestCase {

	public void testShowSalary(){
		ManageController manageController=new ManageController();
		
		assertEquals(null,manageController.showSalary());
	}
}
