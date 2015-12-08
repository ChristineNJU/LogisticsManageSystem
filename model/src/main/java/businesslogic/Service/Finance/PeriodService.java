package businesslogic.Service.Finance;

import State.AddState;
import State.UpdateState;
import VO.PeriodVO;

public interface PeriodService {

	/**
	 * 增加期初
	 * 
	 * @param name 银行名称
	 * @return 添加状态
	 * */
	public AddState addPeriod();

	/**
	 * 更新期初
	 *
	 * @return 更新状态
	 * */
	public UpdateState updatePeriod();
	/**
	 * 查询期初
	 * 
	 * 
	 * @return PeriodVO
	 * */
	public PeriodVO getPeriod();

	
}
