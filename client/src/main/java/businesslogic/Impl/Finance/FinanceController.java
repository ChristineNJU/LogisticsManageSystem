package businesslogic.Impl.Finance;

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
import businesslogic.Service.Finance.FinanceService;
import businesslogic.SystemLog.SystemLog;

// TODO: Auto-generated Javadoc
/**
 * The Class FinanceController.
 * 
 * @author 张斯栋
 * @version 1.0.0
 */
public class FinanceController implements FinanceService{
	
	/**
	 * @see AccountImpl
	 * @see SystemLog#addLog(String)
	 * @see businesslogic.Service.Finance.FinanceService#updateAccount(VO.AccountVO)
	 */
	@Override
	public UpdateState updateAccount(AccountVO account) {
		// TODO Auto-generated method stub
		AccountImpl accountC=new AccountImpl();
		UpdateState state = accountC.updateAccount(account);
		if(state==UpdateState.SUCCESS){
			SystemLog.addLog("更新银行账户");
		}
		return state;
	}
	
	/**
	 * @see SundryImpl
	 * @see businesslogic.Service.Finance.FinanceService#getTransfer(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<TransferVO> getTransfer(String time_start, String time_end) {
		// TODO Auto-generated method stub
		SundryImpl sundryC=new SundryImpl();
		return sundryC.getTransfer(time_start, time_end);
	}
	
	/**
	 * @see SundryImpl
	 * @see businesslogic.Service.Finance.FinanceService#getLog(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<LogVO> getLog(String time_start, String time_end) {
		// TODO Auto-generated method stub
		SundryImpl sundryC=new SundryImpl();
		return sundryC.getLog(time_start, time_end);
	}
	
	/**
	 * @see SundryImpl
	 * @see businesslogic.Service.Finance.FinanceService#searchGathering(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<GatheringVO> searchGathering(String date,
			String businesslobby) {
		// TODO Auto-generated method stub
		SundryImpl sundryC=new SundryImpl();
		return sundryC.searchGathering(date, businesslobby);
	}
	
	/**
	 * @see SundryImpl
	 * @see businesslogic.Service.Finance.FinanceService#getEntrucking(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<EntruckingVO> getEntrucking(String time_start,
			String time_end) {
		// TODO Auto-generated method stub
		SundryImpl sundryC=new SundryImpl();
		return sundryC.getEntrucking(time_start, time_end);
	}
	
	/**
	 * @see SundryImpl
	 * @see businesslogic.Service.Finance.FinanceService#searchCost(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<CostVO> searchCost(String time_start, String time_end) {
		// TODO Auto-generated method stub
		CostImpl costC=new CostImpl();
		return costC.searchCost(time_start, time_end);
	}
	
	/**
	 * @see BenefitImpl
	 * @see businesslogic.Service.Finance.FinanceService#searchBenefit(java.lang.String)
	 */
	@Override
	public ArrayList<BenefitVO> searchBenefit(String time_end) {
		// TODO Auto-generated method stub
		BenefitImpl benefitC=new BenefitImpl();
		return benefitC.searchBenefit(time_end);
	}
	
	/**
	 * @see AccountImpl
	 * @see businesslogic.Service.Finance.FinanceService#searchAccount(java.lang.String)
	 */
	@Override
	public ArrayList<AccountVO> searchAccount(String name) {
		// TODO Auto-generated method stub
		AccountImpl accountC=new AccountImpl();
		return accountC.searchAccount(name);
	}
	
	/**
	 * @see AccountImpl
	 * @see businesslogic.Service.Finance.FinanceService#deleteAccount(VO.AccountVO)
	 */
	@Override
	public DeleteState deleteAccount(AccountVO account) {
		// TODO Auto-generated method stub
		AccountImpl accountC=new AccountImpl();
		DeleteState state = accountC.deleteAccount(account);
		if(state==DeleteState.SUCCESS){
			SystemLog.addLog("删除银行账户");
		}
		return state;
	}
	
	/**
	 * @see CostImpl
	 * @see businesslogic.Service.Finance.FinanceService#addCost(VO.CostVO)
	 */
	@Override
	public AddState addCost(CostVO cost) {
		// TODO Auto-generated method stub
		CostImpl costC=new CostImpl();
		AddState state = costC.addCost(cost);
		if(state==AddState.SUCCESS){
			SystemLog.addLog("添加出款单信息");
		}
		return state;
	}
	
	/**
	 * @see AccountImpl
	 * @see businesslogic.Service.Finance.FinanceService#addAccount(VO.AccountVO)
	 */
	@Override
	public AddState addAccount(AccountVO account) {
		// TODO Auto-generated method stub
		AccountImpl accountC=new AccountImpl();
		AddState state = accountC.addAccount(account);
		if(state==AddState.SUCCESS){
			SystemLog.addLog("添加银行账户");
		}
		return state;
	}
	
	/**
	 * @see businesslogic.Service.Finance.FinanceService#addPeriod()
	 */
	@Override
	public AddState addPeriod() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @see businesslogic.Service.Finance.FinanceService#getPeriod()
	 */
	@Override
	public PeriodVO getPeriod() {
		// TODO Auto-generated method stub
		PeriodImpl period = new PeriodImpl();
		return period.getPeriod();
	}
	
	/**
	 * @see businesslogic.Service.Finance.FinanceService#updatePeriod()
	 */
	@Override
	public UpdateState updatePeriod(PeriodVO vo) {
		// TODO Auto-generated method stub
		PeriodImpl period = new PeriodImpl();
		UpdateState state = period.updatePeriod(vo);
		if(state==UpdateState.SUCCESS){
			SystemLog.addLog("更新期初信息");
		}
		return state;
	}
	
	/**
	 * @see CostImpl 
	 * @see businesslogic.Service.Finance.FinanceService#searchCost(java.lang.String)
	 */
	@Override
	public ArrayList<CostVO> searchCost(String time) {
		// TODO Auto-generated method stub
		CostImpl costC=new CostImpl();
		return costC.searchCost(time);
	}
	
	/**
	 * @see SundryImpl
	 * @see businesslogic.Service.Finance.FinanceService#searchGathering(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<GatheringVO> searchGathering(String startDate,
			String endDate, String businesslobby) {
		// TODO Auto-generated method stub
		SundryImpl sundryC=new SundryImpl();
		return sundryC.searchGathering(startDate, endDate, businesslobby);
	}
	
	
}
