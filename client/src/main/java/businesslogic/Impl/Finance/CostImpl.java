package businesslogic.Impl.Finance;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.CostPO;
import State.AddState;
import VO.CostVO;
import businesslogic.Service.Finance.AddCostService;
import businesslogic.Service.Finance.GetCostService;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import data.Service.Search.SearchCostService;

public class CostImpl implements AddCostService,GetCostService{

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
		}
		return Cost;
	}

	@Override
	public AddState addCost(CostVO cost) {
		// TODO Auto-generated method stub
		AddState state=AddState.SUCCESS;
		try{
			AddService costAdd=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			state=costAdd.add(new CostPO(cost));
		} catch (Exception ex){
			state=AddState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return state;
	}

	@Override
	public ArrayList<CostVO> searchCost(String time) {
		// TODO Auto-generated method stub
		ArrayList<CostVO> Cost=new ArrayList<CostVO>();
		try{
			SearchCostService costSearch=(SearchCostService) Naming.lookup(RMIHelper.SEARCH_COST_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("cost_date= '"+time+"'");
			ArrayList<CostPO> costList=costSearch.searchCost(requirement);
			for(int i=0;i<costList.size();i++){
				Cost.add(new CostVO(costList.get(i)));
			}
		} catch (Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return Cost;
	}

}
