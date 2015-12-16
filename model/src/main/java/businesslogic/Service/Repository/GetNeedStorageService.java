package businesslogic.Service.Repository;

import java.util.ArrayList;

import VO.StorageVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface GetNeedStorageService.
 */
public interface GetNeedStorageService {
	
	/**
	 * Gets the need storage.
	 *
	 * @param destination the destination
	 * @return the need storage
	 */
	public ArrayList<StorageVO> getNeedStorage();
}
