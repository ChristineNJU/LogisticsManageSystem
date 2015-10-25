package businesslogic.Service.Finance;

import businesslogic.VO.AccountVO;
import data.State.UpdateState;

public interface UpdateAccountService {
	public UpdateState updateAccount(AccountVO account, String field, String value);
}
