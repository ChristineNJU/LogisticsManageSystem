package businesslogic.Service.Manage;

import java.util.ArrayList;

import VO.BenefitVO;

// TODO: Auto-generated Javadoc
/**
 * 获取有关成本收益的信息.
 *
 * @author 尹子越
 * @version 1.0.0
 */
public interface GetBenefitService {
	
	/**
	 * 获取最新成本收益.
	 *
	 * @param time_end 结束时间
	 * @return BenefitVO
	 */
	public BenefitVO searchBenefit(String time_end);
	
	/**
	 * 获取区间成本收益.
	 *
	 * @param time_start 起始时间
	 * @param time_end 结束时间
	 * @return ArrayList<BenefitVO>
	 */
	public ArrayList<BenefitVO> searchAllBenefit(String time_start, String time_end);
}
