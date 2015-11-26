package businesslogic.Service.Repository;

import java.util.ArrayList;

import State.AddState;
import VO.StockTakingVO;

public interface StockTakingConfirmService {
	public AddState stockTakingConfirm(ArrayList<StockTakingVO> stockList);
}
