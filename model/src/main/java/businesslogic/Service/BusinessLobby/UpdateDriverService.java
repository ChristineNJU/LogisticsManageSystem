package businesslogic.Service.BusinessLobby;

import State.UpdateState;
import VO.DriverInfoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface UpdateDriverService.
 */
public interface UpdateDriverService {
	
	/**
	 * Update driver.
	 *
	 * @param driver the driver
	 * @return the update state
	 */
	public UpdateState updateDriver(DriverInfoVO driver);
}
