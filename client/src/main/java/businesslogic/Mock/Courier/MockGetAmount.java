package businesslogic.Mock.Courier;

import businesslogic.Impl.Courier.GetAmountImpl;
import businesslogic.State.LogisticsType;
import businesslogic.State.PackingCharge;

public class MockGetAmount extends GetAmountImpl{
	public double getAmount(String starting, String destination,
			LogisticsType type, PackingCharge charge, double weight,
			double size) {
		// TODO Auto-generated method stub
		return 0;
	}
}
