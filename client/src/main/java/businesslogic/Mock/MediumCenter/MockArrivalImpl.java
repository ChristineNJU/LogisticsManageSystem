package businesslogic.Mock.MediumCenter;

import java.util.ArrayList;

import data.State.AddState;
import VO.ArrivalVO;
import businesslogic.Impl.MediumCenter.ArrivalImpl;
import data.State.*;

public class MockArrivalImpl extends ArrivalImpl{

	@Override
	public AddState arrival(ArrayList<ArrivalVO> arrival) {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}

}
