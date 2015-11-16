package businesslogic.Service.Reponsitory;

import java.util.ArrayList;

import businesslogic.VO.VO;

public interface SeeService {
	
	public ArrayList<VO> see(String time_start, String time_end);
}
