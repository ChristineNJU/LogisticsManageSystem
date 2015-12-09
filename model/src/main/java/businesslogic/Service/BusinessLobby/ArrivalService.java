package businesslogic.Service.BusinessLobby;

import java.util.ArrayList;

import State.AddState;
import VO.ArrivalVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ArrivalService.
 */
public interface ArrivalService {
	
	/**
	 * Arrival.
	 *
	 * @param arrival the arrival
	 * @return the adds the state
	 */
	public AddState arrival(ArrayList<ArrivalVO> arrival);
}
