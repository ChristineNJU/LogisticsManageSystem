package businesslogic.Service.Finance;

import businesslogic.VO.AccountVO;
import dataservice.State.AddState;

public interface AddAccountService {
	public AddState addAccount(AccountVO account);
}
