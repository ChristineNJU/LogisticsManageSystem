package businesslogic.Service.BusinessLobby;

import State.AddState;
import VO.DeliveryVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface DeliveryService.
 */
public interface DeliveryService {

	/**
	 * Delivery.
	 *
	 * @param delivery the delivery
	 * @return the adds the state
	 */
	public AddState delivery(DeliveryVO delivery);
}
