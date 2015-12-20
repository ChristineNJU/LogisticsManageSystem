package businesslogic.Impl.Finance;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.AccountPO;
import PO.CostPO;
import State.AddState;
import VO.AccountVO;
import VO.CostVO;
import businesslogic.Service.Finance.CostService;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import data.Service.Search.SearchAccountService;
import data.Service.Search.SearchCostService;
import data.Service.Update.UpdateService;

// TODO: Auto-generated Javadoc
/**
 * The Class CostImpl.
 * 出款单业务的实现
 * 
 * @see SearchCostService
 * @see AddService
 */
public class CostImpl implements CostService{

	/* (non-Javadoc)
	 * @see businesslogic.Service.Finance.CostService#searchCost(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<CostVO> searchCost(String time_start, String time_end) {
		// TODO Auto-generated method stub
		ArrayList<CostVO> Cost=new ArrayList<CostVO>();
		try{
			SearchCostService costSearch=(SearchCostService) Naming.lookup(RMIHelper.SEARCH_COST_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("cost_date between '"+time_start+"' and '"+time_end+"'");
			ArrayList<CostPO> costList=costSearch.searchCost(requirement);
			for(int i=0;i<costList.size();i++){
				Cost.add(new CostVO(costList.get(i)));
			}
		} catch (Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		return Cost;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Finance.CostService#addCost(VO.CostVO)
	 */
	@Override
	public AddState addCost(CostVO cost) {
		// TODO Auto-generated method stub
		AddState state=AddState.SUCCESS;
		try{
			AddService costAdd=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			state=costAdd.add(new CostPO(cost));
			double amount=cost.getAmount();
			SearchAccountService searchAccount=(SearchAccountService) Naming.lookup(RMIHelper.SEARCH_ACCOUNT_IMPL);	
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("account_name='"+cost.getPayerAccount()+"'");
			AccountPO account=searchAccount.searchAccount(requirement).get(0);
			account.setAmount(account.getAmount()-amount);
			UpdateService updateAccount=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			updateAccount.update(account);
		} catch (Exception ex){
			state=AddState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return state;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Finance.CostService#searchCost(java.lang.String)
	 */
	@Override
	public ArrayList<CostVO> searchCost(String time) {
		// TODO Auto-generated method stub
		ArrayList<CostVO> Cost=new ArrayList<CostVO>();
		try{
			SearchCostService costSearch=(SearchCostService) Naming.lookup(RMIHelper.SEARCH_COST_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			if(time.equals("%%")){
				requirement.add("cost_date like '%%'");
			}
			else {
				requirement.add("cost_date= '"+time+"'");
			}
			ArrayList<CostPO> costList=costSearch.searchCost(requirement);
			for(int i=0;i<costList.size();i++){
				Cost.add(new CostVO(costList.get(i)));
			}
		} catch (Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		return Cost;
	}

}
