package businesslogic.Mock.Finance;

import VO.BenefitVO;
import businesslogic.Impl.Finance.BenefitImpl;
import data.State.AddState;

public class MockBenefit extends BenefitImpl{
	@Override
	public AddState addBenefit(BenefitVO benefit) {
		// TODO Auto-generated method stub
		return AddState.FAIL;
	}

	@Override
	public BenefitVO searchBenefit(String time_end) {
		// TODO Auto-generated method stub
		return new BenefitVO(null);
	}
}
