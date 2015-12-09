package businesslogic.Service.Finance;

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
	
	/**
	 * Search gathering.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param businesslobby the businesslobby
	 * @return the array list
	 */
	public ArrayList<GatheringVO> searchGathering(String startDate, String endDate, String businesslobby);
}
