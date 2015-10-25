package test.stub;

import businesslogic.State.LoginState;
import businesslogic.State.ResetState;

public class UserBlService_Stub {
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
		ResetState state=ResetState.SUCCESS;
		return state;
		
	}
}
