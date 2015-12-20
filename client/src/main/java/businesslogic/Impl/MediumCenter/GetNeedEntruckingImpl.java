package businesslogic.Impl.MediumCenter;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.InstitutionStoragePO;
import VO.EntruckingVO;
import businesslogic.Service.MediumCenter.GetNeedEntruckingService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchRemovalService;
import data.Service.Sundry.InstitutionStorageService;

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
			InstitutionStorageService istorageservice=(InstitutionStorageService) Naming.lookup(RMIHelper.INSTITUTION_STORAGE_IMPL);
			ArrayList<String> requirement1=new ArrayList<String>();
			requirement1.add("bar_code like '%%'");
			requirement1.add("isout='true'");
			requirement1.add("istransfer = 'true'");
		
			ArrayList<InstitutionStoragePO> searchResult1=istorageservice.getInstitutionStorage(URLHelper.getInstitutionStorage(SystemLog.getInstitutionId()));
			
			if(searchResult1.isEmpty()){
				System.out.println("not found");
				return result;
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
