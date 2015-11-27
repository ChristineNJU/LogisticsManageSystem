package businesslogic.test.Manage;

import junit.framework.TestCase;
import State.AddState;
import State.InstitutionType;
import State.UserRole;
import VO.StaffVO;
import businesslogic.Impl.Manage.ManageController;

public class TestAddStaff extends TestCase {

	public void testAddStaff(){
		ManageController manageController=new ManageController();
		
		StaffVO staff=new StaffVO("张斯栋","男", 200,InstitutionType.BusinessLobby, UserRole.businessAgent,"025000012","南京", "12345");
		assertEquals(AddState.SUCCESS,manageController.addStaff(staff));
	}
}
