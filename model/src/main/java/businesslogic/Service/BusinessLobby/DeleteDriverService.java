package businesslogic.Service.BusinessLobby;

import VO.DriverInfoVO;
import data.State.DeleteState;

public interface DeleteDriverService {
	public DeleteState deleteDriver(DriverInfoVO driver);
}
