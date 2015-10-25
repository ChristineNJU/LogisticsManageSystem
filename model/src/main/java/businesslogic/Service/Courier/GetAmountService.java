package businesslogic.Service.Courier;

import businesslogic.State.LogisticsType;
import businesslogic.State.PackingCharge;

public interface GetAmountService {
	public double getAmount(String starting, String destination, LogisticsType type, PackingCharge charge, double weight, double height);
}
