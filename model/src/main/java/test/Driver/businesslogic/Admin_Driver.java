package test.Driver.businesslogic;

import java.util.ArrayList;

import test.Stub.businesslogic.AdminBlService_Stub;
import VO.UserVO;

public class Admin_Driver {
	
	public void drive(AdminBlService_Stub Admin){
		
		UserVO user=new UserVO(null, null, null, null, 0, null, null);
		System.out.println(Admin.addUser(user));
		System.out.println();
		
		System.out.println(Admin.updateUser(user,null,null));
		System.out.println();
		
		System.out.println(Admin.deleteUser(user));
		System.out.println();
		
		ArrayList<UserVO> list=Admin.searchUser(null);
		System.out.println();
		
		for(int i=0;i<list.size();i++){
			System.out.println((list.get(i)).getId());
			System.out.println((list.get(i)).getName());
			System.out.println((list.get(i)).getRole());
			System.out.println();
		}
		
		
	}
	
	
}
