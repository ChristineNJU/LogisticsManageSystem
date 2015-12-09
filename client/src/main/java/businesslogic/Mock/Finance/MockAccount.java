package businesslogic.Mock.Finance;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.AccountVO;
import businesslogic.Impl.Finance.AccountImpl;

public class MockAccount extends AccountImpl{
	

	@Override
	public ArrayList<AccountVO> searchAccount(String name) {
		// TODO Auto-generated method stub
		return new ArrayList<AccountVO>();
	}

	@Override
	public DeleteState deleteAccount(AccountVO account) {
		// TODO Auto-generated method stub
		return DeleteState.FAIL;
	}

	@Override
	public AddState addAccount(AccountVO account) {
		// TODO Auto-generated method stub
		return AddState.FAIL
				;
	}


}
