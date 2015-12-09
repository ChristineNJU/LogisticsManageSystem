package businesslogic.Service.BusinessLobby;

import State.AddState;
import VO.DriverInfoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AddDriverService.
 */
public interface AddDriverService {
	
	/**
	 * Adds the driver.
	 *
	 * @param driver the driver
	 * @return the adds the state
	 */
	public AddState AddDriver(DriverInfoVO driver);

}
