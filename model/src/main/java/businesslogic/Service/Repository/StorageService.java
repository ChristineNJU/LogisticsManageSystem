package businesslogic.Service.Repository;

import java.util.ArrayList;

import State.StorageState;
import VO.StorageVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface StorageService.
 */
public interface StorageService {
	
	/**
	 * Storage.
	 *
	 * @param storage the storage
	 * @return the storage state
	 */
	public StorageState storage(ArrayList<StorageVO> storage);
	
}
