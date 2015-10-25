package businesslogic.Service.BusinessLobby;

import businesslogic.VO.CarInfoVO;
import dataservice.State.DeleteState;

public interface DeleteCarService {
	public DeleteState deleteCar(CarInfoVO car);
}
