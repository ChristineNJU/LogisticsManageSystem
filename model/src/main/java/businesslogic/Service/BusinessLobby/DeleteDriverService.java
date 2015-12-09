package businesslogic.Service.BusinessLobby;

import State.DeleteState;
import VO.DriverInfoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface DeleteDriverService.
 */
public interface DeleteDriverService {
	
	/**
	 * Delete driver.
	 *
	 * @param driver the driver
	 * @return the delete state
	 */
	public DeleteState deleteDriver(DriverInfoVO driver);
}
