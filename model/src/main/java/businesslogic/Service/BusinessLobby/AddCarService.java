package businesslogic.Service.BusinessLobby;

import State.AddState;
import VO.CarInfoVO;

public interface AddCarService {
	public AddState addCar(CarInfoVO car);
}
