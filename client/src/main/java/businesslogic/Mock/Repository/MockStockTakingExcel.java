package businesslogic.Mock.Repository;

import State.OutputState;
import businesslogic.Impl.Reponsitory.StockTakingExcelImpl;

public class MockStockTakingExcel extends StockTakingExcelImpl{

	@Override
	public OutputState stockTakingExcel() {
		// TODO Auto-generated method stub
		return OutputState.SUCCESS;
	}
}
