package businesslogic.Service.BusinessLobby;

import businesslogic.VO.CarInfoVO;
import dataservice.State.UpdateState;

public interface UpdateCarService {
	public UpdateState updateCar(CarInfoVO car, String field, String value);
}
