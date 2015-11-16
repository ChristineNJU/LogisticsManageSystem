package businesslogic.Mock.Finance;

import java.util.ArrayList;

import businesslogic.Impl.Finance.CostController;
import businesslogic.VO.CostVO;
import data.State.AddState;

public class MockCostController extends CostController{
	@Override
	public ArrayList<CostVO> searchCost(String time_start, String time_end) {
		// TODO Auto-generated method stub
		MockGetCost getCost=new MockGetCost();
		return getCost.searchCost(time_start, time_end);
	}

	@Override
	public AddState addCost(CostVO cost) {
		// TODO Auto-generated method stub
		MockAddCost addCost=new MockAddCost();
		return addCost.addCost(cost);
	}
}
