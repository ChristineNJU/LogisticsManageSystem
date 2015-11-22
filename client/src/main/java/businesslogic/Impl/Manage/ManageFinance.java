package businesslogic.Impl.Manage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.BenefitPO;
import PO.CostPO;
import PO.GatheringPO;
import PO.InstitutionPO;
import VO.BenefitVO;
import VO.CostVO;
import VO.GatheringVO;
import businesslogic.Service.Manage.GetBenefitService;
import businesslogic.Service.Manage.GetCostService;
import businesslogic.Service.Manage.GetGatheringService;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchBenefitService;
import data.Service.Search.SearchCostService;
import data.Service.Search.SearchGatheringService;
import data.Service.Search.SearchInstitutionInfoService;

public class ManageFinance implements GetBenefitService, GetCostService,GetGatheringService {

	@Override
	public ArrayList<GatheringVO> searchGathering(String date,
			String businesslobby) {
		ArrayList<GatheringVO> result=new ArrayList<GatheringVO>();
		try {
			SearchGatheringService searchGathering=(SearchGatheringService) Naming.lookup(RMIHelper.SEARCH_GATHERING_IMPL);
			SearchInstitutionInfoService searchInstitution=(SearchInstitutionInfoService) Naming.lookup(RMIHelper.SEARCH_INSTITUTION_IMPL);
			
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("date='"+date+"'");
			
			ArrayList<GatheringPO> searchResult=new ArrayList<GatheringPO>();
			
			ArrayList<String> requirementBusinesslobby=new ArrayList<String>();
			requirementBusinesslobby.add("id='"+businesslobby+"'");
			ArrayList<InstitutionPO> searchResultBusinesslobby=searchInstitution.searchInstitutionInfo(requirementBusinesslobby);
			
			if(searchResultBusinesslobby.isEmpty()){
				System.out.println("not found");
			}
			else{
				for(int i=0;i<searchResultBusinesslobby.size();i++){
					searchResult=searchGathering.searchGathering(URLHelper.getGatheringURL(searchResultBusinesslobby.get(i).getInstitutionNumber()) ,requirement);
					if(searchResult.isEmpty()){
						System.out.println("Gathering not found");
					}
					else{
						for(int j=0;j<searchResult.size();j++){
							GatheringVO temp=new GatheringVO(searchResult.get(i));
							result.add(temp);
						}
					}
				}
			}
			

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public ArrayList<CostVO> searchCost(String time_start, String time_end) {
		// TODO Auto-generated method stub
		ArrayList<CostVO> result=new ArrayList<CostVO>();
		try {
			SearchCostService searchCost=(SearchCostService) Naming.lookup(RMIHelper.SEARCH_COST_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("between'"+time_start+"'and'"+time_end+"'");
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
		String time_start="2015-12-22-10:44:20";
		try {
			SearchBenefitService searchBenefit=(SearchBenefitService) Naming.lookup(RMIHelper.SEARCH_BENEFIT_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("between'"+time_start+"'and'"+time_end+"'");
			ArrayList<BenefitPO> searchResult=searchBenefit.searchBenefit(requirement);
			
			if(searchResult.isEmpty()){
				System.out.println("not found");
				return new BenefitVO(0,0,"0","0");
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
		}
		
		BenefitVO result=new BenefitVO(income,cost,"2015-12-22-10:44:20" ,time_end);
		return result;
	}

}
