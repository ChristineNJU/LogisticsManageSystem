package businesslogic.Service.Repository;

import java.util.ArrayList;

import VO.RemovalVO;
import VO.StorageVO;

public interface SeeService {
	
	public ArrayList<StorageVO> seeStorage(String time_start, String time_end);
	
	public ArrayList<RemovalVO> seeRemoval(String time_start, String time_end);
}
