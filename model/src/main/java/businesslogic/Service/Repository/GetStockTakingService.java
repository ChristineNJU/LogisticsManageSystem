package businesslogic.Service.Repository;

import java.util.ArrayList;

import PO.WareHousePO;
import VO.StockTakingVO;

public interface GetStockTakingService {
	public ArrayList<StockTakingVO> getStockTaking();
}
