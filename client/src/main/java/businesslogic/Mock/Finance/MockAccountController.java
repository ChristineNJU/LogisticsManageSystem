package businesslogic.Mock.Finance;

import java.util.ArrayList;

import businesslogic.Impl.Finance.AccountController;
import businesslogic.VO.AccountVO;
import data.State.AddState;
import data.State.DeleteState;
import data.State.UpdateState;

public class MockAccountController extends AccountController{
	@Override
	public UpdateState updateAccount(AccountVO account, String field,
			String value) {
		// TODO Auto-generated method stub
		MockUpdateAccount updateAccount=new MockUpdateAccount();
		return updateAccount.updateAccount(account, field, value);
	}

	@Override
	public DeleteState deleteAccount(AccountVO account) {
		// TODO Auto-generated method stub
		MockDeleteAccount deleteAccount=new MockDeleteAccount();
		return deleteAccount.deleteAccount(account);
	}

	@Override
	public ArrayList<AccountVO> searchAccount(String name) {
		// TODO Auto-generated method stub
		MockGetAccount getAccount=new MockGetAccount();
		return getAccount.searchAccount(name);
	}

	@Override
	public AddState addAccount(AccountVO account) {
		// TODO Auto-generated method stub
		MockAddAccount addAccount=new MockAddAccount();
		return addAccount.addAccount(account);
	}
}
