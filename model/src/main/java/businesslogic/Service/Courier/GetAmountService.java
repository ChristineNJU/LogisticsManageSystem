package businesslogic.Service.Courier;

import State.LogisticsType;
import State.PackingCharge;

// TODO: Auto-generated Javadoc
/**
 * The Interface GetAmountService.
 */
public interface GetAmountService {
	
	/**
	 * Gets the amount.
	 *
	 * @param starting the starting
	 * @param destination the destination
	 * @param type the type
	 * @param charge the charge
	 * @param weight the weight
	 * @param size the size
	 * @return the amount
	 */
	public double getAmount(String starting, String destination, LogisticsType type, PackingCharge charge, double weight, double size);
}
