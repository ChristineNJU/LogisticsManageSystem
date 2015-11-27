package businesslogic.test.Manage;

import State.InstitutionType;
import State.UpdateState;
import State.UserRole;
import VO.StaffVO;
import businesslogic.Impl.Manage.ManageController;
import junit.framework.TestCase;

public class TestUpdateStaff extends TestCase {

	
	public void testUpdateStaff(){
		ManageController manageController=new ManageController();
		StaffVO staff=new StaffVO("张栋","男", 200,InstitutionType.BusinessLobby, UserRole.businessAgent,"025000012","南京", "12345");
		assertEquals(UpdateState.SUCCESS,manageController.updateStaff(staff));
	}
}
