package businesslogic.Mock.User;

import State.ResetState;
import businesslogic.Impl.User.ResetPasswordImpl;

public class MockResetPasswordImpl extends ResetPasswordImpl {
	
	public ResetState reset(String userName, String oldPassword,
			String newPassword) {
		
		return ResetState.SUCCESS;
	}
}
