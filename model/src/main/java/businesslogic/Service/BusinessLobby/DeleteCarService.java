package businesslogic.Service.BusinessLobby;

import businesslogic.VO.CarInfoVO;
import data.State.DeleteState;

public interface DeleteCarService {
	public DeleteState deleteCar(CarInfoVO car);
}
