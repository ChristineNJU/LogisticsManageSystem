package businesslogic.Mock.Manage;

import java.util.ArrayList;

import businesslogic.Impl.Manage.ManageFinance;
import businesslogic.VO.BenefitVO;
import businesslogic.VO.CostVO;
import businesslogic.VO.GatheringVO;

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
