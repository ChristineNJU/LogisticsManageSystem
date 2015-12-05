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

public class FinanceController implements FinanceService{
	
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
	@Override
	public ArrayList<TransferVO> getTransfer(String time_start, String time_end) {
		// TODO Auto-generated method stub
		SundryImpl sundryC=new SundryImpl();
		return sundryC.getTransfer(time_start, time_end);
	}
	@Override
	public ArrayList<LogVO> getLog(String time_start, String time_end) {
		// TODO Auto-generated method stub
		SundryImpl sundryC=new SundryImpl();
		return sundryC.getLog(time_start, time_end);
	}
	@Override
	public ArrayList<GatheringVO> searchGathering(String date,
			String businesslobby) {
		// TODO Auto-generated method stub
		SundryImpl sundryC=new SundryImpl();
		return sundryC.searchGathering(date, businesslobby);
	}
	@Override
	public ArrayList<EntruckingVO> getEntrucking(String time_start,
			String time_end) {
		// TODO Auto-generated method stub
		SundryImpl sundryC=new SundryImpl();
		return sundryC.getEntrucking(time_start, time_end);
	}
	@Override
	public ArrayList<CostVO> searchCost(String time_start, String time_end) {
		// TODO Auto-generated method stub
		CostImpl costC=new CostImpl();
		return costC.searchCost(time_start, time_end);
	}
	@Override
	public BenefitVO searchBenefit(String time_end) {
		// TODO Auto-generated method stub
		BenefitImpl benefitC=new BenefitImpl();
		return benefitC.searchBenefit(time_end);
	}
	@Override
	public ArrayList<AccountVO> searchAccount(String name) {
		// TODO Auto-generated method stub
		AccountImpl accountC=new AccountImpl();
		return accountC.searchAccount(name);
	}
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
	@Override
	public AddState addPeriod() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PeriodVO getPeriod() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public UpdateState updatePeriod() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<CostVO> searchCost(String time) {
		// TODO Auto-generated method stub
		CostImpl costC=new CostImpl();
		return costC.searchCost(time);
	}
	@Override
	public ArrayList<GatheringVO> searchGathering(String startDate,
			String endDate, String businesslobby) {
		// TODO Auto-generated method stub
		SundryImpl sundryC=new SundryImpl();
		return sundryC.searchGathering(startDate, endDate, businesslobby);
	}
	
	
}
