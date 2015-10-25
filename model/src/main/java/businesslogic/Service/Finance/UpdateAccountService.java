package businesslogic.Service.Finance;

import businesslogic.VO.AccountVO;
import dataservice.State.UpdateState;

public interface UpdateAccountService {
	public UpdateState updateAccount(AccountVO account, String field, String value);
}
