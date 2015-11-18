package businesslogic.Service.Finance;

import State.AddState;
import VO.AccountVO;

public interface AddAccountService {
	public AddState addAccount(AccountVO account);
}
