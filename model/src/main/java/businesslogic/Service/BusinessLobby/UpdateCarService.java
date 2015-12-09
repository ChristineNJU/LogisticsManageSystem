package businesslogic.Service.BusinessLobby;

import State.UpdateState;
import VO.CarInfoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface UpdateCarService.
 */
public interface UpdateCarService {
	
	/**
	 * Update car.
	 *
	 * @param car the car
	 * @return the update state
	 */
	public UpdateState updateCar(CarInfoVO car);
}
