package businesslogic.Service.Courier;

import State.LogisticsType;
import State.PackingCharge;

public interface GetAmountService {
	public double getAmount(String starting, String destination, LogisticsType type, PackingCharge charge, double weight, double size);
}
