package businesslogic.Impl.Repository;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.ArrivalPO;
import PO.InstitutionStoragePO;
import PO.StoragePO;
import VO.StorageVO;
import businesslogic.Service.Repository.GetNeedStorageService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchArrivalService;
import data.Service.Sundry.InstitutionStorageService;

// TODO: Auto-generated Javadoc
/**
 * The Class GetNeedStorageImpl.
 */
public class GetNeedStorageImpl implements GetNeedStorageService {

	/* (non-Javadoc)
	 * @see businesslogic.Service.Repository.GetNeedStorageService#getNeedStorage(java.lang.String)
	 */
	@Override
	public ArrayList<StorageVO> getNeedStorage() {
		// TODO Auto-generated method stub
		ArrayList<StorageVO> storage=new ArrayList<StorageVO>();
		try{
			InstitutionStorageService istoragreService=(InstitutionStorageService) Naming.lookup(RMIHelper.INSTITUTION_STORAGE_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("bar_code like '%%'");
			requirement.add("isout='false'");
			
			ArrayList<InstitutionStoragePO> searchResult=istoragreService.getInstitutionStorage(URLHelper.getInstitutionStorage(SystemLog.getInstitutionId()));
			
			
			for(int i=0;i<searchResult.size();i++){
				storage.add(new StorageVO(searchResult.get(i)));
			}
			
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return storage;
	}

}
