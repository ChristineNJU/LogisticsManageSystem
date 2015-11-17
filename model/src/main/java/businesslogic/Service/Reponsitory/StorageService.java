package businesslogic.Service.Reponsitory;

import java.util.ArrayList;

import VO.StorageVO;
import businesslogic.State.StorageState;

public interface StorageService {
	
	public StorageState storage(ArrayList<StorageVO> storage);
}
