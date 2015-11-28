package businesslogic.test.Manage;

import businesslogic.Impl.Manage.ManageController;
import junit.framework.TestCase;

public class TestShowConst extends TestCase {
	

	

		public void testShowReceipt(){
			
			ManageController manageController=new ManageController();
			
			
			assertEquals(null,manageController.showConst());
			
			
		
	}

}
