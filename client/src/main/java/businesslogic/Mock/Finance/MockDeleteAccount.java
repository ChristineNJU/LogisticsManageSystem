package businesslogic.Mock.Finance;

import data.State.DeleteState;
import businesslogic.Impl.Finance.DeleteAccountImpl;
import businesslogic.VO.AccountVO;

public class MockDeleteAccount extends DeleteAccountImpl{
	public DeleteState deleteAccount(AccountVO account) {
		// TODO Auto-generated method stub
		return DeleteState.SUCCESS;
	}
}
