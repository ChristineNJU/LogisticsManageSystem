package businesslogic.test.Manage;

import junit.framework.TestCase;
import State.SalaryType;
import State.UpdateState;
import State.UserRole;
import VO.SalaryVO;
import businesslogic.Impl.Manage.ManageController;

public class TestUpdatePayment extends TestCase {

	public void testUpdatePayment(){
		ManageController manageController=new ManageController();
		
		SalaryVO salary=new SalaryVO(UserRole.businessAgent,10000 , SalaryType.MONTH);
		
		assertEquals(UpdateState.SUCCESS,manageController.updatePayment(salary));
	}
}
