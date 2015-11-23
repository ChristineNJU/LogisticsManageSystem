package businesslogic.Service.Repository;

import java.util.ArrayList;

import State.StorageState;
import VO.StorageVO;

public interface StorageService {
	
	public StorageState storage(ArrayList<StorageVO> storage);
}
