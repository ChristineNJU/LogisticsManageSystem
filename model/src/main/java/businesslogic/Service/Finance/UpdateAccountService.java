package businesslogic.Service.Finance;

import State.UpdateState;
import VO.AccountVO;

public interface UpdateAccountService {
	public UpdateState updateAccount(AccountVO account, String field, String value);
}
