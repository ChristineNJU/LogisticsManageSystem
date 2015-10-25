package businesslogic.Service.BusinessLobby;

import dataservice.State.UpdateState;

public interface UpdateCarService {
	public UpdateState updateCar(CarInfoVO car, String field, String value);
}
