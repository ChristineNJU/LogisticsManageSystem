package businesslogic.Service.BusinessLobby;

import java.util.ArrayList;

import VO.CarInfoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface GetCarService.
 */
public interface GetCarService {
	
	/**
	 * Search car.
	 *
	 * @param id the id
	 * @return the array list
	 */
	public ArrayList<CarInfoVO> searchCar(String id);
}
