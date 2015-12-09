package businesslogic.Service.Finance;

import State.UpdateState;
import VO.AccountVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface UpdateAccountService.
 */
public interface UpdateAccountService {
	
	/**
	 * Update account.
	 *
	 * @param account the account
	 * @return the update state
	 */
	public UpdateState updateAccount(AccountVO account);
}
