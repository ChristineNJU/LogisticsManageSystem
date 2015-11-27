package businesslogic.test.Admin;

import junit.framework.TestCase;
import State.InstitutionType;
import State.UpdateState;
import State.UserRole;
import VO.UserVO;
import businesslogic.Impl.Admin.AdminController;

public class TestUpdateUser extends TestCase {
	
	public void testUpdateUser() {
		
		AdminController admin = new AdminController();
		UserVO user1=new UserVO("025100001", "hy", UserRole.courier,"男" ,10 ,InstitutionType.BusinessLobby, "南京");
		assertEquals(UpdateState.SUCCESS, admin.updateUser(user1));
//		UserVO user2=new UserVO("025100004", "黄勇", UserRole.courier,"男" ,10 ,InstitutionType.BusinessLobby, "南京");
//        assertEquals(UpdateState.NOTFOUND, admin.updateUser(user2));	
	}
}
