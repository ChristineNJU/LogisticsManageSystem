package businesslogic.Impl.Manage;

import java.util.ArrayList;

import VO.BenefitVO;
import VO.CostVO;
import VO.GatheringVO;
import businesslogic.Service.Manage.GetBenefitService;
import businesslogic.Service.Manage.GetCostService;
import businesslogic.Service.Manage.GetGatheringService;

public class ManageFinance implements GetBenefitService, GetCostService,GetGatheringService {

	@Override
	public ArrayList<GatheringVO> searchGathering(String date,
			String businesslobby) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CostVO> searchCost(String time_start, String time_end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BenefitVO searchBenefit(String time_end) {
		// TODO Auto-generated method stub
		return null;
	}

}
