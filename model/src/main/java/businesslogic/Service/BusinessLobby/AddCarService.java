package businesslogic.Service.BusinessLobby;

import businesslogic.VO.CarInfoVO;
import data.State.AddState;

public interface AddCarService {
	public AddState addCar(CarInfoVO car);
}
