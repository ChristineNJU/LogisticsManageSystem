package businesslogic.Service.BusinessLobby;

import State.AddState;
import VO.DeliveryVO;

public interface DeliveryService {

	public AddState delivery(DeliveryVO delivery);
}
