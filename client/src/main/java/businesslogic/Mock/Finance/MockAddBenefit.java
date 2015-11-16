package businesslogic.Mock.Finance;

import businesslogic.Impl.Finance.AddBenefitImpl;
import businesslogic.VO.BenefitVO;
import data.State.AddState;

public class MockAddBenefit extends AddBenefitImpl{
	public AddState addBenefit(BenefitVO benefit) {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}
}
