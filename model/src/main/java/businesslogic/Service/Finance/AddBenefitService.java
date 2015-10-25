package businesslogic.Service.Finance;

import businesslogic.VO.BenefitVO;
import dataservice.State.AddState;

public interface AddBenefitService {
	public AddState addBenefit(BenefitVO benefit);
}
