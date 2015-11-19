package businesslogic.Mock.Businesslobby;

import java.util.ArrayList;

import businesslogic.Impl.Businesslobby.GetNeedEntruckingImpl;
import businesslogic.Impl.Businesslobby.GetNeedGatheringImpl;
import businesslogic.VO.EntruckingVO;

public class MockGetNeedEntrucking extends GetNeedEntruckingImpl{

	@Override
	public ArrayList<EntruckingVO> getNeedEntrucking() {
		// TODO Auto-generated method stub
		return new ArrayList<EntruckingVO>();
	}
}
