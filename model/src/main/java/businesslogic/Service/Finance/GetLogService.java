package businesslogic.Service.Finance;

import java.util.ArrayList;

import VO.LogVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface GetLogService.
 */
public interface GetLogService {
	
	/**
	 * Gets the log.
	 *
	 * @param time_start the time_start
	 * @param time_end the time_end
	 * @return the log
	 */
	public ArrayList<LogVO> getLog(String time_start, String time_end);
}
