package businesslogic.Service.Repository;

import java.util.ArrayList;

import VO.RemovalVO;
import VO.StorageVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SeeService.
 */
public interface SeeService {
	
	/**
	 * See storage.
	 *
	 * @param time_start the time_start
	 * @param time_end the time_end
	 * @return the array list
	 */
	public ArrayList<StorageVO> seeStorage(String time_start, String time_end);
	
	/**
	 * See removal.
	 *
	 * @param time_start the time_start
	 * @param time_end the time_end
	 * @return the array list
	 */
	public ArrayList<RemovalVO> seeRemoval(String time_start, String time_end);
}
