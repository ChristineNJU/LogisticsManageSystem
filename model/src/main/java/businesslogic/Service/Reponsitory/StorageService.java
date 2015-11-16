package businesslogic.Service.Reponsitory;

import java.util.ArrayList;

import businesslogic.State.StorageState;
import businesslogic.VO.StorageVO;

public interface StorageService {
	
	public StorageState storage(ArrayList<StorageVO> storage);
}
