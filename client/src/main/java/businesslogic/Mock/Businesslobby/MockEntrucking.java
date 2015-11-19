package businesslogic.Mock.Businesslobby;

import State.AddState;
import VO.EntruckingVO;
import businesslogic.Impl.Businesslobby.EntruckingImpl;

public class MockEntrucking extends EntruckingImpl{

	@Override
	public AddState entrucking(EntruckingVO entrucking) {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}
	
}
