package businesslogic.Impl.Finance;

import java.rmi.Naming;
import java.util.ArrayList;

import State.AddState;
import VO.BenefitVO;
import PO.BenefitPO;
import businesslogic.Service.Finance.AddBenefitService;
import businesslogic.Service.Finance.GetBenefitService;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import data.Service.Search.SearchBenefitService;

public class BenefitImpl implements AddBenefitService,GetBenefitService{

	@Override
	public AddState addBenefit(BenefitVO benefit) {
		// TODO Auto-generated method stub
		AddState state=AddState.SUCCESS;
		try{
			SearchBenefitService benefitSearch=(SearchBenefitService) Naming.lookup(RMIHelper.SEARCH_BENEFIT_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("number like '%%'");
			ArrayList<BenefitPO> benefitList=benefitSearch.searchBenefit(requirement);
			AddService benefitAdd=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			state=benefitAdd.add(new BenefitPO(benefit,benefitList.get(benefitList.size()-1).getNumber()+1));
		} catch(Exception ex){
			state=AddState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return state;
	}

	@Override
	public BenefitVO searchBenefit(String time_end) {
		// TODO Auto-generated method stub
		BenefitVO benefit=null;
		try{
			SearchBenefitService benefitSearch=(SearchBenefitService) Naming.lookup(RMIHelper.SEARCH_BENEFIT_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("endDate='"+time_end+"'");
			ArrayList<BenefitPO> benefitList=new ArrayList<BenefitPO>();
			benefitList=benefitSearch.searchBenefit(requirement);
			benefit=new BenefitVO(benefitList.get(0));
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return benefit;
	}

}
