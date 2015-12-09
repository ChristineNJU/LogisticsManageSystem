package businesslogic.Service.Finance;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.AccountVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AccountService.
 */
public interface AccountService {
	
	/**
	 * Adds the account.
	 *
	 * @param account the account
	 * @return the adds the state
	 */
	public AddState addAccount(AccountVO account);
	
	/**
	 * Delete account.
	 *
	 * @param account the account
	 * @return the delete state
	 */
	public DeleteState deleteAccount(AccountVO account);
	
	/**
	 * Search account.
	 *
	 * @param name the name
	 * @return the array list
	 */
	public ArrayList<AccountVO> searchAccount(String name);
	
	/**
	 * Update account.
	 *
	 * @param account the account
	 * @return the update state
	 */
	public UpdateState updateAccount(AccountVO account);
}
