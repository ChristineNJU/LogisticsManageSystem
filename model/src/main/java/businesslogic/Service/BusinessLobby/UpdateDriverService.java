package businesslogic.Service.BusinessLobby;

import businesslogic.VO.DriverInfoVO;
import data.State.UpdateState;

public interface UpdateDriverService {
	public UpdateState updateDriver(DriverInfoVO driver, String field, String value);
}
