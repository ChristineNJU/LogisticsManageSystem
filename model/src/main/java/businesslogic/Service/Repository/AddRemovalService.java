package businesslogic.Service.Repository;

import java.util.ArrayList;

import State.AddState;
import VO.RemovalVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AddRemovalService.
 */
public interface AddRemovalService {
	
	/**
	 * Adds the removal.
	 *
	 * @param re the re
	 * @return the adds the state
	 */
	public AddState addRemoval(ArrayList<RemovalVO> re);
}
