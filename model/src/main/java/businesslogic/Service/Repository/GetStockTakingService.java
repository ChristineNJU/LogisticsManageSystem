package businesslogic.Service.Repository;

import java.util.ArrayList;

import PO.WareHousePO;
import VO.StockTakingVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface GetStockTakingService.
 */
public interface GetStockTakingService {
	
	/**
	 * Gets the stock taking.
	 *
	 * @return the stock taking
	 */
	public ArrayList<StockTakingVO> getStockTaking();
}
