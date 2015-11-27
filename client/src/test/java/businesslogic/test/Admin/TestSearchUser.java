package businesslogic.test.Admin;

import java.util.ArrayList;

import junit.framework.TestCase;
import State.InstitutionType;
import State.UserRole;
import VO.UserVO;
import businesslogic.Impl.Admin.AdminController;

public class TestSearchUser extends TestCase {
	
	public void testSearchUser() {
		
		AdminController admin = new AdminController();
		ArrayList<String> requirement=new ArrayList<String>();
		requirement.add("025100003");
//		ArrayList<UserVO> user=new ArrayList<UserVO>();
//		user.add(new UserVO("admin", "永煌", UserRole.courier,"男" ,10 ,InstitutionType.BusinessLobby, "南京"));
		
		UserVO u = admin.searchUser(requirement).get(0);
		
		System.out.println(u.getAge()+u.getCity());
		
		assertEquals("025100003", admin.searchUser(requirement).get(0).getId());
	}
}
