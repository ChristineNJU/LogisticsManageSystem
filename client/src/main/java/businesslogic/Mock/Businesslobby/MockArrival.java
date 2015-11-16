package businesslogic.Mock.Businesslobby;

import java.util.ArrayList;

import businesslogic.Impl.Businesslobby.ArrivalImpl;
import businesslogic.VO.ArrivalVO;
import data.State.AddState;

public class MockArrival extends ArrivalImpl{

	@Override
	public AddState arrival(ArrayList<ArrivalVO> arrival) {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}
}
