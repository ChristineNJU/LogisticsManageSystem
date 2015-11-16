package businesslogic.Mock.Courier;

import java.util.ArrayList;

import businesslogic.Impl.Courier.CourierController;
import businesslogic.State.LogisticsType;
import businesslogic.State.PackingCharge;
import businesslogic.VO.VO;
import data.State.AddState;
import data.State.UpdateState;

public class MockCourierController extends CourierController{
	@Override
	public UpdateState receiveConfirm(VO logistics_info, String field,
			String value) {
		// TODO Auto-generated method stub
		
		MockReceiveConfirm receiveConfirm=new MockReceiveConfirm();
		return receiveConfirm.receiveConfirm(logistics_info, field, value);
		
	}

	@Override
	public ArrayList<String> getCity() {
		// TODO Auto-generated method stub
		MockGetCity getCity=new MockGetCity();
		return getCity.getCity();
	}

	@Override
	public double getAmount(String starting, String destination,
			LogisticsType type, PackingCharge charge, double weight,
			double size) {
		// TODO Auto-generated method stub
		MockGetAmount getAmount=new MockGetAmount();
		return getAmount.getAmount(starting, destination, type, charge, weight, size);
	}

	@Override
	public AddState addLogistics(VO logistics_info) {
		// TODO Auto-generated method stub
		MockAddLogistics addLogistics=new MockAddLogistics();
		return addLogistics.addLogistics(logistics_info);
	}
}
