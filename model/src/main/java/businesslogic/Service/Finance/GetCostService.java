package businesslogic.Service.Finance;

import java.util.ArrayList;

import VO.CostVO;

public interface GetCostService {
	public ArrayList<CostVO> searchCost(String time_start, String time_end);
}
