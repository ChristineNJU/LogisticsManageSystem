package businesslogic.Mock.Finance;

import data.State.AddState;
import businesslogic.Impl.Finance.AddCostImpl;
import businesslogic.VO.CostVO;

public class MockAddCost extends AddCostImpl{
	public AddState addCost(CostVO cost) {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}
}
