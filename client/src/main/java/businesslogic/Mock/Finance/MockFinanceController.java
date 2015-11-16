package businesslogic.Mock.Finance;

import java.util.ArrayList;

import businesslogic.Impl.Finance.FinanceController;
import businesslogic.VO.AccountVO;
import businesslogic.VO.BenefitVO;
import businesslogic.VO.CostVO;
import businesslogic.VO.EntruckingVO;
import businesslogic.VO.GatheringVO;
import businesslogic.VO.LogVO;
import businesslogic.VO.TransferVO;
import data.State.AddState;
import data.State.DeleteState;
import data.State.UpdateState;

public class MockFinanceController extends FinanceController{
	@Override
	public UpdateState updateAccount(AccountVO account, String field,
			String value) {
		// TODO Auto-generated method stub
		MockAccount accountC=new MockAccount();
		return accountC.updateAccount(account, field, value);
	}
	@Override
	public ArrayList<TransferVO> getTransfer(String time_start, String time_end) {
		// TODO Auto-generated method stub
		MockSundry sundryC=new MockSundry();
		return sundryC.getTransfer(time_start, time_end);
	}
	@Override
	public ArrayList<LogVO> getLog(String time_start, String time_end) {
		// TODO Auto-generated method stub
		MockSundry sundryC=new MockSundry();
		return sundryC.getLog(time_start, time_end);
	}
	@Override
	public ArrayList<GatheringVO> searchGathering(String date,
			String businesslobby) {
		// TODO Auto-generated method stub
		MockSundry sundryC=new MockSundry();
		return sundryC.searchGathering(date, businesslobby);
	}
	@Override
	public ArrayList<EntruckingVO> getEntrucking(String time_start,
			String time_end) {
		// TODO Auto-generated method stub
		MockSundry sundryC=new MockSundry();
		return sundryC.getEntrucking(time_start, time_end);
	}
	@Override
	public ArrayList<CostVO> searchCost(String time_start, String time_end) {
		// TODO Auto-generated method stub
		MockCost costC=new MockCost();
		return costC.searchCost(time_start, time_end);
	}
	@Override
	public BenefitVO searchBenefit(String time_end) {
		// TODO Auto-generated method stub
		MockBenefit benefitC=new MockBenefit();
		return benefitC.searchBenefit(time_end);
	}
	@Override
	public ArrayList<AccountVO> searchAccount(String name) {
		// TODO Auto-generated method stub
		MockAccount accountC=new MockAccount();
		return accountC.searchAccount(name);
	}
	@Override
	public DeleteState deleteAccount(AccountVO account) {
		// TODO Auto-generated method stub
		MockAccount accountC=new MockAccount();
		return accountC.deleteAccount(account);
	}
	@Override
	public AddState addCost(CostVO cost) {
		// TODO Auto-generated method stub
		MockCost costC=new MockCost();
		return costC.addCost(cost);
	}
	@Override
	public AddState addBenefit(BenefitVO benefit) {
		// TODO Auto-generated method stub
		MockBenefit benefitC=new MockBenefit();
		return benefitC.addBenefit(benefit);
	}
	@Override
	public AddState addAccount(AccountVO account) {
		// TODO Auto-generated method stub
		MockAccount accountC=new MockAccount();
		return accountC.addAccount(account);
	}
}
