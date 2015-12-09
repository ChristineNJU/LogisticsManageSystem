package businesslogic.Service.Manage;

import java.util.ArrayList;

import VO.GatheringVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface GetGatheringService.
 */
public interface GetGatheringService {
	
	/**
	 * Search gathering.
	 *
	 * @param date the date
	 * @param businesslobby the businesslobby
	 * @return the array list
	 */
	public ArrayList<GatheringVO> searchGathering(String date, String businesslobby);
}
