package businesslogic.Mock.Finance;

import data.State.UpdateState;
import businesslogic.Impl.Finance.UpdateAccountImpl;
import businesslogic.VO.AccountVO;

public class MockUpdateAccount extends UpdateAccountImpl{
	public UpdateState updateAccount(AccountVO account, String field,
			String value) {
		// TODO Auto-generated method stub
		return UpdateState.SUCCESS;
	}
}
