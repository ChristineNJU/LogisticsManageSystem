package businesslogic.Impl.Finance;

import data.State.AddState;
import businesslogic.Service.Finance.AddBenefitService;
import businesslogic.Service.Finance.GetBenefitService;
import businesslogic.VO.BenefitVO;

public class BenefitController implements AddBenefitService, GetBenefitService{
	
	AddBenefitImpl addBenefit=new AddBenefitImpl();
	GetBenefitImpl getBenefit=new GetBenefitImpl();
	
	@Override
	public BenefitVO searchBenefit(String time_end) {
		// TODO Auto-generated method stub
		return getBenefit.searchBenefit(time_end);
	}

	@Override
	public AddState addBenefit(BenefitVO benefit) {
		// TODO Auto-generated method stub
		return addBenefit.addBenefit(benefit);
	}

}
