package businesslogic.Service.Finance;

import State.DeleteState;
import VO.AccountVO;

public interface DeleteAccountService {
	public DeleteState deleteAccount(AccountVO account);
}
