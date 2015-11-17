package businesslogic.Service.Manage;

import java.util.ArrayList;

import VO.ConstVO;
import VO.CostVO;

public interface SearchCostService {
	public ArrayList<CostVO> searchCost(String time_start, String time_end);
}
