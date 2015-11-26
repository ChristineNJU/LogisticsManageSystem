package businesslogic.Service.BusinessLobby;

import State.UpdateState;
import VO.DriverInfoVO;

public interface UpdateDriverService {
	public UpdateState updateDriver(DriverInfoVO driver);
}
