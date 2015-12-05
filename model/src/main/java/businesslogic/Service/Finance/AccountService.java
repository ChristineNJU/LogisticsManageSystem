package businesslogic.Service.Finance;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.AccountVO;

public interface AccountService {
	public AddState addAccount(AccountVO account);
	public DeleteState deleteAccount(AccountVO account);
	public ArrayList<AccountVO> searchAccount(String name);
	public UpdateState updateAccount(AccountVO account);
}
