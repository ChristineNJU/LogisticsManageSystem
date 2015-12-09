package businesslogic.Service.Finance;

import java.util.ArrayList;

import VO.EntruckingVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface GetEntruckingService.
 */
public interface GetEntruckingService {
	
	/**
	 * Gets the entrucking.
	 *
	 * @param time_start the time_start
	 * @param time_end the time_end
	 * @return the entrucking
	 */
	public ArrayList<EntruckingVO> getEntrucking(String time_start, String time_end);
}
