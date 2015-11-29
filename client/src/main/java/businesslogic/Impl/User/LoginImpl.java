package businesslogic.Impl.User;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.UserPO;
import State.LoginState;
import State.UserRole;
import businesslogic.SystemLog.SystemLog;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchUserService;

public class LoginImpl {
	
	public LoginState login(String userName, String password) {
		LoginState state=LoginState.SUCCESS;
		try{
			SearchUserService searchUser=(SearchUserService)Naming.lookup(RMIHelper.SEARCH_USER_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("ID='"+userName+"'");
			ArrayList<UserPO> result=searchUser.searchUser(requirement);
			
			if(result.isEmpty()){
				state=LoginState.WRONGID;
				System.out.println("wrongID");
			}
			
			else{
				boolean isFind=false;
//				for(int i=0;i<result.size();i++){
//					if(result.get(i).getPassword().equals(password)){
//						isFind=true;
//						break;
//					}
//					else
//						isFind=false;
//				}
				UserPO user = result.get(0);
								
				if(user.getPassword().equals(password)){
					isFind = true;
					
					SystemLog.setOperatiorID(user.getID());
					if(user.getRole()==UserRole.courier){
						String id = user.getID();
						SystemLog.setInstitutionId(id.substring(0, id.length()-2));
					}else if(user.getRole()==UserRole.businessAgent){
						String id = user.getID();
						SystemLog.setInstitutionId(id.substring(0, id.length()-1));
					}else if(user.getRole()==UserRole.mediumAgent){
						String id = user.getID();
						SystemLog.setInstitutionId(id.substring(0, id.length()-2));
					}else if(user.getRole()==UserRole.repository){
						String id = user.getID();
						SystemLog.setInstitutionId(id.substring(0, id.length()-1));
					}else{
						SystemLog.setInstitutionId("");
					}
				}else{
					isFind = false;
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
