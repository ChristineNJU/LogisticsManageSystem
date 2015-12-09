package businesslogic.Mock.Finance;

import State.AddState;
import VO.BenefitVO;
import businesslogic.Impl.Finance.BenefitImpl;

public class MockBenefit extends BenefitImpl{

	@Override
	public BenefitVO searchBenefit(String time_end) {
		// TODO Auto-generated method stub
		return new BenefitVO(null);
	}
}
