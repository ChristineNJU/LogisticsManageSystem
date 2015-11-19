package businesslogic.Mock.Repository;

import businesslogic.Impl.Reponsitory.StockTakingConfirmImpl;
import data.State.AddState;

public class MockStockTaking extends StockTakingConfirmImpl{

	@Override
	public AddState stockTakingConfirm() {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}
}
