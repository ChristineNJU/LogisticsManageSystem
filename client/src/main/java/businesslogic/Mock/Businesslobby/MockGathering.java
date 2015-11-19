package businesslogic.Mock.Businesslobby;

import State.AddState;
import VO.GatheringVO;
import businesslogic.Impl.Businesslobby.GatheringImpl;

public class MockGathering extends GatheringImpl{

	@Override
	public AddState gathering(GatheringVO gathering) {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}
}
