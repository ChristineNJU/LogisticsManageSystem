package businesslogic.Mock.Courier;

import data.State.AddState;
import businesslogic.Impl.Courier.AddLogisticsImpl;
import businesslogic.VO.VO;

public class MockAddLogistics extends AddLogisticsImpl{
	public AddState addLogistics(VO logistics_info) {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}
}
