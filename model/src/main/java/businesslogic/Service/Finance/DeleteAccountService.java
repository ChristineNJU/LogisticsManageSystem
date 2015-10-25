package businesslogic.Service.Finance;

import dataservice.State.DeleteState;

public interface DeleteAccountService {
	public DeleteState deleteAccount(AccountVO account);
}
