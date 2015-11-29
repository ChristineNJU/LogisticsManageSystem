package businesslogic.Service.User;

import State.ResetState;

/**
* 密码重设接口
*
* @author 尹子越
* @version 1.0.0
*/
public interface ResetPasswordService {
	
	/**
	 * 修改密码用户名密码,新旧密码比对接口
	 * 
	 * @param userName 用户名
 	 * @param oldPassword 旧密码
 	 * @param newPassword 新密码
 	 * @return 修改状态
	 * */
	public ResetState reset(String userName, String oldPassword, String newPassword);

}
