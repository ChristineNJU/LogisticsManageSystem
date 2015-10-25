package businesslogic.Service.BusinessLobby;

import businesslogic.VO.DriverInfoVO;
import dataservice.State.UpdateState;

public interface UpdateDriverService {
	public UpdateState updateDriver(DriverInfoVO driver, String field, String value);
}
