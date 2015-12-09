package businesslogic.Service.BusinessLobby;

import State.AddState;
import VO.GatheringVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface GatheringService.
 */
public interface GatheringService {
	
	/**
	 * Gathering.
	 *
	 * @param gathering the gathering
	 * @return the adds the state
	 */
	public AddState gathering(GatheringVO gathering);
}
