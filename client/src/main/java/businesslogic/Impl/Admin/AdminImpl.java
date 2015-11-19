package businesslogic.Impl.Admin;

import java.rmi.Naming;
import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.UserVO;
import businesslogic.Service.Admin.AddUserService;
import businesslogic.Service.Admin.DeleteUserService;
import businesslogic.Service.Admin.SearchUserService;
import businesslogic.Service.Admin.UpdateUserService;
import data.Service.Update.UpdateService;
import data.RMIHelper.*;

public class AdminImpl implements AddUserService,DeleteUserService,SearchUserService,UpdateUserService{

	@Override
	public UpdateState updateUser(UserVO user, String field, String value) {
		// TODO Auto-generated method stub
		UpdateState state=UpdateState.SUCCESS;
		
		try{
			
			UpdateService updateService=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			
			
		} catch(Exception ex){
			state=UpdateState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		return state;
	}

	@Override
	public ArrayList<UserVO> searchUser(String id) {
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
