package businesslogic.Mock.Finance;

import java.util.ArrayList;

import data.State.AddState;
import VO.CostVO;
import businesslogic.Impl.Finance.CostImpl;

public class MockCost extends CostImpl{
	@Override
	public ArrayList<CostVO> searchCost(String time_start, String time_end) {
		// TODO Auto-generated method stub
		return new ArrayList<CostVO>();
	}

	@Override
	public AddState addCost(CostVO cost) {
		// TODO Auto-generated method stub
		return AddState.FAIL;
	}
}
