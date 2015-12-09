package businesslogic.Service.Finance;

import State.AddState;
import VO.AccountVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AddAccountService.
 */
public interface AddAccountService {
	
	/**
	 * Adds the account.
	 *
	 * @param account the account
	 * @return the adds the state
	 */
	public AddState addAccount(AccountVO account);
}
