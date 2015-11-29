package businesslogic.Service.Repository;

import java.util.ArrayList;

import State.OutputState;
import VO.StockTakingVO;

public interface StockTakingExcelService {
	public OutputState stockTakingExcel(ArrayList<StockTakingVO> stockTaking);
}
