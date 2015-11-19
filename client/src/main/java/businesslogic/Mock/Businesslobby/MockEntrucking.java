package businesslogic.Mock.Businesslobby;

import businesslogic.Impl.Businesslobby.EntruckingImpl;
import businesslogic.VO.EntruckingVO;
import data.State.AddState;

public class MockEntrucking extends EntruckingImpl{

	@Override
	public AddState entrucking(EntruckingVO entrucking) {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}
	
}
