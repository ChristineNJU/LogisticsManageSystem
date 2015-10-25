package businesslogic.Service.Finance;

import java.util.ArrayList;

import businesslogic.VO.CostVO;

public interface SearchCostService {
	public ArrayList<CostVO> searchCost(String time_start, String time_end);
}
