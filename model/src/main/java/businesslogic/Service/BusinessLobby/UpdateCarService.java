package businesslogic.Service.BusinessLobby;

import State.UpdateState;
import VO.CarInfoVO;

public interface UpdateCarService {
	public UpdateState updateCar(CarInfoVO car);
}
