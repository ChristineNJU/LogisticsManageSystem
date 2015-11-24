package businesslogic.Mock.Repository;

import java.util.ArrayList;

import VO.StockTakingVO;
import businesslogic.Impl.Repository.StockTakingImpl;

public class MockStockTakingConfirm extends StockTakingImpl{

	@Override
	public ArrayList<StockTakingVO> stockTaking() {
		// TODO Auto-generated method stub
		return new ArrayList<StockTakingVO>();
	}
}
