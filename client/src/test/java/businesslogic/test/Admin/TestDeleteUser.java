package businesslogic.test.Admin;

import junit.framework.TestCase;
import State.DeleteState;
import State.InstitutionType;
import State.UserRole;
import VO.UserVO;
import businesslogic.Impl.Admin.AdminController;

public class TestDeleteUser extends TestCase {

	public void testDeleteUser() {
		
		AdminController admin = new AdminController();
		UserVO user1=new UserVO("025100002", "黄勇", UserRole.courier,"男" ,10 ,InstitutionType.BusinessLobby, "南京");
		assertEquals(DeleteState.SUCCESS, admin.deleteUser(user1));
		UserVO user2=new UserVO("025100003", "黄勇", UserRole.courier,"男" ,10 ,InstitutionType.BusinessLobby, "南京");
        assertEquals(DeleteState.FAIL, admin.deleteUser(user2));	
	}
}
