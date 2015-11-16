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

	
	@Override
	public UpdateState updateAccount(AccountVO account, String field,
			String value) {
		// TODO Auto-generated method stub
		UpdateAccountImpl updateAccount=new UpdateAccountImpl();
		return updateAccount.updateAccount(account, field, value);
	}

	@Override
	public DeleteState deleteAccount(AccountVO account) {
		// TODO Auto-generated method stub
		DeleteAccountImpl deleteAccount=new DeleteAccountImpl();
		return deleteAccount.deleteAccount(account);
	}

	@Override
	public ArrayList<AccountVO> searchAccount(String name) {
		// TODO Auto-generated method stub
		GetAccountImpl getAccount=new GetAccountImpl();
		return getAccount.searchAccount(name);
	}

	@Override
	public AddState addAccount(AccountVO account) {
		// TODO Auto-generated method stub
		AddAccountImpl addAccount=new AddAccountImpl();
		return addAccount.addAccount(account);
	}

}
