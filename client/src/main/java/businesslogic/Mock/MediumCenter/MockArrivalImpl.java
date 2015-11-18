package businesslogic.Mock.MediumCenter;

import java.util.ArrayList;

import State.AddState;
import VO.ArrivalVO;
import businesslogic.Impl.MediumCenter.ArrivalImpl;

public class MockArrivalImpl extends ArrivalImpl{

	@Override
	public AddState arrival(ArrayList<ArrivalVO> arrival) {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}

}
