package businesslogic.Impl.Finance;

import data.State.AddState;
import businesslogic.Service.Finance.AddBenefitService;
import businesslogic.Service.Finance.GetBenefitService;
import businesslogic.VO.BenefitVO;

public class BenefitController implements AddBenefitService, GetBenefitService{
	
	
	@Override
	public BenefitVO searchBenefit(String time_end) {
		// TODO Auto-generated method stub
		GetBenefitImpl getBenefit=new GetBenefitImpl();
		return getBenefit.searchBenefit(time_end);
	}

	@Override
	public AddState addBenefit(BenefitVO benefit) {
		// TODO Auto-generated method stub
		AddBenefitImpl addBenefit=new AddBenefitImpl();
		return addBenefit.addBenefit(benefit);
	}

}
