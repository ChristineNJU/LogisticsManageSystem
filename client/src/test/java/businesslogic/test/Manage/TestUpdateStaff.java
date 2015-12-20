package businesslogic.test.Manage;

import junit.framework.TestCase;
import State.AddState;
import State.DeleteState;
import State.InstitutionType;
import State.UpdateState;
import State.UserRole;
import VO.StaffVO;
import businesslogic.Impl.Manage.ManageController;

public class TestUpdateStaff extends TestCase {

	
	public void testUpdateStaff(){
		ManageController manageController=new ManageController();
		StaffVO staff5=new StaffVO("知识点","男",20,InstitutionType.Repository,UserRole.repository,"02500012","南京","12345");
		assertEquals(AddState.SUCCESS,manageController.addStaff(staff5));
		StaffVO staff=new StaffVO("知","男",20,InstitutionType.Repository,UserRole.repository,"02500012","南京","12345");
		assertEquals(UpdateState.SUCCESS,manageController.updateStaff(staff));
		assertEquals(DeleteState.SUCCESS,manageController.DeleteStaff(staff));
		assertEquals(UpdateState.NOTFOUND,manageController.updateStaff(staff));
	}
}
