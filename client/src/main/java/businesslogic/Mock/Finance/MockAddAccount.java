package businesslogic.Mock.Finance;

import businesslogic.Impl.Finance.AddAccountImpl;
import businesslogic.VO.AccountVO;
import data.State.AddState;

public class MockAddAccount extends AddAccountImpl{
	
	public AddState addAccount(AccountVO account) {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}
	
}
