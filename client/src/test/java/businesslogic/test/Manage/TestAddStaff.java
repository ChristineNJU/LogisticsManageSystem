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
		
	//	StaffVO staff0=new StaffVO("张斯栋","男", 20,InstitutionType.BusinessLobby, UserRole.businessAgent,"025000012","南京", "12345");
//		assertEquals(AddState.SUCCESS,manageController.addStaff(staff0));
		
//		StaffVO staff1=new StaffVO("刘庆","男",20,InstitutionType.BusinessLobby,UserRole.courier,"025000101","南京","12345");
//		assertEquals(AddState.SUCCESS,manageController.addStaff(staff1));
//		
//		StaffVO staff2=new StaffVO("尹子越","男",20 ,InstitutionType.MediumCenter,UserRole.mediumAgent,"0250012","南京","12345");
//		assertEquals(AddState.SUCCESS,manageController.addStaff(staff2));
//		
//		StaffVO staff3=new StaffVO("张馨中","女",20,InstitutionType.Other,UserRole.finance,"000012","南京","12345");
//		assertEquals(AddState.SUCCESS,manageController.addStaff(staff3));
//		
//		StaffVO staff4=new StaffVO("希尔瓦纳斯","女",50,InstitutionType.Other,UserRole.manager,"000001","南京","12345");
//		assertEquals(AddState.SUCCESS,manageController.addStaff(staff4));
		
		StaffVO staff5=new StaffVO("知识点","男",20,InstitutionType.Repository,UserRole.repository,"02500012","南京","12345");
		assertEquals(AddState.SUCCESS,manageController.addStaff(staff5));
		
		
		
	}
}
