package businesslogic.Service.Finance;

import VO.BenefitVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface GetBenefitService.
 */
public interface GetBenefitService {
	
	/**
	 * Search benefit.
	 *
	 * @param time_end the time_end
	 * @return the benefit vo
	 */
	public BenefitVO searchBenefit(String time_end);
}
