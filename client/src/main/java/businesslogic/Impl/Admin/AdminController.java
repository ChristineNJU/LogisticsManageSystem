package businesslogic.Impl.Admin;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.UserVO;
import businesslogic.Service.Admin.AdminService;
import businesslogic.SystemLog.SystemLog;

public class AdminController implements AdminService{
	
	@Override
	public UpdateState updateUser(UserVO user) {
		// TODO Auto-generated method stub
		AdminImpl adminUser=new AdminImpl();
		UpdateState state = adminUser.updateUser(user);
		if(state==UpdateState.SUCCESS){
			SystemLog.addLog("更新系统账户");
		}
		return state;
	}

	@Override
	public ArrayList<UserVO> searchUser(ArrayList<String> requirement) {
		// TODO Auto-generated method stub
		AdminImpl adminUser=new AdminImpl();
		return adminUser.searchUser(requirement);
	}

	@Override
	public DeleteState deleteUser(UserVO user) {
		// TODO Auto-generated method stub
		AdminImpl adminUser=new AdminImpl();
		DeleteState state = adminUser.deleteUser(user);
		if(state==DeleteState.SUCCESS){
			SystemLog.addLog("删除系统账户");
		}
		return state;
	}

	@Override
	public AddState addUser(UserVO user) {
		// TODO Auto-generated method stub
		AdminImpl adminUser=new AdminImpl();
		AddState state = adminUser.addUser(user);
		if(state==AddState.SUCCESS){
			SystemLog.addLog("添加系统账户");
		}
		return state;
	}

}
