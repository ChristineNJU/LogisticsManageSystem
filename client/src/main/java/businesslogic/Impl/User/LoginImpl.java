package businesslogic.Impl.User;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.UserPO;
import State.LoginState;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchUserService;

public class LoginImpl {
	
	public LoginState login(String userName, String password) {
		LoginState state=LoginState.SUCCESS;
		try{
			SearchUserService searchUser=(SearchUserService)Naming.lookup(RMIHelper.SEARCH_USER_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("name='"+userName+"'");
			ArrayList<UserPO> result=searchUser.searchUser(requirement);
			
			if(result.isEmpty()){
				state=LoginState.WRONGID;
			}
			
			else{
				boolean isFind=false;
				for(int i=0;i<result.size();i++){
					if(result.get(i).getPassword().equals(password)){
						isFind=true;
						break;
					}
					else
						isFind=false;
				}
				
				if(isFind){
					state=LoginState.SUCCESS;
				}
				else{
					state=LoginState.WRONGPW;
				}
			}
		} catch(Exception ex){
			state=LoginState.CONNECTERROR;
			ex.printStackTrace();
		}
		return state;
	}

}
