package businesslogic.Mock.Finance;

import businesslogic.Impl.Finance.GetBenefitImpl;
import businesslogic.VO.BenefitVO;

public class MockGetBenefit extends GetBenefitImpl{
	public BenefitVO searchBenefit(String time_end) {
		// TODO Auto-generated method stub
		return new BenefitVO(null);
	}
}
