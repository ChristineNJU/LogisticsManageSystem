package businesslogic.test.Manage;

import State.DeleteState;
import State.InstitutionType;
import State.UserRole;
import VO.StaffVO;
import businesslogic.Impl.Manage.ManageController;
import junit.framework.TestCase;

public class TestDeleteStaff extends TestCase {

	public void testDeleteStaff(){
		ManageController manageController=new ManageController();
		StaffVO staff=new StaffVO("张斯栋","男", 200,InstitutionType.BusinessLobby, UserRole.businessAgent,"025000012","南京", "12345");
		assertEquals(DeleteState.SUCCESS,manageController.DeleteStaff(staff));
	}
}
