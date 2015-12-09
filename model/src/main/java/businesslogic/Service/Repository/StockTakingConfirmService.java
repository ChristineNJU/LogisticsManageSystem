package businesslogic.Service.Repository;

import java.util.ArrayList;

import State.AddState;
import VO.StockTakingVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface StockTakingConfirmService.
 */
public interface StockTakingConfirmService {
	
	/**
	 * Stock taking confirm.
	 *
	 * @param stockList the stock list
	 * @return the adds the state
	 */
	public AddState stockTakingConfirm(ArrayList<StockTakingVO> stockList);
}
