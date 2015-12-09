package businesslogic.Service.Repository;

import java.util.ArrayList;

import State.AddState;
import VO.BalanceVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AddBalanceService.
 */
public interface AddBalanceService {
	
	/**
	 * Adds the balance.
	 *
	 * @param balance the balance
	 * @return the adds the state
	 */
	public AddState addBalance(ArrayList<BalanceVO> balance);
}
