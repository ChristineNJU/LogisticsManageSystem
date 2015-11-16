package businesslogic.Impl.Courier;

import businesslogic.Service.Courier.GetAmountService;
import businesslogic.State.LogisticsType;
import businesslogic.State.PackingCharge;

public class GetAmountImpl implements GetAmountService{

	@Override
	public double getAmount(String starting, String destination,
			LogisticsType type, PackingCharge charge, double weight,
			double size) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
