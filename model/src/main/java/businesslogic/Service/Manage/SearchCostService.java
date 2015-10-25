package businesslogic.Service.Manage;

import java.util.ArrayList;

import businesslogic.VO.ConstVO;

public interface SearchConstService {
	public ArrayList<ConstVO> searchConst(String time_start, String time_end);
}
