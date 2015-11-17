package businesslogic.Impl.Manage;

import java.util.ArrayList;

import VO.BenefitVO;
import VO.CostVO;
import VO.GatheringVO;
import businesslogic.Service.Manage.SearchBenefitService;
import businesslogic.Service.Manage.SearchCostService;
import businesslogic.Service.Manage.SearchGatheringService;

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
