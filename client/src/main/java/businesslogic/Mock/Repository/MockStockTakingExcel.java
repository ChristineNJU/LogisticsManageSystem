package businesslogic.Mock.Repository;

import businesslogic.Impl.Reponsitory.StockTakingExcelImpl;
import businesslogic.State.OutputState;

public class MockStockTakingExcel extends StockTakingExcelImpl{

	@Override
	public OutputState stockTakingExcel() {
		// TODO Auto-generated method stub
		return OutputState.SUCCESS;
	}
}
