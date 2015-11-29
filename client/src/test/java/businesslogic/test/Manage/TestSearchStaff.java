package businesslogic.test.Manage;

import junit.framework.TestCase;
import State.InstitutionType;
import State.UserRole;
import VO.StaffVO;
import businesslogic.Impl.Manage.ManageController;

public class TestSearchStaff extends TestCase {

	public void testSearchStaff(){
		ManageController manageController=new ManageController();
		
		StaffVO staff=new StaffVO("张斯栋","男", 200,InstitutionType.BusinessLobby, UserRole.businessAgent,"025000012","南京", "12345");
		assertEquals(staff.getName(),manageController.searchStaff("025000012").get(0).getName());
	}
}
