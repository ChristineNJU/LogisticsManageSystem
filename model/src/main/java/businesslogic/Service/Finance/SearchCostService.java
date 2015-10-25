package businesslogic.Service.Finance;

import java.util.ArrayList;

public interface SearchCostService {
	public ArrayList<CostVO> searchCost(String time_start, String time_end);
}
