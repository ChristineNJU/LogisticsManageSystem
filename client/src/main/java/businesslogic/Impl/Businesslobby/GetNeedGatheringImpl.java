package businesslogic.Impl.Businesslobby;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.GatheringPO;
import VO.GatheringVO;
import businesslogic.Service.BusinessLobby.GetNeedGatheringService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchGatheringService;

// TODO: Auto-generated Javadoc
/**
 * The Class GetNeedGatheringImpl.
 */
public class GetNeedGatheringImpl implements GetNeedGatheringService{

	/* (non-Javadoc)
	 * @see businesslogic.Service.BusinessLobby.GetNeedGatheringService#getNeedGathering()
	 */
	@Override
	public ArrayList<GatheringVO> getNeedGathering() {
		// TODO Auto-generated method stub
		ArrayList<GatheringVO> result=new ArrayList<GatheringVO>();
		try {
			SearchGatheringService searchGathering=(SearchGatheringService) Naming.lookup(RMIHelper.SEARCH_GATHERING_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("date like '%%'");
			
			ArrayList<GatheringPO> searchResult=searchGathering.searchGathering(URLHelper.getGatheringURL(SystemLog.getInstitutionId()), requirement);
			
			if(searchResult.isEmpty()){
				System.out.println("not found");
				return null;
			}
			
			else{
				for(int i=0;i<searchResult.size();i++)
					result.add(new GatheringVO(searchResult.get(i)));
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return result;
		
	}

}
