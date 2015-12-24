package businesslogic.test.Admin;

import junit.framework.TestCase;
import State.AddState;
import State.DeleteState;
import State.InstitutionType;
import State.UserRole;
import VO.UserVO;
import businesslogic.Impl.Admin.AdminController;

public class TestAddUser extends TestCase {
	
	public void testAddUser() {
		
		AdminController admin = new AdminController();
		
		assertEquals(AddState.SUCCESS, admin.addUser(new UserVO("025100004", "yh", UserRole.courier,"男" ,10 ,InstitutionType.BusinessLobby, "南京")));
		assertEquals(AddState.FAIL, admin.addUser(new UserVO("025100004", "yh", UserRole.courier,"男" ,10 ,InstitutionType.BusinessLobby, "南京")));
		assertEquals(DeleteState.SUCCESS, admin.deleteUser(new UserVO("025100004", "yh", UserRole.courier,"男" ,10 ,InstitutionType.BusinessLobby, "南京")));
		
	}
}
