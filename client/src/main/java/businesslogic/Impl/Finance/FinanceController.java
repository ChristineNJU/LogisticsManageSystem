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
import VO.TransferVO;
import businesslogic.Service.Finance.FinanceService;

public class FinanceController implements FinanceService{
	
	@Override
	public UpdateState updateAccount(AccountVO account) {
		// TODO Auto-generated method stub
		AccountImpl accountC=new AccountImpl();
		return accountC.updateAccount(account);
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
		return accountC.deleteAccount(account);
	}
	@Override
	public AddState addCost(CostVO cost) {
		// TODO Auto-generated method stub
		CostImpl costC=new CostImpl();
		return costC.addCost(cost);
	}
	@Override
	public AddState addBenefit(BenefitVO benefit) {
		// TODO Auto-generated method stub
		BenefitImpl benefitC=new BenefitImpl();
		return benefitC.addBenefit(benefit);
	}
	@Override
	public AddState addAccount(AccountVO account) {
		// TODO Auto-generated method stub
		AccountImpl accountC=new AccountImpl();
		return accountC.addAccount(account);
	}
	
	
}
