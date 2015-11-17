package businesslogic.Service.Finance;

import VO.AccountVO;
import data.State.DeleteState;

public interface DeleteAccountService {
	public DeleteState deleteAccount(AccountVO account);
}
