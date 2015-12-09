package businesslogic.Service.Finance;

import State.DeleteState;
import VO.AccountVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface DeleteAccountService.
 */
public interface DeleteAccountService {
	
	/**
	 * Delete account.
	 *
	 * @param account the account
	 * @return the delete state
	 */
	public DeleteState deleteAccount(AccountVO account);
}
