package businesslogic.Service.BusinessLobby;

import State.DeleteState;
import VO.DriverInfoVO;

public interface DeleteDriverService {
	public DeleteState deleteDriver(DriverInfoVO driver);
}
