package businesslogic.Service.Finance;

import businesslogic.VO.CostVO;
import data.State.AddState;

public interface AddCostService {
	public AddState addCost(CostVO cost);
}
