package businesslogic.test.Admin;

import State.InstitutionType;
import State.UserRole;
import VO.UserVO;
import businesslogic.Impl.Admin.AdminController;

public class TestAddUserMain {
public static void main(String[] args){
	AdminController admin = new AdminController();
	
 admin.addUser(new UserVO("025100001", "永煌", UserRole.courier,"男" ,10 ,InstitutionType.BusinessLobby, "南京"));
}
}
