package businesslogic.Impl.Finance;

import java.util.ArrayList;

import data.State.AddState;
import data.State.DeleteState;
import data.State.UpdateState;
import businesslogic.Service.Finance.AddAccountService;
import businesslogic.Service.Finance.DeleteAccountService;
import businesslogic.Service.Finance.GetAccountService;
import businesslogic.Service.Finance.UpdateAccountService;
import businesslogic.VO.AccountVO;

public class AccountImpl implements AddAccountService, DeleteAccountService, GetAccountService, UpdateAccountService{

	@Override
	public UpdateState updateAccount(AccountVO account, String field,
			String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AccountVO> searchAccount(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteState deleteAccount(AccountVO account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddState addAccount(AccountVO account) {
		// TODO Auto-generated method stub
		return null;
	}

}
