package businesslogic.Mock.Businesslobby;

import java.util.ArrayList;

import businesslogic.Impl.Businesslobby.GetNeedEntruckingImpl;
import businesslogic.Impl.Businesslobby.GetNeedGatheringImpl;
import businesslogic.VO.EntruckingVO;
import businesslogic.VO.GatheringVO;

public class MockGetNeedGathering extends GetNeedGatheringImpl{

	@Override
	public ArrayList<GatheringVO> getNeedGathering() {
		// TODO Auto-generated method stub
		return new ArrayList<GatheringVO>();
	}
}
