package businesslogic.Impl.User;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.UserPO;
import State.ResetState;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchUserService;
import data.Service.Update.UpdateService;

public class ResetPasswordImpl {

	public ResetState reset(String userName, String oldPassword,
			String newPassword) {
		
		ResetState state=ResetState.SUCCESS;
		
		try{
			
			SearchUserService searchUser=(SearchUserService)Naming.lookup(RMIHelper.SEARCH_USER_IMPL);
			
			ArrayList<String> requirement=new ArrayList<String>();
			
			requirement.add("id ="+userName);
			
			ArrayList<UserPO> result=searchUser.searchUser(requirement);
			
			if(result.isEmpty()){
				state=ResetState.WRONGID;
			}
			
			else{
				boolean isFind=false;
				int p=0;
				for(p=0;p<result.size();p++){
					if(result.get(p).getPassword().equals(oldPassword)){
						isFind=true;
						break;
					}
					else
						isFind=false;
				}
				
				if(isFind){
					UserPO newUser=result.get(p);
					
					try{
						
						
						UpdateService update =(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
						update.update(newUser, "password", newPassword);
						state=ResetState.SUCCESS;
						
						
					} catch(Exception ex){
						state=ResetState.CONNECTERROR;
						System.out.println(ex.getMessage());
						ex.printStackTrace();
						
					}
					
				}
				else{
					state=ResetState.WRONGPW;
				}
			}
			
		} catch(Exception ex){
			state=ResetState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return state;
	}
	
}
