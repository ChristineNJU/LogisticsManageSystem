package businesslogic.Service.Finance;

import businesslogic.VO.AccountVO;
import data.State.DeleteState;

public interface DeleteAccountService {
	public DeleteState deleteAccount(AccountVO account);
}
