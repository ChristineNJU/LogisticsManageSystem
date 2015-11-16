package businesslogic.Impl.Finance;

import java.util.ArrayList;

import data.State.AddState;
import businesslogic.Service.Finance.AddCostService;
import businesslogic.Service.Finance.GetCostService;
import businesslogic.VO.CostVO;

public class CostController implements AddCostService, GetCostService{
	
	AddCostImpl addCost=new AddCostImpl();
	GetCostImpl getCost=new GetCostImpl();
	
	@Override
	public ArrayList<CostVO> searchCost(String time_start, String time_end) {
		// TODO Auto-generated method stub
		return getCost.searchCost(time_start, time_end);
	}

	@Override
	public AddState addCost(CostVO cost) {
		// TODO Auto-generated method stub
		return addCost.addCost(cost);
	}

}
