package businesslogic.test.Admin;

import State.InstitutionType;
import State.UserRole;
import VO.UserVO;
import businesslogic.Impl.Admin.AdminController;

public class Add {
	public static void main(String[] args){
		
		AdminController admin = new AdminController();
		admin.addUser(new UserVO("025100003", "yh", UserRole.courier,"男" ,10 ,InstitutionType.BusinessLobby, "南京"));
//Hey I am programming on iPad

	}
}
