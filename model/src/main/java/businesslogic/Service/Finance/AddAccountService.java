package businesslogic.Service.Finance;

import VO.AccountVO;
import data.State.AddState;

public interface AddAccountService {
	public AddState addAccount(AccountVO account);
}
