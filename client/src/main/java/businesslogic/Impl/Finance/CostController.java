package businesslogic.Impl.Finance;

import java.util.ArrayList;

import data.State.AddState;
import businesslogic.Service.Finance.AddCostService;
import businesslogic.Service.Finance.GetCostService;
import businesslogic.VO.CostVO;

public class CostController implements AddCostService, GetCostService{
	
	
	@Override
	public ArrayList<CostVO> searchCost(String time_start, String time_end) {
		// TODO Auto-generated method stub
		GetCostImpl getCost=new GetCostImpl();
		return getCost.searchCost(time_start, time_end);
	}

	@Override
	public AddState addCost(CostVO cost) {
		// TODO Auto-generated method stub
		AddCostImpl addCost=new AddCostImpl();
		return addCost.addCost(cost);
	}

}
