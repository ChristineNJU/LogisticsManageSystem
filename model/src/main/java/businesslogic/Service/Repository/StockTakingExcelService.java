package businesslogic.Service.Repository;

import java.util.ArrayList;

import State.OutputState;
import VO.StockTakingVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface StockTakingExcelService.
 */
public interface StockTakingExcelService {
	
	/**
	 * Stock taking excel.
	 *
	 * @param stockTaking the stock taking
	 * @return the output state
	 */
	public OutputState stockTakingExcel(ArrayList<StockTakingVO> stockTaking);
}
