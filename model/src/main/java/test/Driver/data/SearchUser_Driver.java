package test.Driver.data;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.UserPO;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchUserService;

public class SearchUser_Driver {
	

	public static void main(String[] args) {
		
		try {
			SearchUserService search_user = (SearchUserService) Naming.lookup(RMIHelper.SEARCH_USER_IMPL);
		
			ArrayList<String> requirement = new ArrayList<String>();
			
			requirement.add("User_ID LIKE '%admin%'");
			
			ArrayList<UserPO> list = search_user.searchUser(requirement);
			
			UserPO user = list.get(0);
			
			System.out.println(user.getName());
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
