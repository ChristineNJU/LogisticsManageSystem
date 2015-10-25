package businesslogic.Service.BusinessLobby;

import businesslogic.VO.CarInfoVO;
import dataservice.State.AddState;

public interface AddCarService {
	public AddState addCar(CarInfoVO car);
}
