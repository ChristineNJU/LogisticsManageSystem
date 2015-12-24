package businesslogic.Service.Finance;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.AccountVO;
import VO.BenefitVO;
import VO.CostVO;
import VO.EntruckingVO;
import VO.GatheringVO;
import VO.LogVO;
import VO.PeriodVO;
import VO.TransferVO;

// TODO: Auto-generated Javadoc
/**
 * 财务人员业务接口.
 *
 * @author 张斯栋
 * @version 1.0.0
 */
public interface FinanceService {
	
	/**
	 * 添加银行账户.
	 *
	 * @param account AccountVO
	 * @return 添加状态
	 */
	public AddState addAccount(AccountVO account);
	
	/**
	 * 添加出款单.
	 *
	 * @param cost CostVO
	 * @return 添加状态
	 */
	public AddState addCost(CostVO cost);

	/**
	 * 增加期初.
	 *
	 * @return 添加状态
	 */
	public AddState addPeriod();

	
	/**
	 * 删除银行账户.
	 *
	 * @param account AccountVO
	 * @return 删除状态
	 */

	public DeleteState deleteAccount(AccountVO account);
	
	/**
	 * 查询银行账户.
	 *
	 * @param name 银行名称
	 * @return AccountVO的ArrayList
	 */
	public ArrayList<AccountVO> searchAccount(String name);
	
	/**
	 * 查询成本收益.
	 *
	 * @param time_end 截止日期
	 * @return BenefitVO
	 */
	public ArrayList<BenefitVO> searchBenefit(String time_end);
	
	/**
	 * 查询出款单.
	 *
	 * @param time_start 起始日期
	 * @param time_end 截止日期
	 * @return CostVO的ArrayList
	 */
	public ArrayList<CostVO> searchCost(String time_start, String time_end);
	
	/**
	 * 查询出款单.
	 *
	 * @param time 截止日期
	 * @return CostVO的ArrayList
	 */
	public ArrayList<CostVO> searchCost(String time);
	
	/**
	 * 查询装车单.
	 *
	 * @param time_start 起始日期
	 * @param time_end 截止日期
	 * @return EntruckingVO的ArrayList
	 */
	public ArrayList<EntruckingVO> getEntrucking(String time_start, String time_end);
	
	/**
	 * 查询收款单.
	 *
	 * @param date 收款日期
	 * @param businesslobby 收款营业厅
	 * @return GatheringVO的ArrayList
	 */
	public ArrayList<GatheringVO> searchGathering(String date, String businesslobby);
	
	/**
	 * visit gatherings.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param businesslobby the businesslobby
	 * @return ArrayList of GatheringVOs
	 */
	public ArrayList<GatheringVO> searchGathering(String startDate, String endDate, String businesslobby);
	
	/**
	 * 查询日志.
	 *
	 * @param time_start 起始日期
	 * @param time_end 截止日期
	 * @return LogVO的ArrayList
	 */
	public ArrayList<LogVO> getLog(String time_start, String time_end);

	/**
	 * 查询期初.
	 *
	 * @return PeriodVO
	 */
	public PeriodVO getPeriod();

	
	/**
	 * 查询中转单.
	 *
	 * @param time_start 起始日期
	 * @param time_end 截止日期
	 * @return TransferVO的ArrayList
	 */
	public ArrayList<TransferVO> getTransfer(String time_start, String time_end);
	
	/**
	 * 更新银行账户.
	 *
	 * @param account AccountVO
	 * @return 更新状态
	 */
	public UpdateState updateAccount(AccountVO account);
	
	/**
	 * 更新期初.
	 *
	 * @return 更新状态
	 */
	public UpdateState updatePeriod();
	
}
