package businesslogic.Mock.Repository;

import State.AddState;
import businesslogic.Impl.Repository.BalanceImpl;

public class MockBalance extends BalanceImpl{

	@Override
	public AddState balance() {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}
	
}
