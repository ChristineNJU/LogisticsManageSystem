package businesslogic.Impl.Finance;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.BenefitPO;
import VO.BenefitVO;
import businesslogic.Service.Finance.GetBenefitService;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchBenefitService;

// TODO: Auto-generated Javadoc
/**
 * The Class BenefitImpl.
 * 收益管理的实现
 * 
 * @see SearchBenefitService
 */
public class BenefitImpl implements GetBenefitService{

	/* (non-Javadoc)
	 * @see businesslogic.Service.Finance.GetBenefitService#searchBenefit(java.lang.String)
	 */
	@Override
	public BenefitVO searchBenefit(String time_end) {
		// TODO Auto-generated method stub
		BenefitVO benefit=null;
		try{
			SearchBenefitService benefitSearch=(SearchBenefitService) Naming.lookup(RMIHelper.SEARCH_BENEFIT_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("date<='"+time_end+"'");
			ArrayList<BenefitPO> benefitList=new ArrayList<BenefitPO>();
			benefitList=benefitSearch.searchBenefit(requirement);
			benefit=new BenefitVO(benefitList.get(benefitList.size()-1));
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return benefit;
	}

}
