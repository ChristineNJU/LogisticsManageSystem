package businesslogic.Service.User;

import State.ResetState;

public interface ResetPasswordService {
	public ResetState reset(String userName, String oldPassword, String newPassword);

}
