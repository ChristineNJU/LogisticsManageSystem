package businesslogic.Service.Finance;

import java.util.ArrayList;

import VO.AccountVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface GetAccountService.
 */
public interface GetAccountService {
	
	/**
	 * Search account.
	 *
	 * @param name the name
	 * @return the array list
	 */
	public ArrayList<AccountVO> searchAccount(String name);
}
