package businesslogic.Impl.Manage;

import java.util.ArrayList;

import businesslogic.Service.Manage.SearchBenefitService;
import businesslogic.Service.Manage.SearchCostService;
import businesslogic.Service.Manage.SearchGatheringService;
import businesslogic.VO.BenefitVO;
import businesslogic.VO.CostVO;
import businesslogic.VO.GatheringVO;

public class ManageFinance implements SearchBenefitService, SearchCostService,SearchGatheringService {

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
