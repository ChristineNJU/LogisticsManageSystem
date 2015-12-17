package businesslogic.Service.Repository;

import java.util.ArrayList;

import VO.RemovalVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface GetNeedRemovalService.
 */
public interface GetNeedRemovalService {
	
	/**
	 * Gets the need removal.
	 *
	 * @param destination the destination
	 * @return the need removal
	 */
	public ArrayList<RemovalVO> getNeedRemoval();
	
}
