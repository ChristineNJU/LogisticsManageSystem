package businesslogic.Mock.Repository;

import State.AddState;
import businesslogic.Impl.Reponsitory.StockTakingConfirmImpl;

public class MockStockTaking extends StockTakingConfirmImpl{

	@Override
	public AddState stockTakingConfirm() {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}
}
