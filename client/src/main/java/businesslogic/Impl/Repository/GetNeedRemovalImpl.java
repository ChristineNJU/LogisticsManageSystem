package businesslogic.Impl.Repository;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.RemovalPO;
import VO.RemovalVO;
import businesslogic.Service.Repository.GetNeedRemovalService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchRemovalService;

public class GetNeedRemovalImpl implements GetNeedRemovalService {

	@Override
	public ArrayList<RemovalVO> getNeedRemoval(String destination) {
		// TODO Auto-generated method stub
		ArrayList<RemovalVO> removal=new ArrayList<RemovalVO>();
		try{
			SearchRemovalService removalSearch=(SearchRemovalService) Naming.lookup(RMIHelper.SEARCH_REMOVAL_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("destination='"+destination+"'");
			ArrayList<RemovalPO> removalList=removalSearch.searchRemoval(URLHelper.getRemovalURL(SystemLog.getInstitutionId()), requirement);
			for(int i=0;i<removalList.size();i++){
				removal.add(new RemovalVO(removalList.get(i)));
			}
		} catch (Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return removal;
	}

}
