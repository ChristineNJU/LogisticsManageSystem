package businesslogic.Service.BusinessLobby;

import businesslogic.VO.DriverInfoVO;
import data.State.DeleteState;

public interface DeleteDriverService {
	public DeleteState deleteDriver(DriverInfoVO driver);
}
