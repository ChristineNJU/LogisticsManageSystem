package businesslogic.Service.BusinessLobby;

import java.util.ArrayList;

import VO.DriverInfoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface GetDriverService.
 */
public interface GetDriverService {
	
	/**
	 * Search driver.
	 *
	 * @param id the id
	 * @return the array list
	 */
	public ArrayList<DriverInfoVO> searchDriver(String id);
}
