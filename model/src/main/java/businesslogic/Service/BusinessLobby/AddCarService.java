package businesslogic.Service.BusinessLobby;

import State.AddState;
import VO.CarInfoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AddCarService.
 */
public interface AddCarService {
	
	/**
	 * Adds the car.
	 *
	 * @param car the car
	 * @return the adds the state
	 */
	public AddState addCar(CarInfoVO car);
}
