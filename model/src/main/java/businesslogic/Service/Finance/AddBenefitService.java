package businesslogic.Service.Finance;

import businesslogic.VO.BenefitVO;
import data.State.AddState;

public interface AddBenefitService {
	public AddState addBenefit(BenefitVO benefit);
}
