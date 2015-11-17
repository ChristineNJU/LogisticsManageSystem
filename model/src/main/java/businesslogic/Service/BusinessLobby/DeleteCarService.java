package businesslogic.Service.BusinessLobby;

import VO.CarInfoVO;
import data.State.DeleteState;

public interface DeleteCarService {
	public DeleteState deleteCar(CarInfoVO car);
}
