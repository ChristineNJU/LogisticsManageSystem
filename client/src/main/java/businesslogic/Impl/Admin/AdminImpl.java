package businesslogic.Impl.Admin;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.UserPO;
import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.UserVO;
import businesslogic.Service.Admin.AddUserService;
import businesslogic.Service.Admin.DeleteUserService;
import data.Service.Search.*;
import businesslogic.Service.Admin.UpdateUserService;
import businesslogic.Service.Admin.GetUserService;
import data.RMIHelper.RMIHelper;
import data.Service.Update.UpdateService;

public class AdminImpl implements AddUserService,DeleteUserService,GetUserService,UpdateUserService{

	@Override
	public UpdateState updateUser(UserVO user, String field, String value) {
		// TODO Auto-generated method stub
		UpdateState state=UpdateState.SUCCESS;
		
		try{
			
			SearchUserService userSearch=(SearchUserService) Naming.lookup(RMIHelper.SEARCH_USER_IMPL);
			UpdateService updateService=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("id="+user.getId());
			ArrayList<UserPO> result=userSearch.searchUser(requirement);
			for(int i=0;i<result.size();i++){
				
			}
			
		} catch(Exception ex){
			state=UpdateState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		return state;
	}

	@Override
	public ArrayList<UserVO> searchUser(ArrayList<String> requirement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteState deleteUser(UserVO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddState addUser(UserVO user) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
