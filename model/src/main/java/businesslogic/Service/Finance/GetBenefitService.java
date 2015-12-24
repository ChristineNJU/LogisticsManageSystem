package businesslogic.Service.Finance;

import java.util.ArrayList;

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
	public ArrayList<BenefitVO> searchBenefit(String time_end);
}
