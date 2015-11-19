package businesslogic.Mock.Businesslobby;

import businesslogic.Impl.Businesslobby.GatheringImpl;
import businesslogic.VO.GatheringVO;
import data.State.AddState;

public class MockGathering extends GatheringImpl{

	@Override
	public AddState gathering(GatheringVO gathering) {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}
}
