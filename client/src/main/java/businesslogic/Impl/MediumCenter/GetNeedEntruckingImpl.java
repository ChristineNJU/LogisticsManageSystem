package businesslogic.Impl.MediumCenter;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.RemovalPO;
import VO.EntruckingVO;
import businesslogic.Service.MediumCenter.GetNeedEntruckingService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchRemovalService;

// TODO: Auto-generated Javadoc
/**
 * The Class GetNeedEntruckingImpl.
 */
public class GetNeedEntruckingImpl implements GetNeedEntruckingService{

	/* (non-Javadoc)
	 * @see businesslogic.Service.MediumCenter.GetNeedEntruckingService#getNeedEntrucking()
	 */
	@Override
	public ArrayList<EntruckingVO> getNeedEntrucking() {
		// TODO Auto-generated method stub
		ArrayList<EntruckingVO> result=new ArrayList<EntruckingVO>();
		try {
			SearchRemovalService removalSearch=(SearchRemovalService) Naming.lookup(RMIHelper.SEARCH_REMOVAL_IMPL);
			ArrayList<String> requirement1=new ArrayList<String>();
			requirement1.add("bar_code like '%%'");
			requirement1.add("type = 'Railway'");
			
			ArrayList<String> requirement2=new ArrayList<String>();
			requirement2.add("bar_code like '%%'");
			requirement2.add("type = 'car'");
			
			ArrayList<RemovalPO> searchResult1=removalSearch.searchRemoval(URLHelper.getRemovalURL(SystemLog.getInstitutionId()+"0"), requirement1);
			ArrayList<RemovalPO> searchResult2=removalSearch.searchRemoval(URLHelper.getRemovalURL(SystemLog.getInstitutionId()+"0"), requirement2);
			
			for(RemovalPO temp:searchResult2){
				searchResult1.add(temp);
			}
			
			if(searchResult1.isEmpty()){
				System.out.println("not found");
				return null;
			}
			
			else{
				for(int i=0;i<searchResult1.size();i++)
					result.add(new EntruckingVO(searchResult1.get(i)));
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return result;
		
	}

}
