package businesslogic.Mock.Businesslobby;

import java.util.ArrayList;

import State.AddState;
import VO.ArrivalVO;
import businesslogic.Impl.Businesslobby.ArrivalImpl;

public class MockArrival extends ArrivalImpl{

	@Override
	public AddState arrival(ArrayList<ArrivalVO> arrival) {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}
}
