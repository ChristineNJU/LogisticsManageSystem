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

public class AccountController implements AddAccountService, GetAccountService, DeleteAccountService, UpdateAccountService{

	AddAccountImpl addAccount=new AddAccountImpl();
	GetAccountImpl getAccount=new GetAccountImpl();
	DeleteAccountImpl deleteAccount=new DeleteAccountImpl();
	UpdateAccountImpl updateAccount=new UpdateAccountImpl();
	
	@Override
	public UpdateState updateAccount(AccountVO account, String field,
			String value) {
		// TODO Auto-generated method stub
		return updateAccount.updateAccount(account, field, value);
	}

	@Override
	public DeleteState deleteAccount(AccountVO account) {
		// TODO Auto-generated method stub
		return deleteAccount.deleteAccount(account);
	}

	@Override
	public ArrayList<AccountVO> searchAccount(String name) {
		// TODO Auto-generated method stub
		return getAccount.searchAccount(name);
	}

	@Override
	public AddState addAccount(AccountVO account) {
		// TODO Auto-generated method stub
		return addAccount.addAccount(account);
	}

}
