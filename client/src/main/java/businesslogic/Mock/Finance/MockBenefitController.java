package businesslogic.Mock.Finance;

import businesslogic.Impl.Finance.BenefitController;
import businesslogic.VO.BenefitVO;
import data.State.AddState;

public class MockBenefitController extends BenefitController{

	@Override
	public BenefitVO searchBenefit(String time_end) {
		// TODO Auto-generated method stub
		MockGetBenefit getBenefit=new MockGetBenefit();
		return getBenefit.searchBenefit(time_end);
	}

	@Override
	public AddState addBenefit(BenefitVO benefit) {
		// TODO Auto-generated method stub
		MockAddBenefit addBenefit=new MockAddBenefit();
		return addBenefit.addBenefit(benefit);
	}
}
