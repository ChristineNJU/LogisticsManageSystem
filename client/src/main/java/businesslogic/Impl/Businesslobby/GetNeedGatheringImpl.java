package businesslogic.Impl.Businesslobby;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.GatheringPO;
import PO.GatheringStoragePO;
import VO.GatheringVO;
import businesslogic.Service.BusinessLobby.GetNeedGatheringService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Sundry.GatheringStorageService;

// TODO: Auto-generated Javadoc
/**
 * The Class GetNeedGatheringImpl.
 * 营业厅获取派件快递的实现
 * 
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
			GatheringStorageService searchGathering=(GatheringStorageService) Naming.lookup(RMIHelper.GATHERING_STORAGE_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("bar_code like '%%'");
			
			ArrayList<GatheringStoragePO> searchResult=searchGathering.getGatheringStorage(URLHelper.getGatheringStorage(SystemLog.getInstitutionId()));
					
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
