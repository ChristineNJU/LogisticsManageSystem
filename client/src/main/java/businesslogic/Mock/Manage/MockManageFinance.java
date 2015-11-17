package businesslogic.Mock.Manage;

import java.util.ArrayList;

import VO.BenefitVO;
import VO.CostVO;
import VO.GatheringVO;
import businesslogic.Impl.Manage.ManageFinance;

public class MockManageFinance extends ManageFinance{

	@Override
	public ArrayList<GatheringVO> searchGathering(String date,
			String businesslobby) {
		// TODO Auto-generated method stub
		return new ArrayList<GatheringVO>();
	}

	@Override
	public ArrayList<CostVO> searchCost(String time_start, String time_end) {
		// TODO Auto-generated method stub
		return new ArrayList<CostVO>();
	}

	@Override
	public BenefitVO searchBenefit(String time_end) {
		// TODO Auto-generated method stub
		return new BenefitVO(null);
	}
}
