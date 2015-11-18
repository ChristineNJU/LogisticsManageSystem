package businesslogic.Service.Reponsitory;

import java.util.ArrayList;

import VO.VO;

public interface SeeService {
	
	public ArrayList<VO> see(String time_start, String time_end);
}
