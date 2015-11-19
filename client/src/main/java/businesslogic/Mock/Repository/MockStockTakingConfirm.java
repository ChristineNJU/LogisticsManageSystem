package businesslogic.Mock.Repository;

import java.util.ArrayList;

import businesslogic.Impl.Reponsitory.StockTakingImpl;
import businesslogic.VO.StockTakingVO;

public class MockStockTakingConfirm extends StockTakingImpl{

	@Override
	public ArrayList<StockTakingVO> stockTaking() {
		// TODO Auto-generated method stub
		return new ArrayList<StockTakingVO>();
	}
}
