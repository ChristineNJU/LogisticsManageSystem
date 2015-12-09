package businesslogic.Impl.User;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.UserPO;
import State.ResetState;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchUserService;
import data.Service.Update.UpdateService;

// TODO: Auto-generated Javadoc
/**
 * 密码修改的实现.
 *
 * @author 张晨剑
 * @version 1.0.0
 */
public class ResetPasswordImpl {
	
	/**
	 * 密码的修改方法,包括密码的比对和修改.
	 *
	 * @param userName 用户名
	 * @param oldPassword 旧密码
	 * @param newPassword 新密码
	 * @return 重设状态ResetState
	 * @see SearchUserService#searchUser(ArrayList)
	 * @see UpdateService#update(PO.PO)
	 */
	public ResetState reset(String userName, String oldPassword,
			String newPassword) {
		
		ResetState state=ResetState.SUCCESS;
		
		try{
			
			SearchUserService searchUser=(SearchUserService)Naming.lookup(RMIHelper.SEARCH_USER_IMPL);
			
			ArrayList<String> requirement=new ArrayList<String>();
			
			requirement.add("id='"+userName+"'");
			
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
						UserPO temp=new UserPO(newUser.getID(),newPassword,newUser.getName(),newUser.getSex(),newUser.getAge(),newUser.getInstitution(),newUser.getCity(),newUser.getRole(),newUser.getURL());
						update.update(temp);
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
