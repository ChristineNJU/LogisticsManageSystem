package test.Stub.businesslogic;

import java.rmi.RemoteException;

import test.Stub.data.UpdateService_Stub;
import PO.UserPO;
import State.LoginState;
import State.ResetState;
import businesslogic.Service.User.LoginService;
import businesslogic.Service.User.ResetPasswordService;

public class UserBlService_Stub implements LoginService,ResetPasswordService{
	/*-------------------------------------------
	 用户确认登录
	---------------------------------------------*/
	public LoginState login(String account, String password){
		System.out.println("登录成功");
		LoginState state=LoginState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	 用户确认修改密码
	---------------------------------------------*/
	public ResetState reset(String account, String oldPassword, String newPassword){
		System.out.println("修改成功");
		UserPO user=new UserPO(account, newPassword, null, null, 20, null, null, null, "user_info");
		
		try {
			System.out.println("Update_Stub"+new UpdateService_Stub().update(user));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResetState state=ResetState.SUCCESS;
		return state;
		
	}
	
}
