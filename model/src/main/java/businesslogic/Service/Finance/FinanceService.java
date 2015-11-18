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
import VO.TransferVO;

public interface FinanceService {
	
	public AddState addAccount(AccountVO account);
	public AddState addBenefit(BenefitVO benefit);
	public AddState addCost(CostVO cost);
	public DeleteState deleteAccount(AccountVO account);
	public ArrayList<AccountVO> searchAccount(String name);
	public BenefitVO searchBenefit(String time_end);
	public ArrayList<CostVO> searchCost(String time_start, String time_end);
	public ArrayList<EntruckingVO> getEntrucking(String time_start, String time_end);
	public ArrayList<GatheringVO> searchGathering(String date, String businesslobby);
	public ArrayList<LogVO> getLog(String time_start, String time_end);
	public ArrayList<TransferVO> getTransfer(String time_start, String time_end);
	public UpdateState updateAccount(AccountVO account, String field, String value);
	
}
