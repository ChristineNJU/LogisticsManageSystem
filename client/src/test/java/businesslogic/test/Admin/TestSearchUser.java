package businesslogic.test.Admin;

import java.util.ArrayList;

import junit.framework.TestCase;
import State.AddState;
import State.DeleteState;
import State.InstitutionType;
import State.UserRole;
import VO.UserVO;
import businesslogic.Impl.Admin.AdminController;

public class TestSearchUser extends TestCase {
	
	public void testSearchUser() {
		
		AdminController admin = new AdminController();
		assertEquals(AddState.SUCCESS, admin.addUser(new UserVO("025100004", "yh", UserRole.courier,"男" ,10 ,InstitutionType.BusinessLobby, "南京")));
		
		ArrayList<String> requirement=new ArrayList<String>();
		requirement.add("025100004");
//		ArrayList<UserVO> user=new ArrayList<UserVO>();
//		user.add(new UserVO("admin", "永煌", UserRole.courier,"男" ,10 ,InstitutionType.BusinessLobby, "南京"));
		
//		UserVO u = admin.searchUser(requirement).get(0);
		
//		System.out.println(u.getAge()+u.getCity());
		
		assertEquals(DeleteState.SUCCESS, admin.deleteUser(new UserVO("025100004", "yh", UserRole.courier,"男" ,10 ,InstitutionType.BusinessLobby, "南京")));
		
		assertEquals(null, admin.searchUser(requirement).get(0));
	}
}
