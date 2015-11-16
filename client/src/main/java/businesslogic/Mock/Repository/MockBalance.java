package businesslogic.Mock.Repository;

import businesslogic.Impl.Reponsitory.BalanceImpl;
import data.State.AddState;

public class MockBalance extends BalanceImpl{

	@Override
	public AddState balance() {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}
	
}
