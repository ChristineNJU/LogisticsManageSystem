package businesslogic.Mock.Courier;

import java.util.ArrayList;

import State.AddState;
import State.LogisticsType;
import State.PackingCharge;
import State.UpdateState;
import VO.VO;
import businesslogic.Impl.Courier.CourierImpl;

public class MockCourier extends CourierImpl{
	@Override
	public UpdateState receiveConfirm(VO logistics_info, String field,
			String value) {
		// TODO Auto-generated method stub
		return UpdateState.NOTFOUND;
	}

	@Override
	public ArrayList<String> getCity() {
		// TODO Auto-generated method stub
		return new ArrayList<String>();
	}

	@Override
	public double getAmount(String starting, String destination,
			LogisticsType type, PackingCharge charge, double weight,
			double height) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AddState addLogistics(VO logistics_info) {
		// TODO Auto-generated method stub
		return AddState.FAIL;
	}
}