package businesslogic.Service.BusinessLobby;

import State.DeleteState;
import VO.CarInfoVO;

public interface DeleteCarService {
	public DeleteState deleteCar(CarInfoVO car);
}
