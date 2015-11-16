package businesslogic.Mock.User;

import businesslogic.Impl.User.ResetPasswordImpl;
import businesslogic.State.ResetState;

public class MockResetPasswordImpl extends ResetPasswordImpl {
	
	public ResetState reset(String userName, String oldPassword,
			String newPassword) {
		
		return ResetState.SUCCESS;
	}
}
