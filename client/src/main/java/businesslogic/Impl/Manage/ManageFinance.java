package businesslogic.Impl.Manage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.BenefitPO;
import PO.CostPO;
import VO.BenefitVO;
import VO.CostVO;
import VO.GatheringVO;
import businesslogic.Service.Manage.GetBenefitService;
import businesslogic.Service.Manage.GetCostService;
import businesslogic.Service.Manage.GetGatheringService;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchBenefitService;
import data.Service.Search.SearchCostService;
import data.Service.Search.SearchGatheringService;

public class ManageFinance implements GetBenefitService, GetCostService,GetGatheringService {

	@Override
	public ArrayList<GatheringVO> searchGathering(String date,
			String businesslobby) {
		ArrayList<GatheringVO> result=new ArrayList<GatheringVO>();
		try {
			SearchGatheringService searchGathering=(SearchGatheringService) Naming.lookup(RMIHelper.SEARCH_GATHERING_IMPL);
			ArrayList<String> requirementDate=new ArrayList<String>();
			ArrayList<String> requirementBusinesslobby=new ArrayList<String>();
			ArrayList<GatheringVO> searchResultDate=new ArrayList<GatheringVO>();
			ArrayList<GatheringVO> searchResultBusinesslobby=new ArrayList<GatheringVO>();
			
//			if(date!=null){
//				requirementDate.add("date"+date);
//				searchResultDate=searchGathering.searchGathering(URLHelper.getGatheringURL(institution_id), requirement);
//			}
//			
//			requirement.add("businesslobby");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CostVO> searchCost(String time_start, String time_end) {
		// TODO Auto-generated method stub
		ArrayList<CostVO> result=new ArrayList<CostVO>();
		try {
			SearchCostService searchCost=(SearchCostService) Naming.lookup(RMIHelper.SEARCH_COST_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("'between'"+time_start+"'and'"+time_end);
			ArrayList<CostPO> searchResult=searchCost.searchCost(requirement);
			
			if(searchResult.isEmpty()){
				System.out.println("not found");
				return result;
			}
			
			else{
				for(int i=0;i<searchResult.size();i++){
					CostVO temp=new CostVO(searchResult.get(i));
					result.add(temp);
				}
			}
				
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public BenefitVO searchBenefit(String time_end) {
		// TODO Auto-generated method stub
		double income=0,cost=0;
		double time_start=0;
		try {
			SearchBenefitService searchBenefit=(SearchBenefitService) Naming.lookup(RMIHelper.SEARCH_BENEFIT_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("'between'"+time_start+"'and'"+time_end);
			ArrayList<BenefitPO> searchResult=searchBenefit.searchBenefit(requirement);
			
			if(searchResult.isEmpty()){
				System.out.println("not found");
				return null;
			}
			else{
				for(int i=0;i<searchResult.size();i++){
					income+=searchResult.get(i).getIncome();
					cost+=searchResult.get(i).getExpend();
				}
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
			return null;
		}
		
		BenefitVO result=new BenefitVO(income,cost);
		return result;
	}

}
