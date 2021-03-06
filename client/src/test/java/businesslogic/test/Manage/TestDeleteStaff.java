package businesslogic.test.Manage;

import junit.framework.TestCase;
import State.AddState;
import State.DeleteState;
import State.InstitutionType;
import State.UserRole;
import VO.StaffVO;
import businesslogic.Impl.Manage.ManageController;

public class TestDeleteStaff extends TestCase {

	public void testDeleteStaff(){
		ManageController manageController=new ManageController();
//		StaffVO staff=new StaffVO("张斯栋","男", 200,InstitutionType.BusinessLobby, UserRole.businessAgent,"025000012","南京", "12345");
//		StaffVO staff5=new StaffVO("知识点","男",20,InstitutionType.Repository,UserRole.repository,"02500012","南京","12345");
		StaffVO staff5=new StaffVO("知识点","男",20,InstitutionType.Repository,UserRole.repository,"02500012","南京","12345");
		assertEquals(AddState.SUCCESS,manageController.addStaff(staff5));
		assertEquals(DeleteState.SUCCESS,manageController.DeleteStaff(staff5));
		assertEquals(DeleteState.FAIL,manageController.DeleteStaff(staff5));
	}
}
