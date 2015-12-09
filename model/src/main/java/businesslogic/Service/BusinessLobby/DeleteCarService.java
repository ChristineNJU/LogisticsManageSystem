package businesslogic.Service.BusinessLobby;

import State.DeleteState;
import VO.CarInfoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface DeleteCarService.
 */
public interface DeleteCarService {
	
	/**
	 * Delete car.
	 *
	 * @param car the car
	 * @return the delete state
	 */
	public DeleteState deleteCar(CarInfoVO car);
}
