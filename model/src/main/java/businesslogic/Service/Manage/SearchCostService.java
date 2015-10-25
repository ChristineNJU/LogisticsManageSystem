package businesslogic.Service.Manage;

import java.util.ArrayList;

import businesslogic.VO.ConstVO;
import businesslogic.VO.CostVO;

public interface SearchCostService {
	public ArrayList<CostVO> searchCost(String time_start, String time_end);
}
