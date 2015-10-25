package businesslogic.Service.Finance;

import businesslogic.VO.AccountVO;
import dataservice.State.DeleteState;

public interface DeleteAccountService {
	public DeleteState deleteAccount(AccountVO account);
}
