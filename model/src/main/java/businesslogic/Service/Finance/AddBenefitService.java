package businesslogic.Service.Finance;

import State.AddState;
import VO.BenefitVO;

public interface AddBenefitService {
	public AddState addBenefit(BenefitVO benefit);
}
