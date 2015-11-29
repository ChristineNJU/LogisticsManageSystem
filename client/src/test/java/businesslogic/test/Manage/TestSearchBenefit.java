package businesslogic.test.Manage;

import VO.BenefitVO;
import businesslogic.Impl.Manage.ManageController;
import junit.framework.TestCase;

public class TestSearchBenefit extends TestCase {

	public void testSearchBenefit(){
		ManageController manageController=new ManageController();
		
		
		
		assertEquals(0,manageController.searchBenefit("2015-11-29 11:20:29"));
	}
}
